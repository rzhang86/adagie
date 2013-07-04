
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
    <div class="row">
        <div class="span12 well">
            <div class="row"><div class="span12 text-right"><button type="button" class="btn btn-primary" id="edit-button" data-toggle="button">Edit</button></div></div>
            <form action=""""),_display_(Seq[Any](/*7.28*/routes/*7.34*/.Profile.post())),format.raw/*7.49*/("""" method="post">
                        <div class="row"><div class="span12 text-center"><strong>Required fields:</strong></div></div>
                        <br>
                        <div class="row">
                            <div class="span4 offset1">Email:</div>
                            <!--
                            <div class="span3">Password:</div>
                            -->
                        </div>
                        <div class="row">
                            <div class="span4 offset1 nonform-div text-info"><i>"""),_display_(Seq[Any](/*17.82*/form("email")/*17.95*/.value)),format.raw/*17.101*/("""</i></div>
                            <div class="span4 offset1 form-div nonform-height text-info"><i>"""),_display_(Seq[Any](/*18.94*/form("email")/*18.107*/.value)),format.raw/*18.113*/("""</i></div>
                            <!--
                            <div class="span3 nonform-div"></div>
                            <div class="span3 nonform-div"></div>
                            <div class="span4 offset1 form-div"><input class="span4" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*22.151*/form("email")/*22.164*/.value)),format.raw/*22.170*/("""" pattern="."""),format.raw/*22.182*/("""{"""),format.raw/*22.183*/("""1,63"""),format.raw/*22.187*/("""}"""),format.raw/*22.188*/(""""></div>
                            <div class="span3 form-div"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*23.157*/("""{"""),format.raw/*23.158*/("""6,31"""),format.raw/*23.162*/("""}"""),format.raw/*23.163*/(""""></div>
                            <div class="span3 form-div"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*24.176*/("""{"""),format.raw/*24.177*/("""6,31"""),format.raw/*24.181*/("""}"""),format.raw/*24.182*/(""""></div>
                            -->
                        </div>
                        <br>
                        <div class="row"><div class="span12 text-center"><strong>Optional fields:</strong></div></div>
                        <br>
                        <div class="row"><div class="span5 offset1">Occupations:</div></div>
                        """),_display_(Seq[Any](/*31.26*/defining(Occupation.findAll())/*31.56*/ {occupations =>_display_(Seq[Any](format.raw/*31.72*/("""
                            <div class="row ">
                                <div class="span5 offset1 nonform-div text-info"><i>"""),_display_(Seq[Any](/*33.86*/Occupation/*33.96*/.getNameByString(form("occupation1").value))),format.raw/*33.139*/("""</i></div>
                                <div class="span5 nonform-div text-info"><i>"""),_display_(Seq[Any](/*34.78*/Occupation/*34.88*/.getNameByString(form("occupation2").value))),format.raw/*34.131*/("""</i></div>
                                <div class="span5 offset1 form-div"><select class="span5 occupation" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*35.150*/occupations/*35.161*/.map/*35.165*/ {occupation =>_display_(Seq[Any](format.raw/*35.180*/(""" <option value=""""),_display_(Seq[Any](/*35.197*/occupation/*35.207*/.getId())),format.raw/*35.215*/("""" """),_display_(Seq[Any](/*35.218*/if(occupation.getId().toString().equals(form("occupation1").value))/*35.285*/ {_display_(Seq[Any](format.raw/*35.287*/("""selected""")))})),format.raw/*35.296*/(""">"""),_display_(Seq[Any](/*35.298*/occupation/*35.308*/.getName())),format.raw/*35.318*/("""</option>""")))})),format.raw/*35.328*/("""</select></div>
                                <div class="span5 form-div"><select class="span5 occupation" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*36.142*/occupations/*36.153*/.map/*36.157*/ {occupation =>_display_(Seq[Any](format.raw/*36.172*/(""" <option value=""""),_display_(Seq[Any](/*36.189*/occupation/*36.199*/.getId())),format.raw/*36.207*/("""" """),_display_(Seq[Any](/*36.210*/if(occupation.getId().toString().equals(form("occupation2").value))/*36.277*/ {_display_(Seq[Any](format.raw/*36.279*/("""selected""")))})),format.raw/*36.288*/(""">"""),_display_(Seq[Any](/*36.290*/occupation/*36.300*/.getName())),format.raw/*36.310*/("""</option>""")))})),format.raw/*36.320*/("""</select></div>
                            </div>
                        """)))})),format.raw/*38.26*/("""
                        <div class="row">
                            <div class="span2 offset1">Age:</div>
                            <div class="span2">Zip code:</div>
                            <div class="span2">Gender:</div>
                            <div class="span4">Interests:</div>
                        </div>
                        """),_display_(Seq[Any](/*45.26*/defining(Interest.findAll())/*45.54*/ {interests =>_display_(Seq[Any](format.raw/*45.68*/("""
                            <div class="row">
                                <div class="span2 offset1 nonform-div text-info"><i>"""),_display_(Seq[Any](/*47.86*/form("age")/*47.97*/.value)),format.raw/*47.103*/("""</i></div>
                                <div class="span2 nonform-div text-info"><i>"""),_display_(Seq[Any](/*48.78*/form("zipCode")/*48.93*/.value)),format.raw/*48.99*/("""</i></div>
                                <div class="span1 nonform-div text-info">"""),_display_(Seq[Any](/*49.75*/if(form("gender").value=="M")/*49.104*/ {_display_(Seq[Any](format.raw/*49.106*/("""<img src="assets/img/male.png">""")))})),format.raw/*49.138*/("""</div>
                                <div class="span1 nonform-div text-info">"""),_display_(Seq[Any](/*50.75*/if(form("gender").value=="F")/*50.104*/ {_display_(Seq[Any](format.raw/*50.106*/("""<img src="assets/img/female.png">""")))})),format.raw/*50.140*/("""</div>
                                <div class="span4 nonform-div text-info"><i>"""),_display_(Seq[Any](/*51.78*/Interest/*51.86*/.getNameByString(form("interest1").value))),format.raw/*51.127*/("""</i></div>
                                <div class="span2 offset1 form-div"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*52.182*/form("age")/*52.193*/.value)),format.raw/*52.199*/(""""></div>
                                <div class="span2 form-div"><input class="span2" type="text" id="zipCode" name="zipCode" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*53.167*/form("zipCode")/*53.182*/.value)),format.raw/*53.188*/(""""></div>
                                <div class="span1 form-div"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*54.144*/if(form("gender").value=="M")/*54.173*/ {_display_(Seq[Any](format.raw/*54.175*/("""checked""")))})),format.raw/*54.183*/("""><img src="assets/img/male.png"></label></div>
                                <div class="span1 form-div"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*55.146*/if(form("gender").value=="F")/*55.175*/ {_display_(Seq[Any](format.raw/*55.177*/("""checked""")))})),format.raw/*55.185*/("""><img src="assets/img/female.png"></label></div>
                                <div class="span4 form-div"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*56.138*/interests/*56.147*/.map/*56.151*/ {interest =>_display_(Seq[Any](format.raw/*56.164*/(""" <option value=""""),_display_(Seq[Any](/*56.181*/interest/*56.189*/.getId())),format.raw/*56.197*/("""" """),_display_(Seq[Any](/*56.200*/if(interest.getId().toString().equals(form("interest1").value))/*56.263*/ {_display_(Seq[Any](format.raw/*56.265*/("""selected""")))})),format.raw/*56.274*/(""">"""),_display_(Seq[Any](/*56.276*/interest/*56.284*/.getName())),format.raw/*56.294*/("""</option>""")))})),format.raw/*56.304*/("""</select></div>
                            </div>
                            <div class="row ">
                                <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*59.86*/Interest/*59.94*/.getNameByString(form("interest2").value))),format.raw/*59.135*/("""</i></div>
                                <div class="span4 offset7 form-div"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*60.146*/interests/*60.155*/.map/*60.159*/ {interest =>_display_(Seq[Any](format.raw/*60.172*/(""" <option value=""""),_display_(Seq[Any](/*60.189*/interest/*60.197*/.getId())),format.raw/*60.205*/("""" """),_display_(Seq[Any](/*60.208*/if(interest.getId().toString().equals(form("interest2").value))/*60.271*/ {_display_(Seq[Any](format.raw/*60.273*/("""selected""")))})),format.raw/*60.282*/(""">"""),_display_(Seq[Any](/*60.284*/interest/*60.292*/.getName())),format.raw/*60.302*/("""</option>""")))})),format.raw/*60.312*/("""</select></div>
                            </div>
                            <div class="row">
                                <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*63.86*/Interest/*63.94*/.getNameByString(form("interest3").value))),format.raw/*63.135*/("""</i></div>
                                <div class="span4 offset7 form-div"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*64.146*/interests/*64.155*/.map/*64.159*/ {interest =>_display_(Seq[Any](format.raw/*64.172*/(""" <option value=""""),_display_(Seq[Any](/*64.189*/interest/*64.197*/.getId())),format.raw/*64.205*/("""" """),_display_(Seq[Any](/*64.208*/if(interest.getId().toString().equals(form("interest3").value))/*64.271*/ {_display_(Seq[Any](format.raw/*64.273*/("""selected""")))})),format.raw/*64.282*/(""">"""),_display_(Seq[Any](/*64.284*/interest/*64.292*/.getName())),format.raw/*64.302*/("""</option>""")))})),format.raw/*64.312*/("""</select></div>
                            </div>
                            <div class="row">
                                <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*67.86*/Interest/*67.94*/.getNameByString(form("interest4").value))),format.raw/*67.135*/("""</i></div>
                                <div class="span4 offset7 form-div"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*68.146*/interests/*68.155*/.map/*68.159*/ {interest =>_display_(Seq[Any](format.raw/*68.172*/(""" <option value=""""),_display_(Seq[Any](/*68.189*/interest/*68.197*/.getId())),format.raw/*68.205*/("""" """),_display_(Seq[Any](/*68.208*/if(interest.getId().toString().equals(form("interest4").value))/*68.271*/ {_display_(Seq[Any](format.raw/*68.273*/("""selected""")))})),format.raw/*68.282*/(""">"""),_display_(Seq[Any](/*68.284*/interest/*68.292*/.getName())),format.raw/*68.302*/("""</option>""")))})),format.raw/*68.312*/("""</select></div>
                            </div>
                        """)))})),format.raw/*70.26*/("""
                        <div class="row"><div class="span12 text-center"><i>Optional fields help match you with higher-paying videos!</i></div></div>
                        <div class="row">
                            <div class="span12 text-center nonform-div text-info"></div>
                            <div class="span12 text-center form-div"><button type="submit" class="btn btn-large btn-success">Submit</button></div>
                        </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
    	$('.form-div').hide()
    	$('.nonform-div').show()
    	var editButton = $('#edit-button')
    	editButton.click(function() """),format.raw/*83.34*/("""{"""),format.raw/*83.35*/("""
            //b.button('toggle')
            if (editButton.hasClass('active')) """),format.raw/*85.48*/("""{"""),format.raw/*85.49*/("""
            	$('.form-div').hide()
            	$('.nonform-div').show()
            """),format.raw/*88.13*/("""}"""),format.raw/*88.14*/("""
            else """),format.raw/*89.18*/("""{"""),format.raw/*89.19*/("""
            	$('.form-div').show()
            	$('.nonform-div').hide()
            """),format.raw/*92.13*/("""}"""),format.raw/*92.14*/("""
        """),format.raw/*93.9*/("""}"""),format.raw/*93.10*/(""")
        
        $.getJSON(""""),_display_(Seq[Any](/*95.21*/routes/*95.27*/.Assets.at("data/Zips.json"))),format.raw/*95.55*/("""", function(data) """),format.raw/*95.73*/("""{"""),format.raw/*95.74*/("""
            var zipCodes = [];
            $.each(data, function(i, item) """),format.raw/*97.44*/("""{"""),format.raw/*97.45*/("""zipCodes.push(item);"""),format.raw/*97.65*/("""}"""),format.raw/*97.66*/(""");
            $('#zipCode')
                .typeahead("""),format.raw/*99.28*/("""{"""),format.raw/*99.29*/("""source: zipCodes, items: 10"""),format.raw/*99.56*/("""}"""),format.raw/*99.57*/(""")
                .blur(function() """),format.raw/*100.34*/("""{"""),format.raw/*100.35*/("""if($.inArray($(this).val(), zipCodes) == -1) """),format.raw/*100.80*/("""{"""),format.raw/*100.81*/("""$('#zipCode').val('');"""),format.raw/*100.103*/("""}"""),format.raw/*100.104*/("""}"""),format.raw/*100.105*/(""");
        """),format.raw/*101.9*/("""}"""),format.raw/*101.10*/(""");
    	
        $('#email').tooltip("""),format.raw/*103.29*/("""{"""),format.raw/*103.30*/("""placement: "bottom", title: "Must be between 1 and 63 characters.""""),format.raw/*103.96*/("""}"""),format.raw/*103.97*/(""")
        $('#password').tooltip("""),format.raw/*104.32*/("""{"""),format.raw/*104.33*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*104.99*/("""}"""),format.raw/*104.100*/(""")
        $('#passwordRepeat').tooltip("""),format.raw/*105.38*/("""{"""),format.raw/*105.39*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*105.105*/("""}"""),format.raw/*105.106*/(""")
        $('#age').tooltip("""),format.raw/*106.27*/("""{"""),format.raw/*106.28*/("""placement: "bottom", title: "Match with videos for your age group.""""),format.raw/*106.95*/("""}"""),format.raw/*106.96*/(""")
        $('#zipCode').tooltip("""),format.raw/*107.31*/("""{"""),format.raw/*107.32*/("""placement: "bottom", title: "Match with videos in your area.""""),format.raw/*107.93*/("""}"""),format.raw/*107.94*/(""")
        $('#male').tooltip("""),format.raw/*108.28*/("""{"""),format.raw/*108.29*/("""placement: "bottom", title: "Match you with videos for guys.""""),format.raw/*108.90*/("""}"""),format.raw/*108.91*/(""")
        $('#female').tooltip("""),format.raw/*109.30*/("""{"""),format.raw/*109.31*/("""placement: "bottom", title: "Match you with videos for gals.""""),format.raw/*109.92*/("""}"""),format.raw/*109.93*/(""")
        $('.occupation').tooltip("""),format.raw/*110.34*/("""{"""),format.raw/*110.35*/("""placement: "bottom", title: "Match with videos related to your job.""""),format.raw/*110.103*/("""}"""),format.raw/*110.104*/(""")
        $('.interest').tooltip("""),format.raw/*111.32*/("""{"""),format.raw/*111.33*/("""placement: "bottom", title: "Match with videos about your interests.""""),format.raw/*111.102*/("""}"""),format.raw/*111.103*/(""")
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Profile.ProfileForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Profile.ProfileForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 04 19:43:54 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: 74295b4ffb867d7ec736891ce06ab4623a04944a
                    MATRIX: 749->1|871->46|910->51|939->72|978->74|1271->332|1285->338|1321->353|1924->920|1946->933|1975->939|2116->1044|2139->1057|2168->1063|2535->1393|2558->1406|2587->1412|2628->1424|2658->1425|2691->1429|2721->1430|2916->1596|2946->1597|2979->1601|3009->1602|3223->1787|3253->1788|3286->1792|3316->1793|3726->2167|3765->2197|3819->2213|3990->2348|4009->2358|4075->2401|4200->2490|4219->2500|4285->2543|4483->2704|4504->2715|4518->2719|4572->2734|4626->2751|4646->2761|4677->2769|4717->2772|4794->2839|4835->2841|4877->2850|4916->2852|4936->2862|4969->2872|5012->2882|5207->3040|5228->3051|5242->3055|5296->3070|5350->3087|5370->3097|5401->3105|5441->3108|5518->3175|5559->3177|5601->3186|5640->3188|5660->3198|5693->3208|5736->3218|5846->3296|6242->3656|6279->3684|6331->3698|6501->3832|6521->3843|6550->3849|6675->3938|6699->3953|6727->3959|6849->4045|6888->4074|6929->4076|6994->4108|7112->4190|7151->4219|7192->4221|7259->4255|7380->4340|7397->4348|7461->4389|7691->4582|7712->4593|7741->4599|7954->4775|7979->4790|8008->4796|8198->4949|8237->4978|8278->4980|8319->4988|8549->5181|8588->5210|8629->5212|8670->5220|8894->5407|8913->5416|8927->5420|8979->5433|9033->5450|9051->5458|9082->5466|9122->5469|9195->5532|9236->5534|9278->5543|9317->5545|9335->5553|9368->5563|9411->5573|9633->5759|9650->5767|9714->5808|9908->5965|9927->5974|9941->5978|9993->5991|10047->6008|10065->6016|10096->6024|10136->6027|10209->6090|10250->6092|10292->6101|10331->6103|10349->6111|10382->6121|10425->6131|10646->6316|10663->6324|10727->6365|10921->6522|10940->6531|10954->6535|11006->6548|11060->6565|11078->6573|11109->6581|11149->6584|11222->6647|11263->6649|11305->6658|11344->6660|11362->6668|11395->6678|11438->6688|11659->6873|11676->6881|11740->6922|11934->7079|11953->7088|11967->7092|12019->7105|12073->7122|12091->7130|12122->7138|12162->7141|12235->7204|12276->7206|12318->7215|12357->7217|12375->7225|12408->7235|12451->7245|12561->7323|13274->8008|13303->8009|13414->8092|13443->8093|13560->8182|13589->8183|13636->8202|13665->8203|13782->8292|13811->8293|13848->8303|13877->8304|13946->8337|13961->8343|14011->8371|14057->8389|14086->8390|14191->8467|14220->8468|14268->8488|14297->8489|14383->8547|14412->8548|14467->8575|14496->8576|14561->8612|14591->8613|14665->8658|14695->8659|14747->8681|14778->8682|14809->8683|14849->8695|14879->8696|14947->8735|14977->8736|15072->8802|15102->8803|15165->8837|15195->8838|15290->8904|15321->8905|15390->8945|15420->8946|15516->9012|15547->9013|15605->9042|15635->9043|15731->9110|15761->9111|15823->9144|15853->9145|15943->9206|15973->9207|16032->9237|16062->9238|16152->9299|16182->9300|16243->9332|16273->9333|16363->9394|16393->9395|16458->9431|16488->9432|16586->9500|16617->9501|16680->9535|16710->9536|16809->9605|16840->9606
                    LINES: 26->1|29->1|31->3|31->3|31->3|35->7|35->7|35->7|45->17|45->17|45->17|46->18|46->18|46->18|50->22|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|52->24|52->24|52->24|52->24|59->31|59->31|59->31|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|66->38|73->45|73->45|73->45|75->47|75->47|75->47|76->48|76->48|76->48|77->49|77->49|77->49|77->49|78->50|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|80->52|81->53|81->53|81->53|82->54|82->54|82->54|82->54|83->55|83->55|83->55|83->55|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|87->59|87->59|87->59|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|91->63|91->63|91->63|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|98->70|111->83|111->83|113->85|113->85|116->88|116->88|117->89|117->89|120->92|120->92|121->93|121->93|123->95|123->95|123->95|123->95|123->95|125->97|125->97|125->97|125->97|127->99|127->99|127->99|127->99|128->100|128->100|128->100|128->100|128->100|128->100|128->100|129->101|129->101|131->103|131->103|131->103|131->103|132->104|132->104|132->104|132->104|133->105|133->105|133->105|133->105|134->106|134->106|134->106|134->106|135->107|135->107|135->107|135->107|136->108|136->108|136->108|136->108|137->109|137->109|137->109|137->109|138->110|138->110|138->110|138->110|139->111|139->111|139->111|139->111
                    -- GENERATED --
                */
            