
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
                                <div class="span5 offset1 nonform-div text-info"><i>"""),_display_(Seq[Any](/*33.86*/occupations/*33.97*/.map/*33.101*/ {occupation =>_display_(Seq[Any](format.raw/*33.116*/(""" """),_display_(Seq[Any](/*33.118*/if(form("occupation1").value==occupation.getId().toString())/*33.178*/ {_display_(Seq[Any](_display_(Seq[Any](/*33.181*/occupation/*33.191*/.getName()))))}))))})),format.raw/*33.203*/("""</i></div>
                                <div class="span5 nonform-div text-info"><i>"""),_display_(Seq[Any](/*34.78*/occupations/*34.89*/.map/*34.93*/ {occupation =>_display_(Seq[Any](format.raw/*34.108*/(""" """),_display_(Seq[Any](/*34.110*/if(form("occupation2").value==occupation.getId().toString())/*34.170*/ {_display_(Seq[Any](_display_(Seq[Any](/*34.173*/occupation/*34.183*/.getName()))))}))))})),format.raw/*34.195*/("""</i></div>
                                <div class="span5 offset1 form-div"><select class="span5 occupation" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*35.150*/occupations/*35.161*/.map/*35.165*/ {occupation =>_display_(Seq[Any](format.raw/*35.180*/(""" <option value=""""),_display_(Seq[Any](/*35.197*/occupation/*35.207*/.getId())),format.raw/*35.215*/("""" """),_display_(Seq[Any](/*35.218*/if(form("occupation1").value==occupation.getId().toString())/*35.278*/ {_display_(Seq[Any](format.raw/*35.280*/("""selected""")))})),format.raw/*35.289*/(""">"""),_display_(Seq[Any](/*35.291*/occupation/*35.301*/.getName())),format.raw/*35.311*/("""</option>""")))})),format.raw/*35.321*/("""</select></div>
                                <div class="span5 form-div"><select class="span5 occupation" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*36.142*/occupations/*36.153*/.map/*36.157*/ {occupation =>_display_(Seq[Any](format.raw/*36.172*/(""" <option value=""""),_display_(Seq[Any](/*36.189*/occupation/*36.199*/.getId())),format.raw/*36.207*/("""" """),_display_(Seq[Any](/*36.210*/if(form("occupation2").value==occupation.getId().toString())/*36.270*/ {_display_(Seq[Any](format.raw/*36.272*/("""selected""")))})),format.raw/*36.281*/(""">"""),_display_(Seq[Any](/*36.283*/occupation/*36.293*/.getName())),format.raw/*36.303*/("""</option>""")))})),format.raw/*36.313*/("""</select></div>
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
                                <div class="span4 nonform-div text-info"><i>"""),_display_(Seq[Any](/*51.78*/interests/*51.87*/.map/*51.91*/ {interest =>_display_(Seq[Any](format.raw/*51.104*/(""" """),_display_(Seq[Any](/*51.106*/if(form("interest1").value==interest.getId().toString())/*51.162*/ {_display_(Seq[Any](_display_(Seq[Any](/*51.165*/interest/*51.173*/.getName()))))}))))})),format.raw/*51.185*/("""</i></div>
                                <div class="span2 offset1 form-div"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*52.182*/form("age")/*52.193*/.value)),format.raw/*52.199*/(""""></div>
                                <div class="span2 form-div"><input class="span2" type="text" id="zipCode" name="zipCode" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*53.167*/form("zipCode")/*53.182*/.value)),format.raw/*53.188*/(""""></div>
                                <div class="span1 form-div"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*54.144*/if(form("gender").value=="M")/*54.173*/ {_display_(Seq[Any](format.raw/*54.175*/("""checked""")))})),format.raw/*54.183*/("""><img src="assets/img/male.png"></label></div>
                                <div class="span1 form-div"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*55.146*/if(form("gender").value=="F")/*55.175*/ {_display_(Seq[Any](format.raw/*55.177*/("""checked""")))})),format.raw/*55.185*/("""><img src="assets/img/female.png"></label></div>
                                <div class="span4 form-div"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*56.138*/interests/*56.147*/.map/*56.151*/ {interest =>_display_(Seq[Any](format.raw/*56.164*/(""" <option value=""""),_display_(Seq[Any](/*56.181*/interest/*56.189*/.getId())),format.raw/*56.197*/("""" """),_display_(Seq[Any](/*56.200*/if(form("interest1").value==interest.getId().toString())/*56.256*/ {_display_(Seq[Any](format.raw/*56.258*/("""selected""")))})),format.raw/*56.267*/(""">"""),_display_(Seq[Any](/*56.269*/interest/*56.277*/.getName())),format.raw/*56.287*/("""</option>""")))})),format.raw/*56.297*/("""</select></div>
                            </div>
                            <div class="row ">
                                <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*59.86*/interests/*59.95*/.map/*59.99*/ {interest =>_display_(Seq[Any](format.raw/*59.112*/(""" """),_display_(Seq[Any](/*59.114*/if(form("interest2").value==interest.getId().toString())/*59.170*/ {_display_(Seq[Any](_display_(Seq[Any](/*59.173*/interest/*59.181*/.getName()))))}))))})),format.raw/*59.193*/("""</i></div>
                                <div class="span4 offset7 form-div"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*60.146*/interests/*60.155*/.map/*60.159*/ {interest =>_display_(Seq[Any](format.raw/*60.172*/(""" <option value=""""),_display_(Seq[Any](/*60.189*/interest/*60.197*/.getId())),format.raw/*60.205*/("""" """),_display_(Seq[Any](/*60.208*/if(form("interest2").value==interest.getId().toString())/*60.264*/ {_display_(Seq[Any](format.raw/*60.266*/("""selected""")))})),format.raw/*60.275*/(""">"""),_display_(Seq[Any](/*60.277*/interest/*60.285*/.getName())),format.raw/*60.295*/("""</option>""")))})),format.raw/*60.305*/("""</select></div>
                            </div>
                            <div class="row">
                                <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*63.86*/interests/*63.95*/.map/*63.99*/ {interest =>_display_(Seq[Any](format.raw/*63.112*/(""" """),_display_(Seq[Any](/*63.114*/if(form("interest3").value==interest.getId().toString())/*63.170*/ {_display_(Seq[Any](_display_(Seq[Any](/*63.173*/interest/*63.181*/.getName()))))}))))})),format.raw/*63.193*/("""</i></div>
                                <div class="span4 offset7 form-div"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*64.146*/interests/*64.155*/.map/*64.159*/ {interest =>_display_(Seq[Any](format.raw/*64.172*/(""" <option value=""""),_display_(Seq[Any](/*64.189*/interest/*64.197*/.getId())),format.raw/*64.205*/("""" """),_display_(Seq[Any](/*64.208*/if(form("interest3").value==interest.getId().toString())/*64.264*/ {_display_(Seq[Any](format.raw/*64.266*/("""selected""")))})),format.raw/*64.275*/(""">"""),_display_(Seq[Any](/*64.277*/interest/*64.285*/.getName())),format.raw/*64.295*/("""</option>""")))})),format.raw/*64.305*/("""</select></div>
                            </div>
                            <div class="row">
                                <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*67.86*/interests/*67.95*/.map/*67.99*/ {interest =>_display_(Seq[Any](format.raw/*67.112*/(""" """),_display_(Seq[Any](/*67.114*/if(form("interest4").value==interest.getId().toString())/*67.170*/ {_display_(Seq[Any](_display_(Seq[Any](/*67.173*/interest/*67.181*/.getName()))))}))))})),format.raw/*67.193*/("""</i></div>
                                <div class="span4 offset7 form-div"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*68.146*/interests/*68.155*/.map/*68.159*/ {interest =>_display_(Seq[Any](format.raw/*68.172*/(""" <option value=""""),_display_(Seq[Any](/*68.189*/interest/*68.197*/.getId())),format.raw/*68.205*/("""" """),_display_(Seq[Any](/*68.208*/if(form("interest4").value==interest.getId().toString())/*68.264*/ {_display_(Seq[Any](format.raw/*68.266*/("""selected""")))})),format.raw/*68.275*/(""">"""),_display_(Seq[Any](/*68.277*/interest/*68.285*/.getName())),format.raw/*68.295*/("""</option>""")))})),format.raw/*68.305*/("""</select></div>
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
        
        $('#email').tooltip("""),format.raw/*95.29*/("""{"""),format.raw/*95.30*/("""placement: "bottom", title: "Must be between 1 and 63 characters.""""),format.raw/*95.96*/("""}"""),format.raw/*95.97*/(""")
        $('#password').tooltip("""),format.raw/*96.32*/("""{"""),format.raw/*96.33*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*96.99*/("""}"""),format.raw/*96.100*/(""")
        $('#passwordRepeat').tooltip("""),format.raw/*97.38*/("""{"""),format.raw/*97.39*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*97.105*/("""}"""),format.raw/*97.106*/(""")
        $('#age').tooltip("""),format.raw/*98.27*/("""{"""),format.raw/*98.28*/("""placement: "bottom", title: "Match with videos for your age group.""""),format.raw/*98.95*/("""}"""),format.raw/*98.96*/(""")
        $('#zipCode').tooltip("""),format.raw/*99.31*/("""{"""),format.raw/*99.32*/("""placement: "bottom", title: "Match with videos in your area.""""),format.raw/*99.93*/("""}"""),format.raw/*99.94*/(""")
        $('#male').tooltip("""),format.raw/*100.28*/("""{"""),format.raw/*100.29*/("""placement: "bottom", title: "Match you with videos for guys.""""),format.raw/*100.90*/("""}"""),format.raw/*100.91*/(""")
        $('#female').tooltip("""),format.raw/*101.30*/("""{"""),format.raw/*101.31*/("""placement: "bottom", title: "Match you with videos for gals.""""),format.raw/*101.92*/("""}"""),format.raw/*101.93*/(""")
        $('.occupation').tooltip("""),format.raw/*102.34*/("""{"""),format.raw/*102.35*/("""placement: "bottom", title: "Match with videos related to your job.""""),format.raw/*102.103*/("""}"""),format.raw/*102.104*/(""")
        $('.interest').tooltip("""),format.raw/*103.32*/("""{"""),format.raw/*103.33*/("""placement: "bottom", title: "Match with videos about your interests.""""),format.raw/*103.102*/("""}"""),format.raw/*103.103*/(""")
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Profile.ProfileForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Profile.ProfileForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 04 16:24:35 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: 87f7f6dc2d3e392d7013ebf7a9ab36e25efb6281
                    MATRIX: 749->1|871->46|910->51|939->72|978->74|1271->332|1285->338|1321->353|1924->920|1946->933|1975->939|2116->1044|2139->1057|2168->1063|2535->1393|2558->1406|2587->1412|2628->1424|2658->1425|2691->1429|2721->1430|2916->1596|2946->1597|2979->1601|3009->1602|3223->1787|3253->1788|3286->1792|3316->1793|3726->2167|3765->2197|3819->2213|3990->2348|4010->2359|4024->2363|4078->2378|4117->2380|4187->2440|4237->2443|4257->2453|4300->2465|4425->2554|4445->2565|4458->2569|4512->2584|4551->2586|4621->2646|4671->2649|4691->2659|4734->2671|4932->2832|4953->2843|4967->2847|5021->2862|5075->2879|5095->2889|5126->2897|5166->2900|5236->2960|5277->2962|5319->2971|5358->2973|5378->2983|5411->2993|5454->3003|5649->3161|5670->3172|5684->3176|5738->3191|5792->3208|5812->3218|5843->3226|5883->3229|5953->3289|5994->3291|6036->3300|6075->3302|6095->3312|6128->3322|6171->3332|6281->3410|6677->3770|6714->3798|6766->3812|6936->3946|6956->3957|6985->3963|7110->4052|7134->4067|7162->4073|7284->4159|7323->4188|7364->4190|7429->4222|7547->4304|7586->4333|7627->4335|7694->4369|7815->4454|7833->4463|7846->4467|7898->4480|7937->4482|8003->4538|8053->4541|8071->4549|8114->4561|8344->4754|8365->4765|8394->4771|8607->4947|8632->4962|8661->4968|8851->5121|8890->5150|8931->5152|8972->5160|9202->5353|9241->5382|9282->5384|9323->5392|9547->5579|9566->5588|9580->5592|9632->5605|9686->5622|9704->5630|9735->5638|9775->5641|9841->5697|9882->5699|9924->5708|9963->5710|9981->5718|10014->5728|10057->5738|10279->5924|10297->5933|10310->5937|10362->5950|10401->5952|10467->6008|10517->6011|10535->6019|10578->6031|10772->6188|10791->6197|10805->6201|10857->6214|10911->6231|10929->6239|10960->6247|11000->6250|11066->6306|11107->6308|11149->6317|11188->6319|11206->6327|11239->6337|11282->6347|11503->6532|11521->6541|11534->6545|11586->6558|11625->6560|11691->6616|11741->6619|11759->6627|11802->6639|11996->6796|12015->6805|12029->6809|12081->6822|12135->6839|12153->6847|12184->6855|12224->6858|12290->6914|12331->6916|12373->6925|12412->6927|12430->6935|12463->6945|12506->6955|12727->7140|12745->7149|12758->7153|12810->7166|12849->7168|12915->7224|12965->7227|12983->7235|13026->7247|13220->7404|13239->7413|13253->7417|13305->7430|13359->7447|13377->7455|13408->7463|13448->7466|13514->7522|13555->7524|13597->7533|13636->7535|13654->7543|13687->7553|13730->7563|13840->7641|14553->8326|14582->8327|14693->8410|14722->8411|14839->8500|14868->8501|14915->8520|14944->8521|15061->8610|15090->8611|15127->8621|15156->8622|15225->8663|15254->8664|15348->8730|15377->8731|15439->8765|15468->8766|15562->8832|15592->8833|15660->8873|15689->8874|15784->8940|15814->8941|15871->8970|15900->8971|15995->9038|16024->9039|16085->9072|16114->9073|16203->9134|16232->9135|16291->9165|16321->9166|16411->9227|16441->9228|16502->9260|16532->9261|16622->9322|16652->9323|16717->9359|16747->9360|16845->9428|16876->9429|16939->9463|16969->9464|17068->9533|17099->9534
                    LINES: 26->1|29->1|31->3|31->3|31->3|35->7|35->7|35->7|45->17|45->17|45->17|46->18|46->18|46->18|50->22|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|52->24|52->24|52->24|52->24|59->31|59->31|59->31|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|66->38|73->45|73->45|73->45|75->47|75->47|75->47|76->48|76->48|76->48|77->49|77->49|77->49|77->49|78->50|78->50|78->50|78->50|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|80->52|80->52|80->52|81->53|81->53|81->53|82->54|82->54|82->54|82->54|83->55|83->55|83->55|83->55|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|98->70|111->83|111->83|113->85|113->85|116->88|116->88|117->89|117->89|120->92|120->92|121->93|121->93|123->95|123->95|123->95|123->95|124->96|124->96|124->96|124->96|125->97|125->97|125->97|125->97|126->98|126->98|126->98|126->98|127->99|127->99|127->99|127->99|128->100|128->100|128->100|128->100|129->101|129->101|129->101|129->101|130->102|130->102|130->102|130->102|131->103|131->103|131->103|131->103
                    -- GENERATED --
                */
            