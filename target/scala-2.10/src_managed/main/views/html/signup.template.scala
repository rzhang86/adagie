
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
            <form action=""""),_display_(Seq[Any](/*6.28*/routes/*6.34*/.Lobby.postSignup())),format.raw/*6.53*/("""" method="post">
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
                    DATE: Tue Jul 02 22:28:01 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/signup.scala.html
                    HASH: 45ef6db8a22a41cd31d99c531b451572ccc6419e
                    MATRIX: 740->1|847->31|886->36|914->56|953->58|1081->151|1095->157|1135->176|1486->490|1512->506|1541->512|1582->524|1612->525|1645->529|1675->530|1837->655|1860->668|1889->674|1930->686|1960->687|1993->691|2023->692|2225->865|2255->866|2288->870|2318->871|2540->1064|2570->1065|2603->1069|2633->1070|3105->1505|3126->1516|3155->1522|3322->1652|3343->1663|3372->1669|3528->1788|3567->1817|3608->1819|3649->1827|3823->1964|3862->1993|3903->1995|3944->2003|4153->2176|4192->2206|4246->2222|4398->2337|4419->2348|4433->2352|4487->2367|4541->2384|4561->2394|4587->2397|4627->2400|4681->2444|4722->2446|4764->2455|4803->2457|4823->2467|4851->2472|4894->2482|5055->2606|5076->2617|5090->2621|5144->2636|5198->2653|5218->2663|5244->2666|5284->2669|5338->2713|5379->2715|5421->2724|5460->2726|5480->2736|5508->2741|5551->2751|5623->2791|5811->2943|5848->2971|5900->2985|6048->3096|6067->3105|6081->3109|6133->3122|6187->3139|6205->3147|6231->3150|6271->3153|6321->3193|6362->3195|6404->3204|6443->3206|6461->3214|6489->3219|6532->3229|6689->3349|6708->3358|6722->3362|6774->3375|6828->3392|6846->3400|6872->3403|6912->3406|6962->3446|7003->3448|7045->3457|7084->3459|7102->3467|7130->3472|7173->3482|7368->3640|7387->3649|7401->3653|7453->3666|7507->3683|7525->3691|7551->3694|7591->3697|7641->3737|7682->3739|7724->3748|7763->3750|7781->3758|7809->3763|7852->3773|8009->3893|8028->3902|8042->3906|8094->3919|8148->3936|8166->3944|8192->3947|8232->3950|8282->3990|8323->3992|8365->4001|8404->4003|8422->4011|8450->4016|8493->4026|8565->4066|8983->4456|9012->4457|9105->4522|9134->4523|9190->4551|9219->4552|9312->4617|9341->4618|9400->4649|9429->4650|9522->4715|9551->4716|9616->4753|9645->4754|9739->4819|9769->4820|9823->4846|9852->4847|9947->4914|9976->4915|10030->4941|10059->4942|10148->5003|10177->5004|10232->5031|10261->5032|10350->5093|10379->5094|10436->5123|10465->5124|10554->5185|10583->5186|10644->5219|10673->5220|10770->5288|10800->5289|10859->5320|10888->5321|10985->5390|11015->5391
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|42->14|42->14|42->14|42->14|44->16|44->16|44->16|44->16|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|55->27|56->28|56->28|56->28|56->28|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|73->45|83->55|83->55|83->55|83->55|84->56|84->56|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64
                    -- GENERATED --
                */
            