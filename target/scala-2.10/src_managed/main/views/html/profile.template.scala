
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
object profile extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Form[Application.ProfileForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, form: Form[Application.ProfileForm]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.51*/("""

"""),_display_(Seq[Any](/*3.2*/main(user, "profile")/*3.23*/ {_display_(Seq[Any](format.raw/*3.25*/("""
    <div class="row-fluid">
        <div class="span12 well">
            <form action=""""),_display_(Seq[Any](/*6.28*/routes/*6.34*/.Application.postProfile())),format.raw/*6.60*/("""" method="post">
                <div class="span5">
                    <h5>Required fields:</h5>
                    <div class="span12">
                        <ul class="inline">
                            <p><input type="text" class="span9" id="username" name="username" placeholder="Username" value=""""),_display_(Seq[Any](/*11.126*/form("username")/*11.142*/.value)),format.raw/*11.148*/("""" pattern="."""),format.raw/*11.160*/("""{"""),format.raw/*11.161*/("""1,31"""),format.raw/*11.165*/("""}"""),format.raw/*11.166*/(""""></p>
                            <p><input type="email" class="span9" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*12.118*/form("email")/*12.131*/.value)),format.raw/*12.137*/("""" pattern="."""),format.raw/*12.149*/("""{"""),format.raw/*12.150*/("""1,63"""),format.raw/*12.154*/("""}"""),format.raw/*12.155*/(""""></p>
                            <p>
                                <input type="password" class="span9" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*14.133*/("""{"""),format.raw/*14.134*/("""6,31"""),format.raw/*14.138*/("""}"""),format.raw/*14.139*/("""" disabled>
                                <br>
                                <input type="password" class="span9" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*16.152*/("""{"""),format.raw/*16.153*/("""6,31"""),format.raw/*16.157*/("""}"""),format.raw/*16.158*/("""" disabled>
                            </p>
                        </ul>
                    </div>
                </div>
                <div class="span7">
                    <h5>Optional fields: *</h5>
                    <div class="span12">
                        <ul class="inline">
                            <input type="number" class="span3" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*25.142*/form("age")/*25.153*/.value)),format.raw/*25.159*/("""">
                            <input type="text" class="span3" id="zip" name="zip" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*26.127*/form("zip")/*26.138*/.value)),format.raw/*26.144*/("""">
                            <li><label id="male" class="radio inline"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*27.116*/if(form("gender").value=="M")/*27.145*/ {_display_(Seq[Any](format.raw/*27.147*/("""checked""")))})),format.raw/*27.155*/(""">Male</label></li>
                            <li><label id="female" class="radio inline"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*28.118*/if(form("gender").value=="F")/*28.147*/ {_display_(Seq[Any](format.raw/*28.149*/("""checked""")))})),format.raw/*28.157*/(""">Female</label></li>
                        </ul>
                        <p>Occupations:</p>
                        <div class="span12">
                            """),_display_(Seq[Any](/*32.30*/defining(Occupation.findAll())/*32.60*/ {occupations =>_display_(Seq[Any](format.raw/*32.76*/("""
                                <select name="occupation1" class="span5 occupation"><option value="-1"></option>"""),_display_(Seq[Any](/*33.114*/occupations/*33.125*/.map/*33.129*/ {occupation =>_display_(Seq[Any](format.raw/*33.144*/(""" <option value=""""),_display_(Seq[Any](/*33.161*/occupation/*33.171*/.id)),format.raw/*33.174*/("""" """),_display_(Seq[Any](/*33.177*/if(form("occupation1").value==occupation.id.toString())/*33.232*/ {_display_(Seq[Any](format.raw/*33.234*/("""selected""")))})),format.raw/*33.243*/(""">"""),_display_(Seq[Any](/*33.245*/occupation/*33.255*/.name)),format.raw/*33.260*/("""</option>""")))})),format.raw/*33.270*/("""</select>
                                <select name="occupation2" class="span5 occupation"><option value="-1"></option>"""),_display_(Seq[Any](/*34.114*/occupations/*34.125*/.map/*34.129*/ {occupation =>_display_(Seq[Any](format.raw/*34.144*/(""" <option value=""""),_display_(Seq[Any](/*34.161*/occupation/*34.171*/.id)),format.raw/*34.174*/("""" """),_display_(Seq[Any](/*34.177*/if(form("occupation2").value==occupation.id.toString())/*34.232*/ {_display_(Seq[Any](format.raw/*34.234*/("""selected""")))})),format.raw/*34.243*/(""">"""),_display_(Seq[Any](/*34.245*/occupation/*34.255*/.name)),format.raw/*34.260*/("""</option>""")))})),format.raw/*34.270*/("""</select>
                            """)))})),format.raw/*35.30*/("""
                        </div>
                        <p>Interests:</p>
                        <div class="span12">
                            """),_display_(Seq[Any](/*39.30*/defining(Interest.findAll())/*39.58*/ {interests =>_display_(Seq[Any](format.raw/*39.72*/("""
                                <select name="interest1" class="span5 interest"><option value="-1"></option>"""),_display_(Seq[Any](/*40.110*/interests/*40.119*/.map/*40.123*/ {interest =>_display_(Seq[Any](format.raw/*40.136*/(""" <option value=""""),_display_(Seq[Any](/*40.153*/interest/*40.161*/.id)),format.raw/*40.164*/("""" """),_display_(Seq[Any](/*40.167*/if(form("interest1").value==interest.id.toString())/*40.218*/ {_display_(Seq[Any](format.raw/*40.220*/("""selected""")))})),format.raw/*40.229*/(""">"""),_display_(Seq[Any](/*40.231*/interest/*40.239*/.name)),format.raw/*40.244*/("""</option>""")))})),format.raw/*40.254*/("""</select>
                                <select name="interest2" class="span5 interest"><option value="-1"></option>"""),_display_(Seq[Any](/*41.110*/interests/*41.119*/.map/*41.123*/ {interest =>_display_(Seq[Any](format.raw/*41.136*/(""" <option value=""""),_display_(Seq[Any](/*41.153*/interest/*41.161*/.id)),format.raw/*41.164*/("""" """),_display_(Seq[Any](/*41.167*/if(form("interest2").value==interest.id.toString())/*41.218*/ {_display_(Seq[Any](format.raw/*41.220*/("""selected""")))})),format.raw/*41.229*/(""">"""),_display_(Seq[Any](/*41.231*/interest/*41.239*/.name)),format.raw/*41.244*/("""</option>""")))})),format.raw/*41.254*/("""</select>
                                <br>
                                <select name="interest3" class="span5 interest"><option value="-1"></option>"""),_display_(Seq[Any](/*43.110*/interests/*43.119*/.map/*43.123*/ {interest =>_display_(Seq[Any](format.raw/*43.136*/(""" <option value=""""),_display_(Seq[Any](/*43.153*/interest/*43.161*/.id)),format.raw/*43.164*/("""" """),_display_(Seq[Any](/*43.167*/if(form("interest3").value==interest.id.toString())/*43.218*/ {_display_(Seq[Any](format.raw/*43.220*/("""selected""")))})),format.raw/*43.229*/(""">"""),_display_(Seq[Any](/*43.231*/interest/*43.239*/.name)),format.raw/*43.244*/("""</option>""")))})),format.raw/*43.254*/("""</select>
                                <select name="interest4" class="span5 interest"><option value="-1"></option>"""),_display_(Seq[Any](/*44.110*/interests/*44.119*/.map/*44.123*/ {interest =>_display_(Seq[Any](format.raw/*44.136*/(""" <option value=""""),_display_(Seq[Any](/*44.153*/interest/*44.161*/.id)),format.raw/*44.164*/("""" """),_display_(Seq[Any](/*44.167*/if(form("interest4").value==interest.id.toString())/*44.218*/ {_display_(Seq[Any](format.raw/*44.220*/("""selected""")))})),format.raw/*44.229*/(""">"""),_display_(Seq[Any](/*44.231*/interest/*44.239*/.name)),format.raw/*44.244*/("""</option>""")))})),format.raw/*44.254*/("""</select>
                            """)))})),format.raw/*45.30*/("""
                        </div>
                    </div>
                    <p><i>* Optional fields help match you with higher-paying videos!</i><p>
                </div>
                <p><button type="submit" class="btn btn-large btn-success">Submit</button></p>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        $('#username').tooltip("""),format.raw/*55.32*/("""{"""),format.raw/*55.33*/("""placement: "right", title: "Must be between 1 and 31 characters.""""),format.raw/*55.98*/("""}"""),format.raw/*55.99*/(""")
        $('#email').tooltip("""),format.raw/*56.29*/("""{"""),format.raw/*56.30*/("""placement: "right", title: "Must be between 1 and 63 characters.""""),format.raw/*56.95*/("""}"""),format.raw/*56.96*/(""")
        $('#password').tooltip("""),format.raw/*57.32*/("""{"""),format.raw/*57.33*/("""placement: "right", title: "Must be between 6 and 31 characters.""""),format.raw/*57.98*/("""}"""),format.raw/*57.99*/(""")
        $('#passwordRepeat').tooltip("""),format.raw/*58.38*/("""{"""),format.raw/*58.39*/("""placement: "right", title: "Must be between 6 and 31 characters.""""),format.raw/*58.104*/("""}"""),format.raw/*58.105*/(""")
        $('#age').tooltip("""),format.raw/*59.27*/("""{"""),format.raw/*59.28*/("""placement: "bottom", title: "Match with videos for your age group.""""),format.raw/*59.95*/("""}"""),format.raw/*59.96*/(""")
        $('#zip').tooltip("""),format.raw/*60.27*/("""{"""),format.raw/*60.28*/("""placement: "bottom", title: "Match with videos in your area.""""),format.raw/*60.89*/("""}"""),format.raw/*60.90*/(""")
        $('#male').tooltip("""),format.raw/*61.28*/("""{"""),format.raw/*61.29*/("""placement: "bottom", title: "Match you with videos for guys.""""),format.raw/*61.90*/("""}"""),format.raw/*61.91*/(""")
        $('#female').tooltip("""),format.raw/*62.30*/("""{"""),format.raw/*62.31*/("""placement: "bottom", title: "Match you with videos for gals.""""),format.raw/*62.92*/("""}"""),format.raw/*62.93*/(""")
        $('.occupation').tooltip("""),format.raw/*63.34*/("""{"""),format.raw/*63.35*/("""placement: "bottom", title: "Match with videos related to your job.""""),format.raw/*63.103*/("""}"""),format.raw/*63.104*/(""")
        $('.interest').tooltip("""),format.raw/*64.32*/("""{"""),format.raw/*64.33*/("""placement: "bottom", title: "Match with videos about your interests.""""),format.raw/*64.102*/("""}"""),format.raw/*64.103*/(""")
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Application.ProfileForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Application.ProfileForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jul 02 23:09:01 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: c0dbdf199b2e4032c00bc608a66d898028d69647
                    MATRIX: 753->1|879->50|918->55|947->76|986->78|1114->171|1128->177|1175->203|1526->517|1552->533|1581->539|1622->551|1652->552|1685->556|1715->557|1877->682|1900->695|1929->701|1970->713|2000->714|2033->718|2063->719|2265->892|2295->893|2328->897|2358->898|2589->1100|2619->1101|2652->1105|2682->1106|3163->1550|3184->1561|3213->1567|3380->1697|3401->1708|3430->1714|3586->1833|3625->1862|3666->1864|3707->1872|3881->2009|3920->2038|3961->2040|4002->2048|4211->2221|4250->2251|4304->2267|4456->2382|4477->2393|4491->2397|4545->2412|4599->2429|4619->2439|4645->2442|4685->2445|4750->2500|4791->2502|4833->2511|4872->2513|4892->2523|4920->2528|4963->2538|5124->2662|5145->2673|5159->2677|5213->2692|5267->2709|5287->2719|5313->2722|5353->2725|5418->2780|5459->2782|5501->2791|5540->2793|5560->2803|5588->2808|5631->2818|5703->2858|5891->3010|5928->3038|5980->3052|6128->3163|6147->3172|6161->3176|6213->3189|6267->3206|6285->3214|6311->3217|6351->3220|6412->3271|6453->3273|6495->3282|6534->3284|6552->3292|6580->3297|6623->3307|6780->3427|6799->3436|6813->3440|6865->3453|6919->3470|6937->3478|6963->3481|7003->3484|7064->3535|7105->3537|7147->3546|7186->3548|7204->3556|7232->3561|7275->3571|7470->3729|7489->3738|7503->3742|7555->3755|7609->3772|7627->3780|7653->3783|7693->3786|7754->3837|7795->3839|7837->3848|7876->3850|7894->3858|7922->3863|7965->3873|8122->3993|8141->4002|8155->4006|8207->4019|8261->4036|8279->4044|8305->4047|8345->4050|8406->4101|8447->4103|8489->4112|8528->4114|8546->4122|8574->4127|8617->4137|8689->4177|9110->4570|9139->4571|9232->4636|9261->4637|9320->4668|9349->4669|9442->4734|9471->4735|9533->4769|9562->4770|9655->4835|9684->4836|9752->4876|9781->4877|9875->4942|9905->4943|9962->4972|9991->4973|10086->5040|10115->5041|10172->5070|10201->5071|10290->5132|10319->5133|10377->5163|10406->5164|10495->5225|10524->5226|10584->5258|10613->5259|10702->5320|10731->5321|10795->5357|10824->5358|10921->5426|10951->5427|11013->5461|11042->5462|11140->5531|11170->5532
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|42->14|42->14|42->14|42->14|44->16|44->16|44->16|44->16|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|55->27|56->28|56->28|56->28|56->28|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|73->45|83->55|83->55|83->55|83->55|84->56|84->56|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64
                    -- GENERATED --
                */
            