
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
object home extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Form[Home.VideoEndedForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, form: Form[Home.VideoEndedForm]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""

"""),_display_(Seq[Any](/*3.2*/main(user, "home")/*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""
    <div class="row-fluid">
        <div class="span12 well">
            """),_display_(Seq[Any](/*6.14*/if(user.watchingVideo!=null)/*6.42*/ {_display_(Seq[Any](format.raw/*6.44*/("""
                """),_display_(Seq[Any](/*7.18*/defining(user.watchingVideo)/*7.46*/ {video =>_display_(Seq[Any](format.raw/*7.56*/("""
                 <video id="myVideo" autoplay controls preload="auto" width="320" height="240">
                     <source src=""""),_display_(Seq[Any](/*9.36*/routes/*9.42*/.Assets.at("uploads/"+video.id+".webm"))),format.raw/*9.81*/("""" type='video/webm'>
                     <source src=""""),_display_(Seq[Any](/*10.36*/routes/*10.42*/.Assets.at("uploads/"+video.id+".mp4"))),format.raw/*10.80*/("""" type='video/mp4'>
                     Your browser does not support the HTML5 video.
                 </video>
                 <h4>"""),_display_(Seq[Any](/*13.23*/video/*13.28*/.title)),format.raw/*13.34*/("""</h4>
                 <p>"""),_display_(Seq[Any](/*14.22*/video/*14.27*/.description)),format.raw/*14.39*/("""</p>
                 <form action=""""),_display_(Seq[Any](/*15.33*/routes/*15.39*/.Home.post())),format.raw/*15.51*/("""" method="post" id="videoEndedForm">
                     <input type="hidden" name="videoId" value=""""),_display_(Seq[Any](/*16.66*/(video.id))),format.raw/*16.76*/("""">
                     <button type="submit" id="videoEndedButton" class="btn btn-success" disabled>Next (Earn """),_display_(Seq[Any](/*17.111*/(Application.centsToDollars(user.watchingPayout)))),format.raw/*17.160*/(""") <i class="icon-play icon-white"></i></button>
                 </form>
                """)))})),format.raw/*19.18*/("""
            """)))}/*20.15*/else/*20.20*/{_display_(Seq[Any](format.raw/*20.21*/("""
                <p>You have already watched all paying videos</p>
            """)))})),format.raw/*22.14*/("""
        </div>
    </div>
    <script type="text/javascript">
        $(document).ready(function() """),format.raw/*26.38*/("""{"""),format.raw/*26.39*/("""
            document.getElementById('myVideo').removeAttribute("controls");
        """),format.raw/*28.9*/("""}"""),format.raw/*28.10*/(""");
        document.getElementById('myVideo').addEventListener('ended', onEnded, false);
        function onEnded(e) """),format.raw/*30.29*/("""{"""),format.raw/*30.30*/("""
            if(!e) """),format.raw/*31.20*/("""{"""),format.raw/*31.21*/("""e = window.event;"""),format.raw/*31.38*/("""}"""),format.raw/*31.39*/("""
            document.getElementById("videoEndedButton").removeAttribute("disabled");
            //document.getElementById("myForm").submit();
        """),format.raw/*34.9*/("""}"""),format.raw/*34.10*/("""
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Home.VideoEndedForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Home.VideoEndedForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 03 12:11:03 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/home.scala.html
                    HASH: b6516aa5e7a761b27b28bd051c26ff20ad16d5d9
                    MATRIX: 746->1|868->46|907->51|933->69|972->71|1086->150|1122->178|1161->180|1215->199|1251->227|1298->237|1467->371|1481->377|1541->416|1634->473|1649->479|1709->517|1884->656|1898->661|1926->667|1990->695|2004->700|2038->712|2112->750|2127->756|2161->768|2300->871|2332->881|2483->995|2555->1044|2679->1136|2713->1152|2726->1157|2765->1158|2879->1240|3011->1344|3040->1345|3154->1432|3183->1433|3330->1552|3359->1553|3408->1574|3437->1575|3482->1592|3511->1593|3693->1748|3722->1749
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|35->7|35->7|35->7|37->9|37->9|37->9|38->10|38->10|38->10|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|45->17|45->17|47->19|48->20|48->20|48->20|50->22|54->26|54->26|56->28|56->28|58->30|58->30|59->31|59->31|59->31|59->31|62->34|62->34
                    -- GENERATED --
                */
            