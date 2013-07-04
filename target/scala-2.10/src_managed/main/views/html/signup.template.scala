
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
                            <div class="span5 offset1"><select class="span5 occupation" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*29.137*/occupations/*29.148*/.map/*29.152*/ {occupation =>_display_(Seq[Any](format.raw/*29.167*/(""" <option value=""""),_display_(Seq[Any](/*29.184*/occupation/*29.194*/.id)),format.raw/*29.197*/("""" """),_display_(Seq[Any](/*29.200*/if(form("occupation1").value==occupation.id.toString())/*29.255*/ {_display_(Seq[Any](format.raw/*29.257*/("""selected""")))})),format.raw/*29.266*/(""">"""),_display_(Seq[Any](/*29.268*/occupation/*29.278*/.name)),format.raw/*29.283*/("""</option>""")))})),format.raw/*29.293*/("""</select></div>
                            <div class="span5"><select class="span5 occupation" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*30.129*/occupations/*30.140*/.map/*30.144*/ {occupation =>_display_(Seq[Any](format.raw/*30.159*/(""" <option value=""""),_display_(Seq[Any](/*30.176*/occupation/*30.186*/.id)),format.raw/*30.189*/("""" """),_display_(Seq[Any](/*30.192*/if(form("occupation2").value==occupation.id.toString())/*30.247*/ {_display_(Seq[Any](format.raw/*30.249*/("""selected""")))})),format.raw/*30.258*/(""">"""),_display_(Seq[Any](/*30.260*/occupation/*30.270*/.name)),format.raw/*30.275*/("""</option>""")))})),format.raw/*30.285*/("""</select></div>
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
                            <div class="span4"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*43.125*/interests/*43.134*/.map/*43.138*/ {interest =>_display_(Seq[Any](format.raw/*43.151*/(""" <option value=""""),_display_(Seq[Any](/*43.168*/interest/*43.176*/.id)),format.raw/*43.179*/("""" """),_display_(Seq[Any](/*43.182*/if(form("interest1").value==interest.id.toString())/*43.233*/ {_display_(Seq[Any](format.raw/*43.235*/("""selected""")))})),format.raw/*43.244*/(""">"""),_display_(Seq[Any](/*43.246*/interest/*43.254*/.name)),format.raw/*43.259*/("""</option>""")))})),format.raw/*43.269*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*46.133*/interests/*46.142*/.map/*46.146*/ {interest =>_display_(Seq[Any](format.raw/*46.159*/(""" <option value=""""),_display_(Seq[Any](/*46.176*/interest/*46.184*/.id)),format.raw/*46.187*/("""" """),_display_(Seq[Any](/*46.190*/if(form("interest2").value==interest.id.toString())/*46.241*/ {_display_(Seq[Any](format.raw/*46.243*/("""selected""")))})),format.raw/*46.252*/(""">"""),_display_(Seq[Any](/*46.254*/interest/*46.262*/.name)),format.raw/*46.267*/("""</option>""")))})),format.raw/*46.277*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*49.133*/interests/*49.142*/.map/*49.146*/ {interest =>_display_(Seq[Any](format.raw/*49.159*/(""" <option value=""""),_display_(Seq[Any](/*49.176*/interest/*49.184*/.id)),format.raw/*49.187*/("""" """),_display_(Seq[Any](/*49.190*/if(form("interest3").value==interest.id.toString())/*49.241*/ {_display_(Seq[Any](format.raw/*49.243*/("""selected""")))})),format.raw/*49.252*/(""">"""),_display_(Seq[Any](/*49.254*/interest/*49.262*/.name)),format.raw/*49.267*/("""</option>""")))})),format.raw/*49.277*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*52.133*/interests/*52.142*/.map/*52.146*/ {interest =>_display_(Seq[Any](format.raw/*52.159*/(""" <option value=""""),_display_(Seq[Any](/*52.176*/interest/*52.184*/.id)),format.raw/*52.187*/("""" """),_display_(Seq[Any](/*52.190*/if(form("interest4").value==interest.id.toString())/*52.241*/ {_display_(Seq[Any](format.raw/*52.243*/("""selected""")))})),format.raw/*52.252*/(""">"""),_display_(Seq[Any](/*52.254*/interest/*52.262*/.name)),format.raw/*52.267*/("""</option>""")))})),format.raw/*52.277*/("""</select></div>
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
                    DATE: Thu Jul 04 01:04:59 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/signup.scala.html
                    HASH: 1c7766b21457d172239311c61ca75e86e2c15020
                    MATRIX: 741->1|849->32|888->37|916->57|955->59|1077->146|1091->152|1126->166|1196->201|1234->231|1288->248|1346->271|1382->299|1434->314|2087->930|2113->946|2142->952|2183->964|2213->965|2246->969|2276->970|2456->1113|2479->1126|2508->1132|2549->1144|2579->1145|2612->1149|2642->1150|2828->1307|2858->1308|2891->1312|2921->1313|3209->1572|3239->1573|3272->1577|3302->1578|3891->2130|3912->2141|3926->2145|3980->2160|4034->2177|4054->2187|4080->2190|4120->2193|4185->2248|4226->2250|4268->2259|4307->2261|4327->2271|4355->2276|4398->2286|4580->2431|4601->2442|4615->2446|4669->2461|4723->2478|4743->2488|4769->2491|4809->2494|4874->2549|4915->2551|4957->2560|4996->2562|5016->2572|5044->2577|5087->2587|5717->3180|5738->3191|5767->3197|5959->3352|5980->3363|6009->3369|6186->3509|6225->3538|6266->3540|6307->3548|6524->3728|6563->3757|6604->3759|6645->3767|6856->3941|6875->3950|6889->3954|6941->3967|6995->3984|7013->3992|7039->3995|7079->3998|7140->4049|7181->4051|7223->4060|7262->4062|7280->4070|7308->4075|7351->4085|7612->4309|7631->4318|7645->4322|7697->4335|7751->4352|7769->4360|7795->4363|7835->4366|7896->4417|7937->4419|7979->4428|8018->4430|8036->4438|8064->4443|8107->4453|8368->4677|8387->4686|8401->4690|8453->4703|8507->4720|8525->4728|8551->4731|8591->4734|8652->4785|8693->4787|8735->4796|8774->4798|8792->4806|8820->4811|8863->4821|9124->5045|9143->5054|9157->5058|9209->5071|9263->5088|9281->5096|9307->5099|9347->5102|9408->5153|9449->5155|9491->5164|9530->5166|9548->5174|9576->5179|9619->5189|9879->5417|9930->5436|10074->5552|10103->5553|10194->5616|10223->5617|10279->5645|10308->5646|10399->5709|10428->5710|10487->5741|10516->5742|10607->5805|10636->5806|10701->5843|10730->5844|10821->5907|10851->5908|10905->5934|10934->5935|11026->5999|11055->6000|11109->6026|11138->6027|11224->6085|11253->6086|11308->6113|11337->6114|11423->6172|11452->6173|11509->6202|11538->6203|11624->6261|11653->6262|11714->6295|11743->6296|11836->6361|11865->6362|11924->6393|11953->6394|12047->6460|12076->6461
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|45->17|45->17|45->17|45->17|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|46->18|47->19|47->19|47->19|47->19|50->22|50->22|50->22|50->22|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|83->55|84->56|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|93->65|93->65|93->65|93->65|94->66|94->66|94->66|94->66|95->67|95->67|95->67|95->67|96->68|96->68|96->68|96->68|97->69|97->69|97->69|97->69|98->70|98->70|98->70|98->70
                    -- GENERATED --
                */
            