
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
object home extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Form[Application.VideoEndedForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, form: Form[Application.VideoEndedForm]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.54*/("""

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
                 <form action=""""),_display_(Seq[Any](/*15.33*/routes/*15.39*/.Application.readVideoEndedForm())),format.raw/*15.72*/("""" method="post" id="videoEndedForm">
                     <input type="hidden" name="videoId" value=""""),_display_(Seq[Any](/*16.66*/(video.id))),format.raw/*16.76*/("""">
                     <button type="submit" id="videoEndedButton" class="btn btn-success" disabled>Next (Earn """),_display_(Seq[Any](/*17.111*/(Application.centsToDollars(user.watchingPayout)))),format.raw/*17.160*/(""") <i class="icon-play icon-white"></i></button>
                 </form>
                """)))})),format.raw/*19.18*/("""
            """)))}/*20.15*/else/*20.20*/{_display_(Seq[Any](format.raw/*20.21*/("""
                <p>You have already watched all paying videos</p>
            """)))})),format.raw/*22.14*/("""
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12 well">
            """),_display_(Seq[Any](/*27.14*/user/*27.18*/.financialInstitutionLogins.map/*27.49*/ {financialInstitutionLogin =>_display_(Seq[Any](format.raw/*27.79*/("""
                """),_display_(Seq[Any](/*28.18*/financialInstitutionLogin/*28.43*/.loginChallenges.map/*28.63*/ {loginChallenge =>_display_(Seq[Any](format.raw/*28.82*/("""
                    """),_display_(Seq[Any](/*29.22*/if(loginChallenge.answer==null)/*29.53*/ {_display_(Seq[Any](format.raw/*29.55*/("""
                        <h4>Your credit card accounts require confirmation</h4>
                        <p>"""),_display_(Seq[Any](/*31.29*/loginChallenge/*31.43*/.challengeQuestion.value)),format.raw/*31.67*/("""</p>
                        <form action=""""),_display_(Seq[Any](/*32.40*/routes/*32.46*/.Application.readChallengeAnswerForm())),format.raw/*32.84*/("""" method="post" id="challengeAnswerForm">
                            <input type="hidden" name="id" value=""""),_display_(Seq[Any](/*33.68*/loginChallenge/*33.82*/.id)),format.raw/*33.85*/("""">
                            <input type="text" name="answer" placeholder="Enter your answer">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    """)))})),format.raw/*37.22*/("""
                """)))})),format.raw/*38.18*/("""
            """)))})),format.raw/*39.14*/("""
        </div>
    </div>
    
    <script type="text/javascript">
        $(document).ready(function() """),format.raw/*44.38*/("""{"""),format.raw/*44.39*/("""
            document.getElementById('myVideo').removeAttribute("controls");
        """),format.raw/*46.9*/("""}"""),format.raw/*46.10*/(""");
        document.getElementById('myVideo').addEventListener('ended', onEnded, false);
        function onEnded(e) """),format.raw/*48.29*/("""{"""),format.raw/*48.30*/("""
            if(!e) """),format.raw/*49.20*/("""{"""),format.raw/*49.21*/("""e = window.event;"""),format.raw/*49.38*/("""}"""),format.raw/*49.39*/("""
            document.getElementById("videoEndedButton").removeAttribute("disabled");
            //document.getElementById("myForm").submit();
        """),format.raw/*52.9*/("""}"""),format.raw/*52.10*/("""
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Application.VideoEndedForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Application.VideoEndedForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 28 01:17:08 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/home.scala.html
                    HASH: f35edb9df78ace63cdfa15db9b7a81778aa090c4
                    MATRIX: 753->1|882->53|921->58|947->76|986->78|1100->157|1136->185|1175->187|1229->206|1265->234|1312->244|1481->378|1495->384|1555->423|1648->480|1663->486|1723->524|1898->663|1912->668|1940->674|2004->702|2018->707|2052->719|2126->757|2141->763|2196->796|2335->899|2367->909|2518->1023|2590->1072|2714->1164|2748->1180|2761->1185|2800->1186|2914->1268|3057->1375|3070->1379|3110->1410|3178->1440|3233->1459|3267->1484|3296->1504|3353->1523|3412->1546|3452->1577|3492->1579|3639->1690|3662->1704|3708->1728|3789->1773|3804->1779|3864->1817|4010->1927|4033->1941|4058->1944|4334->2188|4385->2207|4432->2222|4570->2332|4599->2333|4713->2420|4742->2421|4889->2540|4918->2541|4967->2562|4996->2563|5041->2580|5070->2581|5252->2736|5281->2737
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|35->7|35->7|35->7|37->9|37->9|37->9|38->10|38->10|38->10|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|45->17|45->17|47->19|48->20|48->20|48->20|50->22|55->27|55->27|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|57->29|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|65->37|66->38|67->39|72->44|72->44|74->46|74->46|76->48|76->48|77->49|77->49|77->49|77->49|80->52|80->52
                    -- GENERATED --
                */
            