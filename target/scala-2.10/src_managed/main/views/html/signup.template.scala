
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
                """),_display_(Seq[Any](/*7.18*/defining(Occupation.findAll())/*7.48*/ { occupations =>_display_(Seq[Any](format.raw/*7.65*/("""
                    """),_display_(Seq[Any](/*8.22*/defining(Interest.findAll())/*8.50*/ { interests =>_display_(Seq[Any](format.raw/*8.65*/("""
                        <div class="row"><div class="span12 text-center"><strong>Required fields:</strong></div></div>
                        <br>
                        <div class="row">
                            <div class="span4 offset1">Email:</div>
                            <div class="span3">Password:</div>
                        </div>
                        <div class="row">
                            <div class="span4 offset1"><input class="span4" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*16.142*/form("email")/*16.155*/.value)),format.raw/*16.161*/("""" pattern="."""),format.raw/*16.173*/("""{"""),format.raw/*16.174*/("""1,63"""),format.raw/*16.178*/("""}"""),format.raw/*16.179*/(""""></div>
                            <div class="span3"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*17.148*/("""{"""),format.raw/*17.149*/("""6,31"""),format.raw/*17.153*/("""}"""),format.raw/*17.154*/(""""></div>
                            <div class="span3"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*18.167*/("""{"""),format.raw/*18.168*/("""6,31"""),format.raw/*18.172*/("""}"""),format.raw/*18.173*/(""""></div>
                        </div>
                        <br>
                        <div class="row"><div class="span12 text-center"><strong>Optional fields:</strong></div></div>
                        <br>
                        <div class="row"><div class="span5 offset1">Occupations:</div></div>
                        <div class="row">
                            <div class="span5 offset1"><select class="span5 occupation" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*25.137*/occupations/*25.148*/.map/*25.152*/ {occupation =>_display_(Seq[Any](format.raw/*25.167*/(""" <option value=""""),_display_(Seq[Any](/*25.184*/occupation/*25.194*/.id)),format.raw/*25.197*/("""" """),_display_(Seq[Any](/*25.200*/if(form("occupation1").value==occupation.id.toString())/*25.255*/ {_display_(Seq[Any](format.raw/*25.257*/("""selected""")))})),format.raw/*25.266*/(""">"""),_display_(Seq[Any](/*25.268*/occupation/*25.278*/.name)),format.raw/*25.283*/("""</option>""")))})),format.raw/*25.293*/("""</select></div>
                            <div class="span5"><select class="span5 occupation" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*26.129*/occupations/*26.140*/.map/*26.144*/ {occupation =>_display_(Seq[Any](format.raw/*26.159*/(""" <option value=""""),_display_(Seq[Any](/*26.176*/occupation/*26.186*/.id)),format.raw/*26.189*/("""" """),_display_(Seq[Any](/*26.192*/if(form("occupation2").value==occupation.id.toString())/*26.247*/ {_display_(Seq[Any](format.raw/*26.249*/("""selected""")))})),format.raw/*26.258*/(""">"""),_display_(Seq[Any](/*26.260*/occupation/*26.270*/.name)),format.raw/*26.275*/("""</option>""")))})),format.raw/*26.285*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span2 offset1">Age:</div>
                            <div class="span2">Zip code:</div>
                            <div class="span2">Gender:</div>
                            <div class="span4">Interests:</div>
                        </div>
                        <div class="row">
                            <div class="span2 offset1"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*35.169*/form("age")/*35.180*/.value)),format.raw/*35.186*/(""""></div>
                            <div class="span2"><input class="span2" type="text" id="zipCode" name="zipCode" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*36.154*/form("zipCode")/*36.169*/.value)),format.raw/*36.175*/(""""></div>
                            <div class="span1"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*37.131*/if(form("gender").value=="M")/*37.160*/ {_display_(Seq[Any](format.raw/*37.162*/("""checked""")))})),format.raw/*37.170*/("""><img src="assets/img/male.png"></label></div>
                            <div class="span1"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*38.133*/if(form("gender").value=="F")/*38.162*/ {_display_(Seq[Any](format.raw/*38.164*/("""checked""")))})),format.raw/*38.172*/("""><img src="assets/img/female.png"></label></div>
                            <div class="span4"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*39.125*/interests/*39.134*/.map/*39.138*/ {interest =>_display_(Seq[Any](format.raw/*39.151*/(""" <option value=""""),_display_(Seq[Any](/*39.168*/interest/*39.176*/.id)),format.raw/*39.179*/("""" """),_display_(Seq[Any](/*39.182*/if(form("interest1").value==interest.id.toString())/*39.233*/ {_display_(Seq[Any](format.raw/*39.235*/("""selected""")))})),format.raw/*39.244*/(""">"""),_display_(Seq[Any](/*39.246*/interest/*39.254*/.name)),format.raw/*39.259*/("""</option>""")))})),format.raw/*39.269*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*42.133*/interests/*42.142*/.map/*42.146*/ {interest =>_display_(Seq[Any](format.raw/*42.159*/(""" <option value=""""),_display_(Seq[Any](/*42.176*/interest/*42.184*/.id)),format.raw/*42.187*/("""" """),_display_(Seq[Any](/*42.190*/if(form("interest2").value==interest.id.toString())/*42.241*/ {_display_(Seq[Any](format.raw/*42.243*/("""selected""")))})),format.raw/*42.252*/(""">"""),_display_(Seq[Any](/*42.254*/interest/*42.262*/.name)),format.raw/*42.267*/("""</option>""")))})),format.raw/*42.277*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*45.133*/interests/*45.142*/.map/*45.146*/ {interest =>_display_(Seq[Any](format.raw/*45.159*/(""" <option value=""""),_display_(Seq[Any](/*45.176*/interest/*45.184*/.id)),format.raw/*45.187*/("""" """),_display_(Seq[Any](/*45.190*/if(form("interest3").value==interest.id.toString())/*45.241*/ {_display_(Seq[Any](format.raw/*45.243*/("""selected""")))})),format.raw/*45.252*/(""">"""),_display_(Seq[Any](/*45.254*/interest/*45.262*/.name)),format.raw/*45.267*/("""</option>""")))})),format.raw/*45.277*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*48.133*/interests/*48.142*/.map/*48.146*/ {interest =>_display_(Seq[Any](format.raw/*48.159*/(""" <option value=""""),_display_(Seq[Any](/*48.176*/interest/*48.184*/.id)),format.raw/*48.187*/("""" """),_display_(Seq[Any](/*48.190*/if(form("interest4").value==interest.id.toString())/*48.241*/ {_display_(Seq[Any](format.raw/*48.243*/("""selected""")))})),format.raw/*48.252*/(""">"""),_display_(Seq[Any](/*48.254*/interest/*48.262*/.name)),format.raw/*48.267*/("""</option>""")))})),format.raw/*48.277*/("""</select></div>
                        </div>
                        <div class="row"><div class="span12 text-center"><i>Optional fields help match you with higher-paying videos!</i></div></div>
                        <div class="row"><div class="span12 text-center"><button type="submit" class="btn btn-large btn-success">Submit</button></div></div>
                    """)))})),format.raw/*52.22*/("""
                """)))})),format.raw/*53.18*/("""
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
                    DATE: Thu Jul 04 13:51:48 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/signup.scala.html
                    HASH: 3cc76cb1a21b67e6babfd0f5c06ae5baf8840e6d
                    MATRIX: 741->1|849->32|888->37|916->57|955->59|1077->146|1091->152|1126->166|1196->201|1234->231|1288->248|1346->271|1382->299|1434->314|2015->858|2038->871|2067->877|2108->889|2138->890|2171->894|2201->895|2387->1052|2417->1053|2450->1057|2480->1058|2685->1234|2715->1235|2748->1239|2778->1240|3310->1735|3331->1746|3345->1750|3399->1765|3453->1782|3473->1792|3499->1795|3539->1798|3604->1853|3645->1855|3687->1864|3726->1866|3746->1876|3774->1881|3817->1891|3999->2036|4020->2047|4034->2051|4088->2066|4142->2083|4162->2093|4188->2096|4228->2099|4293->2154|4334->2156|4376->2165|4415->2167|4435->2177|4463->2182|4506->2192|5136->2785|5157->2796|5186->2802|5386->2965|5411->2980|5440->2986|5617->3126|5656->3155|5697->3157|5738->3165|5955->3345|5994->3374|6035->3376|6076->3384|6287->3558|6306->3567|6320->3571|6372->3584|6426->3601|6444->3609|6470->3612|6510->3615|6571->3666|6612->3668|6654->3677|6693->3679|6711->3687|6739->3692|6782->3702|7043->3926|7062->3935|7076->3939|7128->3952|7182->3969|7200->3977|7226->3980|7266->3983|7327->4034|7368->4036|7410->4045|7449->4047|7467->4055|7495->4060|7538->4070|7799->4294|7818->4303|7832->4307|7884->4320|7938->4337|7956->4345|7982->4348|8022->4351|8083->4402|8124->4404|8166->4413|8205->4415|8223->4423|8251->4428|8294->4438|8555->4662|8574->4671|8588->4675|8640->4688|8694->4705|8712->4713|8738->4716|8778->4719|8839->4770|8880->4772|8922->4781|8961->4783|8979->4791|9007->4796|9050->4806|9461->5185|9512->5204|9653->5317|9682->5318|9776->5384|9805->5385|9864->5416|9893->5417|9987->5483|10016->5484|10081->5521|10110->5522|10205->5588|10235->5589|10289->5615|10318->5616|10413->5683|10442->5684|10500->5714|10529->5715|10618->5776|10647->5777|10702->5804|10731->5805|10820->5866|10849->5867|10906->5896|10935->5897|11024->5958|11053->5959|11114->5992|11143->5993|11240->6061|11270->6062|11329->6093|11358->6094|11455->6163|11485->6164
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|44->16|44->16|44->16|44->16|44->16|44->16|44->16|45->17|45->17|45->17|45->17|46->18|46->18|46->18|46->18|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|65->37|66->38|66->38|66->38|66->38|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|73->45|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|76->48|80->52|81->53|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|93->65|93->65|93->65|93->65|94->66|94->66|94->66|94->66
                    -- GENERATED --
                */
            