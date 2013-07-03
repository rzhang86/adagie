
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
    <div>
        <video width="320" height="240" controls>
            <source src="assets/uploads/"""),_display_(Seq[Any](/*6.42*/(video.id))),format.raw/*6.52*/(""".webm" type='video/webm'>
            <source src="assets/uploads/"""),_display_(Seq[Any](/*7.42*/(video.id))),format.raw/*7.52*/(""".mp4" type="video/mp4">
            Your browser does not support the HTML5 video.
        </video>
        <h4>"""),_display_(Seq[Any](/*10.14*/video/*10.19*/.title)),format.raw/*10.25*/("""</h4>
        <p>"""),_display_(Seq[Any](/*11.13*/video/*11.18*/.description)),format.raw/*11.30*/("""</p>
        """),_display_(Seq[Any](/*12.10*/if(video.user.equals(user))/*12.37*/ {_display_(Seq[Any](format.raw/*12.39*/("""
            (<a href=""""),_display_(Seq[Any](/*13.24*/routes/*13.30*/.Uploads.delete(video.id))),format.raw/*13.55*/("""">Delete</a>)
        """)))})),format.raw/*14.10*/("""
    </div>
""")))};
Seq[Any](format.raw/*1.62*/("""

"""),format.raw/*16.2*/("""

"""),_display_(Seq[Any](/*18.2*/main(user, "uploads")/*18.23*/ {_display_(Seq[Any](format.raw/*18.25*/("""
    <div class="row-fluid">            
        <div class="span12 well">
            <h4>Upload video</h4>
            <form id="myForm" action=""""),_display_(Seq[Any](/*22.40*/routes/*22.46*/.Uploads.post())),format.raw/*22.61*/("""" method="post" enctype="multipart/form-data">
                <p><input type="file" name="file" placeholder="Select file"></p>
                <p><input type="text" name="title" placeholder="Title" value=""""),_display_(Seq[Any](/*24.80*/uploadVideoForm("title")/*24.104*/.value)),format.raw/*24.110*/("""" maxlength=63></p>
                <p><textarea rows="6" name="description" placeholder="Description" maxlength=255>"""),_display_(Seq[Any](/*25.99*/uploadVideoForm("description")/*25.129*/.value)),format.raw/*25.135*/("""</textarea></p>
                <div id="formulas">
                </div>
                <a class="addFormula btn btn-success">Add another formula</a>
                <p><button type="submit" class="btn btn-primary">Upload</button></p>
            </form>
            <div class="formula-template" hidden>
                <a class="removeFormula btn btn-danger pull-right">Remove this formula</a>
                <input type="text" name="conditions[x]" placeholder="Condition formula">
                <input type="text" name="results[x]" placeholder="Payout formula">
            </div>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12 well">
            """),_display_(Seq[Any](/*40.14*/user/*40.18*/.videos.map/*40.29*/ {video =>_display_(Seq[Any](format.raw/*40.39*/(""" """),_display_(Seq[Any](/*40.41*/videoItem(video)))))})),format.raw/*40.58*/("""
        </div>
    </div>
    <script type="text/javascript">
    	$('.removeFormula').on('click', function(e) """),format.raw/*44.50*/("""{"""),format.raw/*44.51*/("""
    		$(this).parents('.formula-clone').remove();
    		renumber();
        """),format.raw/*47.9*/("""}"""),format.raw/*47.10*/(""");
        $('.addFormula').on('click', function(e) """),format.raw/*48.50*/("""{"""),format.raw/*48.51*/("""
            $('.formula-template').clone(true).removeClass('formula-template').addClass('formula-clone').appendTo('#formulas').show();
    		renumber();
        """),format.raw/*51.9*/("""}"""),format.raw/*51.10*/(""");
        $('#myForm').submit(function() """),format.raw/*52.40*/("""{"""),format.raw/*52.41*/("""
            $('.formula-template').remove();
        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/(""");
        var renumber = function() """),format.raw/*55.35*/("""{"""),format.raw/*55.36*/("""
            $('.formula-clone').each(function(i) """),format.raw/*56.50*/("""{"""),format.raw/*56.51*/("""
                $('input', this).each(function() """),format.raw/*57.50*/("""{"""),format.raw/*57.51*/("""
                	$(this).attr('name', $(this).attr('name').replace(/conditions\[.+?\]/g, 'conditions[' + i + ']'));
                	$(this).attr('name', $(this).attr('name').replace(/results\[.+?\]/g, 'results[' + i + ']'));
            	"""),format.raw/*60.14*/("""}"""),format.raw/*60.15*/(""");
        	"""),format.raw/*61.10*/("""}"""),format.raw/*61.11*/(""");
        """),format.raw/*62.9*/("""}"""),format.raw/*62.10*/("""
        
    </script>
""")))})))}
    }
    
    def render(user:User,uploadVideoForm:Form[Uploads.UploadVideoForm]): play.api.templates.Html = apply(user,uploadVideoForm)
    
    def f:((User,Form[Uploads.UploadVideoForm]) => play.api.templates.Html) = (user,uploadVideoForm) => apply(user,uploadVideoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 03 12:01:25 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/uploads.scala.html
                    HASH: 604c5f6abe1a8cc6b812f181e525c95c28cabad2
                    MATRIX: 753->1|873->66|890->75|971->93|1111->198|1142->208|1245->276|1276->286|1428->402|1442->407|1470->413|1525->432|1539->437|1573->449|1624->464|1660->491|1700->493|1761->518|1776->524|1823->549|1879->573|1933->61|1964->588|2004->593|2034->614|2074->616|2262->768|2277->774|2314->789|2559->998|2593->1022|2622->1028|2777->1147|2817->1177|2846->1183|3588->1889|3601->1893|3621->1904|3669->1914|3707->1916|3750->1933|3894->2049|3923->2050|4030->2130|4059->2131|4140->2184|4169->2185|4361->2350|4390->2351|4461->2394|4490->2395|4573->2451|4602->2452|4668->2490|4697->2491|4776->2542|4805->2543|4884->2594|4913->2595|5184->2838|5213->2839|5254->2852|5283->2853|5322->2865|5351->2866
                    LINES: 26->1|28->3|28->3|30->3|33->6|33->6|34->7|34->7|37->10|37->10|37->10|38->11|38->11|38->11|39->12|39->12|39->12|40->13|40->13|40->13|41->14|44->1|46->16|48->18|48->18|48->18|52->22|52->22|52->22|54->24|54->24|54->24|55->25|55->25|55->25|70->40|70->40|70->40|70->40|70->40|70->40|74->44|74->44|77->47|77->47|78->48|78->48|81->51|81->51|82->52|82->52|84->54|84->54|85->55|85->55|86->56|86->56|87->57|87->57|90->60|90->60|91->61|91->61|92->62|92->62
                    -- GENERATED --
                */
            