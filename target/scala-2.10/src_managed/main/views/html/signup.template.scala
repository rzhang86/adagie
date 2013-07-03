
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
                <div class="row">
                    <div class="span3 offset2"><input class="span3" type="text" id="username" name="username" placeholder="Username" value=""""),_display_(Seq[Any](/*9.142*/form("username")/*9.158*/.value)),format.raw/*9.164*/("""" pattern="."""),format.raw/*9.176*/("""{"""),format.raw/*9.177*/("""1,31"""),format.raw/*9.181*/("""}"""),format.raw/*9.182*/(""""></div>
                    <div class="span3"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*10.140*/("""{"""),format.raw/*10.141*/("""6,31"""),format.raw/*10.145*/("""}"""),format.raw/*10.146*/(""""></div>
                    <div class="span3"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*11.159*/("""{"""),format.raw/*11.160*/("""6,31"""),format.raw/*11.164*/("""}"""),format.raw/*11.165*/(""""></div>
                </div>
                <div class="row">
                    <div class="span5 offset2"><input class="span5" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*14.134*/form("email")/*14.147*/.value)),format.raw/*14.153*/("""" pattern="."""),format.raw/*14.165*/("""{"""),format.raw/*14.166*/("""1,63"""),format.raw/*14.170*/("""}"""),format.raw/*14.171*/(""""></div>
                </div>
                <br>
                <div class="row"><div class="span12 text-center"><strong>Optional fields: *</strong></div></div>
                <div class="row">
                    <div class="span2 offset2"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*19.161*/form("age")/*19.172*/.value)),format.raw/*19.178*/(""""></div>
                    <div class="span2"><input class="span2" type="text" id="zip" name="zip" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*20.138*/form("zip")/*20.149*/.value)),format.raw/*20.155*/(""""></div>
                    <div class="span1"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*21.123*/if(form("gender").value=="M")/*21.152*/ {_display_(Seq[Any](format.raw/*21.154*/("""checked""")))})),format.raw/*21.162*/("""><img src="assets/img/male.png"></label></div>
                    <div class="span1"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*22.125*/if(form("gender").value=="F")/*22.154*/ {_display_(Seq[Any](format.raw/*22.156*/("""checked""")))})),format.raw/*22.164*/("""><img src="assets/img/female.png"></label></div>
                </div>
                """),_display_(Seq[Any](/*24.18*/defining(Occupation.findAll())/*24.48*/ {occupations =>_display_(Seq[Any](format.raw/*24.64*/("""
                    <div class="row">
                        <div class="span2 text-right">Occupations:</div>
                        <div class="span7"><select class="span7 occupation" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*27.125*/occupations/*27.136*/.map/*27.140*/ {occupation =>_display_(Seq[Any](format.raw/*27.155*/(""" <option value=""""),_display_(Seq[Any](/*27.172*/occupation/*27.182*/.id)),format.raw/*27.185*/("""" """),_display_(Seq[Any](/*27.188*/if(form("occupation1").value==occupation.id)/*27.232*/ {_display_(Seq[Any](format.raw/*27.234*/("""selected""")))})),format.raw/*27.243*/(""">"""),_display_(Seq[Any](/*27.245*/occupation/*27.255*/.name)),format.raw/*27.260*/("""</option>""")))})),format.raw/*27.270*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span7 offset2"><select class="span7 occupation" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*30.133*/occupations/*30.144*/.map/*30.148*/ {occupation =>_display_(Seq[Any](format.raw/*30.163*/(""" <option value=""""),_display_(Seq[Any](/*30.180*/occupation/*30.190*/.id)),format.raw/*30.193*/("""" """),_display_(Seq[Any](/*30.196*/if(form("occupation2").value==occupation.id)/*30.240*/ {_display_(Seq[Any](format.raw/*30.242*/("""selected""")))})),format.raw/*30.251*/(""">"""),_display_(Seq[Any](/*30.253*/occupation/*30.263*/.name)),format.raw/*30.268*/("""</option>""")))})),format.raw/*30.278*/("""</select></div>
                    </div>
                """)))})),format.raw/*32.18*/("""
                """),_display_(Seq[Any](/*33.18*/defining(Interest.findAll())/*33.46*/ {interests =>_display_(Seq[Any](format.raw/*33.60*/("""
                    <div class="row">
                        <div class="span2 text-right">Interests:</div>
                        <div class="span4"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*36.121*/interests/*36.130*/.map/*36.134*/ {interest =>_display_(Seq[Any](format.raw/*36.147*/(""" <option value=""""),_display_(Seq[Any](/*36.164*/interest/*36.172*/.id)),format.raw/*36.175*/("""" """),_display_(Seq[Any](/*36.178*/if(form("interest1").value==interest.id)/*36.218*/ {_display_(Seq[Any](format.raw/*36.220*/("""selected""")))})),format.raw/*36.229*/(""">"""),_display_(Seq[Any](/*36.231*/interest/*36.239*/.name)),format.raw/*36.244*/("""</option>""")))})),format.raw/*36.254*/("""</select></div>
                        <div class="span4"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*37.121*/interests/*37.130*/.map/*37.134*/ {interest =>_display_(Seq[Any](format.raw/*37.147*/(""" <option value=""""),_display_(Seq[Any](/*37.164*/interest/*37.172*/.id)),format.raw/*37.175*/("""" """),_display_(Seq[Any](/*37.178*/if(form("interest2").value==interest.id)/*37.218*/ {_display_(Seq[Any](format.raw/*37.220*/("""selected""")))})),format.raw/*37.229*/(""">"""),_display_(Seq[Any](/*37.231*/interest/*37.239*/.name)),format.raw/*37.244*/("""</option>""")))})),format.raw/*37.254*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span4 offset2"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*40.129*/interests/*40.138*/.map/*40.142*/ {interest =>_display_(Seq[Any](format.raw/*40.155*/(""" <option value=""""),_display_(Seq[Any](/*40.172*/interest/*40.180*/.id)),format.raw/*40.183*/("""" """),_display_(Seq[Any](/*40.186*/if(form("interest3").value==interest.id)/*40.226*/ {_display_(Seq[Any](format.raw/*40.228*/("""selected""")))})),format.raw/*40.237*/(""">"""),_display_(Seq[Any](/*40.239*/interest/*40.247*/.name)),format.raw/*40.252*/("""</option>""")))})),format.raw/*40.262*/("""</select></div>
                        <div class="span4"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*41.121*/interests/*41.130*/.map/*41.134*/ {interest =>_display_(Seq[Any](format.raw/*41.147*/(""" <option value=""""),_display_(Seq[Any](/*41.164*/interest/*41.172*/.id)),format.raw/*41.175*/("""" """),_display_(Seq[Any](/*41.178*/if(form("interest4").value==interest.id)/*41.218*/ {_display_(Seq[Any](format.raw/*41.220*/("""selected""")))})),format.raw/*41.229*/(""">"""),_display_(Seq[Any](/*41.231*/interest/*41.239*/.name)),format.raw/*41.244*/("""</option>""")))})),format.raw/*41.254*/("""</select></div>
                    </div>
                """)))})),format.raw/*43.18*/("""
                <p class="text-center"><i>* Optional fields help match you with higher-paying videos!</i><p>
                <p class="text-center"><button type="submit" class="btn btn-large btn-success">Submit</button></p>
            </form>
        </div>
    </div>
    <script type="text/javascript">
    	$('#username').tooltip("""),format.raw/*50.29*/("""{"""),format.raw/*50.30*/("""placement: "top", title: "Must be between 1 and 31 characters.""""),format.raw/*50.93*/("""}"""),format.raw/*50.94*/(""")
    	$('#email').tooltip("""),format.raw/*51.26*/("""{"""),format.raw/*51.27*/("""placement: "top", title: "Must be between 1 and 63 characters.""""),format.raw/*51.90*/("""}"""),format.raw/*51.91*/(""")
    	$('#password').tooltip("""),format.raw/*52.29*/("""{"""),format.raw/*52.30*/("""placement: "top", title: "Must be between 6 and 31 characters.""""),format.raw/*52.93*/("""}"""),format.raw/*52.94*/(""")
    	$('#passwordRepeat').tooltip("""),format.raw/*53.35*/("""{"""),format.raw/*53.36*/("""placement: "top", title: "Must be between 6 and 31 characters.""""),format.raw/*53.99*/("""}"""),format.raw/*53.100*/(""")
    	$('#age').tooltip("""),format.raw/*54.24*/("""{"""),format.raw/*54.25*/("""placement: "top", title: "Match with videos for your age group.""""),format.raw/*54.89*/("""}"""),format.raw/*54.90*/(""")
    	$('#zip').tooltip("""),format.raw/*55.24*/("""{"""),format.raw/*55.25*/("""placement: "top", title: "Match with videos in your area.""""),format.raw/*55.83*/("""}"""),format.raw/*55.84*/(""")
    	$('#male').tooltip("""),format.raw/*56.25*/("""{"""),format.raw/*56.26*/("""placement: "top", title: "Match you with videos for guys.""""),format.raw/*56.84*/("""}"""),format.raw/*56.85*/(""")
    	$('#female').tooltip("""),format.raw/*57.27*/("""{"""),format.raw/*57.28*/("""placement: "top", title: "Match you with videos for gals.""""),format.raw/*57.86*/("""}"""),format.raw/*57.87*/(""")
    	$('.occupation').tooltip("""),format.raw/*58.31*/("""{"""),format.raw/*58.32*/("""placement: "top", title: "Match with videos related to your job.""""),format.raw/*58.97*/("""}"""),format.raw/*58.98*/(""")
    	$('.interest').tooltip("""),format.raw/*59.29*/("""{"""),format.raw/*59.30*/("""placement: "top", title: "Match with videos about your interests.""""),format.raw/*59.96*/("""}"""),format.raw/*59.97*/(""")
    </script>
""")))})))}
    }
    
    def render(form:Form[Signup.SignupForm]): play.api.templates.Html = apply(form)
    
    def f:((Form[Signup.SignupForm]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 03 18:46:14 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/signup.scala.html
                    HASH: 820458a6b7627d1614831371e34f3888ee5a9ab4
                    MATRIX: 741->1|849->32|888->37|916->57|955->59|1077->146|1091->152|1126->166|1468->472|1493->488|1521->494|1561->506|1590->507|1622->511|1651->512|1829->661|1859->662|1892->666|1922->667|2119->835|2149->836|2182->840|2212->841|2451->1043|2474->1056|2503->1062|2544->1074|2574->1075|2607->1079|2637->1080|3039->1445|3060->1456|3089->1462|3273->1609|3294->1620|3323->1626|3492->1758|3531->1787|3572->1789|3613->1797|3822->1969|3861->1998|3902->2000|3943->2008|4070->2099|4109->2129|4163->2145|4439->2384|4460->2395|4474->2399|4528->2414|4582->2431|4602->2441|4628->2444|4668->2447|4722->2491|4763->2493|4805->2502|4844->2504|4864->2514|4892->2519|4935->2529|5188->2745|5209->2756|5223->2760|5277->2775|5331->2792|5351->2802|5377->2805|5417->2808|5471->2852|5512->2854|5554->2863|5593->2865|5613->2875|5641->2880|5684->2890|5778->2952|5833->2971|5870->2999|5922->3013|6192->3246|6211->3255|6225->3259|6277->3272|6331->3289|6349->3297|6375->3300|6415->3303|6465->3343|6506->3345|6548->3354|6587->3356|6605->3364|6633->3369|6676->3379|6850->3516|6869->3525|6883->3529|6935->3542|6989->3559|7007->3567|7033->3570|7073->3573|7123->3613|7164->3615|7206->3624|7245->3626|7263->3634|7291->3639|7334->3649|7583->3861|7602->3870|7616->3874|7668->3887|7722->3904|7740->3912|7766->3915|7806->3918|7856->3958|7897->3960|7939->3969|7978->3971|7996->3979|8024->3984|8067->3994|8241->4131|8260->4140|8274->4144|8326->4157|8380->4174|8398->4182|8424->4185|8464->4188|8514->4228|8555->4230|8597->4239|8636->4241|8654->4249|8682->4254|8725->4264|8819->4326|9189->4668|9218->4669|9309->4732|9338->4733|9394->4761|9423->4762|9514->4825|9543->4826|9602->4857|9631->4858|9722->4921|9751->4922|9816->4959|9845->4960|9936->5023|9966->5024|10020->5050|10049->5051|10141->5115|10170->5116|10224->5142|10253->5143|10339->5201|10368->5202|10423->5229|10452->5230|10538->5288|10567->5289|10624->5318|10653->5319|10739->5377|10768->5378|10829->5411|10858->5412|10951->5477|10980->5478|11039->5509|11068->5510|11162->5576|11191->5577
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|37->9|37->9|37->9|37->9|37->9|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|39->11|42->14|42->14|42->14|42->14|42->14|42->14|42->14|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|49->21|50->22|50->22|50->22|50->22|52->24|52->24|52->24|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|60->32|61->33|61->33|61->33|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|71->43|78->50|78->50|78->50|78->50|79->51|79->51|79->51|79->51|80->52|80->52|80->52|80->52|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|83->55|83->55|83->55|83->55|84->56|84->56|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59
                    -- GENERATED --
                */
            