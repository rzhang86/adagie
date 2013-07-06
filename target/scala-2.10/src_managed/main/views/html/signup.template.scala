
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
                        <div class="row"><div class="span4"><input class="span4" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*10.147*/form("email")/*10.160*/.value)),format.raw/*10.166*/("""" pattern="."""),format.raw/*10.178*/("""{"""),format.raw/*10.179*/("""1,63"""),format.raw/*10.183*/("""}"""),format.raw/*10.184*/("""" required></div></div>
                    </div>
                    <div class="span6">
                        <div class="row nonform-height2"><div class="span7">Password:</div></div>
                        <div class="row">
                            <div class="span3"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*15.148*/("""{"""),format.raw/*15.149*/("""6,31"""),format.raw/*15.153*/("""}"""),format.raw/*15.154*/("""" required></div>
                            <div class="span3"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*16.167*/("""{"""),format.raw/*16.168*/("""6,31"""),format.raw/*16.172*/("""}"""),format.raw/*16.173*/("""" required></div>
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
                        <div class="row"><div class="span2"><input class="span2" type="text" id="zipCode" name="zipCode" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*39.167*/form("zipCode")/*39.182*/.value)),format.raw/*39.188*/("""" autocomplete="off"></div></div>
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
        
        $('#age').tooltip("""),format.raw/*71.27*/("""{"""),format.raw/*71.28*/("""placement: "bottom", title: "Match with ads for your age group.""""),format.raw/*71.92*/("""}"""),format.raw/*71.93*/(""")
        $('#zipCode').tooltip("""),format.raw/*72.31*/("""{"""),format.raw/*72.32*/("""placement: "bottom", title: "Match with ads in your area.""""),format.raw/*72.90*/("""}"""),format.raw/*72.91*/(""")
        $('#male').tooltip("""),format.raw/*73.28*/("""{"""),format.raw/*73.29*/("""placement: "bottom", title: "Match with ads for guys.""""),format.raw/*73.83*/("""}"""),format.raw/*73.84*/(""")
        $('#female').tooltip("""),format.raw/*74.30*/("""{"""),format.raw/*74.31*/("""placement: "bottom", title: "Match with ads for gals.""""),format.raw/*74.85*/("""}"""),format.raw/*74.86*/(""")
        $('.occupation').tooltip("""),format.raw/*75.34*/("""{"""),format.raw/*75.35*/("""placement: "bottom", title: "Match with ads related to your job.""""),format.raw/*75.100*/("""}"""),format.raw/*75.101*/(""")
        $('.interest').tooltip("""),format.raw/*76.32*/("""{"""),format.raw/*76.33*/("""placement: "bottom", title: "Match with ads about your interests.""""),format.raw/*76.99*/("""}"""),format.raw/*76.100*/(""")
    </script>
""")))})))}
    }
    
    def render(form:Form[Signup.SignupForm]): play.api.templates.Html = apply(form)
    
    def f:((Form[Signup.SignupForm]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 06 16:24:40 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/signup.scala.html
                    HASH: a18693d53d10dddfcefd599482f16e438549076b
                    MATRIX: 741->1|849->32|888->37|916->57|955->59|1077->146|1091->152|1126->166|1507->510|1530->523|1559->529|1600->541|1630->542|1663->546|1693->547|2105->930|2135->931|2168->935|2198->936|2412->1121|2442->1122|2475->1126|2505->1127|3042->1628|3081->1658|3135->1674|3362->1864|3383->1875|3397->1879|3451->1894|3505->1911|3525->1921|3556->1929|3596->1932|3673->1999|3714->2001|3756->2010|3795->2012|3815->2022|3848->2032|3891->2042|4090->2204|4111->2215|4125->2219|4179->2234|4233->2251|4253->2261|4284->2269|4324->2272|4401->2339|4442->2341|4484->2350|4523->2352|4543->2362|4576->2372|4619->2382|4725->2456|5151->2845|5172->2856|5201->2862|5572->3196|5597->3211|5626->3217|6021->3575|6060->3604|6101->3606|6142->3614|6372->3807|6411->3836|6452->3838|6493->3846|6802->4119|6839->4147|6891->4161|7082->4315|7101->4324|7115->4328|7167->4341|7221->4358|7239->4366|7270->4374|7310->4377|7383->4440|7424->4442|7466->4451|7505->4453|7523->4461|7556->4471|7599->4481|7811->4656|7830->4665|7844->4669|7896->4682|7950->4699|7968->4707|7999->4715|8039->4718|8112->4781|8153->4783|8195->4792|8234->4794|8252->4802|8285->4812|8328->4822|8540->4997|8559->5006|8573->5010|8625->5023|8679->5040|8697->5048|8728->5056|8768->5059|8841->5122|8882->5124|8924->5133|8963->5135|8981->5143|9014->5153|9057->5163|9269->5338|9288->5347|9302->5351|9354->5364|9408->5381|9426->5389|9457->5397|9497->5400|9570->5463|9611->5465|9653->5474|9692->5476|9710->5484|9743->5494|9786->5504|9866->5552|10213->5863|10228->5869|10278->5897|10324->5915|10353->5916|10458->5993|10487->5994|10535->6014|10564->6015|10650->6073|10679->6074|10734->6101|10763->6102|10827->6138|10856->6139|10929->6184|10958->6185|11009->6207|11039->6208|11069->6209|11108->6221|11137->6222|11205->6262|11234->6263|11326->6327|11355->6328|11416->6361|11445->6362|11531->6420|11560->6421|11618->6451|11647->6452|11729->6506|11758->6507|11818->6539|11847->6540|11929->6594|11958->6595|12022->6631|12051->6632|12145->6697|12175->6698|12237->6732|12266->6733|12360->6799|12390->6800
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|38->10|38->10|38->10|38->10|38->10|38->10|38->10|43->15|43->15|43->15|43->15|44->16|44->16|44->16|44->16|52->24|52->24|52->24|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|55->27|57->29|63->35|63->35|63->35|67->39|67->39|67->39|72->44|72->44|72->44|72->44|73->45|73->45|73->45|73->45|78->50|78->50|78->50|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|80->52|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|83->55|91->63|91->63|91->63|91->63|91->63|93->65|93->65|93->65|93->65|95->67|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|97->69|97->69|99->71|99->71|99->71|99->71|100->72|100->72|100->72|100->72|101->73|101->73|101->73|101->73|102->74|102->74|102->74|102->74|103->75|103->75|103->75|103->75|104->76|104->76|104->76|104->76
                    -- GENERATED --
                */
            