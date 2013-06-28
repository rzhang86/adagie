
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
object myVideos extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Form[Application.UploadVideoForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, uploadVideoForm: Form[Application.UploadVideoForm]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.66*/("""

"""),_display_(Seq[Any](/*3.2*/main(user, "myVideos")/*3.24*/ {_display_(Seq[Any](format.raw/*3.26*/("""
    <div class="row-fluid">            
        <div class="span12 well">
            <h4>Upload video</h4>
            <form id="myForm" action=""""),_display_(Seq[Any](/*7.40*/routes/*7.46*/.Application.readUploadVideoForm())),format.raw/*7.80*/("""" method="post" enctype="multipart/form-data">
                <p><input type="file" name="file" placeholder="Select file"></p>
                <p><input type="text" name="title" placeholder="Title" value=""""),_display_(Seq[Any](/*9.80*/uploadVideoForm("title")/*9.104*/.value)),format.raw/*9.110*/("""" maxlength=63></p>
                <p><textarea rows="6" name="description" placeholder="Description" maxlength=255>"""),_display_(Seq[Any](/*10.99*/uploadVideoForm("description")/*10.129*/.value)),format.raw/*10.135*/("""</textarea></p>
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
            """),_display_(Seq[Any](/*25.14*/user/*25.18*/.videos.map/*25.29*/ {video =>_display_(Seq[Any](format.raw/*25.39*/(""" """),_display_(Seq[Any](/*25.41*/views/*25.46*/.html.videoItem(user,video)))))})),format.raw/*25.74*/("""
        </div>
    </div>
    <script type="text/javascript">
    	$('.removeFormula').on('click', function(e) """),format.raw/*29.50*/("""{"""),format.raw/*29.51*/("""
    		$(this).parents('.formula-clone').remove();
    		renumber();
        """),format.raw/*32.9*/("""}"""),format.raw/*32.10*/(""");
        $('.addFormula').on('click', function(e) """),format.raw/*33.50*/("""{"""),format.raw/*33.51*/("""
            $('.formula-template').clone(true).removeClass('formula-template').addClass('formula-clone').appendTo('#formulas').show();
    		renumber();
        """),format.raw/*36.9*/("""}"""),format.raw/*36.10*/(""");
        $('#myForm').submit(function() """),format.raw/*37.40*/("""{"""),format.raw/*37.41*/("""
            $('.formula-template').remove();
        """),format.raw/*39.9*/("""}"""),format.raw/*39.10*/(""");
        var renumber = function() """),format.raw/*40.35*/("""{"""),format.raw/*40.36*/("""
            $('.formula-clone').each(function(i) """),format.raw/*41.50*/("""{"""),format.raw/*41.51*/("""
                $('input', this).each(function() """),format.raw/*42.50*/("""{"""),format.raw/*42.51*/("""
                	$(this).attr('name', $(this).attr('name').replace(/conditions\[.+?\]/g, 'conditions[' + i + ']'));
                	$(this).attr('name', $(this).attr('name').replace(/results\[.+?\]/g, 'results[' + i + ']'));
            	"""),format.raw/*45.14*/("""}"""),format.raw/*45.15*/(""");
        	"""),format.raw/*46.10*/("""}"""),format.raw/*46.11*/(""");
        """),format.raw/*47.9*/("""}"""),format.raw/*47.10*/("""
        
    </script>
""")))})))}
    }
    
    def render(user:User,uploadVideoForm:Form[Application.UploadVideoForm]): play.api.templates.Html = apply(user,uploadVideoForm)
    
    def f:((User,Form[Application.UploadVideoForm]) => play.api.templates.Html) = (user,uploadVideoForm) => apply(user,uploadVideoForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 28 01:17:08 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/myVideos.scala.html
                    HASH: f70ea293e3128d44711ff4985b0d32dd05a9717f
                    MATRIX: 758->1|899->65|938->70|968->92|1007->94|1194->246|1208->252|1263->286|1507->495|1540->519|1568->525|1723->644|1763->674|1792->680|2534->1386|2547->1390|2567->1401|2615->1411|2653->1413|2667->1418|2721->1446|2865->1562|2894->1563|3001->1643|3030->1644|3111->1697|3140->1698|3332->1863|3361->1864|3432->1907|3461->1908|3544->1964|3573->1965|3639->2003|3668->2004|3747->2055|3776->2056|3855->2107|3884->2108|4155->2351|4184->2352|4225->2365|4254->2366|4293->2378|4322->2379
                    LINES: 26->1|29->1|31->3|31->3|31->3|35->7|35->7|35->7|37->9|37->9|37->9|38->10|38->10|38->10|53->25|53->25|53->25|53->25|53->25|53->25|53->25|57->29|57->29|60->32|60->32|61->33|61->33|64->36|64->36|65->37|65->37|67->39|67->39|68->40|68->40|69->41|69->41|70->42|70->42|73->45|73->45|74->46|74->46|75->47|75->47
                    -- GENERATED --
                */
            