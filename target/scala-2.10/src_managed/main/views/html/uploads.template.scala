
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object uploads extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Form[Uploads.UploadVideoForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, uploadVideoForm: Form[Uploads.UploadVideoForm]):play.api.templates.Html = {
        _display_ {
def /*3.2*/videoItem/*3.11*/(video: Video):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*3.29*/("""
    <div class="span3">
        <h4>"""),_display_(Seq[Any](/*5.14*/video/*5.19*/.getTitle())),format.raw/*5.30*/("""</h4>
        <video width="160" height="120" controls>
            <source src="assets/uploads/"""),_display_(Seq[Any](/*7.42*/(video.getId()))),format.raw/*7.57*/(""".webm" type='video/webm'>
            <source src="assets/uploads/"""),_display_(Seq[Any](/*8.42*/(video.getId()))),format.raw/*8.57*/(""".mp4" type="video/mp4">
            Your browser does not support the HTML5 video.
        </video>
        <p>"""),_display_(Seq[Any](/*11.13*/video/*11.18*/.getDescription())),format.raw/*11.35*/("""</p>
        """),_display_(Seq[Any](/*12.10*/if(video.getUser().equals(user))/*12.42*/ {_display_(Seq[Any](format.raw/*12.44*/("""
            <form id="myForm" action=""""),_display_(Seq[Any](/*13.40*/routes/*13.46*/.Uploads.delete(video.getId()))),format.raw/*13.76*/("""" method="post">
                <button type="submit" class="btn btn-danger btn-mini">Delete</button>
            </form>
        """)))})),format.raw/*16.10*/("""
    </div>
""")))};
Seq[Any](format.raw/*1.62*/("""

"""),format.raw/*18.2*/("""

"""),_display_(Seq[Any](/*20.2*/main(user, "uploads")/*20.23*/ {_display_(Seq[Any](format.raw/*20.25*/("""
    <div class="row">
        <div class="span12 well">
            <div class="row"><div class="span12 text-right"><button type="button" class="btn btn-info" id="new-button" data-toggle="button">New</button></div></div>
            <form id="myForm" action=""""),_display_(Seq[Any](/*24.40*/routes/*24.46*/.Uploads.post())),format.raw/*24.61*/("""" method="post" enctype="multipart/form-data">
                <div class="row form-div">
                    <div class="span6 offset1">
                        <div class="row"><div class="span6">Title:</div></div>
                        <div class="row"><div class="span6"><input class="span6" id="title" type="text" name="title" placeholder="Title" value=""""),_display_(Seq[Any](/*28.146*/uploadVideoForm("title")/*28.170*/.value)),format.raw/*28.176*/("""" pattern="."""),format.raw/*28.188*/("""{"""),format.raw/*28.189*/("""1,63"""),format.raw/*28.193*/("""}"""),format.raw/*28.194*/("""" maxlength="63" required></div></div>
                    </div>
                    <div class="span5">
                        <div class="row"><div class="span5">File:</div></div>
                        <div class="row"><div class="span5"><input class="span4" id="file" type="file" name="file" required></div></div>
                    </div>
                </div>
                <div class="row form-div">
                    <div class="span10 offset1">
                        <div class="row"><div class="span10">Description:</div></div>
                    	<div class="row"><div class="span10"><textarea class="span10" id="description" rows="4" name="description" placeholder="Description" pattern="."""),format.raw/*38.165*/("""{"""),format.raw/*38.166*/("""0, 255"""),format.raw/*38.172*/("""}"""),format.raw/*38.173*/("""" maxlength="255">"""),_display_(Seq[Any](/*38.192*/uploadVideoForm("description")/*38.222*/.value)),format.raw/*38.228*/("""</textarea></div></div>
                    </div>
                </div>
                <div class="row form-div">
                    <div class="span11 offset1">
                        <div class="row">
                            <div class="span11">Payout formulas: (<a class="addFormula text-primary" href="#">Add a formula</a>)</div>
                        </div>
                        <div id="formulas"></div>
                    </div>
                    
                </div>
                <div class="row form-div"><div class="span12 text-center"><button type="submit" class="btn btn-warning btn-large">Upload</button></div></div>
            </form>
            <div class="formula-template" hidden>
                <div class="row">
                    <div class="span10"><input class="span10 formula" type="text" name="formula[x]" placeholder="Payout formula" pattern="."""),format.raw/*54.140*/("""{"""),format.raw/*54.141*/("""0,63"""),format.raw/*54.145*/("""}"""),format.raw/*54.146*/("""" maxlength="63"></div>
                    <div class="span1"><a class="removeFormula btn btn-danger" href="#"><i class="icon-remove icon-white"></i></a></div>
                </div>
            </div>
            <div class="row">
                """),_display_(Seq[Any](/*59.18*/user/*59.22*/.videos.map/*59.33*/ {video =>_display_(Seq[Any](format.raw/*59.43*/(""" """),_display_(Seq[Any](/*59.45*/videoItem(video)))))})),format.raw/*59.62*/("""
            </div>
        </div>
    </div>
    
    
    
    
    
    
    <script type="text/javascript">
        var newButton = $('#new-button');
    	$('.form-div').hide();
    	$('.nonform-div').show();
    	newButton.click(function() """),format.raw/*73.33*/("""{"""),format.raw/*73.34*/("""
            if (newButton.hasClass('active')) """),format.raw/*74.47*/("""{"""),format.raw/*74.48*/("""
            	$('.form-div').hide();
            	$('.nonform-div').show();
            """),format.raw/*77.13*/("""}"""),format.raw/*77.14*/("""
            else """),format.raw/*78.18*/("""{"""),format.raw/*78.19*/("""
            	$('.form-div').show();
            	$('.nonform-div').hide();
            """),format.raw/*81.13*/("""}"""),format.raw/*81.14*/("""
        """),format.raw/*82.9*/("""}"""),format.raw/*82.10*/(""");
        """),_display_(Seq[Any](/*83.10*/if(flash.contains("new"))/*83.35*/ {_display_(Seq[Any](format.raw/*83.37*/("""editButton.click();""")))})),format.raw/*83.57*/("""
    	
    	$('.removeFormula').on('click', function(e) """),format.raw/*85.50*/("""{"""),format.raw/*85.51*/("""
    		$(this).parents('.formula-clone').remove();
    		renumber();
        """),format.raw/*88.9*/("""}"""),format.raw/*88.10*/(""");
        $('.addFormula').on('click', function(e) """),format.raw/*89.50*/("""{"""),format.raw/*89.51*/("""
            $('.formula-template').clone(true).removeClass('formula-template').addClass('formula-clone').appendTo('#formulas').show();
    		renumber();
        """),format.raw/*92.9*/("""}"""),format.raw/*92.10*/(""");
        $('#myForm').submit(function() """),format.raw/*93.40*/("""{"""),format.raw/*93.41*/("""
            $('.formula-template').remove();
        """),format.raw/*95.9*/("""}"""),format.raw/*95.10*/(""");
        var renumber = function() """),format.raw/*96.35*/("""{"""),format.raw/*96.36*/("""
            $('.formula-clone').each(function(i) """),format.raw/*97.50*/("""{"""),format.raw/*97.51*/("""
                $('input', this).each(function() """),format.raw/*98.50*/("""{"""),format.raw/*98.51*/("""
                	$(this).attr('name', $(this).attr('name').replace(/formula\[.+?\]/g, 'formula[' + i + ']'));
                	$(this).tooltip("""),format.raw/*100.34*/("""{"""),format.raw/*100.35*/("""placement: "bottom", animation: false, title: "Optional. 0-63 characters.""""),format.raw/*100.109*/("""}"""),format.raw/*100.110*/(""")
            	"""),format.raw/*101.14*/("""}"""),format.raw/*101.15*/(""");
        	"""),format.raw/*102.10*/("""}"""),format.raw/*102.11*/(""");
        """),format.raw/*103.9*/("""}"""),format.raw/*103.10*/("""
        
        $('#title').tooltip("""),format.raw/*105.29*/("""{"""),format.raw/*105.30*/("""placement: "bottom", animation: false, title: "Required. 1-63 characters.""""),format.raw/*105.104*/("""}"""),format.raw/*105.105*/(""")
        $('#file').tooltip("""),format.raw/*106.28*/("""{"""),format.raw/*106.29*/("""placement: "bottom", animation: false, title: "Required.""""),format.raw/*106.86*/("""}"""),format.raw/*106.87*/(""")
        $('#description').tooltip("""),format.raw/*107.35*/("""{"""),format.raw/*107.36*/("""placement: "bottom", animation: false, title: "Optional. 0-255 characters.""""),format.raw/*107.111*/("""}"""),format.raw/*107.112*/(""")
    </script>
""")))})))}
    }
    
    def render(user:User,uploadVideoForm:Form[Uploads.UploadVideoForm]): play.api.templates.Html = apply(user,uploadVideoForm)
    
    def f:((User,Form[Uploads.UploadVideoForm]) => play.api.templates.Html) = (user,uploadVideoForm) => apply(user,uploadVideoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jul 09 23:58:52 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/uploads.scala.html
                    HASH: 59ac24b870257a0887f85b8aea20146cd5ae2c3c
                    MATRIX: 753->1|873->66|890->75|971->93|1046->133|1059->138|1091->149|1225->248|1261->263|1364->331|1400->346|1551->461|1565->466|1604->483|1655->498|1696->530|1736->532|1813->573|1828->579|1880->609|2047->744|2101->61|2132->759|2172->764|2202->785|2242->787|2543->1052|2558->1058|2595->1073|2998->1439|3032->1463|3061->1469|3102->1481|3132->1482|3165->1486|3195->1487|3947->2210|3977->2211|4012->2217|4042->2218|4098->2237|4138->2267|4167->2273|5108->3185|5138->3186|5171->3190|5201->3191|5492->3446|5505->3450|5525->3461|5573->3471|5611->3473|5654->3490|5941->3749|5970->3750|6046->3798|6075->3799|6194->3890|6223->3891|6270->3910|6299->3911|6418->4002|6447->4003|6484->4013|6513->4014|6562->4027|6596->4052|6636->4054|6688->4074|6774->4132|6803->4133|6910->4213|6939->4214|7020->4267|7049->4268|7241->4433|7270->4434|7341->4477|7370->4478|7453->4534|7482->4535|7548->4573|7577->4574|7656->4625|7685->4626|7764->4677|7793->4678|7968->4824|7998->4825|8102->4899|8133->4900|8178->4916|8208->4917|8250->4930|8280->4931|8320->4943|8350->4944|8419->4984|8449->4985|8553->5059|8584->5060|8643->5090|8673->5091|8759->5148|8789->5149|8855->5186|8885->5187|8990->5262|9021->5263
                    LINES: 26->1|28->3|28->3|30->3|32->5|32->5|32->5|34->7|34->7|35->8|35->8|38->11|38->11|38->11|39->12|39->12|39->12|40->13|40->13|40->13|43->16|46->1|48->18|50->20|50->20|50->20|54->24|54->24|54->24|58->28|58->28|58->28|58->28|58->28|58->28|58->28|68->38|68->38|68->38|68->38|68->38|68->38|68->38|84->54|84->54|84->54|84->54|89->59|89->59|89->59|89->59|89->59|89->59|103->73|103->73|104->74|104->74|107->77|107->77|108->78|108->78|111->81|111->81|112->82|112->82|113->83|113->83|113->83|113->83|115->85|115->85|118->88|118->88|119->89|119->89|122->92|122->92|123->93|123->93|125->95|125->95|126->96|126->96|127->97|127->97|128->98|128->98|130->100|130->100|130->100|130->100|131->101|131->101|132->102|132->102|133->103|133->103|135->105|135->105|135->105|135->105|136->106|136->106|136->106|136->106|137->107|137->107|137->107|137->107
                    -- GENERATED --
                */
            