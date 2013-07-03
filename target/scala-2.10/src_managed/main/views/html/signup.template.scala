
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
    <div class="row-fluid">
        <div class="span12 well">
            <form action=""""),_display_(Seq[Any](/*6.28*/routes/*6.34*/.Signup.post())),format.raw/*6.48*/("""" method="post">
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
    
    def render(form:Form[Signup.SignupForm]): play.api.templates.Html = apply(form)
    
    def f:((Form[Signup.SignupForm]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 03 10:33:30 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/signup.scala.html
                    HASH: e624c75bd587bcbc3c0058beb116c70ff8e89785
                    MATRIX: 741->1|849->32|888->37|916->57|955->59|1083->152|1097->158|1132->172|1483->486|1509->502|1538->508|1579->520|1609->521|1642->525|1672->526|1834->651|1857->664|1886->670|1927->682|1957->683|1990->687|2020->688|2222->861|2252->862|2285->866|2315->867|2537->1060|2567->1061|2600->1065|2630->1066|3102->1501|3123->1512|3152->1518|3319->1648|3340->1659|3369->1665|3525->1784|3564->1813|3605->1815|3646->1823|3820->1960|3859->1989|3900->1991|3941->1999|4150->2172|4189->2202|4243->2218|4395->2333|4416->2344|4430->2348|4484->2363|4538->2380|4558->2390|4584->2393|4624->2396|4678->2440|4719->2442|4761->2451|4800->2453|4820->2463|4848->2468|4891->2478|5052->2602|5073->2613|5087->2617|5141->2632|5195->2649|5215->2659|5241->2662|5281->2665|5335->2709|5376->2711|5418->2720|5457->2722|5477->2732|5505->2737|5548->2747|5620->2787|5808->2939|5845->2967|5897->2981|6045->3092|6064->3101|6078->3105|6130->3118|6184->3135|6202->3143|6228->3146|6268->3149|6318->3189|6359->3191|6401->3200|6440->3202|6458->3210|6486->3215|6529->3225|6686->3345|6705->3354|6719->3358|6771->3371|6825->3388|6843->3396|6869->3399|6909->3402|6959->3442|7000->3444|7042->3453|7081->3455|7099->3463|7127->3468|7170->3478|7365->3636|7384->3645|7398->3649|7450->3662|7504->3679|7522->3687|7548->3690|7588->3693|7638->3733|7679->3735|7721->3744|7760->3746|7778->3754|7806->3759|7849->3769|8006->3889|8025->3898|8039->3902|8091->3915|8145->3932|8163->3940|8189->3943|8229->3946|8279->3986|8320->3988|8362->3997|8401->3999|8419->4007|8447->4012|8490->4022|8562->4062|8980->4452|9009->4453|9102->4518|9131->4519|9187->4547|9216->4548|9309->4613|9338->4614|9397->4645|9426->4646|9519->4711|9548->4712|9613->4749|9642->4750|9736->4815|9766->4816|9820->4842|9849->4843|9944->4910|9973->4911|10027->4937|10056->4938|10145->4999|10174->5000|10229->5027|10258->5028|10347->5089|10376->5090|10433->5119|10462->5120|10551->5181|10580->5182|10641->5215|10670->5216|10767->5284|10797->5285|10856->5316|10885->5317|10982->5386|11012->5387
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|39->11|39->11|39->11|39->11|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|42->14|42->14|42->14|42->14|44->16|44->16|44->16|44->16|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|55->27|56->28|56->28|56->28|56->28|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|73->45|83->55|83->55|83->55|83->55|84->56|84->56|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64
                    -- GENERATED --
                */
            