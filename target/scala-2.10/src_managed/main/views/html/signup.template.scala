
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
object signup extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Lobby.SignupForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(form: Form[Lobby.SignupForm]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),_display_(Seq[Any](/*3.2*/main(null, "signup")/*3.22*/ {_display_(Seq[Any](format.raw/*3.24*/("""
    <div class="row-fluid">
        <div class="span12 well">
            <form action=""""),_display_(Seq[Any](/*6.28*/routes/*6.34*/.Lobby.readSignupForm())),format.raw/*6.57*/("""" method="post">
                <div class="span5">
                    <h5>Required fields:</h5>
                    <div class="span12">
                        <ul class="inline">
                            <p><input type="text" class="span9" id="username" name="username" placeholder="Username" value=""""),_display_(Seq[Any](/*11.126*/form("username")/*11.142*/.value)),format.raw/*11.148*/("""" pattern="."""),format.raw/*11.160*/("""{"""),format.raw/*11.161*/("""1,31"""),format.raw/*11.165*/("""}"""),format.raw/*11.166*/(""""></p>
                            <p><input type="email" class="span9" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*12.118*/form("email")/*12.131*/.value)),format.raw/*12.137*/("""" pattern="."""),format.raw/*12.149*/("""{"""),format.raw/*12.150*/("""1,63"""),format.raw/*12.154*/("""}"""),format.raw/*12.155*/(""""></p>
                            <p>
                                <input type="password" class="span9" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*14.133*/("""{"""),format.raw/*14.134*/("""6,31"""),format.raw/*14.138*/("""}"""),format.raw/*14.139*/("""">
                                <br>
                                <input type="password" class="span9" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*16.152*/("""{"""),format.raw/*16.153*/("""6,31"""),format.raw/*16.157*/("""}"""),format.raw/*16.158*/("""">
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
                                <select name="occupation1" class="span5 occupation"><option value="-1"></option>"""),_display_(Seq[Any](/*33.114*/occupations/*33.125*/.map/*33.129*/ {occupation =>_display_(Seq[Any](format.raw/*33.144*/(""" <option value=""""),_display_(Seq[Any](/*33.161*/occupation/*33.171*/.id)),format.raw/*33.174*/("""" """),_display_(Seq[Any](/*33.177*/if(form("occupation1").value==occupation.id)/*33.221*/ {_display_(Seq[Any](format.raw/*33.223*/("""selected""")))})),format.raw/*33.232*/(""">"""),_display_(Seq[Any](/*33.234*/occupation/*33.244*/.name)),format.raw/*33.249*/("""</option>""")))})),format.raw/*33.259*/("""</select>
                                <select name="occupation2" class="span5 occupation"><option value="-1"></option>"""),_display_(Seq[Any](/*34.114*/occupations/*34.125*/.map/*34.129*/ {occupation =>_display_(Seq[Any](format.raw/*34.144*/(""" <option value=""""),_display_(Seq[Any](/*34.161*/occupation/*34.171*/.id)),format.raw/*34.174*/("""" """),_display_(Seq[Any](/*34.177*/if(form("occupation2").value==occupation.id)/*34.221*/ {_display_(Seq[Any](format.raw/*34.223*/("""selected""")))})),format.raw/*34.232*/(""">"""),_display_(Seq[Any](/*34.234*/occupation/*34.244*/.name)),format.raw/*34.249*/("""</option>""")))})),format.raw/*34.259*/("""</select>
                            """)))})),format.raw/*35.30*/("""
                        </div>
                        <p>Interests:</p>
                        <div class="span12">
                            """),_display_(Seq[Any](/*39.30*/defining(Interest.findAll())/*39.58*/ {interests =>_display_(Seq[Any](format.raw/*39.72*/("""
                                <select name="interest1" class="span5 interest"><option value="-1"></option>"""),_display_(Seq[Any](/*40.110*/interests/*40.119*/.map/*40.123*/ {interest =>_display_(Seq[Any](format.raw/*40.136*/(""" <option value=""""),_display_(Seq[Any](/*40.153*/interest/*40.161*/.id)),format.raw/*40.164*/("""" """),_display_(Seq[Any](/*40.167*/if(form("interest1").value==interest.id)/*40.207*/ {_display_(Seq[Any](format.raw/*40.209*/("""selected""")))})),format.raw/*40.218*/(""">"""),_display_(Seq[Any](/*40.220*/interest/*40.228*/.name)),format.raw/*40.233*/("""</option>""")))})),format.raw/*40.243*/("""</select>
                                <select name="interest2" class="span5 interest"><option value="-1"></option>"""),_display_(Seq[Any](/*41.110*/interests/*41.119*/.map/*41.123*/ {interest =>_display_(Seq[Any](format.raw/*41.136*/(""" <option value=""""),_display_(Seq[Any](/*41.153*/interest/*41.161*/.id)),format.raw/*41.164*/("""" """),_display_(Seq[Any](/*41.167*/if(form("interest2").value==interest.id)/*41.207*/ {_display_(Seq[Any](format.raw/*41.209*/("""selected""")))})),format.raw/*41.218*/(""">"""),_display_(Seq[Any](/*41.220*/interest/*41.228*/.name)),format.raw/*41.233*/("""</option>""")))})),format.raw/*41.243*/("""</select>
                                <br>
                                <select name="interest3" class="span5 interest"><option value="-1"></option>"""),_display_(Seq[Any](/*43.110*/interests/*43.119*/.map/*43.123*/ {interest =>_display_(Seq[Any](format.raw/*43.136*/(""" <option value=""""),_display_(Seq[Any](/*43.153*/interest/*43.161*/.id)),format.raw/*43.164*/("""" """),_display_(Seq[Any](/*43.167*/if(form("interest3").value==interest.id)/*43.207*/ {_display_(Seq[Any](format.raw/*43.209*/("""selected""")))})),format.raw/*43.218*/(""">"""),_display_(Seq[Any](/*43.220*/interest/*43.228*/.name)),format.raw/*43.233*/("""</option>""")))})),format.raw/*43.243*/("""</select>
                                <select name="interest4" class="span5 interest"><option value="-1"></option>"""),_display_(Seq[Any](/*44.110*/interests/*44.119*/.map/*44.123*/ {interest =>_display_(Seq[Any](format.raw/*44.136*/(""" <option value=""""),_display_(Seq[Any](/*44.153*/interest/*44.161*/.id)),format.raw/*44.164*/("""" """),_display_(Seq[Any](/*44.167*/if(form("interest4").value==interest.id)/*44.207*/ {_display_(Seq[Any](format.raw/*44.209*/("""selected""")))})),format.raw/*44.218*/(""">"""),_display_(Seq[Any](/*44.220*/interest/*44.228*/.name)),format.raw/*44.233*/("""</option>""")))})),format.raw/*44.243*/("""</select>
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
    	$('#username').tooltip("""),format.raw/*55.29*/("""{"""),format.raw/*55.30*/("""placement: "right", title: "Must be between 1 and 31 characters.""""),format.raw/*55.95*/("""}"""),format.raw/*55.96*/(""")
    	$('#email').tooltip("""),format.raw/*56.26*/("""{"""),format.raw/*56.27*/("""placement: "right", title: "Must be between 1 and 63 characters.""""),format.raw/*56.92*/("""}"""),format.raw/*56.93*/(""")
    	$('#password').tooltip("""),format.raw/*57.29*/("""{"""),format.raw/*57.30*/("""placement: "right", title: "Must be between 6 and 31 characters.""""),format.raw/*57.95*/("""}"""),format.raw/*57.96*/(""")
    	$('#passwordRepeat').tooltip("""),format.raw/*58.35*/("""{"""),format.raw/*58.36*/("""placement: "right", title: "Must be between 6 and 31 characters.""""),format.raw/*58.101*/("""}"""),format.raw/*58.102*/(""")
    	$('#age').tooltip("""),format.raw/*59.24*/("""{"""),format.raw/*59.25*/("""placement: "bottom", title: "Match with videos for your age group.""""),format.raw/*59.92*/("""}"""),format.raw/*59.93*/(""")
    	$('#zip').tooltip("""),format.raw/*60.24*/("""{"""),format.raw/*60.25*/("""placement: "bottom", title: "Match with videos in your area.""""),format.raw/*60.86*/("""}"""),format.raw/*60.87*/(""")
    	$('#male').tooltip("""),format.raw/*61.25*/("""{"""),format.raw/*61.26*/("""placement: "bottom", title: "Match you with videos for guys.""""),format.raw/*61.87*/("""}"""),format.raw/*61.88*/(""")
    	$('#female').tooltip("""),format.raw/*62.27*/("""{"""),format.raw/*62.28*/("""placement: "bottom", title: "Match you with videos for gals.""""),format.raw/*62.89*/("""}"""),format.raw/*62.90*/(""")
    	$('.occupation').tooltip("""),format.raw/*63.31*/("""{"""),format.raw/*63.32*/("""placement: "bottom", title: "Match with videos related to your job.""""),format.raw/*63.100*/("""}"""),format.raw/*63.101*/(""")
    	$('.interest').tooltip("""),format.raw/*64.29*/("""{"""),format.raw/*64.30*/("""placement: "bottom", title: "Match with videos about your interests.""""),format.raw/*64.99*/("""}"""),format.raw/*64.100*/(""")
    </script>
""")))})))}
    }
    
    def render(form:Form[Lobby.SignupForm]): play.api.templates.Html = apply(form)
    
    def f:((Form[Lobby.SignupForm]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 28 01:17:08 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/signup.scala.html
                    HASH: fc4d9e1c566b73ad003192ddbac0f8d1444c6d04
                    MATRIX: 740->1|847->31|886->36|914->56|953->58|1081->151|1095->157|1139->180|1490->494|1516->510|1545->516|1586->528|1616->529|1649->533|1679->534|1841->659|1864->672|1893->678|1934->690|1964->691|1997->695|2027->696|2229->869|2259->870|2292->874|2322->875|2544->1068|2574->1069|2607->1073|2637->1074|3109->1509|3130->1520|3159->1526|3326->1656|3347->1667|3376->1673|3532->1792|3571->1821|3612->1823|3653->1831|3827->1968|3866->1997|3907->1999|3948->2007|4157->2180|4196->2210|4250->2226|4402->2341|4423->2352|4437->2356|4491->2371|4545->2388|4565->2398|4591->2401|4631->2404|4685->2448|4726->2450|4768->2459|4807->2461|4827->2471|4855->2476|4898->2486|5059->2610|5080->2621|5094->2625|5148->2640|5202->2657|5222->2667|5248->2670|5288->2673|5342->2717|5383->2719|5425->2728|5464->2730|5484->2740|5512->2745|5555->2755|5627->2795|5815->2947|5852->2975|5904->2989|6052->3100|6071->3109|6085->3113|6137->3126|6191->3143|6209->3151|6235->3154|6275->3157|6325->3197|6366->3199|6408->3208|6447->3210|6465->3218|6493->3223|6536->3233|6693->3353|6712->3362|6726->3366|6778->3379|6832->3396|6850->3404|6876->3407|6916->3410|6966->3450|7007->3452|7049->3461|7088->3463|7106->3471|7134->3476|7177->3486|7372->3644|7391->3653|7405->3657|7457->3670|7511->3687|7529->3695|7555->3698|7595->3701|7645->3741|7686->3743|7728->3752|7767->3754|7785->3762|7813->3767|7856->3777|8013->3897|8032->3906|8046->3910|8098->3923|8152->3940|8170->3948|8196->3951|8236->3954|8286->3994|8327->3996|8369->4005|8408->4007|8426->4015|8454->4020|8497->4030|8569->4070|8987->4460|9016->4461|9109->4526|9138->4527|9194->4555|9223->4556|9316->4621|9345->4622|9404->4653|9433->4654|9526->4719|9555->4720|9620->4757|9649->4758|9743->4823|9773->4824|9827->4850|9856->4851|9951->4918|9980->4919|10034->4945|10063->4946|10152->5007|10181->5008|10236->5035|10265->5036|10354->5097|10383->5098|10440->5127|10469->5128|10558->5189|10587->5190|10648->5223|10677->5224|10774->5292|10804->5293|10863->5324|10892->5325|10989->5394|11019->5395
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|42->14|42->14|42->14|42->14|44->16|44->16|44->16|44->16|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|55->27|56->28|56->28|56->28|56->28|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|73->45|83->55|83->55|83->55|83->55|84->56|84->56|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64
                    -- GENERATED --
                */
            