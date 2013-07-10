
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
                <div class="row">
                    <div class="span4 offset1">
                        <div class="row nonform-height2"><div class="span4">Email:</div></div>
                        <div class="row"><div class="span4"><input class="span4" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*10.147*/form("email")/*10.160*/.value)),format.raw/*10.166*/("""" pattern="."""),format.raw/*10.178*/("""{"""),format.raw/*10.179*/("""1,63"""),format.raw/*10.183*/("""}"""),format.raw/*10.184*/("""" maxlength="63" required></div></div>
                    </div>
                    <div class="span6">
                        <div class="row nonform-height2"><div class="span7">Password:</div></div>
                        <div class="row">
                            <div class="span3"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*15.148*/("""{"""),format.raw/*15.149*/("""6,31"""),format.raw/*15.153*/("""}"""),format.raw/*15.154*/("""" maxlength="31" required></div>
                            <div class="span3"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*16.167*/("""{"""),format.raw/*16.168*/("""6,31"""),format.raw/*16.172*/("""}"""),format.raw/*16.173*/("""" maxlength="31" required></div>
                        </div>
                    </div>
                </div>
                <br><br><div class="row"><div class="span10 offset1"><strong>- Optional fields: </strong><i>(These fields help match you with higher-paying ads)</i><strong> -</strong></div></div><br>
                <div class="row">
                    <div class="span10 offset1">
                        <div class="row"><div class="span10">Occupations:</div></div>
                        """),_display_(Seq[Any](/*24.26*/defining(Occupation.findAll())/*24.56*/ {occupations =>_display_(Seq[Any](format.raw/*24.72*/("""
                        <div class="row">
                            <div class="span5"><select class="span5 occupation" id="occupation1" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*26.146*/occupations/*26.157*/.map/*26.161*/ {occupation =>_display_(Seq[Any](format.raw/*26.176*/(""" <option value=""""),_display_(Seq[Any](/*26.193*/occupation/*26.203*/.getId())),format.raw/*26.211*/("""" """),_display_(Seq[Any](/*26.214*/if(occupation.getId().toString().equals(form("occupation1").value))/*26.281*/ {_display_(Seq[Any](format.raw/*26.283*/("""selected""")))})),format.raw/*26.292*/(""">"""),_display_(Seq[Any](/*26.294*/occupation/*26.304*/.getName())),format.raw/*26.314*/("""</option>""")))})),format.raw/*26.324*/("""</select></div>
                            <div class="span5"><select class="span5 occupation" id="occupation2" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*27.146*/occupations/*27.157*/.map/*27.161*/ {occupation =>_display_(Seq[Any](format.raw/*27.176*/(""" <option value=""""),_display_(Seq[Any](/*27.193*/occupation/*27.203*/.getId())),format.raw/*27.211*/("""" """),_display_(Seq[Any](/*27.214*/if(occupation.getId().toString().equals(form("occupation2").value))/*27.281*/ {_display_(Seq[Any](format.raw/*27.283*/("""selected""")))})),format.raw/*27.292*/(""">"""),_display_(Seq[Any](/*27.294*/occupation/*27.304*/.getName())),format.raw/*27.314*/("""</option>""")))})),format.raw/*27.324*/("""</select></div>
                        </div>
                        """)))})),format.raw/*29.26*/("""
                    </div>
                </div>
                <div class="row">
                    <div class="span2 offset1">
                        <div class="row"><div class="span2">Age:</div></div>
                        <div class="row"><div class="span2"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*35.174*/form("age")/*35.185*/.value)),format.raw/*35.191*/(""""></div></div>
                    </div>
                    <div class="span2">
                        <div class="row"><div class="span2">Zip code:</div></div>
                        <div class="row"><div class="span2"><input class="span2" type="text" id="zipCode" name="zipCode" pattern="."""),format.raw/*39.132*/("""{"""),format.raw/*39.133*/("""5,5"""),format.raw/*39.136*/("""}"""),format.raw/*39.137*/("""" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*39.184*/form("zipCode")/*39.199*/.value)),format.raw/*39.205*/("""" autocomplete="off"></div></div>
                    </div>
                    <div class="span2">
                        <div class="row"><div class="span2">Gender:</div></div>
                        <div class="row">
                            <div class="span1"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*44.131*/if(form("gender").value=="M")/*44.160*/ {_display_(Seq[Any](format.raw/*44.162*/("""checked""")))})),format.raw/*44.170*/("""><img src="assets/img/male.png" width="15px"></label></div>
                            <div class="span1"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*45.133*/if(form("gender").value=="F")/*45.162*/ {_display_(Seq[Any](format.raw/*45.164*/("""checked""")))})),format.raw/*45.172*/("""><img src="assets/img/female.png" width="15px"></label></div>
                        </div>
                    </div>
                    <div class="span4">
                        <div class="row"><div class="span4">Interests:</div></div>
                        """),_display_(Seq[Any](/*50.26*/defining(Interest.findAll())/*50.54*/ {interests =>_display_(Seq[Any](format.raw/*50.68*/("""
                        <div class="row"><div class="span4"><select class="span4 interest" id="interest1" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*51.153*/interests/*51.162*/.map/*51.166*/ {interest =>_display_(Seq[Any](format.raw/*51.179*/(""" <option value=""""),_display_(Seq[Any](/*51.196*/interest/*51.204*/.getId())),format.raw/*51.212*/("""" """),_display_(Seq[Any](/*51.215*/if(interest.getId().toString().equals(form("interest1").value))/*51.278*/ {_display_(Seq[Any](format.raw/*51.280*/("""selected""")))})),format.raw/*51.289*/(""">"""),_display_(Seq[Any](/*51.291*/interest/*51.299*/.getName())),format.raw/*51.309*/("""</option>""")))})),format.raw/*51.319*/("""</select></div></div>
                        <div class="row"><div class="span4"><select class="span4 interest" id="interest2" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*52.153*/interests/*52.162*/.map/*52.166*/ {interest =>_display_(Seq[Any](format.raw/*52.179*/(""" <option value=""""),_display_(Seq[Any](/*52.196*/interest/*52.204*/.getId())),format.raw/*52.212*/("""" """),_display_(Seq[Any](/*52.215*/if(interest.getId().toString().equals(form("interest2").value))/*52.278*/ {_display_(Seq[Any](format.raw/*52.280*/("""selected""")))})),format.raw/*52.289*/(""">"""),_display_(Seq[Any](/*52.291*/interest/*52.299*/.getName())),format.raw/*52.309*/("""</option>""")))})),format.raw/*52.319*/("""</select></div></div>
                        <div class="row"><div class="span4"><select class="span4 interest" id="interest3" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*53.153*/interests/*53.162*/.map/*53.166*/ {interest =>_display_(Seq[Any](format.raw/*53.179*/(""" <option value=""""),_display_(Seq[Any](/*53.196*/interest/*53.204*/.getId())),format.raw/*53.212*/("""" """),_display_(Seq[Any](/*53.215*/if(interest.getId().toString().equals(form("interest3").value))/*53.278*/ {_display_(Seq[Any](format.raw/*53.280*/("""selected""")))})),format.raw/*53.289*/(""">"""),_display_(Seq[Any](/*53.291*/interest/*53.299*/.getName())),format.raw/*53.309*/("""</option>""")))})),format.raw/*53.319*/("""</select></div></div>
                        <div class="row"><div class="span4"><select class="span4 interest" id="interest4" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*54.153*/interests/*54.162*/.map/*54.166*/ {interest =>_display_(Seq[Any](format.raw/*54.179*/(""" <option value=""""),_display_(Seq[Any](/*54.196*/interest/*54.204*/.getId())),format.raw/*54.212*/("""" """),_display_(Seq[Any](/*54.215*/if(interest.getId().toString().equals(form("interest4").value))/*54.278*/ {_display_(Seq[Any](format.raw/*54.280*/("""selected""")))})),format.raw/*54.289*/(""">"""),_display_(Seq[Any](/*54.291*/interest/*54.299*/.getName())),format.raw/*54.309*/("""</option>""")))})),format.raw/*54.319*/("""</select></div></div>
                        """)))})),format.raw/*55.26*/("""
                    </div>
                </div>
                <div class="row"><div class="span12 text-center"><button type="submit" class="btn btn-large btn-warning">Sign up</button></div></div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        $.getJSON(""""),_display_(Seq[Any](/*63.21*/routes/*63.27*/.Assets.at("data/Zips.json"))),format.raw/*63.55*/("""", function(data) """),format.raw/*63.73*/("""{"""),format.raw/*63.74*/("""
            var zipCodes = [];
            $.each(data, function(i, item) """),format.raw/*65.44*/("""{"""),format.raw/*65.45*/("""zipCodes.push(item);"""),format.raw/*65.65*/("""}"""),format.raw/*65.66*/(""");
            $('#zipCode')
                .typeahead("""),format.raw/*67.28*/("""{"""),format.raw/*67.29*/("""source: zipCodes, items: 10"""),format.raw/*67.56*/("""}"""),format.raw/*67.57*/(""")
                .blur(function() """),format.raw/*68.34*/("""{"""),format.raw/*68.35*/("""if($.inArray($(this).val(), zipCodes) == -1) """),format.raw/*68.80*/("""{"""),format.raw/*68.81*/("""$('#zipCode').val('');"""),format.raw/*68.103*/("""}"""),format.raw/*68.104*/("""}"""),format.raw/*68.105*/(""");
        """),format.raw/*69.9*/("""}"""),format.raw/*69.10*/(""");
        
        $('#email').tooltip("""),format.raw/*71.29*/("""{"""),format.raw/*71.30*/("""placement: "bottom", animation: false, title: "Required. 1-63 characters.""""),format.raw/*71.104*/("""}"""),format.raw/*71.105*/(""")
        $('#password').tooltip("""),format.raw/*72.32*/("""{"""),format.raw/*72.33*/("""placement: "bottom", animation: false, title: "Required. 6-31 characters.""""),format.raw/*72.107*/("""}"""),format.raw/*72.108*/(""")
        $('#passwordRepeat').tooltip("""),format.raw/*73.38*/("""{"""),format.raw/*73.39*/("""placement: "bottom", animation: false, title: "Required. 6-31 characters.""""),format.raw/*73.113*/("""}"""),format.raw/*73.114*/(""")
        $('#age').tooltip("""),format.raw/*74.27*/("""{"""),format.raw/*74.28*/("""placement: "bottom", animation: false, title: "Optional. Match with ads for your age group.""""),format.raw/*74.120*/("""}"""),format.raw/*74.121*/(""")
        $('#zipCode').tooltip("""),format.raw/*75.31*/("""{"""),format.raw/*75.32*/("""placement: "bottom", animation: false, title: "Optional. Match with ads in your area.""""),format.raw/*75.118*/("""}"""),format.raw/*75.119*/(""")
        $('#male').tooltip("""),format.raw/*76.28*/("""{"""),format.raw/*76.29*/("""placement: "bottom", animation: false, title: "Optional. Match with ads for guys.""""),format.raw/*76.111*/("""}"""),format.raw/*76.112*/(""")
        $('#female').tooltip("""),format.raw/*77.30*/("""{"""),format.raw/*77.31*/("""placement: "bottom", animation: false, title: "Optional. Match with ads for gals.""""),format.raw/*77.113*/("""}"""),format.raw/*77.114*/(""")
        $('.occupation').tooltip("""),format.raw/*78.34*/("""{"""),format.raw/*78.35*/("""placement: "bottom", animation: false, title: "Optional. Match with ads related to your job.""""),format.raw/*78.128*/("""}"""),format.raw/*78.129*/(""")
        $('.interest').tooltip("""),format.raw/*79.32*/("""{"""),format.raw/*79.33*/("""placement: "bottom", animation: false, title: "Optional. Match with ads about your interests.""""),format.raw/*79.127*/("""}"""),format.raw/*79.128*/(""")
    </script>
""")))})))}
    }
    
    def render(form:Form[Signup.SignupForm]): play.api.templates.Html = apply(form)
    
    def f:((Form[Signup.SignupForm]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jul 09 23:29:07 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/signup.scala.html
                    HASH: 1a51246fe0762b4a6ea9b7e4cd0e13e0bf365b4f
                    MATRIX: 741->1|849->32|888->37|916->57|955->59|1077->146|1091->152|1126->166|1507->510|1530->523|1559->529|1600->541|1630->542|1663->546|1693->547|2120->945|2150->946|2183->950|2213->951|2442->1151|2472->1152|2505->1156|2535->1157|3087->1673|3126->1703|3180->1719|3407->1909|3428->1920|3442->1924|3496->1939|3550->1956|3570->1966|3601->1974|3641->1977|3718->2044|3759->2046|3801->2055|3840->2057|3860->2067|3893->2077|3936->2087|4135->2249|4156->2260|4170->2264|4224->2279|4278->2296|4298->2306|4329->2314|4369->2317|4446->2384|4487->2386|4529->2395|4568->2397|4588->2407|4621->2417|4664->2427|4770->2501|5196->2890|5217->2901|5246->2907|5574->3206|5604->3207|5636->3210|5666->3211|5750->3258|5775->3273|5804->3279|6199->3637|6238->3666|6279->3668|6320->3676|6550->3869|6589->3898|6630->3900|6671->3908|6980->4181|7017->4209|7069->4223|7260->4377|7279->4386|7293->4390|7345->4403|7399->4420|7417->4428|7448->4436|7488->4439|7561->4502|7602->4504|7644->4513|7683->4515|7701->4523|7734->4533|7777->4543|7989->4718|8008->4727|8022->4731|8074->4744|8128->4761|8146->4769|8177->4777|8217->4780|8290->4843|8331->4845|8373->4854|8412->4856|8430->4864|8463->4874|8506->4884|8718->5059|8737->5068|8751->5072|8803->5085|8857->5102|8875->5110|8906->5118|8946->5121|9019->5184|9060->5186|9102->5195|9141->5197|9159->5205|9192->5215|9235->5225|9447->5400|9466->5409|9480->5413|9532->5426|9586->5443|9604->5451|9635->5459|9675->5462|9748->5525|9789->5527|9831->5536|9870->5538|9888->5546|9921->5556|9964->5566|10044->5614|10391->5925|10406->5931|10456->5959|10502->5977|10531->5978|10636->6055|10665->6056|10713->6076|10742->6077|10828->6135|10857->6136|10912->6163|10941->6164|11005->6200|11034->6201|11107->6246|11136->6247|11187->6269|11217->6270|11247->6271|11286->6283|11315->6284|11385->6326|11414->6327|11517->6401|11547->6402|11609->6436|11638->6437|11741->6511|11771->6512|11839->6552|11868->6553|11971->6627|12001->6628|12058->6657|12087->6658|12208->6750|12238->6751|12299->6784|12328->6785|12443->6871|12473->6872|12531->6902|12560->6903|12671->6985|12701->6986|12761->7018|12790->7019|12901->7101|12931->7102|12995->7138|13024->7139|13146->7232|13176->7233|13238->7267|13267->7268|13390->7362|13420->7363
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|38->10|38->10|38->10|38->10|38->10|38->10|38->10|43->15|43->15|43->15|43->15|44->16|44->16|44->16|44->16|52->24|52->24|52->24|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|57->29|63->35|63->35|63->35|67->39|67->39|67->39|67->39|67->39|67->39|67->39|72->44|72->44|72->44|72->44|73->45|73->45|73->45|73->45|78->50|78->50|78->50|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|83->55|91->63|91->63|91->63|91->63|91->63|93->65|93->65|93->65|93->65|95->67|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|97->69|97->69|99->71|99->71|99->71|99->71|100->72|100->72|100->72|100->72|101->73|101->73|101->73|101->73|102->74|102->74|102->74|102->74|103->75|103->75|103->75|103->75|104->76|104->76|104->76|104->76|105->77|105->77|105->77|105->77|106->78|106->78|106->78|106->78|107->79|107->79|107->79|107->79
                    -- GENERATED --
                */
            