
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
                <div class="row"><div class="span12 text-center"><strong>Required fields:</strong></div></div>
                <br>
                <div class="row">
                    <div class="span4 offset1">Email:</div>
                    <div class="span3">Password:</div>
                </div>
                <div class="row">
                    <div class="span4 offset1"><input class="span4" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*14.134*/form("email")/*14.147*/.value)),format.raw/*14.153*/("""" pattern="."""),format.raw/*14.165*/("""{"""),format.raw/*14.166*/("""1,63"""),format.raw/*14.170*/("""}"""),format.raw/*14.171*/(""""></div>
                    <div class="span3"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*15.140*/("""{"""),format.raw/*15.141*/("""6,31"""),format.raw/*15.145*/("""}"""),format.raw/*15.146*/(""""></div>
                    <div class="span3"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*16.159*/("""{"""),format.raw/*16.160*/("""6,31"""),format.raw/*16.164*/("""}"""),format.raw/*16.165*/(""""></div>
                </div>
                <br>
                <div class="row"><div class="span12 text-center"><strong>Optional fields *:</strong></div></div>
                <br>
                <div class="row"><div class="span5 offset1">Occupations:</div></div>
                """),_display_(Seq[Any](/*22.18*/defining(Occupation.findAll())/*22.48*/ {occupations =>_display_(Seq[Any](format.raw/*22.64*/("""
                    <div class="row">
                        <div class="span5 offset1"><select class="span5 occupation" id="occupation1" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*24.150*/occupations/*24.161*/.map/*24.165*/ {occupation =>_display_(Seq[Any](format.raw/*24.180*/(""" <option value=""""),_display_(Seq[Any](/*24.197*/occupation/*24.207*/.getId())),format.raw/*24.215*/("""" """),_display_(Seq[Any](/*24.218*/if(occupation.getId().toString().equals(form("occupation1").value))/*24.285*/ {_display_(Seq[Any](format.raw/*24.287*/("""selected""")))})),format.raw/*24.296*/(""">"""),_display_(Seq[Any](/*24.298*/occupation/*24.308*/.getName())),format.raw/*24.318*/("""</option>""")))})),format.raw/*24.328*/("""</select></div>
                        <div class="span5"><select class="span5 occupation" id="occupation2" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*25.142*/occupations/*25.153*/.map/*25.157*/ {occupation =>_display_(Seq[Any](format.raw/*25.172*/(""" <option value=""""),_display_(Seq[Any](/*25.189*/occupation/*25.199*/.getId())),format.raw/*25.207*/("""" """),_display_(Seq[Any](/*25.210*/if(occupation.getId().toString().equals(form("occupation2").value))/*25.277*/ {_display_(Seq[Any](format.raw/*25.279*/("""selected""")))})),format.raw/*25.288*/(""">"""),_display_(Seq[Any](/*25.290*/occupation/*25.300*/.getName())),format.raw/*25.310*/("""</option>""")))})),format.raw/*25.320*/("""</select></div>
                    </div>
                """)))})),format.raw/*27.18*/("""
                <div class="row">
                    <div class="span2 offset1">Age:</div>
                    <div class="span2">Zip code:</div>
                    <div class="span2">Gender:</div>
                    <div class="span4">Interests:</div>
                </div>
                """),_display_(Seq[Any](/*34.18*/defining(Interest.findAll())/*34.46*/ {interests =>_display_(Seq[Any](format.raw/*34.60*/("""
                    <div class="row">
                        <div class="span2 offset1"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*36.165*/form("age")/*36.176*/.value)),format.raw/*36.182*/(""""></div>
                        <div class="span2"><input class="span2" type="text" id="zipCode" name="zipCode" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*37.150*/form("zipCode")/*37.165*/.value)),format.raw/*37.171*/("""" autocomplete="off"></div>
                        <div class="span1"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*38.127*/if(form("gender").value=="M")/*38.156*/ {_display_(Seq[Any](format.raw/*38.158*/("""checked""")))})),format.raw/*38.166*/("""><img src="assets/img/male.png" width="15px"></label></div>
                        <div class="span1"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*39.129*/if(form("gender").value=="F")/*39.158*/ {_display_(Seq[Any](format.raw/*39.160*/("""checked""")))})),format.raw/*39.168*/("""><img src="assets/img/female.png" width="15px"></label></div>
                        <div class="span4"><select class="span4 interest" id="interest1" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*40.136*/interests/*40.145*/.map/*40.149*/ {interest =>_display_(Seq[Any](format.raw/*40.162*/(""" <option value=""""),_display_(Seq[Any](/*40.179*/interest/*40.187*/.getId())),format.raw/*40.195*/("""" """),_display_(Seq[Any](/*40.198*/if(interest.getId().toString().equals(form("interest1").value))/*40.261*/ {_display_(Seq[Any](format.raw/*40.263*/("""selected""")))})),format.raw/*40.272*/(""">"""),_display_(Seq[Any](/*40.274*/interest/*40.282*/.getName())),format.raw/*40.292*/("""</option>""")))})),format.raw/*40.302*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span4 offset7"><select class="span4 interest" id="interest2" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*43.144*/interests/*43.153*/.map/*43.157*/ {interest =>_display_(Seq[Any](format.raw/*43.170*/(""" <option value=""""),_display_(Seq[Any](/*43.187*/interest/*43.195*/.getId())),format.raw/*43.203*/("""" """),_display_(Seq[Any](/*43.206*/if(interest.getId().toString().equals(form("interest2").value))/*43.269*/ {_display_(Seq[Any](format.raw/*43.271*/("""selected""")))})),format.raw/*43.280*/(""">"""),_display_(Seq[Any](/*43.282*/interest/*43.290*/.getName())),format.raw/*43.300*/("""</option>""")))})),format.raw/*43.310*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span4 offset7"><select class="span4 interest" id="interest3" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*46.144*/interests/*46.153*/.map/*46.157*/ {interest =>_display_(Seq[Any](format.raw/*46.170*/(""" <option value=""""),_display_(Seq[Any](/*46.187*/interest/*46.195*/.getId())),format.raw/*46.203*/("""" """),_display_(Seq[Any](/*46.206*/if(interest.getId().toString().equals(form("interest3").value))/*46.269*/ {_display_(Seq[Any](format.raw/*46.271*/("""selected""")))})),format.raw/*46.280*/(""">"""),_display_(Seq[Any](/*46.282*/interest/*46.290*/.getName())),format.raw/*46.300*/("""</option>""")))})),format.raw/*46.310*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span4 offset7"><select class="span4 interest" id="interest4" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*49.144*/interests/*49.153*/.map/*49.157*/ {interest =>_display_(Seq[Any](format.raw/*49.170*/(""" <option value=""""),_display_(Seq[Any](/*49.187*/interest/*49.195*/.getId())),format.raw/*49.203*/("""" """),_display_(Seq[Any](/*49.206*/if(interest.getId().toString().equals(form("interest4").value))/*49.269*/ {_display_(Seq[Any](format.raw/*49.271*/("""selected""")))})),format.raw/*49.280*/(""">"""),_display_(Seq[Any](/*49.282*/interest/*49.290*/.getName())),format.raw/*49.300*/("""</option>""")))})),format.raw/*49.310*/("""</select></div>
                    </div>
                """)))})),format.raw/*51.18*/("""
                <div class="row"><div class="span12 text-center"><i>* Optional fields help match you with higher-paying videos!</i></div></div>
                <div class="row"><div class="span12 text-center"><button type="submit" class="btn btn-large btn-success">Submit</button></div></div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        $.getJSON(""""),_display_(Seq[Any](/*58.21*/routes/*58.27*/.Assets.at("data/Zips.json"))),format.raw/*58.55*/("""", function(data) """),format.raw/*58.73*/("""{"""),format.raw/*58.74*/("""
            var zipCodes = [];
            $.each(data, function(i, item) """),format.raw/*60.44*/("""{"""),format.raw/*60.45*/("""zipCodes.push(item);"""),format.raw/*60.65*/("""}"""),format.raw/*60.66*/(""");
            $('#zipCode')
                .typeahead("""),format.raw/*62.28*/("""{"""),format.raw/*62.29*/("""source: zipCodes, items: 10"""),format.raw/*62.56*/("""}"""),format.raw/*62.57*/(""")
                .blur(function() """),format.raw/*63.34*/("""{"""),format.raw/*63.35*/("""if($.inArray($(this).val(), zipCodes) == -1) """),format.raw/*63.80*/("""{"""),format.raw/*63.81*/("""$('#zipCode').val('');"""),format.raw/*63.103*/("""}"""),format.raw/*63.104*/("""}"""),format.raw/*63.105*/(""");
        """),format.raw/*64.9*/("""}"""),format.raw/*64.10*/(""");
        
    	$('#email').tooltip("""),format.raw/*66.26*/("""{"""),format.raw/*66.27*/("""placement: "bottom", title: "Must be between 1 and 63 characters.""""),format.raw/*66.93*/("""}"""),format.raw/*66.94*/(""")
    	$('#password').tooltip("""),format.raw/*67.29*/("""{"""),format.raw/*67.30*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*67.96*/("""}"""),format.raw/*67.97*/(""")
    	$('#passwordRepeat').tooltip("""),format.raw/*68.35*/("""{"""),format.raw/*68.36*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*68.102*/("""}"""),format.raw/*68.103*/(""")
    	$('#age').tooltip("""),format.raw/*69.24*/("""{"""),format.raw/*69.25*/("""placement: "bottom", title: "Match with videos for your age group.""""),format.raw/*69.92*/("""}"""),format.raw/*69.93*/(""")
    	$('#zipCode').tooltip("""),format.raw/*70.28*/("""{"""),format.raw/*70.29*/("""placement: "bottom", title: "Match with videos in your area.""""),format.raw/*70.90*/("""}"""),format.raw/*70.91*/(""")
    	$('#male').tooltip("""),format.raw/*71.25*/("""{"""),format.raw/*71.26*/("""placement: "bottom", title: "Match you with videos for guys.""""),format.raw/*71.87*/("""}"""),format.raw/*71.88*/(""")
    	$('#female').tooltip("""),format.raw/*72.27*/("""{"""),format.raw/*72.28*/("""placement: "bottom", title: "Match you with videos for gals.""""),format.raw/*72.89*/("""}"""),format.raw/*72.90*/(""")
    	$('.occupation').tooltip("""),format.raw/*73.31*/("""{"""),format.raw/*73.32*/("""placement: "bottom", title: "Match with videos related to your job.""""),format.raw/*73.100*/("""}"""),format.raw/*73.101*/(""")
    	$('.interest').tooltip("""),format.raw/*74.29*/("""{"""),format.raw/*74.30*/("""placement: "bottom", title: "Match with videos about your interests.""""),format.raw/*74.99*/("""}"""),format.raw/*74.100*/(""")
    </script>
""")))})))}
    }
    
    def render(form:Form[Signup.SignupForm]): play.api.templates.Html = apply(form)
    
    def f:((Form[Signup.SignupForm]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 05 19:03:16 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/signup.scala.html
                    HASH: b4d4c0b74555e2abe5452d9e204d7a052ce5d64a
                    MATRIX: 741->1|849->32|888->37|916->57|955->59|1077->146|1091->152|1126->166|1659->662|1682->675|1711->681|1752->693|1782->694|1815->698|1845->699|2023->848|2053->849|2086->853|2116->854|2313->1022|2343->1023|2376->1027|2406->1028|2737->1323|2776->1353|2830->1369|3057->1559|3078->1570|3092->1574|3146->1589|3200->1606|3220->1616|3251->1624|3291->1627|3368->1694|3409->1696|3451->1705|3490->1707|3510->1717|3543->1727|3586->1737|3781->1895|3802->1906|3816->1910|3870->1925|3924->1942|3944->1952|3975->1960|4015->1963|4092->2030|4133->2032|4175->2041|4214->2043|4234->2053|4267->2063|4310->2073|4404->2135|4744->2439|4781->2467|4833->2481|5075->2686|5096->2697|5125->2703|5321->2862|5346->2877|5375->2883|5567->3038|5606->3067|5647->3069|5688->3077|5914->3266|5953->3295|5994->3297|6035->3305|6270->3503|6289->3512|6303->3516|6355->3529|6409->3546|6427->3554|6458->3562|6498->3565|6571->3628|6612->3630|6654->3639|6693->3641|6711->3649|6744->3659|6787->3669|7051->3896|7070->3905|7084->3909|7136->3922|7190->3939|7208->3947|7239->3955|7279->3958|7352->4021|7393->4023|7435->4032|7474->4034|7492->4042|7525->4052|7568->4062|7832->4289|7851->4298|7865->4302|7917->4315|7971->4332|7989->4340|8020->4348|8060->4351|8133->4414|8174->4416|8216->4425|8255->4427|8273->4435|8306->4445|8349->4455|8613->4682|8632->4691|8646->4695|8698->4708|8752->4725|8770->4733|8801->4741|8841->4744|8914->4807|8955->4809|8997->4818|9036->4820|9054->4828|9087->4838|9130->4848|9224->4910|9663->5313|9678->5319|9728->5347|9774->5365|9803->5366|9908->5443|9937->5444|9985->5464|10014->5465|10100->5523|10129->5524|10184->5551|10213->5552|10277->5588|10306->5589|10379->5634|10408->5635|10459->5657|10489->5658|10519->5659|10558->5671|10587->5672|10654->5711|10683->5712|10777->5778|10806->5779|10865->5810|10894->5811|10988->5877|11017->5878|11082->5915|11111->5916|11206->5982|11236->5983|11290->6009|11319->6010|11414->6077|11443->6078|11501->6108|11530->6109|11619->6170|11648->6171|11703->6198|11732->6199|11821->6260|11850->6261|11907->6290|11936->6291|12025->6352|12054->6353|12115->6386|12144->6387|12241->6455|12271->6456|12330->6487|12359->6488|12456->6557|12486->6558
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|42->14|42->14|42->14|42->14|42->14|42->14|42->14|43->15|43->15|43->15|43->15|44->16|44->16|44->16|44->16|50->22|50->22|50->22|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|55->27|62->34|62->34|62->34|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|66->38|67->39|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|79->51|86->58|86->58|86->58|86->58|86->58|88->60|88->60|88->60|88->60|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|92->64|92->64|94->66|94->66|94->66|94->66|95->67|95->67|95->67|95->67|96->68|96->68|96->68|96->68|97->69|97->69|97->69|97->69|98->70|98->70|98->70|98->70|99->71|99->71|99->71|99->71|100->72|100->72|100->72|100->72|101->73|101->73|101->73|101->73|102->74|102->74|102->74|102->74
                    -- GENERATED --
                */
            