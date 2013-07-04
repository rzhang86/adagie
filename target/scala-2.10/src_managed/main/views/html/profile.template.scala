
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
                            <div class="span3 offset1">Username:</div>
                            <div class="span4">Email:</div>
                            <div class="span3">Password:</div>
                        </div>
                        <div class="row">
                            <div class="span3 offset1 nonform-div"><i>"""),_display_(Seq[Any](/*18.72*/form("username")/*18.88*/.value)),format.raw/*18.94*/("""</i></div>
                            <div class="span4 nonform-div"><i>"""),_display_(Seq[Any](/*19.64*/form("email")/*19.77*/.value)),format.raw/*19.83*/("""</i></div>
                            <div class="span3 nonform-div"></div>
                            <div class="span3 offset1 form-div"><input class="span3" type="text" id="username" name="username" placeholder="Username" value=""""),_display_(Seq[Any](/*21.159*/form("username")/*21.175*/.value)),format.raw/*21.181*/("""" pattern="."""),format.raw/*21.193*/("""{"""),format.raw/*21.194*/("""1,31"""),format.raw/*21.198*/("""}"""),format.raw/*21.199*/(""""></div>
                            <div class="span4 form-div"><input class="span4" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*22.143*/form("email")/*22.156*/.value)),format.raw/*22.162*/("""" pattern="."""),format.raw/*22.174*/("""{"""),format.raw/*22.175*/("""1,63"""),format.raw/*22.179*/("""}"""),format.raw/*22.180*/(""""></div>
                            <div class="span3 form-div"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*23.157*/("""{"""),format.raw/*23.158*/("""6,31"""),format.raw/*23.162*/("""}"""),format.raw/*23.163*/(""""></div>
                        </div>
                        <div class="row">
                            <div class="span3 offset8 nonform-div"></div>
                            <div class="span3 offset8 form-div"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*27.184*/("""{"""),format.raw/*27.185*/("""6,31"""),format.raw/*27.189*/("""}"""),format.raw/*27.190*/(""""></div>
                        </div>
                        <br>
                        <div class="row"><div class="span12 text-center"><strong>Optional fields: </strong><i>(These help match you with higher-paying videos!)</i></div></div>
                        <br>
                        <div class="row"><div class="span5 offset1">Occupations:</div></div>
                        <div class="row ">
                            <div class="span5 offset1 nonform-div"><i>"""),_display_(Seq[Any](/*34.72*/occupations/*34.83*/.map/*34.87*/ {occupation =>_display_(Seq[Any](format.raw/*34.102*/(""" """),_display_(Seq[Any](/*34.104*/if(form("occupation1").value==occupation.id.toString())/*34.159*/ {_display_(Seq[Any](_display_(Seq[Any](/*34.162*/occupation/*34.172*/.name))))}))))})),format.raw/*34.179*/("""</i></div>
                            <div class="span5 nonform-div"><i>"""),_display_(Seq[Any](/*35.64*/occupations/*35.75*/.map/*35.79*/ {occupation =>_display_(Seq[Any](format.raw/*35.94*/(""" """),_display_(Seq[Any](/*35.96*/if(form("occupation2").value==occupation.id.toString())/*35.151*/ {_display_(Seq[Any](_display_(Seq[Any](/*35.154*/occupation/*35.164*/.name))))}))))})),format.raw/*35.171*/("""</i></div>
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
                            <div class="span2 offset1 nonform-div"><i>"""),_display_(Seq[Any](/*46.72*/form("age")/*46.83*/.value)),format.raw/*46.89*/("""</i></div>
                            <div class="span2 nonform-div"><i>"""),_display_(Seq[Any](/*47.64*/form("zip")/*47.75*/.value)),format.raw/*47.81*/("""</i></div>
                            <div class="span1 nonform-div">"""),_display_(Seq[Any](/*48.61*/if(form("gender").value=="M")/*48.90*/ {_display_(Seq[Any](format.raw/*48.92*/("""<img src="assets/img/male.png">""")))})),format.raw/*48.124*/("""</div>
                            <div class="span1 nonform-div">"""),_display_(Seq[Any](/*49.61*/if(form("gender").value=="F")/*49.90*/ {_display_(Seq[Any](format.raw/*49.92*/("""<img src="assets/img/female.png">""")))})),format.raw/*49.126*/("""</div>
                            <div class="span4 nonform-div"><i>"""),_display_(Seq[Any](/*50.64*/interests/*50.73*/.map/*50.77*/ {interest =>_display_(Seq[Any](format.raw/*50.90*/(""" """),_display_(Seq[Any](/*50.92*/if(form("interest1").value==interest.id.toString())/*50.143*/ {_display_(Seq[Any](_display_(Seq[Any](/*50.146*/interest/*50.154*/.name))))}))))})),format.raw/*50.161*/("""</i></div>
                            <div class="span2 offset1 form-div"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*51.178*/form("age")/*51.189*/.value)),format.raw/*51.195*/(""""></div>
                            <div class="span2 form-div"><input class="span2" type="text" id="zip" name="zip" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*52.155*/form("zip")/*52.166*/.value)),format.raw/*52.172*/(""""></div>
                            <div class="span1 form-div"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*53.140*/if(form("gender").value=="M")/*53.169*/ {_display_(Seq[Any](format.raw/*53.171*/("""checked""")))})),format.raw/*53.179*/("""><img src="assets/img/male.png"></label></div>
                            <div class="span1 form-div"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*54.142*/if(form("gender").value=="F")/*54.171*/ {_display_(Seq[Any](format.raw/*54.173*/("""checked""")))})),format.raw/*54.181*/("""><img src="assets/img/female.png"></label></div>
                            <div class="span4 form-div"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*55.134*/interests/*55.143*/.map/*55.147*/ {interest =>_display_(Seq[Any](format.raw/*55.160*/(""" <option value=""""),_display_(Seq[Any](/*55.177*/interest/*55.185*/.id)),format.raw/*55.188*/("""" """),_display_(Seq[Any](/*55.191*/if(form("interest1").value==interest.id.toString())/*55.242*/ {_display_(Seq[Any](format.raw/*55.244*/("""selected""")))})),format.raw/*55.253*/(""">"""),_display_(Seq[Any](/*55.255*/interest/*55.263*/.name)),format.raw/*55.268*/("""</option>""")))})),format.raw/*55.278*/("""</select></div>
                        </div>
                        <div class="row ">
                            <div class="span4 offset7 nonform-div"><i>"""),_display_(Seq[Any](/*58.72*/interests/*58.81*/.map/*58.85*/ {interest =>_display_(Seq[Any](format.raw/*58.98*/(""" """),_display_(Seq[Any](/*58.100*/if(form("interest2").value==interest.id.toString())/*58.151*/ {_display_(Seq[Any](_display_(Seq[Any](/*58.154*/interest/*58.162*/.name))))}))))})),format.raw/*58.169*/("""</i></div>
                            <div class="span4 offset7 form-div"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*59.142*/interests/*59.151*/.map/*59.155*/ {interest =>_display_(Seq[Any](format.raw/*59.168*/(""" <option value=""""),_display_(Seq[Any](/*59.185*/interest/*59.193*/.id)),format.raw/*59.196*/("""" """),_display_(Seq[Any](/*59.199*/if(form("interest2").value==interest.id.toString())/*59.250*/ {_display_(Seq[Any](format.raw/*59.252*/("""selected""")))})),format.raw/*59.261*/(""">"""),_display_(Seq[Any](/*59.263*/interest/*59.271*/.name)),format.raw/*59.276*/("""</option>""")))})),format.raw/*59.286*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7 nonform-div"><i>"""),_display_(Seq[Any](/*62.72*/interests/*62.81*/.map/*62.85*/ {interest =>_display_(Seq[Any](format.raw/*62.98*/(""" """),_display_(Seq[Any](/*62.100*/if(form("interest3").value==interest.id.toString())/*62.151*/ {_display_(Seq[Any](_display_(Seq[Any](/*62.154*/interest/*62.162*/.name))))}))))})),format.raw/*62.169*/("""</i></div>
                            <div class="span4 offset7 form-div"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*63.142*/interests/*63.151*/.map/*63.155*/ {interest =>_display_(Seq[Any](format.raw/*63.168*/(""" <option value=""""),_display_(Seq[Any](/*63.185*/interest/*63.193*/.id)),format.raw/*63.196*/("""" """),_display_(Seq[Any](/*63.199*/if(form("interest3").value==interest.id.toString())/*63.250*/ {_display_(Seq[Any](format.raw/*63.252*/("""selected""")))})),format.raw/*63.261*/(""">"""),_display_(Seq[Any](/*63.263*/interest/*63.271*/.name)),format.raw/*63.276*/("""</option>""")))})),format.raw/*63.286*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7 nonform-div"><i>"""),_display_(Seq[Any](/*66.72*/interests/*66.81*/.map/*66.85*/ {interest =>_display_(Seq[Any](format.raw/*66.98*/(""" """),_display_(Seq[Any](/*66.100*/if(form("interest4").value==interest.id.toString())/*66.151*/ {_display_(Seq[Any](_display_(Seq[Any](/*66.154*/interest/*66.162*/.name))))}))))})),format.raw/*66.169*/("""</i></div>
                            <div class="span4 offset7 form-div"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*67.142*/interests/*67.151*/.map/*67.155*/ {interest =>_display_(Seq[Any](format.raw/*67.168*/(""" <option value=""""),_display_(Seq[Any](/*67.185*/interest/*67.193*/.id)),format.raw/*67.196*/("""" """),_display_(Seq[Any](/*67.199*/if(form("interest4").value==interest.id.toString())/*67.250*/ {_display_(Seq[Any](format.raw/*67.252*/("""selected""")))})),format.raw/*67.261*/(""">"""),_display_(Seq[Any](/*67.263*/interest/*67.271*/.name)),format.raw/*67.276*/("""</option>""")))})),format.raw/*67.286*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span12 text-center nonform-div"></div>
                            <div class="span12 text-center form-div"><button type="submit" class="btn btn-large btn-success">Submit</button></div>
                        </div>
                    """)))})),format.raw/*73.22*/("""
                """)))})),format.raw/*74.18*/("""
            </form>
        </div>
    </div>
    <script type="text/javascript">
		$('.nonform-div').height(40)
    	$('.form-div').hide()
    	var editButton = $('#edit-button')
    	editButton.click(function() """),format.raw/*82.34*/("""{"""),format.raw/*82.35*/("""
            //b.button('toggle')
            if (editButton.hasClass('active')) """),format.raw/*84.48*/("""{"""),format.raw/*84.49*/("""
            	$('.nonform-div').show()
            	$('.form-div').hide()
            """),format.raw/*87.13*/("""}"""),format.raw/*87.14*/("""
            else """),format.raw/*88.18*/("""{"""),format.raw/*88.19*/("""
            	$('.nonform-div').hide()
            	$('.form-div').show()
            """),format.raw/*91.13*/("""}"""),format.raw/*91.14*/("""
        """),format.raw/*92.9*/("""}"""),format.raw/*92.10*/(""")
        
        $('#username').tooltip("""),format.raw/*94.32*/("""{"""),format.raw/*94.33*/("""placement: "top", title: "Must be between 1 and 31 characters.""""),format.raw/*94.96*/("""}"""),format.raw/*94.97*/(""")
        $('#email').tooltip("""),format.raw/*95.29*/("""{"""),format.raw/*95.30*/("""placement: "top", title: "Must be between 1 and 63 characters.""""),format.raw/*95.93*/("""}"""),format.raw/*95.94*/(""")
        $('#password').tooltip("""),format.raw/*96.32*/("""{"""),format.raw/*96.33*/("""placement: "top", title: "Must be between 6 and 31 characters.""""),format.raw/*96.96*/("""}"""),format.raw/*96.97*/(""")
        $('#passwordRepeat').tooltip("""),format.raw/*97.38*/("""{"""),format.raw/*97.39*/("""placement: "top", title: "Must be between 6 and 31 characters.""""),format.raw/*97.102*/("""}"""),format.raw/*97.103*/(""")
        $('#age').tooltip("""),format.raw/*98.27*/("""{"""),format.raw/*98.28*/("""placement: "top", title: "Match with videos for your age group.""""),format.raw/*98.92*/("""}"""),format.raw/*98.93*/(""")
        $('#zip').tooltip("""),format.raw/*99.27*/("""{"""),format.raw/*99.28*/("""placement: "top", title: "Match with videos in your area.""""),format.raw/*99.86*/("""}"""),format.raw/*99.87*/(""")
        $('#male').tooltip("""),format.raw/*100.28*/("""{"""),format.raw/*100.29*/("""placement: "top", title: "Match you with videos for guys.""""),format.raw/*100.87*/("""}"""),format.raw/*100.88*/(""")
        $('#female').tooltip("""),format.raw/*101.30*/("""{"""),format.raw/*101.31*/("""placement: "top", title: "Match you with videos for gals.""""),format.raw/*101.89*/("""}"""),format.raw/*101.90*/(""")
        $('.occupation').tooltip("""),format.raw/*102.34*/("""{"""),format.raw/*102.35*/("""placement: "top", title: "Match with videos related to your job.""""),format.raw/*102.100*/("""}"""),format.raw/*102.101*/(""")
        $('.interest').tooltip("""),format.raw/*103.32*/("""{"""),format.raw/*103.33*/("""placement: "top", title: "Match with videos about your interests.""""),format.raw/*103.99*/("""}"""),format.raw/*103.100*/(""")
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Profile.ProfileForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Profile.ProfileForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 04 01:13:48 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: ab0f1fc1450157fcccf69375ca51c3f9b214dfcd
                    MATRIX: 749->1|871->46|910->51|939->72|978->74|1271->332|1285->338|1321->353|1391->388|1429->418|1483->435|1541->458|1577->486|1629->501|2203->1039|2228->1055|2256->1061|2367->1136|2389->1149|2417->1155|2691->1392|2717->1408|2746->1414|2787->1426|2817->1427|2850->1431|2880->1432|3069->1584|3092->1597|3121->1603|3162->1615|3192->1616|3225->1620|3255->1621|3450->1787|3480->1788|3513->1792|3543->1793|3915->2136|3945->2137|3978->2141|4008->2142|4532->2630|4552->2641|4565->2645|4619->2660|4658->2662|4723->2717|4773->2720|4793->2730|4831->2737|4942->2812|4962->2823|4975->2827|5028->2842|5066->2844|5131->2899|5181->2902|5201->2912|5239->2919|5433->3076|5454->3087|5468->3091|5522->3106|5576->3123|5596->3133|5622->3136|5662->3139|5727->3194|5768->3196|5810->3205|5849->3207|5869->3217|5897->3222|5940->3232|6131->3386|6152->3397|6166->3401|6220->3416|6274->3433|6294->3443|6320->3446|6360->3449|6425->3504|6466->3506|6508->3515|6547->3517|6567->3527|6595->3532|6638->3542|7170->4038|7190->4049|7218->4055|7329->4130|7349->4141|7377->4147|7485->4219|7523->4248|7563->4250|7628->4282|7732->4350|7770->4379|7810->4381|7877->4415|7984->4486|8002->4495|8015->4499|8066->4512|8104->4514|8165->4565|8215->4568|8233->4576|8271->4583|8497->4772|8518->4783|8547->4789|8748->4953|8769->4964|8798->4970|8984->5119|9023->5148|9064->5150|9105->5158|9331->5347|9370->5376|9411->5378|9452->5386|9672->5569|9691->5578|9705->5582|9757->5595|9811->5612|9829->5620|9855->5623|9895->5626|9956->5677|9997->5679|10039->5688|10078->5690|10096->5698|10124->5703|10167->5713|10367->5877|10385->5886|10398->5890|10449->5903|10488->5905|10549->5956|10599->5959|10617->5967|10655->5974|10845->6127|10864->6136|10878->6140|10930->6153|10984->6170|11002->6178|11028->6181|11068->6184|11129->6235|11170->6237|11212->6246|11251->6248|11269->6256|11297->6261|11340->6271|11539->6434|11557->6443|11570->6447|11621->6460|11660->6462|11721->6513|11771->6516|11789->6524|11827->6531|12017->6684|12036->6693|12050->6697|12102->6710|12156->6727|12174->6735|12200->6738|12240->6741|12301->6792|12342->6794|12384->6803|12423->6805|12441->6813|12469->6818|12512->6828|12711->6991|12729->7000|12742->7004|12793->7017|12832->7019|12893->7070|12943->7073|12961->7081|12999->7088|13189->7241|13208->7250|13222->7254|13274->7267|13328->7284|13346->7292|13372->7295|13412->7298|13473->7349|13514->7351|13556->7360|13595->7362|13613->7370|13641->7375|13684->7385|14089->7758|14140->7777|14390->7999|14419->8000|14530->8083|14559->8084|14676->8173|14705->8174|14752->8193|14781->8194|14898->8283|14927->8284|14964->8294|14993->8295|15065->8339|15094->8340|15185->8403|15214->8404|15273->8435|15302->8436|15393->8499|15422->8500|15484->8534|15513->8535|15604->8598|15633->8599|15701->8639|15730->8640|15822->8703|15852->8704|15909->8733|15938->8734|16030->8798|16059->8799|16116->8828|16145->8829|16231->8887|16260->8888|16319->8918|16349->8919|16436->8977|16466->8978|16527->9010|16557->9011|16644->9069|16674->9070|16739->9106|16769->9107|16864->9172|16895->9173|16958->9207|16988->9208|17083->9274|17114->9275
                    LINES: 26->1|29->1|31->3|31->3|31->3|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|46->18|46->18|46->18|47->19|47->19|47->19|49->21|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|55->27|55->27|55->27|55->27|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|64->36|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|74->46|74->46|74->46|75->47|75->47|75->47|76->48|76->48|76->48|76->48|77->49|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|80->52|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|87->59|90->62|90->62|90->62|90->62|90->62|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|94->66|94->66|94->66|94->66|94->66|94->66|94->66|94->66|94->66|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|95->67|101->73|102->74|110->82|110->82|112->84|112->84|115->87|115->87|116->88|116->88|119->91|119->91|120->92|120->92|122->94|122->94|122->94|122->94|123->95|123->95|123->95|123->95|124->96|124->96|124->96|124->96|125->97|125->97|125->97|125->97|126->98|126->98|126->98|126->98|127->99|127->99|127->99|127->99|128->100|128->100|128->100|128->100|129->101|129->101|129->101|129->101|130->102|130->102|130->102|130->102|131->103|131->103|131->103|131->103
                    -- GENERATED --
                */
            