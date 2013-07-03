
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
object profile extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Form[Profile.ProfileForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, form: Form[Profile.ProfileForm]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""

"""),_display_(Seq[Any](/*3.2*/main(user, "profile")/*3.23*/ {_display_(Seq[Any](format.raw/*3.25*/("""
    <div class="row-fluid">
        <div class="span12 well">
            <form action=""""),_display_(Seq[Any](/*6.28*/routes/*6.34*/.Profile.post())),format.raw/*6.49*/("""" method="post">
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
    
    def render(user:User,form:Form[Profile.ProfileForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Profile.ProfileForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 03 10:39:05 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: d32c1231981b4624601b49b9be8c7ad2565762aa
                    MATRIX: 749->1|871->46|910->51|939->72|978->74|1106->167|1120->173|1156->188|1507->502|1533->518|1562->524|1603->536|1633->537|1666->541|1696->542|1858->667|1881->680|1910->686|1951->698|1981->699|2014->703|2044->704|2246->877|2276->878|2309->882|2339->883|2570->1085|2600->1086|2633->1090|2663->1091|3144->1535|3165->1546|3194->1552|3361->1682|3382->1693|3411->1699|3567->1818|3606->1847|3647->1849|3688->1857|3862->1994|3901->2023|3942->2025|3983->2033|4192->2206|4231->2236|4285->2252|4437->2367|4458->2378|4472->2382|4526->2397|4580->2414|4600->2424|4626->2427|4666->2430|4731->2485|4772->2487|4814->2496|4853->2498|4873->2508|4901->2513|4944->2523|5105->2647|5126->2658|5140->2662|5194->2677|5248->2694|5268->2704|5294->2707|5334->2710|5399->2765|5440->2767|5482->2776|5521->2778|5541->2788|5569->2793|5612->2803|5684->2843|5872->2995|5909->3023|5961->3037|6109->3148|6128->3157|6142->3161|6194->3174|6248->3191|6266->3199|6292->3202|6332->3205|6393->3256|6434->3258|6476->3267|6515->3269|6533->3277|6561->3282|6604->3292|6761->3412|6780->3421|6794->3425|6846->3438|6900->3455|6918->3463|6944->3466|6984->3469|7045->3520|7086->3522|7128->3531|7167->3533|7185->3541|7213->3546|7256->3556|7451->3714|7470->3723|7484->3727|7536->3740|7590->3757|7608->3765|7634->3768|7674->3771|7735->3822|7776->3824|7818->3833|7857->3835|7875->3843|7903->3848|7946->3858|8103->3978|8122->3987|8136->3991|8188->4004|8242->4021|8260->4029|8286->4032|8326->4035|8387->4086|8428->4088|8470->4097|8509->4099|8527->4107|8555->4112|8598->4122|8670->4162|9091->4555|9120->4556|9213->4621|9242->4622|9301->4653|9330->4654|9423->4719|9452->4720|9514->4754|9543->4755|9636->4820|9665->4821|9733->4861|9762->4862|9856->4927|9886->4928|9943->4957|9972->4958|10067->5025|10096->5026|10153->5055|10182->5056|10271->5117|10300->5118|10358->5148|10387->5149|10476->5210|10505->5211|10565->5243|10594->5244|10683->5305|10712->5306|10776->5342|10805->5343|10902->5411|10932->5412|10994->5446|11023->5447|11121->5516|11151->5517
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|42->14|42->14|42->14|42->14|44->16|44->16|44->16|44->16|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|55->27|56->28|56->28|56->28|56->28|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|73->45|83->55|83->55|83->55|83->55|84->56|84->56|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64
                    -- GENERATED --
                */
            