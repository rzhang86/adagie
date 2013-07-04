
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
                """),_display_(Seq[Any](/*8.18*/defining(Occupation.findAll())/*8.48*/ { occupations =>_display_(Seq[Any](format.raw/*8.65*/("""
                    """),_display_(Seq[Any](/*9.22*/defining(Interest.findAll())/*9.50*/ { interests =>_display_(Seq[Any](format.raw/*9.65*/("""
                        <div class="row"><div class="span12 text-center"><strong>Required fields:</strong></div></div>
                        <br>
                        <div class="row">
                            <div class="span4 offset1">Email:</div>
                            <!--
                            <div class="span3">Password:</div>
                            -->
                        </div>
                        <div class="row">
                            <div class="span4 offset1 nonform-div text-info"><i>"""),_display_(Seq[Any](/*19.82*/form("email")/*19.95*/.value)),format.raw/*19.101*/("""</i></div>
                            <div class="span4 offset1 form-div nonform-height text-info"><i>"""),_display_(Seq[Any](/*20.94*/form("email")/*20.107*/.value)),format.raw/*20.113*/("""</i></div>
                            <!--
                            <div class="span3 nonform-div"></div>
                            <div class="span3 nonform-div"></div>
                            <div class="span4 offset1 form-div"><input class="span4" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*24.151*/form("email")/*24.164*/.value)),format.raw/*24.170*/("""" pattern="."""),format.raw/*24.182*/("""{"""),format.raw/*24.183*/("""1,63"""),format.raw/*24.187*/("""}"""),format.raw/*24.188*/(""""></div>
                            <div class="span3 form-div"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*25.157*/("""{"""),format.raw/*25.158*/("""6,31"""),format.raw/*25.162*/("""}"""),format.raw/*25.163*/(""""></div>
                            <div class="span3 form-div"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*26.176*/("""{"""),format.raw/*26.177*/("""6,31"""),format.raw/*26.181*/("""}"""),format.raw/*26.182*/(""""></div>
                            -->
                        </div>
                        <br>
                        <div class="row"><div class="span12 text-center"><strong>Optional fields:</strong></div></div>
                        <br>
                        <div class="row"><div class="span5 offset1">Occupations:</div></div>
                        <div class="row ">
                            <div class="span5 offset1 nonform-div text-info"><i>"""),_display_(Seq[Any](/*34.82*/occupations/*34.93*/.map/*34.97*/ {occupation =>_display_(Seq[Any](format.raw/*34.112*/(""" """),_display_(Seq[Any](/*34.114*/if(form("occupation1").value==occupation.id.toString())/*34.169*/ {_display_(Seq[Any](_display_(Seq[Any](/*34.172*/occupation/*34.182*/.name))))}))))})),format.raw/*34.189*/("""</i></div>
                            <div class="span5 nonform-div text-info"><i>"""),_display_(Seq[Any](/*35.74*/occupations/*35.85*/.map/*35.89*/ {occupation =>_display_(Seq[Any](format.raw/*35.104*/(""" """),_display_(Seq[Any](/*35.106*/if(form("occupation2").value==occupation.id.toString())/*35.161*/ {_display_(Seq[Any](_display_(Seq[Any](/*35.164*/occupation/*35.174*/.name))))}))))})),format.raw/*35.181*/("""</i></div>
                            <div class="span5 offset1 form-div"><select class="span5 occupation" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*36.146*/occupations/*36.157*/.map/*36.161*/ {occupation =>_display_(Seq[Any](format.raw/*36.176*/(""" <option value=""""),_display_(Seq[Any](/*36.193*/occupation/*36.203*/.id)),format.raw/*36.206*/("""" """),_display_(Seq[Any](/*36.209*/if(form("occupation1").value==occupation.id.toString())/*36.264*/ {_display_(Seq[Any](format.raw/*36.266*/("""selected""")))})),format.raw/*36.275*/(""">"""),_display_(Seq[Any](/*36.277*/occupation/*36.287*/.name)),format.raw/*36.292*/("""</option>""")))})),format.raw/*36.302*/("""</select></div>
                            <div class="span5 form-div"><select class="span5 occupation" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*37.138*/occupations/*37.149*/.map/*37.153*/ {occupation =>_display_(Seq[Any](format.raw/*37.168*/(""" <option value=""""),_display_(Seq[Any](/*37.185*/occupation/*37.195*/.id)),format.raw/*37.198*/("""" """),_display_(Seq[Any](/*37.201*/if(form("occupation2").value==occupation.id.toString())/*37.256*/ {_display_(Seq[Any](format.raw/*37.258*/("""selected""")))})),format.raw/*37.267*/(""">"""),_display_(Seq[Any](/*37.269*/occupation/*37.279*/.name)),format.raw/*37.284*/("""</option>""")))})),format.raw/*37.294*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span2 offset1">Age:</div>
                            <div class="span2">Zip code:</div>
                            <div class="span2">Gender:</div>
                            <div class="span4">Interests:</div>
                        </div>
                        <div class="row">
                            <div class="span2 offset1 nonform-div text-info"><i>"""),_display_(Seq[Any](/*46.82*/form("age")/*46.93*/.value)),format.raw/*46.99*/("""</i></div>
                            <div class="span2 nonform-div text-info"><i>"""),_display_(Seq[Any](/*47.74*/form("zipCode")/*47.89*/.value)),format.raw/*47.95*/("""</i></div>
                            <div class="span1 nonform-div text-info">"""),_display_(Seq[Any](/*48.71*/if(form("gender").value=="M")/*48.100*/ {_display_(Seq[Any](format.raw/*48.102*/("""<img src="assets/img/male.png">""")))})),format.raw/*48.134*/("""</div>
                            <div class="span1 nonform-div text-info">"""),_display_(Seq[Any](/*49.71*/if(form("gender").value=="F")/*49.100*/ {_display_(Seq[Any](format.raw/*49.102*/("""<img src="assets/img/female.png">""")))})),format.raw/*49.136*/("""</div>
                            <div class="span4 nonform-div text-info"><i>"""),_display_(Seq[Any](/*50.74*/interests/*50.83*/.map/*50.87*/ {interest =>_display_(Seq[Any](format.raw/*50.100*/(""" """),_display_(Seq[Any](/*50.102*/if(form("interest1").value==interest.id.toString())/*50.153*/ {_display_(Seq[Any](_display_(Seq[Any](/*50.156*/interest/*50.164*/.name))))}))))})),format.raw/*50.171*/("""</i></div>
                            <div class="span2 offset1 form-div"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*51.178*/form("age")/*51.189*/.value)),format.raw/*51.195*/(""""></div>
                            <div class="span2 form-div"><input class="span2" type="text" id="zipCode" name="zipCode" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*52.163*/form("zipCode")/*52.178*/.value)),format.raw/*52.184*/(""""></div>
                            <div class="span1 form-div"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*53.140*/if(form("gender").value=="M")/*53.169*/ {_display_(Seq[Any](format.raw/*53.171*/("""checked""")))})),format.raw/*53.179*/("""><img src="assets/img/male.png"></label></div>
                            <div class="span1 form-div"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*54.142*/if(form("gender").value=="F")/*54.171*/ {_display_(Seq[Any](format.raw/*54.173*/("""checked""")))})),format.raw/*54.181*/("""><img src="assets/img/female.png"></label></div>
                            <div class="span4 form-div"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*55.134*/interests/*55.143*/.map/*55.147*/ {interest =>_display_(Seq[Any](format.raw/*55.160*/(""" <option value=""""),_display_(Seq[Any](/*55.177*/interest/*55.185*/.id)),format.raw/*55.188*/("""" """),_display_(Seq[Any](/*55.191*/if(form("interest1").value==interest.id.toString())/*55.242*/ {_display_(Seq[Any](format.raw/*55.244*/("""selected""")))})),format.raw/*55.253*/(""">"""),_display_(Seq[Any](/*55.255*/interest/*55.263*/.name)),format.raw/*55.268*/("""</option>""")))})),format.raw/*55.278*/("""</select></div>
                        </div>
                        <div class="row ">
                            <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*58.82*/interests/*58.91*/.map/*58.95*/ {interest =>_display_(Seq[Any](format.raw/*58.108*/(""" """),_display_(Seq[Any](/*58.110*/if(form("interest2").value==interest.id.toString())/*58.161*/ {_display_(Seq[Any](_display_(Seq[Any](/*58.164*/interest/*58.172*/.name))))}))))})),format.raw/*58.179*/("""</i></div>
                            <div class="span4 offset7 form-div"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*59.142*/interests/*59.151*/.map/*59.155*/ {interest =>_display_(Seq[Any](format.raw/*59.168*/(""" <option value=""""),_display_(Seq[Any](/*59.185*/interest/*59.193*/.id)),format.raw/*59.196*/("""" """),_display_(Seq[Any](/*59.199*/if(form("interest2").value==interest.id.toString())/*59.250*/ {_display_(Seq[Any](format.raw/*59.252*/("""selected""")))})),format.raw/*59.261*/(""">"""),_display_(Seq[Any](/*59.263*/interest/*59.271*/.name)),format.raw/*59.276*/("""</option>""")))})),format.raw/*59.286*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*62.82*/interests/*62.91*/.map/*62.95*/ {interest =>_display_(Seq[Any](format.raw/*62.108*/(""" """),_display_(Seq[Any](/*62.110*/if(form("interest3").value==interest.id.toString())/*62.161*/ {_display_(Seq[Any](_display_(Seq[Any](/*62.164*/interest/*62.172*/.name))))}))))})),format.raw/*62.179*/("""</i></div>
                            <div class="span4 offset7 form-div"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*63.142*/interests/*63.151*/.map/*63.155*/ {interest =>_display_(Seq[Any](format.raw/*63.168*/(""" <option value=""""),_display_(Seq[Any](/*63.185*/interest/*63.193*/.id)),format.raw/*63.196*/("""" """),_display_(Seq[Any](/*63.199*/if(form("interest3").value==interest.id.toString())/*63.250*/ {_display_(Seq[Any](format.raw/*63.252*/("""selected""")))})),format.raw/*63.261*/(""">"""),_display_(Seq[Any](/*63.263*/interest/*63.271*/.name)),format.raw/*63.276*/("""</option>""")))})),format.raw/*63.286*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*66.82*/interests/*66.91*/.map/*66.95*/ {interest =>_display_(Seq[Any](format.raw/*66.108*/(""" """),_display_(Seq[Any](/*66.110*/if(form("interest4").value==interest.id.toString())/*66.161*/ {_display_(Seq[Any](_display_(Seq[Any](/*66.164*/interest/*66.172*/.name))))}))))})),format.raw/*66.179*/("""</i></div>
                            <div class="span4 offset7 form-div"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*67.142*/interests/*67.151*/.map/*67.155*/ {interest =>_display_(Seq[Any](format.raw/*67.168*/(""" <option value=""""),_display_(Seq[Any](/*67.185*/interest/*67.193*/.id)),format.raw/*67.196*/("""" """),_display_(Seq[Any](/*67.199*/if(form("interest4").value==interest.id.toString())/*67.250*/ {_display_(Seq[Any](format.raw/*67.252*/("""selected""")))})),format.raw/*67.261*/(""">"""),_display_(Seq[Any](/*67.263*/interest/*67.271*/.name)),format.raw/*67.276*/("""</option>""")))})),format.raw/*67.286*/("""</select></div>
                        </div>
                        <div class="row"><div class="span12 text-center"><i>Optional fields help match you with higher-paying videos!</i></div></div>
                        <div class="row">
                            <div class="span12 text-center nonform-div text-info"></div>
                            <div class="span12 text-center form-div"><button type="submit" class="btn btn-large btn-success">Submit</button></div>
                        </div>
                    """)))})),format.raw/*74.22*/("""
                """)))})),format.raw/*75.18*/("""
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
                    DATE: Thu Jul 04 14:04:33 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: 84ff682ca86a2b55e8a01ebac91aa66607253603
                    MATRIX: 749->1|871->46|910->51|939->72|978->74|1271->332|1285->338|1321->353|1391->388|1429->418|1483->435|1541->458|1577->486|1629->501|2216->1052|2238->1065|2267->1071|2408->1176|2431->1189|2460->1195|2827->1525|2850->1538|2879->1544|2920->1556|2950->1557|2983->1561|3013->1562|3208->1728|3238->1729|3271->1733|3301->1734|3515->1919|3545->1920|3578->1924|3608->1925|4118->2399|4138->2410|4151->2414|4205->2429|4244->2431|4309->2486|4359->2489|4379->2499|4417->2506|4538->2591|4558->2602|4571->2606|4625->2621|4664->2623|4729->2678|4779->2681|4799->2691|4837->2698|5031->2855|5052->2866|5066->2870|5120->2885|5174->2902|5194->2912|5220->2915|5260->2918|5325->2973|5366->2975|5408->2984|5447->2986|5467->2996|5495->3001|5538->3011|5729->3165|5750->3176|5764->3180|5818->3195|5872->3212|5892->3222|5918->3225|5958->3228|6023->3283|6064->3285|6106->3294|6145->3296|6165->3306|6193->3311|6236->3321|6778->3827|6798->3838|6826->3844|6947->3929|6971->3944|6999->3950|7117->4032|7156->4061|7197->4063|7262->4095|7376->4173|7415->4202|7456->4204|7523->4238|7640->4319|7658->4328|7671->4332|7723->4345|7762->4347|7823->4398|7873->4401|7891->4409|7929->4416|8155->4605|8176->4616|8205->4622|8414->4794|8439->4809|8468->4815|8654->4964|8693->4993|8734->4995|8775->5003|9001->5192|9040->5221|9081->5223|9122->5231|9342->5414|9361->5423|9375->5427|9427->5440|9481->5457|9499->5465|9525->5468|9565->5471|9626->5522|9667->5524|9709->5533|9748->5535|9766->5543|9794->5548|9837->5558|10047->5732|10065->5741|10078->5745|10130->5758|10169->5760|10230->5811|10280->5814|10298->5822|10336->5829|10526->5982|10545->5991|10559->5995|10611->6008|10665->6025|10683->6033|10709->6036|10749->6039|10810->6090|10851->6092|10893->6101|10932->6103|10950->6111|10978->6116|11021->6126|11230->6299|11248->6308|11261->6312|11313->6325|11352->6327|11413->6378|11463->6381|11481->6389|11519->6396|11709->6549|11728->6558|11742->6562|11794->6575|11848->6592|11866->6600|11892->6603|11932->6606|11993->6657|12034->6659|12076->6668|12115->6670|12133->6678|12161->6683|12204->6693|12413->6866|12431->6875|12444->6879|12496->6892|12535->6894|12596->6945|12646->6948|12664->6956|12702->6963|12892->7116|12911->7125|12925->7129|12977->7142|13031->7159|13049->7167|13075->7170|13115->7173|13176->7224|13217->7226|13259->7235|13298->7237|13316->7245|13344->7250|13387->7260|13953->7794|14004->7813|14253->8034|14282->8035|14393->8118|14422->8119|14539->8208|14568->8209|14615->8228|14644->8229|14761->8318|14790->8319|14827->8329|14856->8330|14925->8371|14954->8372|15048->8438|15077->8439|15139->8473|15168->8474|15262->8540|15292->8541|15360->8581|15389->8582|15484->8648|15514->8649|15571->8678|15600->8679|15695->8746|15724->8747|15785->8780|15814->8781|15903->8842|15932->8843|15991->8873|16021->8874|16111->8935|16141->8936|16202->8968|16232->8969|16322->9030|16352->9031|16417->9067|16447->9068|16545->9136|16576->9137|16639->9171|16669->9172|16768->9241|16799->9242
                    LINES: 26->1|29->1|31->3|31->3|31->3|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|47->19|47->19|47->19|48->20|48->20|48->20|52->24|52->24|52->24|52->24|52->24|52->24|52->24|53->25|53->25|53->25|53->25|54->26|54->26|54->26|54->26|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|74->46|74->46|74->46|75->47|75->47|75->47|76->48|76->48|76->48|76->48|77->49|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|80->52|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|90->62|90->62|90->62|90->62|90->62|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|94->66|94->66|94->66|94->66|94->66|94->66|94->66|94->66|94->66|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|102->74|103->75|111->83|111->83|113->85|113->85|116->88|116->88|117->89|117->89|120->92|120->92|121->93|121->93|123->95|123->95|123->95|123->95|124->96|124->96|124->96|124->96|125->97|125->97|125->97|125->97|126->98|126->98|126->98|126->98|127->99|127->99|127->99|127->99|128->100|128->100|128->100|128->100|129->101|129->101|129->101|129->101|130->102|130->102|130->102|130->102|131->103|131->103|131->103|131->103
                    -- GENERATED --
                */
            