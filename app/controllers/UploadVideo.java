package controllers;

import java.util.*;
import java.io.*;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.*;
import play.data.*;
import static play.data.Form.*;

import models.*;
import views.html.*;
import views.html.videos.*;

//todo: verify payformula parses with jep
@Security.Authenticated(Secured.class) public class UploadVideo extends Controller {
    public static Result get() {
    	return ok(uploadVideo.render(User.find.ref(request().username()), form(UploadVideoInfo.class)));
    }

    public static class UploadVideoInfo {
        public String title;
        public String description;
    	public String payFormula;
    }
    
    // todo:add limit on input file size/duration
    // todo: keep connection open and show progress when uploading long jobs
    // todo: adjust ffmpeg resolution
    public static Result post() {
        Video video = Video.create(User.find.ref(request().username()));
        MultipartFormData formData = request().body().asMultipartFormData();
        File file = new File("public/uploads/" + video.getId() + "-temp.mp4");
        File tempFile = new File("public/uploads/" + video.getId() + "-temp.mp4");
        File finalFileMp4 = new File("public/uploads/" + video.getId() + ".mp4");
        File finalFileWebm = new File("public/uploads/" + video.getId() + ".webm");
        try {
            video
                .setTitle(formData.asFormUrlEncoded().get("title")[0])
                .setDescription(formData.asFormUrlEncoded().get("description")[0])
                .setPayFormula(formData.asFormUrlEncoded().get("payFormula")[0]);
            file = formData.getFile("file").getFile();
            Process process;
            process = Runtime.getRuntime().exec("cmd /C lib\\ffmpeg -y -i " + file.getAbsolutePath() + " -vf scale=320:trunc(ow/a/2)*2 " + tempFile.getAbsolutePath());
            int duration = getDuration(process);
            process = Runtime.getRuntime().exec("cmd /C lib\\ffmpeg -y -i " + tempFile.getAbsolutePath() + " -vf scale=trunc(oh*a/2)*2:240 " + finalFileMp4.getAbsolutePath());
            getDuration(process);
            process = Runtime.getRuntime().exec("cmd /C lib\\ffmpeg -y -i " + finalFileMp4.getAbsolutePath() + " " + finalFileWebm.getAbsolutePath());
            getDuration(process);
            if (!finalFileMp4.exists() || !finalFileWebm.exists() || duration == 0) flash("failure", "Video improperly formatted");
            else {
                video.setDuration(duration).save();
                flash("success", "Video uploaded");
                file.delete();
                tempFile.delete();
                return redirect(routes.YourVideos.get());
            }
        }
        catch (Exception e) {flash("failure", "Invalid file");}
        file.delete();
        tempFile.delete();
        finalFileMp4.delete();
        finalFileWebm.delete();
        video.delete();
        return redirect(routes.UploadVideo.get());
    }
    
    public static int getDuration(Process process) {
        int duration = 0;
        try {
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = errorReader.readLine()) != null) { if (duration == 0) duration = getDurationReader(line);}
            while ((line = outputReader.readLine()) != null) { if (duration == 0) duration = getDurationReader(line);}
            process.waitFor();
        }
        catch (Exception e) {}
        return duration;
    }
    
    public static int getDurationReader(String line) {
        int duration = 0;
        if (line.contains("Duration: ")) {
            String[] durationTokens = line.split("Duration: ")[1].split(",")[0].split(":");
            duration = (Integer.parseInt(durationTokens[0]) * 60 * 60) + (Integer.parseInt(durationTokens[1]) * 60) + ((int) Double.parseDouble(durationTokens[2]));
        }
        return duration;
    }
    
    /*
    // resize video, convert to .mp4, and delete if any of this fails
    public static Result readUploadVideoInfo() {
    	MultipartFormData formData = request().body().asMultipartFormData();
    	Video video = Video.create(User.find.ref(request().username()));
    	boolean uploadSuccessful = false;
    	try {
			video.centsForWatching = Long.parseLong(formData.asFormUrlEncoded().get("centsForWatching")[0]);
			video.title = formData.asFormUrlEncoded().get("title")[0];
			video.description = formData.asFormUrlEncoded().get("description")[0];
	    	File file = formData.getFile("file").getFile();
	    	IMediaReader reader = ToolFactory.makeReader(file.getAbsolutePath());
	    	File tempFile = new File("public/uploads/" + video.id + "-temp.mp4");
	    	IMediaWriter writer = ToolFactory.makeWriter(tempFile.getAbsolutePath(), reader);
	    	reader.addListener(writer);
	    	try {while (reader.readPacket() == null);}
	    	catch (Exception e) {
	            System.out.println("YOHO");
	            e.printStackTrace();
	            System.out.println("OHOY");
	            flash("failure", "Video conversion failed");
	        }
	    	finally {reader.close();}
	    	file.delete();
	    	reader = ToolFactory.makeReader(tempFile.getAbsolutePath());
	    	MediaResizer resizer = new MediaResizer(320, 240);
	    	File finalFile = new File("public/uploads/" + video.id + ".mp4");
	    	writer = ToolFactory.makeWriter(finalFile.getAbsolutePath(), reader);
	    	reader.addListener(resizer);
	    	resizer.addListener(writer);
	    	try {while (reader.readPacket() == null);} catch (Exception e) {} finally {reader.close();}
			tempFile.delete();
	        IContainer container = IContainer.make();
			// delete if resulting file doesn't exist or is < 1kb (too small)
			if (!finalFile.exists() || finalFile.length() < 1000 || container.open(finalFile.getAbsolutePath(), IContainer.Type.READ, null) < 0) {
				file.delete();
				tempFile.delete();
				finalFile.delete();
				flash("failure", "Video formatting failed");
			} else {
				video.duration = container.getDuration();
				video.centsForWatchingPerSecond = 1000000L * video.centsForWatching / video.duration;
				video.save();
				uploadSuccessful = true;
				flash("success", "Video uploaded");
			}
    	}
    	catch (NullPointerException e) {flash("failure", "Invalid file");}
    	catch (NumberFormatException e) {flash("failure", "Invalid pay rate");}
    	if (!uploadSuccessful) video.delete();
        return redirect(routes.YourVideos.uploadVideo());
    }
    
    // converts input video to .mp4
    private static class MediaResizer extends MediaToolAdapter {
        private IVideoResampler videoResampler = null;
        private int mediaWidth;
        private int mediaHeight;
        private boolean dimensionsFinal = false;

        public MediaResizer (int aWidth, int aHeight) {
            mediaWidth = aWidth;
            mediaHeight = aHeight;
        }
        
        private void finalizeDimensions(int inWidth, int inHeight) {
        	double picWidth = (double) inWidth;
        	double picHeight = (double) inHeight;
        	double outWidth = (double) mediaWidth;
        	double outHeight = (double) mediaHeight;
        	double picRatio = picWidth / picHeight;
        	double outRatio = outWidth / outHeight;
        	if (picRatio > outRatio) mediaHeight = (int) (picHeight / (picWidth / outWidth));
        	else mediaWidth = (int) (picWidth / (picHeight / outHeight));
        	dimensionsFinal = true;
        }
        
        @Override public void onAddStream(IAddStreamEvent event) {
    		int streamIndex = event.getStreamIndex();
    		IStreamCoder streamCoder = event.getSource().getContainer().getStream(streamIndex).getStreamCoder();
    		// In case of audio only, do not re-size as it is not needed
    		if (streamCoder.getCodecType() == ICodec.Type.CODEC_TYPE_VIDEO) {
                if (!dimensionsFinal) finalizeDimensions(streamCoder.getWidth(), streamCoder.getHeight());
    			streamCoder.setWidth(mediaWidth);
    			streamCoder.setHeight(mediaHeight);
    		}
    		//else if (streamCoder.getCodecType() == ICodec.Type.CODEC_TYPE_AUDIO) {}
    		super.onAddStream(event);
    	}
        
        @Override public void onVideoPicture(IVideoPictureEvent event) {
            IVideoPicture pic = event.getPicture();
            if (!dimensionsFinal) finalizeDimensions(pic.getWidth(), pic.getHeight());
            if (videoResampler == null) videoResampler = IVideoResampler.make(mediaWidth, mediaHeight, pic.getPixelType(), pic.getWidth(), pic.getHeight(), pic.getPixelType());
            IVideoPicture out = IVideoPicture.make(pic.getPixelType(), mediaWidth, mediaHeight);
            videoResampler.resample(out, pic);
            IVideoPictureEvent asc = new VideoPictureEvent(event.getSource(), out, event.getStreamIndex());
            super.onVideoPicture(asc);
            out.delete();
        }
    }
    */
}