
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
                            <div class="span3 offset1"><input class="span3 form-item" type="text" id="username" name="username" placeholder="Username" value=""""),_display_(Seq[Any](/*18.160*/form("username")/*18.176*/.value)),format.raw/*18.182*/("""" pattern="."""),format.raw/*18.194*/("""{"""),format.raw/*18.195*/("""1,31"""),format.raw/*18.199*/("""}"""),format.raw/*18.200*/(""""></div>
                            <div class="span4"><input class="span4 form-item" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*19.144*/form("email")/*19.157*/.value)),format.raw/*19.163*/("""" pattern="."""),format.raw/*19.175*/("""{"""),format.raw/*19.176*/("""1,63"""),format.raw/*19.180*/("""}"""),format.raw/*19.181*/(""""></div>
                            <div class="span3"><input class="span3 form-item" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*20.158*/("""{"""),format.raw/*20.159*/("""6,31"""),format.raw/*20.163*/("""}"""),format.raw/*20.164*/(""""></div>
                        </div>
                        <div class="row">
                            <div class="span3 offset8"><input class="span3 form-item" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*23.185*/("""{"""),format.raw/*23.186*/("""6,31"""),format.raw/*23.190*/("""}"""),format.raw/*23.191*/(""""></div>
                        </div>
                        <br>
                        <div class="row"><div class="span12 text-center"><strong>Optional fields: </strong><i>(These help match you with higher-paying videos!)</i></div></div>
                        <br>
                        <div class="row"><div class="span5 offset1">Occupations:</div></div>
                        <div class="row">
                            <div class="span5 offset1"><select class="span5 occupation form-item" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*30.147*/occupations/*30.158*/.map/*30.162*/ {occupation =>_display_(Seq[Any](format.raw/*30.177*/(""" <option value=""""),_display_(Seq[Any](/*30.194*/occupation/*30.204*/.id)),format.raw/*30.207*/("""" """),_display_(Seq[Any](/*30.210*/if(form("occupation1").value==occupation.id)/*30.254*/ {_display_(Seq[Any](format.raw/*30.256*/("""selected""")))})),format.raw/*30.265*/(""">"""),_display_(Seq[Any](/*30.267*/occupation/*30.277*/.name)),format.raw/*30.282*/("""</option>""")))})),format.raw/*30.292*/("""</select></div>
                            <div class="span5"><select class="span5 occupation form-item" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*31.139*/occupations/*31.150*/.map/*31.154*/ {occupation =>_display_(Seq[Any](format.raw/*31.169*/(""" <option value=""""),_display_(Seq[Any](/*31.186*/occupation/*31.196*/.id)),format.raw/*31.199*/("""" """),_display_(Seq[Any](/*31.202*/if(form("occupation2").value==occupation.id)/*31.246*/ {_display_(Seq[Any](format.raw/*31.248*/("""selected""")))})),format.raw/*31.257*/(""">"""),_display_(Seq[Any](/*31.259*/occupation/*31.269*/.name)),format.raw/*31.274*/("""</option>""")))})),format.raw/*31.284*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span2 offset1">Age:</div>
                            <div class="span2">Zip code:</div>
                            <div class="span2">Gender:</div>
                            <div class="span4">Interests:</div>
                        </div>
                        <div class="row">
                            <div class="span2 offset1"><input class="span2 form-item" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*40.179*/form("age")/*40.190*/.value)),format.raw/*40.196*/(""""></div>
                            <div class="span2"><input class="span2 form-item" type="text" id="zip" name="zip" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*41.156*/form("zip")/*41.167*/.value)),format.raw/*41.173*/(""""></div>
                            <div class="span1"><label class="radio inline form-item" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*42.141*/if(form("gender").value=="M")/*42.170*/ {_display_(Seq[Any](format.raw/*42.172*/("""checked""")))})),format.raw/*42.180*/("""><img src="assets/img/male.png"></label></div>
                            <div class="span1"><label class="radio inline form-item" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*43.143*/if(form("gender").value=="F")/*43.172*/ {_display_(Seq[Any](format.raw/*43.174*/("""checked""")))})),format.raw/*43.182*/("""><img src="assets/img/female.png"></label></div>
                            <div class="span4"><select class="span4 interest form-item" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*44.135*/interests/*44.144*/.map/*44.148*/ {interest =>_display_(Seq[Any](format.raw/*44.161*/(""" <option value=""""),_display_(Seq[Any](/*44.178*/interest/*44.186*/.id)),format.raw/*44.189*/("""" """),_display_(Seq[Any](/*44.192*/if(form("interest1").value==interest.id)/*44.232*/ {_display_(Seq[Any](format.raw/*44.234*/("""selected""")))})),format.raw/*44.243*/(""">"""),_display_(Seq[Any](/*44.245*/interest/*44.253*/.name)),format.raw/*44.258*/("""</option>""")))})),format.raw/*44.268*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest form-item" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*47.143*/interests/*47.152*/.map/*47.156*/ {interest =>_display_(Seq[Any](format.raw/*47.169*/(""" <option value=""""),_display_(Seq[Any](/*47.186*/interest/*47.194*/.id)),format.raw/*47.197*/("""" """),_display_(Seq[Any](/*47.200*/if(form("interest2").value==interest.id)/*47.240*/ {_display_(Seq[Any](format.raw/*47.242*/("""selected""")))})),format.raw/*47.251*/(""">"""),_display_(Seq[Any](/*47.253*/interest/*47.261*/.name)),format.raw/*47.266*/("""</option>""")))})),format.raw/*47.276*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest form-item" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*50.143*/interests/*50.152*/.map/*50.156*/ {interest =>_display_(Seq[Any](format.raw/*50.169*/(""" <option value=""""),_display_(Seq[Any](/*50.186*/interest/*50.194*/.id)),format.raw/*50.197*/("""" """),_display_(Seq[Any](/*50.200*/if(form("interest3").value==interest.id)/*50.240*/ {_display_(Seq[Any](format.raw/*50.242*/("""selected""")))})),format.raw/*50.251*/(""">"""),_display_(Seq[Any](/*50.253*/interest/*50.261*/.name)),format.raw/*50.266*/("""</option>""")))})),format.raw/*50.276*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset7"><select class="span4 interest form-item" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*53.143*/interests/*53.152*/.map/*53.156*/ {interest =>_display_(Seq[Any](format.raw/*53.169*/(""" <option value=""""),_display_(Seq[Any](/*53.186*/interest/*53.194*/.id)),format.raw/*53.197*/("""" """),_display_(Seq[Any](/*53.200*/if(form("interest4").value==interest.id)/*53.240*/ {_display_(Seq[Any](format.raw/*53.242*/("""selected""")))})),format.raw/*53.251*/(""">"""),_display_(Seq[Any](/*53.253*/interest/*53.261*/.name)),format.raw/*53.266*/("""</option>""")))})),format.raw/*53.276*/("""</select></div>
                        </div>
                        <div class="row"><div class="span12 text-center"><button type="submit" class="btn btn-large btn-success form-item">Submit</button></div></div>
                    """)))})),format.raw/*56.22*/("""
                """)))})),format.raw/*57.18*/("""
            </form>
        </div>
    </div>
    <script type="text/javascript">
    	$('.form-item').hide()
    	var editButton = $('#edit-button')
    	editButton.click(function() """),format.raw/*64.34*/("""{"""),format.raw/*64.35*/("""
            //b.button('toggle')
            if (editButton.hasClass('active')) """),format.raw/*66.48*/("""{"""),format.raw/*66.49*/("""
            	//$('#nonform-div').show()
            	$('.form-item').hide()
            """),format.raw/*69.13*/("""}"""),format.raw/*69.14*/("""
            else """),format.raw/*70.18*/("""{"""),format.raw/*70.19*/("""
            	//$('#nonform-div').hide()
            	$('.form-item').show()
            """),format.raw/*73.13*/("""}"""),format.raw/*73.14*/("""
        """),format.raw/*74.9*/("""}"""),format.raw/*74.10*/(""")
        
        $('#username').tooltip("""),format.raw/*76.32*/("""{"""),format.raw/*76.33*/("""placement: "top", title: "Must be between 1 and 31 characters.""""),format.raw/*76.96*/("""}"""),format.raw/*76.97*/(""")
        $('#email').tooltip("""),format.raw/*77.29*/("""{"""),format.raw/*77.30*/("""placement: "top", title: "Must be between 1 and 63 characters.""""),format.raw/*77.93*/("""}"""),format.raw/*77.94*/(""")
        $('#password').tooltip("""),format.raw/*78.32*/("""{"""),format.raw/*78.33*/("""placement: "top", title: "Must be between 6 and 31 characters.""""),format.raw/*78.96*/("""}"""),format.raw/*78.97*/(""")
        $('#passwordRepeat').tooltip("""),format.raw/*79.38*/("""{"""),format.raw/*79.39*/("""placement: "top", title: "Must be between 6 and 31 characters.""""),format.raw/*79.102*/("""}"""),format.raw/*79.103*/(""")
        $('#age').tooltip("""),format.raw/*80.27*/("""{"""),format.raw/*80.28*/("""placement: "top", title: "Match with videos for your age group.""""),format.raw/*80.92*/("""}"""),format.raw/*80.93*/(""")
        $('#zip').tooltip("""),format.raw/*81.27*/("""{"""),format.raw/*81.28*/("""placement: "top", title: "Match with videos in your area.""""),format.raw/*81.86*/("""}"""),format.raw/*81.87*/(""")
        $('#male').tooltip("""),format.raw/*82.28*/("""{"""),format.raw/*82.29*/("""placement: "top", title: "Match you with videos for guys.""""),format.raw/*82.87*/("""}"""),format.raw/*82.88*/(""")
        $('#female').tooltip("""),format.raw/*83.30*/("""{"""),format.raw/*83.31*/("""placement: "top", title: "Match you with videos for gals.""""),format.raw/*83.89*/("""}"""),format.raw/*83.90*/(""")
        $('.occupation').tooltip("""),format.raw/*84.34*/("""{"""),format.raw/*84.35*/("""placement: "top", title: "Match with videos related to your job.""""),format.raw/*84.100*/("""}"""),format.raw/*84.101*/(""")
        $('.interest').tooltip("""),format.raw/*85.32*/("""{"""),format.raw/*85.33*/("""placement: "top", title: "Match with videos about your interests.""""),format.raw/*85.99*/("""}"""),format.raw/*85.100*/(""")
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Profile.ProfileForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Profile.ProfileForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 03 21:48:26 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: 11615cc794bcfd0cd7e85ba0f81cd7689e1ce0dc
                    MATRIX: 749->1|871->46|910->51|939->72|978->74|1271->332|1285->338|1321->353|1391->388|1429->418|1483->435|1541->458|1577->486|1629->501|2292->1127|2318->1143|2347->1149|2388->1161|2418->1162|2451->1166|2481->1167|2671->1320|2694->1333|2723->1339|2764->1351|2794->1352|2827->1356|2857->1357|3053->1524|3083->1525|3116->1529|3146->1530|3444->1799|3474->1800|3507->1804|3537->1805|4136->2367|4157->2378|4171->2382|4225->2397|4279->2414|4299->2424|4325->2427|4365->2430|4419->2474|4460->2476|4502->2485|4541->2487|4561->2497|4589->2502|4632->2512|4824->2667|4845->2678|4859->2682|4913->2697|4967->2714|4987->2724|5013->2727|5053->2730|5107->2774|5148->2776|5190->2785|5229->2787|5249->2797|5277->2802|5320->2812|5960->3415|5981->3426|6010->3432|6212->3597|6233->3608|6262->3614|6449->3764|6488->3793|6529->3795|6570->3803|6797->3993|6836->4022|6877->4024|6918->4032|7139->4216|7158->4225|7172->4229|7224->4242|7278->4259|7296->4267|7322->4270|7362->4273|7412->4313|7453->4315|7495->4324|7534->4326|7552->4334|7580->4339|7623->4349|7894->4583|7913->4592|7927->4596|7979->4609|8033->4626|8051->4634|8077->4637|8117->4640|8167->4680|8208->4682|8250->4691|8289->4693|8307->4701|8335->4706|8378->4716|8649->4950|8668->4959|8682->4963|8734->4976|8788->4993|8806->5001|8832->5004|8872->5007|8922->5047|8963->5049|9005->5058|9044->5060|9062->5068|9090->5073|9133->5083|9404->5317|9423->5326|9437->5330|9489->5343|9543->5360|9561->5368|9587->5371|9627->5374|9677->5414|9718->5416|9760->5425|9799->5427|9817->5435|9845->5440|9888->5450|10158->5688|10209->5707|10428->5898|10457->5899|10568->5982|10597->5983|10717->6075|10746->6076|10793->6095|10822->6096|10942->6188|10971->6189|11008->6199|11037->6200|11109->6244|11138->6245|11229->6308|11258->6309|11317->6340|11346->6341|11437->6404|11466->6405|11528->6439|11557->6440|11648->6503|11677->6504|11745->6544|11774->6545|11866->6608|11896->6609|11953->6638|11982->6639|12074->6703|12103->6704|12160->6733|12189->6734|12275->6792|12304->6793|12362->6823|12391->6824|12477->6882|12506->6883|12566->6915|12595->6916|12681->6974|12710->6975|12774->7011|12803->7012|12897->7077|12927->7078|12989->7112|13018->7113|13112->7179|13142->7180
                    LINES: 26->1|29->1|31->3|31->3|31->3|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|46->18|46->18|46->18|46->18|46->18|46->18|46->18|47->19|47->19|47->19|47->19|47->19|47->19|47->19|48->20|48->20|48->20|48->20|51->23|51->23|51->23|51->23|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|70->42|71->43|71->43|71->43|71->43|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|78->50|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|81->53|84->56|85->57|92->64|92->64|94->66|94->66|97->69|97->69|98->70|98->70|101->73|101->73|102->74|102->74|104->76|104->76|104->76|104->76|105->77|105->77|105->77|105->77|106->78|106->78|106->78|106->78|107->79|107->79|107->79|107->79|108->80|108->80|108->80|108->80|109->81|109->81|109->81|109->81|110->82|110->82|110->82|110->82|111->83|111->83|111->83|111->83|112->84|112->84|112->84|112->84|113->85|113->85|113->85|113->85
                    -- GENERATED --
                */
            