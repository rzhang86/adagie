
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
object signup extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Signup.SignupForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(form: Form[Signup.SignupForm]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.33*/("""

"""),_display_(Seq[Any](/*3.2*/main(null, "signup")/*3.22*/ {_display_(Seq[Any](format.raw/*3.24*/("""
    <div class="row">
        <div class="span12 well">
            <form action=""""),_display_(Seq[Any](/*6.28*/routes/*6.34*/.Signup.post())),format.raw/*6.48*/("""" method="post">
                <div class="row"><div class="span12 text-center"><strong>Required fields:</strong></div></div>
                <br>
                <div class="row">
                    <div class="span4 offset1">Email:</div>
                    <div class="span3">Password:</div>
                </div>
                <div class="row">
                    <div class="span4 offset1"><input class="span4" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*14.134*/form("email")/*14.147*/.value)),format.raw/*14.153*/("""" pattern="."""),format.raw/*14.165*/("""{"""),format.raw/*14.166*/("""1,63"""),format.raw/*14.170*/("""}"""),format.raw/*14.171*/(""""></div>
                    <div class="span3"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*15.140*/("""{"""),format.raw/*15.141*/("""6,31"""),format.raw/*15.145*/("""}"""),format.raw/*15.146*/(""""></div>
                    <div class="span3"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*16.159*/("""{"""),format.raw/*16.160*/("""6,31"""),format.raw/*16.164*/("""}"""),format.raw/*16.165*/(""""></div>
                </div>
                <br>
                <div class="row"><div class="span12 text-center"><strong>Optional fields:</strong></div></div>
                <br>
                <div class="row"><div class="span5 offset1">Occupations:</div></div>
                """),_display_(Seq[Any](/*22.18*/defining(Occupation.findAll())/*22.48*/ {occupations =>_display_(Seq[Any](format.raw/*22.64*/("""
                    <div class="row">
                        <div class="span5 offset1"><select class="span5 occupation" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*24.133*/occupations/*24.144*/.map/*24.148*/ {occupation =>_display_(Seq[Any](format.raw/*24.163*/(""" <option value=""""),_display_(Seq[Any](/*24.180*/occupation/*24.190*/.getId())),format.raw/*24.198*/("""" """),_display_(Seq[Any](/*24.201*/if(form("occupation1").value==occupation.getId().toString())/*24.261*/ {_display_(Seq[Any](format.raw/*24.263*/("""selected""")))})),format.raw/*24.272*/(""">"""),_display_(Seq[Any](/*24.274*/occupation/*24.284*/.getName())),format.raw/*24.294*/("""</option>""")))})),format.raw/*24.304*/("""</select></div>
                        <div class="span5"><select class="span5 occupation" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*25.125*/occupations/*25.136*/.map/*25.140*/ {occupation =>_display_(Seq[Any](format.raw/*25.155*/(""" <option value=""""),_display_(Seq[Any](/*25.172*/occupation/*25.182*/.getId())),format.raw/*25.190*/("""" """),_display_(Seq[Any](/*25.193*/if(form("occupation2").value==occupation.getId().toString())/*25.253*/ {_display_(Seq[Any](format.raw/*25.255*/("""selected""")))})),format.raw/*25.264*/(""">"""),_display_(Seq[Any](/*25.266*/occupation/*25.276*/.getName())),format.raw/*25.286*/("""</option>""")))})),format.raw/*25.296*/("""</select></div>
                    </div>
                """)))})),format.raw/*27.18*/("""
                <div class="row">
                    <div class="span2 offset1">Age:</div>
                    <div class="span2">Zip code:</div>
                    <div class="span2">Gender:</div>
                    <div class="span4">Interests:</div>
                </div>
                """),_display_(Seq[Any](/*34.18*/defining(Interest.findAll())/*34.46*/ {interests =>_display_(Seq[Any](format.raw/*34.60*/("""
                    <div class="row">
                        <div class="span2 offset1"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*36.165*/form("age")/*36.176*/.value)),format.raw/*36.182*/(""""></div>
                        <div class="span2"><input class="span2" type="text" id="zipCode" name="zipCode" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*37.150*/form("zipCode")/*37.165*/.value)),format.raw/*37.171*/(""""></div>
                        <div class="span1"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*38.127*/if(form("gender").value=="M")/*38.156*/ {_display_(Seq[Any](format.raw/*38.158*/("""checked""")))})),format.raw/*38.166*/("""><img src="assets/img/male.png"></label></div>
                        <div class="span1"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*39.129*/if(form("gender").value=="F")/*39.158*/ {_display_(Seq[Any](format.raw/*39.160*/("""checked""")))})),format.raw/*39.168*/("""><img src="assets/img/female.png"></label></div>
                        <div class="span4"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*40.121*/interests/*40.130*/.map/*40.134*/ {interest =>_display_(Seq[Any](format.raw/*40.147*/(""" <option value=""""),_display_(Seq[Any](/*40.164*/interest/*40.172*/.getId())),format.raw/*40.180*/("""" """),_display_(Seq[Any](/*40.183*/if(form("interest1").value==interest.getId().toString())/*40.239*/ {_display_(Seq[Any](format.raw/*40.241*/("""selected""")))})),format.raw/*40.250*/(""">"""),_display_(Seq[Any](/*40.252*/interest/*40.260*/.getName())),format.raw/*40.270*/("""</option>""")))})),format.raw/*40.280*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span4 offset7"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*43.129*/interests/*43.138*/.map/*43.142*/ {interest =>_display_(Seq[Any](format.raw/*43.155*/(""" <option value=""""),_display_(Seq[Any](/*43.172*/interest/*43.180*/.getId())),format.raw/*43.188*/("""" """),_display_(Seq[Any](/*43.191*/if(form("interest2").value==interest.getId().toString())/*43.247*/ {_display_(Seq[Any](format.raw/*43.249*/("""selected""")))})),format.raw/*43.258*/(""">"""),_display_(Seq[Any](/*43.260*/interest/*43.268*/.getName())),format.raw/*43.278*/("""</option>""")))})),format.raw/*43.288*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span4 offset7"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*46.129*/interests/*46.138*/.map/*46.142*/ {interest =>_display_(Seq[Any](format.raw/*46.155*/(""" <option value=""""),_display_(Seq[Any](/*46.172*/interest/*46.180*/.getId())),format.raw/*46.188*/("""" """),_display_(Seq[Any](/*46.191*/if(form("interest3").value==interest.getId().toString())/*46.247*/ {_display_(Seq[Any](format.raw/*46.249*/("""selected""")))})),format.raw/*46.258*/(""">"""),_display_(Seq[Any](/*46.260*/interest/*46.268*/.getName())),format.raw/*46.278*/("""</option>""")))})),format.raw/*46.288*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span4 offset7"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*49.129*/interests/*49.138*/.map/*49.142*/ {interest =>_display_(Seq[Any](format.raw/*49.155*/(""" <option value=""""),_display_(Seq[Any](/*49.172*/interest/*49.180*/.getId())),format.raw/*49.188*/("""" """),_display_(Seq[Any](/*49.191*/if(form("interest4").value==interest.getId().toString())/*49.247*/ {_display_(Seq[Any](format.raw/*49.249*/("""selected""")))})),format.raw/*49.258*/(""">"""),_display_(Seq[Any](/*49.260*/interest/*49.268*/.getName())),format.raw/*49.278*/("""</option>""")))})),format.raw/*49.288*/("""</select></div>
                    </div>
                """)))})),format.raw/*51.18*/("""
                <div class="row"><div class="span12 text-center"><i>Optional fields help match you with higher-paying videos!</i></div></div>
                <div class="row"><div class="span12 text-center"><button type="submit" class="btn btn-large btn-success">Submit</button></div></div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
    	$('#email').tooltip("""),format.raw/*58.26*/("""{"""),format.raw/*58.27*/("""placement: "bottom", title: "Must be between 1 and 63 characters.""""),format.raw/*58.93*/("""}"""),format.raw/*58.94*/(""")
    	$('#password').tooltip("""),format.raw/*59.29*/("""{"""),format.raw/*59.30*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*59.96*/("""}"""),format.raw/*59.97*/(""")
    	$('#passwordRepeat').tooltip("""),format.raw/*60.35*/("""{"""),format.raw/*60.36*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*60.102*/("""}"""),format.raw/*60.103*/(""")
    	$('#age').tooltip("""),format.raw/*61.24*/("""{"""),format.raw/*61.25*/("""placement: "bottom", title: "Match with videos for your age group.""""),format.raw/*61.92*/("""}"""),format.raw/*61.93*/(""")
    	$('#zipCode').tooltip("""),format.raw/*62.28*/("""{"""),format.raw/*62.29*/("""placement: "bottom", title: "Match with videos in your area.""""),format.raw/*62.90*/("""}"""),format.raw/*62.91*/(""")
    	$('#male').tooltip("""),format.raw/*63.25*/("""{"""),format.raw/*63.26*/("""placement: "bottom", title: "Match you with videos for guys.""""),format.raw/*63.87*/("""}"""),format.raw/*63.88*/(""")
    	$('#female').tooltip("""),format.raw/*64.27*/("""{"""),format.raw/*64.28*/("""placement: "bottom", title: "Match you with videos for gals.""""),format.raw/*64.89*/("""}"""),format.raw/*64.90*/(""")
    	$('.occupation').tooltip("""),format.raw/*65.31*/("""{"""),format.raw/*65.32*/("""placement: "bottom", title: "Match with videos related to your job.""""),format.raw/*65.100*/("""}"""),format.raw/*65.101*/(""")
    	$('.interest').tooltip("""),format.raw/*66.29*/("""{"""),format.raw/*66.30*/("""placement: "bottom", title: "Match with videos about your interests.""""),format.raw/*66.99*/("""}"""),format.raw/*66.100*/(""")
    </script>
""")))})))}
    }
    
    def render(form:Form[Signup.SignupForm]): play.api.templates.Html = apply(form)
    
    def f:((Form[Signup.SignupForm]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 04 16:23:14 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/signup.scala.html
                    HASH: b105abe4eeafe244f7aa0198d7e01df4ea28a143
                    MATRIX: 741->1|849->32|888->37|916->57|955->59|1077->146|1091->152|1126->166|1659->662|1682->675|1711->681|1752->693|1782->694|1815->698|1845->699|2023->848|2053->849|2086->853|2116->854|2313->1022|2343->1023|2376->1027|2406->1028|2735->1321|2774->1351|2828->1367|3038->1540|3059->1551|3073->1555|3127->1570|3181->1587|3201->1597|3232->1605|3272->1608|3342->1668|3383->1670|3425->1679|3464->1681|3484->1691|3517->1701|3560->1711|3738->1852|3759->1863|3773->1867|3827->1882|3881->1899|3901->1909|3932->1917|3972->1920|4042->1980|4083->1982|4125->1991|4164->1993|4184->2003|4217->2013|4260->2023|4354->2085|4694->2389|4731->2417|4783->2431|5025->2636|5046->2647|5075->2653|5271->2812|5296->2827|5325->2833|5498->2969|5537->2998|5578->3000|5619->3008|5832->3184|5871->3213|5912->3215|5953->3223|6160->3393|6179->3402|6193->3406|6245->3419|6299->3436|6317->3444|6348->3452|6388->3455|6454->3511|6495->3513|6537->3522|6576->3524|6594->3532|6627->3542|6670->3552|6919->3764|6938->3773|6952->3777|7004->3790|7058->3807|7076->3815|7107->3823|7147->3826|7213->3882|7254->3884|7296->3893|7335->3895|7353->3903|7386->3913|7429->3923|7678->4135|7697->4144|7711->4148|7763->4161|7817->4178|7835->4186|7866->4194|7906->4197|7972->4253|8013->4255|8055->4264|8094->4266|8112->4274|8145->4284|8188->4294|8437->4506|8456->4515|8470->4519|8522->4532|8576->4549|8594->4557|8625->4565|8665->4568|8731->4624|8772->4626|8814->4635|8853->4637|8871->4645|8904->4655|8947->4665|9041->4727|9475->5133|9504->5134|9598->5200|9627->5201|9686->5232|9715->5233|9809->5299|9838->5300|9903->5337|9932->5338|10027->5404|10057->5405|10111->5431|10140->5432|10235->5499|10264->5500|10322->5530|10351->5531|10440->5592|10469->5593|10524->5620|10553->5621|10642->5682|10671->5683|10728->5712|10757->5713|10846->5774|10875->5775|10936->5808|10965->5809|11062->5877|11092->5878|11151->5909|11180->5910|11277->5979|11307->5980
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|42->14|42->14|42->14|42->14|42->14|42->14|42->14|43->15|43->15|43->15|43->15|44->16|44->16|44->16|44->16|50->22|50->22|50->22|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|55->27|62->34|62->34|62->34|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|66->38|67->39|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|79->51|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|93->65|93->65|93->65|93->65|94->66|94->66|94->66|94->66
                    -- GENERATED --
                */
            