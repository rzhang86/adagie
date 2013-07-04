
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
                            <div class="span3 offset1">Username:</div>
                            <div class="span4">Email:</div>
                            <div class="span3">Password:</div>
                        </div>
                        <div class="row">
                            <div class="span3 offset1"><input class="span3" type="text" id="username" name="username" placeholder="Username" value=""""),_display_(Seq[Any](/*17.150*/form("username")/*17.166*/.value)),format.raw/*17.172*/("""" pattern="."""),format.raw/*17.184*/("""{"""),format.raw/*17.185*/("""1,31"""),format.raw/*17.189*/("""}"""),format.raw/*17.190*/(""""></div>
                            <div class="span4"><input class="span4" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*18.134*/form("email")/*18.147*/.value)),format.raw/*18.153*/("""" pattern="."""),format.raw/*18.165*/("""{"""),format.raw/*18.166*/("""1,63"""),format.raw/*18.170*/("""}"""),format.raw/*18.171*/(""""></div>
                            <div class="span3"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*19.148*/("""{"""),format.raw/*19.149*/("""6,31"""),format.raw/*19.153*/("""}"""),format.raw/*19.154*/(""""></div>
                        </div>
                        <div class="row">
                            <div class="span3 offset8"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*22.175*/("""{"""),format.raw/*22.176*/("""6,31"""),format.raw/*22.180*/("""}"""),format.raw/*22.181*/(""""></div>
                        </div>
                        <br>
                        <div class="row"><div class="span12 text-center"><strong>Optional fields: </strong><i>(These help match you with higher-paying videos!)</i></div></div>
                        <br>
                        <div class="row"><div class="span5 offset1">Occupations:</div></div>
                        <div class="row">
                            <div class="span5 offset1"><select class="span5 occupation" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*29.137*/occupations/*29.148*/.map/*29.152*/ {occupation =>_display_(Seq[Any](format.raw/*29.167*/(""" <option value=""""),_display_(Seq[Any](/*29.184*/occupation/*29.194*/.id)),format.raw/*29.197*/("""" """),_display_(Seq[Any](/*29.200*/if(form("occupation1").value==occupation.id)/*29.244*/ {_display_(Seq[Any](format.raw/*29.246*/("""selected""")))})),format.raw/*29.255*/(""">"""),_display_(Seq[Any](/*29.257*/occupation/*29.267*/.name)),format.raw/*29.272*/("""</option>""")))})),format.raw/*29.282*/("""</select></div>
                            <div class="span5"><select class="span5 occupation" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*30.129*/occupations/*30.140*/.map/*30.144*/ {occupation =>_display_(Seq[Any](format.raw/*30.159*/(""" <option value=""""),_display_(Seq[Any](/*30.176*/occupation/*30.186*/.id)),format.raw/*30.189*/("""" """),_display_(Seq[Any](/*30.192*/if(form("occupation2").value==occupation.id)/*30.236*/ {_display_(Seq[Any](format.raw/*30.238*/("""selected""")))})),format.raw/*30.247*/(""">"""),_display_(Seq[Any](/*30.249*/occupation/*30.259*/.name)),format.raw/*30.264*/("""</option>""")))})),format.raw/*30.274*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span2 offset1">Age:</div>
                            <div class="span2">Zip code:</div>
                            <div class="span2">Gender:</div>
                            <div class="span4">Interests:</div>
                        </div>
                        <div class="row">
                            <div class="span2 offset1"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*39.169*/form("age")/*39.180*/.value)),format.raw/*39.186*/(""""></div>
                            <div class="span2"><input class="span2" type="text" id="zip" name="zip" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*40.146*/form("zip")/*40.157*/.value)),format.raw/*40.163*/(""""></div>
                            <div class="span1"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*41.131*/if(form("gender").value=="M")/*41.160*/ {_display_(Seq[Any](format.raw/*41.162*/("""checked""")))})),format.raw/*41.170*/("""><img src="assets/img/male.png"></label></div>
                            <div class="span1"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*42.133*/if(form("gender").value=="F")/*42.162*/ {_display_(Seq[Any](format.raw/*42.164*/("""checked""")))})),format.raw/*42.172*/("""><img src="assets/img/female.png"></label></div>
                            <div class="span4"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*43.125*/interests/*43.134*/.map/*43.138*/ {interest =>_display_(Seq[Any](format.raw/*43.151*/(""" <option value=""""),_display_(Seq[Any](/*43.168*/interest/*43.176*/.id)),format.raw/*43.179*/("""" """),_display_(Seq[Any](/*43.182*/if(form("interest1").value==interest.id)/*43.222*/ {_display_(Seq[Any](format.raw/*43.224*/("""selected""")))})),format.raw/*43.233*/(""">"""),_display_(Seq[Any](/*43.235*/interest/*43.243*/.name)),format.raw/*43.248*/("""</option>""")))})),format.raw/*43.258*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*46.133*/interests/*46.142*/.map/*46.146*/ {interest =>_display_(Seq[Any](format.raw/*46.159*/(""" <option value=""""),_display_(Seq[Any](/*46.176*/interest/*46.184*/.id)),format.raw/*46.187*/("""" """),_display_(Seq[Any](/*46.190*/if(form("interest2").value==interest.id)/*46.230*/ {_display_(Seq[Any](format.raw/*46.232*/("""selected""")))})),format.raw/*46.241*/(""">"""),_display_(Seq[Any](/*46.243*/interest/*46.251*/.name)),format.raw/*46.256*/("""</option>""")))})),format.raw/*46.266*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*49.133*/interests/*49.142*/.map/*49.146*/ {interest =>_display_(Seq[Any](format.raw/*49.159*/(""" <option value=""""),_display_(Seq[Any](/*49.176*/interest/*49.184*/.id)),format.raw/*49.187*/("""" """),_display_(Seq[Any](/*49.190*/if(form("interest3").value==interest.id)/*49.230*/ {_display_(Seq[Any](format.raw/*49.232*/("""selected""")))})),format.raw/*49.241*/(""">"""),_display_(Seq[Any](/*49.243*/interest/*49.251*/.name)),format.raw/*49.256*/("""</option>""")))})),format.raw/*49.266*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*52.133*/interests/*52.142*/.map/*52.146*/ {interest =>_display_(Seq[Any](format.raw/*52.159*/(""" <option value=""""),_display_(Seq[Any](/*52.176*/interest/*52.184*/.id)),format.raw/*52.187*/("""" """),_display_(Seq[Any](/*52.190*/if(form("interest4").value==interest.id)/*52.230*/ {_display_(Seq[Any](format.raw/*52.232*/("""selected""")))})),format.raw/*52.241*/(""">"""),_display_(Seq[Any](/*52.243*/interest/*52.251*/.name)),format.raw/*52.256*/("""</option>""")))})),format.raw/*52.266*/("""</select></div>
                        </div>
                        <div class="row"><div class="span12 text-center"><button type="submit" class="btn btn-large btn-success">Submit</button></div></div>
                    """)))})),format.raw/*55.22*/("""
                """)))})),format.raw/*56.18*/("""
            </form>
        </div>
    </div>
    <script type="text/javascript">
    	$('#username').tooltip("""),format.raw/*61.29*/("""{"""),format.raw/*61.30*/("""placement: "top", title: "Must be between 1 and 31 characters.""""),format.raw/*61.93*/("""}"""),format.raw/*61.94*/(""")
    	$('#email').tooltip("""),format.raw/*62.26*/("""{"""),format.raw/*62.27*/("""placement: "top", title: "Must be between 1 and 63 characters.""""),format.raw/*62.90*/("""}"""),format.raw/*62.91*/(""")
    	$('#password').tooltip("""),format.raw/*63.29*/("""{"""),format.raw/*63.30*/("""placement: "top", title: "Must be between 6 and 31 characters.""""),format.raw/*63.93*/("""}"""),format.raw/*63.94*/(""")
    	$('#passwordRepeat').tooltip("""),format.raw/*64.35*/("""{"""),format.raw/*64.36*/("""placement: "top", title: "Must be between 6 and 31 characters.""""),format.raw/*64.99*/("""}"""),format.raw/*64.100*/(""")
    	$('#age').tooltip("""),format.raw/*65.24*/("""{"""),format.raw/*65.25*/("""placement: "top", title: "Match with videos for your age group.""""),format.raw/*65.89*/("""}"""),format.raw/*65.90*/(""")
    	$('#zip').tooltip("""),format.raw/*66.24*/("""{"""),format.raw/*66.25*/("""placement: "top", title: "Match with videos in your area.""""),format.raw/*66.83*/("""}"""),format.raw/*66.84*/(""")
    	$('#male').tooltip("""),format.raw/*67.25*/("""{"""),format.raw/*67.26*/("""placement: "top", title: "Match you with videos for guys.""""),format.raw/*67.84*/("""}"""),format.raw/*67.85*/(""")
    	$('#female').tooltip("""),format.raw/*68.27*/("""{"""),format.raw/*68.28*/("""placement: "top", title: "Match you with videos for gals.""""),format.raw/*68.86*/("""}"""),format.raw/*68.87*/(""")
    	$('.occupation').tooltip("""),format.raw/*69.31*/("""{"""),format.raw/*69.32*/("""placement: "top", title: "Match with videos related to your job.""""),format.raw/*69.97*/("""}"""),format.raw/*69.98*/(""")
    	$('.interest').tooltip("""),format.raw/*70.29*/("""{"""),format.raw/*70.30*/("""placement: "top", title: "Match with videos about your interests.""""),format.raw/*70.96*/("""}"""),format.raw/*70.97*/(""")
    </script>
""")))})))}
    }
    
    def render(form:Form[Signup.SignupForm]): play.api.templates.Html = apply(form)
    
    def f:((Form[Signup.SignupForm]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 03 20:51:05 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/signup.scala.html
                    HASH: 6e47c1b110d232138de32416ee305caef98ed40d
                    MATRIX: 741->1|849->32|888->37|916->57|955->59|1077->146|1091->152|1126->166|1196->201|1234->231|1288->248|1346->271|1382->299|1434->314|2087->930|2113->946|2142->952|2183->964|2213->965|2246->969|2276->970|2456->1113|2479->1126|2508->1132|2549->1144|2579->1145|2612->1149|2642->1150|2828->1307|2858->1308|2891->1312|2921->1313|3209->1572|3239->1573|3272->1577|3302->1578|3891->2130|3912->2141|3926->2145|3980->2160|4034->2177|4054->2187|4080->2190|4120->2193|4174->2237|4215->2239|4257->2248|4296->2250|4316->2260|4344->2265|4387->2275|4569->2420|4590->2431|4604->2435|4658->2450|4712->2467|4732->2477|4758->2480|4798->2483|4852->2527|4893->2529|4935->2538|4974->2540|4994->2550|5022->2555|5065->2565|5695->3158|5716->3169|5745->3175|5937->3330|5958->3341|5987->3347|6164->3487|6203->3516|6244->3518|6285->3526|6502->3706|6541->3735|6582->3737|6623->3745|6834->3919|6853->3928|6867->3932|6919->3945|6973->3962|6991->3970|7017->3973|7057->3976|7107->4016|7148->4018|7190->4027|7229->4029|7247->4037|7275->4042|7318->4052|7579->4276|7598->4285|7612->4289|7664->4302|7718->4319|7736->4327|7762->4330|7802->4333|7852->4373|7893->4375|7935->4384|7974->4386|7992->4394|8020->4399|8063->4409|8324->4633|8343->4642|8357->4646|8409->4659|8463->4676|8481->4684|8507->4687|8547->4690|8597->4730|8638->4732|8680->4741|8719->4743|8737->4751|8765->4756|8808->4766|9069->4990|9088->4999|9102->5003|9154->5016|9208->5033|9226->5041|9252->5044|9292->5047|9342->5087|9383->5089|9425->5098|9464->5100|9482->5108|9510->5113|9553->5123|9813->5351|9864->5370|10008->5486|10037->5487|10128->5550|10157->5551|10213->5579|10242->5580|10333->5643|10362->5644|10421->5675|10450->5676|10541->5739|10570->5740|10635->5777|10664->5778|10755->5841|10785->5842|10839->5868|10868->5869|10960->5933|10989->5934|11043->5960|11072->5961|11158->6019|11187->6020|11242->6047|11271->6048|11357->6106|11386->6107|11443->6136|11472->6137|11558->6195|11587->6196|11648->6229|11677->6230|11770->6295|11799->6296|11858->6327|11887->6328|11981->6394|12010->6395
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|45->17|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|46->18|47->19|47->19|47->19|47->19|50->22|50->22|50->22|50->22|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|83->55|84->56|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|93->65|93->65|93->65|93->65|94->66|94->66|94->66|94->66|95->67|95->67|95->67|95->67|96->68|96->68|96->68|96->68|97->69|97->69|97->69|97->69|98->70|98->70|98->70|98->70
                    -- GENERATED --
                */
            