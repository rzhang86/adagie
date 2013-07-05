
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
            <form action=""""),_display_(Seq[Any](/*6.28*/routes/*6.34*/.Profile.post())),format.raw/*6.49*/("""" method="post">
                <div class="row"><div class="span12 text-right"><button type="button" class="btn btn-primary" id="edit-button" data-toggle="button">Edit</button></div></div>
                <div class="row"><div class="span6 offset3 text-center"><strong>Required fields:</strong></div></div>
                <div class="row">
                    <div class="span4 offset1">Email:</div>
                    <div class="span6">Password:</div>
                </div>
                <div class="row">
                    <div class="span4 offset1 nonform-height text-info"><i>"""),_display_(Seq[Any](/*14.77*/form("email")/*14.90*/.value)),format.raw/*14.96*/("""</i></div>
                    <div class="span5 nonform-div text-info"><i>(not shown of course...)</i></div>
                    <div class="span3 form-div">
                        <button type="button" class="btn btn-danger" id="change-password-button" data-toggle="button">Change password</button>
                        <input type="hidden" class="span1" id="changePassword" name="changePassword" value="0">
                    </div>
                    <div class="span3 password-div"><input class="span3" type="password" id="password" name="password" placeholder="Current password" pattern="."""),format.raw/*20.161*/("""{"""),format.raw/*20.162*/("""6,31"""),format.raw/*20.166*/("""}"""),format.raw/*20.167*/(""""></div>
                    <!--
                    <div class="span3 nonform-div"></div>
                    <div class="span4 offset1 form-div"><input class="span4" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*23.143*/form("email")/*23.156*/.value)),format.raw/*23.162*/("""" pattern="."""),format.raw/*23.174*/("""{"""),format.raw/*23.175*/("""1,63"""),format.raw/*23.179*/("""}"""),format.raw/*23.180*/(""""></div>
                    <div class="span3 form-div"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*24.149*/("""{"""),format.raw/*24.150*/("""6,31"""),format.raw/*24.154*/("""}"""),format.raw/*24.155*/(""""></div>
                    <div class="span3 form-div"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*25.168*/("""{"""),format.raw/*25.169*/("""6,31"""),format.raw/*25.173*/("""}"""),format.raw/*25.174*/(""""></div>
                    -->
                </div>
                <div class="row">
                    <div class="span3 offset8 nonform-height nonpassword-div"></div>
                    <div class="span3 offset8 password-div"><input class="span3" type="password" id="newPassword" name="newPassword" placeholder="New password" pattern="."""),format.raw/*30.171*/("""{"""),format.raw/*30.172*/("""6,31"""),format.raw/*30.176*/("""}"""),format.raw/*30.177*/(""""></div>
                </div>
                <div class="row">
                    <div class="span3 offset8 nonform-height nonpassword-div"></div>
                    <div class="span3 offset8 password-div"><input class="span3" type="password" id="newPasswordRepeat" name="newPasswordRepeat" placeholder="Repeat new password" pattern="."""),format.raw/*34.190*/("""{"""),format.raw/*34.191*/("""6,31"""),format.raw/*34.195*/("""}"""),format.raw/*34.196*/(""""></div>
                </div>
                <div class="row"><div class="span6 offset3 text-center"><strong>Optional fields*:</strong></div></div>
                <br>
                <div class="row"><div class="span5 offset1">Occupations:</div></div>
                """),_display_(Seq[Any](/*39.18*/defining(Occupation.findAll())/*39.48*/ {occupations =>_display_(Seq[Any](format.raw/*39.64*/("""
                    <div class="row ">
                        <div class="span5 offset1 nonform-div text-info"><i>"""),_display_(Seq[Any](/*41.78*/Occupation/*41.88*/.getNameByString(form("occupation1").value))),format.raw/*41.131*/("""</i></div>
                        <div class="span5 nonform-div text-info"><i>"""),_display_(Seq[Any](/*42.70*/Occupation/*42.80*/.getNameByString(form("occupation2").value))),format.raw/*42.123*/("""</i></div>
                        <div class="span5 offset1 form-div"><select class="span5 occupation" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*43.142*/occupations/*43.153*/.map/*43.157*/ {occupation =>_display_(Seq[Any](format.raw/*43.172*/(""" <option value=""""),_display_(Seq[Any](/*43.189*/occupation/*43.199*/.getId())),format.raw/*43.207*/("""" """),_display_(Seq[Any](/*43.210*/if(occupation.getId().toString().equals(form("occupation1").value))/*43.277*/ {_display_(Seq[Any](format.raw/*43.279*/("""selected""")))})),format.raw/*43.288*/(""">"""),_display_(Seq[Any](/*43.290*/occupation/*43.300*/.getName())),format.raw/*43.310*/("""</option>""")))})),format.raw/*43.320*/("""</select></div>
                        <div class="span5 form-div"><select class="span5 occupation" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*44.134*/occupations/*44.145*/.map/*44.149*/ {occupation =>_display_(Seq[Any](format.raw/*44.164*/(""" <option value=""""),_display_(Seq[Any](/*44.181*/occupation/*44.191*/.getId())),format.raw/*44.199*/("""" """),_display_(Seq[Any](/*44.202*/if(occupation.getId().toString().equals(form("occupation2").value))/*44.269*/ {_display_(Seq[Any](format.raw/*44.271*/("""selected""")))})),format.raw/*44.280*/(""">"""),_display_(Seq[Any](/*44.282*/occupation/*44.292*/.getName())),format.raw/*44.302*/("""</option>""")))})),format.raw/*44.312*/("""</select></div>
                    </div>
                """)))})),format.raw/*46.18*/("""
                <div class="row">
                    <div class="span2 offset1">Age:</div>
                    <div class="span2">Zip code:</div>
                    <div class="span2">Gender:</div>
                    <div class="span4">Interests:</div>
                </div>
                """),_display_(Seq[Any](/*53.18*/defining(Interest.findAll())/*53.46*/ {interests =>_display_(Seq[Any](format.raw/*53.60*/("""
                    <div class="row">
                        <div class="span2 offset1 nonform-div text-info"><i>"""),_display_(Seq[Any](/*55.78*/form("age")/*55.89*/.value)),format.raw/*55.95*/("""</i></div>
                        <div class="span2 nonform-div text-info"><i>"""),_display_(Seq[Any](/*56.70*/form("zipCode")/*56.85*/.value)),format.raw/*56.91*/("""</i></div>
                        <div class="span1 nonform-div text-info">"""),_display_(Seq[Any](/*57.67*/if(form("gender").value=="M")/*57.96*/ {_display_(Seq[Any](format.raw/*57.98*/("""<img src="assets/img/male.png">""")))})),format.raw/*57.130*/("""</div>
                        <div class="span1 nonform-div text-info">"""),_display_(Seq[Any](/*58.67*/if(form("gender").value=="F")/*58.96*/ {_display_(Seq[Any](format.raw/*58.98*/("""<img src="assets/img/female.png">""")))})),format.raw/*58.132*/("""</div>
                        <div class="span4 nonform-div text-info"><i>"""),_display_(Seq[Any](/*59.70*/Interest/*59.78*/.getNameByString(form("interest1").value))),format.raw/*59.119*/("""</i></div>
                        <div class="span2 offset1 form-div"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*60.174*/form("age")/*60.185*/.value)),format.raw/*60.191*/(""""></div>
                        <div class="span2 form-div"><input class="span2" type="text" id="zipCode" name="zipCode" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*61.159*/form("zipCode")/*61.174*/.value)),format.raw/*61.180*/(""""></div>
                        <div class="span1 form-div"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*62.136*/if(form("gender").value=="M")/*62.165*/ {_display_(Seq[Any](format.raw/*62.167*/("""checked""")))})),format.raw/*62.175*/("""><img src="assets/img/male.png"></label></div>
                        <div class="span1 form-div"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*63.138*/if(form("gender").value=="F")/*63.167*/ {_display_(Seq[Any](format.raw/*63.169*/("""checked""")))})),format.raw/*63.177*/("""><img src="assets/img/female.png"></label></div>
                        <div class="span4 form-div"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*64.130*/interests/*64.139*/.map/*64.143*/ {interest =>_display_(Seq[Any](format.raw/*64.156*/(""" <option value=""""),_display_(Seq[Any](/*64.173*/interest/*64.181*/.getId())),format.raw/*64.189*/("""" """),_display_(Seq[Any](/*64.192*/if(interest.getId().toString().equals(form("interest1").value))/*64.255*/ {_display_(Seq[Any](format.raw/*64.257*/("""selected""")))})),format.raw/*64.266*/(""">"""),_display_(Seq[Any](/*64.268*/interest/*64.276*/.getName())),format.raw/*64.286*/("""</option>""")))})),format.raw/*64.296*/("""</select></div>
                    </div>
                    <div class="row ">
                        <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*67.78*/Interest/*67.86*/.getNameByString(form("interest2").value))),format.raw/*67.127*/("""</i></div>
                        <div class="span4 offset7 form-div"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*68.138*/interests/*68.147*/.map/*68.151*/ {interest =>_display_(Seq[Any](format.raw/*68.164*/(""" <option value=""""),_display_(Seq[Any](/*68.181*/interest/*68.189*/.getId())),format.raw/*68.197*/("""" """),_display_(Seq[Any](/*68.200*/if(interest.getId().toString().equals(form("interest2").value))/*68.263*/ {_display_(Seq[Any](format.raw/*68.265*/("""selected""")))})),format.raw/*68.274*/(""">"""),_display_(Seq[Any](/*68.276*/interest/*68.284*/.getName())),format.raw/*68.294*/("""</option>""")))})),format.raw/*68.304*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*71.78*/Interest/*71.86*/.getNameByString(form("interest3").value))),format.raw/*71.127*/("""</i></div>
                        <div class="span4 offset7 form-div"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*72.138*/interests/*72.147*/.map/*72.151*/ {interest =>_display_(Seq[Any](format.raw/*72.164*/(""" <option value=""""),_display_(Seq[Any](/*72.181*/interest/*72.189*/.getId())),format.raw/*72.197*/("""" """),_display_(Seq[Any](/*72.200*/if(interest.getId().toString().equals(form("interest3").value))/*72.263*/ {_display_(Seq[Any](format.raw/*72.265*/("""selected""")))})),format.raw/*72.274*/(""">"""),_display_(Seq[Any](/*72.276*/interest/*72.284*/.getName())),format.raw/*72.294*/("""</option>""")))})),format.raw/*72.304*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*75.78*/Interest/*75.86*/.getNameByString(form("interest4").value))),format.raw/*75.127*/("""</i></div>
                        <div class="span4 offset7 form-div"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*76.138*/interests/*76.147*/.map/*76.151*/ {interest =>_display_(Seq[Any](format.raw/*76.164*/(""" <option value=""""),_display_(Seq[Any](/*76.181*/interest/*76.189*/.getId())),format.raw/*76.197*/("""" """),_display_(Seq[Any](/*76.200*/if(interest.getId().toString().equals(form("interest4").value))/*76.263*/ {_display_(Seq[Any](format.raw/*76.265*/("""selected""")))})),format.raw/*76.274*/(""">"""),_display_(Seq[Any](/*76.276*/interest/*76.284*/.getName())),format.raw/*76.294*/("""</option>""")))})),format.raw/*76.304*/("""</select></div>
                    </div>
                """)))})),format.raw/*78.18*/("""
                <div class="row"><div class="span12 text-center"><i>*Optional fields help match you with higher-paying videos!</i></div></div>
                <div class="row"><div class="span12 text-center"><button type="submit" class="btn btn-large btn-success" id="submit-button">Submit</button></div></div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
		$('#submit-button').hide();
    	$('.form-div').hide();
    	$('.password-div').hide();
    	$('.nonform-div').show();
    	$('.nonpassword-div').show();
    	var editButton = $('#edit-button');
        var changePasswordButton = $('#change-password-button');
    	editButton.click(function() """),format.raw/*92.34*/("""{"""),format.raw/*92.35*/("""
            if (editButton.hasClass('active')) """),format.raw/*93.48*/("""{"""),format.raw/*93.49*/("""
            	$('.form-div').hide();
            	$('.password-div').hide();
            	$('#submit-button').hide();
            	$('.nonform-div').show();
            	$('.nonpassword-div').show();
            """),format.raw/*99.13*/("""}"""),format.raw/*99.14*/("""
            else """),format.raw/*100.18*/("""{"""),format.raw/*100.19*/("""
            	$('.form-div').show();
            	if (changePasswordButton.hasClass('active')) """),format.raw/*102.59*/("""{"""),format.raw/*102.60*/("""
                	$('.password-div').show();
                	$('.nonpassword-div').hide();
        		"""),format.raw/*105.11*/("""}"""),format.raw/*105.12*/("""
            	else """),format.raw/*106.19*/("""{"""),format.raw/*106.20*/("""
                	$('.password-div').hide();
                	$('.nonpassword-div').show();
            	"""),format.raw/*109.14*/("""}"""),format.raw/*109.15*/("""
            	$('#submit-button').show();
            	$('.nonform-div').hide();
            """),format.raw/*112.13*/("""}"""),format.raw/*112.14*/("""
        """),format.raw/*113.9*/("""}"""),format.raw/*113.10*/(""");
    	changePasswordButton.click(function() """),format.raw/*114.44*/("""{"""),format.raw/*114.45*/("""
            if (changePasswordButton.hasClass('active')) """),format.raw/*115.58*/("""{"""),format.raw/*115.59*/("""
            	$('#changePassword').val('0');
            	$('.password-div').hide();
            	$('.nonpassword-div').show();
            """),format.raw/*119.13*/("""}"""),format.raw/*119.14*/("""
            else """),format.raw/*120.18*/("""{"""),format.raw/*120.19*/("""
            	$('#changePassword').val('1');
            	$('.password-div').show();
            	$('.nonpassword-div').hide();
            """),format.raw/*124.13*/("""}"""),format.raw/*124.14*/("""
        """),format.raw/*125.9*/("""}"""),format.raw/*125.10*/(""")
        """),_display_(Seq[Any](/*126.10*/if(flash.contains("edit"))/*126.36*/ {_display_(Seq[Any](format.raw/*126.38*/("""editButton.click();""")))})),format.raw/*126.58*/("""
    	"""),_display_(Seq[Any](/*127.7*/if(flash.contains("changePassword"))/*127.43*/ {_display_(Seq[Any](format.raw/*127.45*/("""changePasswordButton.click();""")))})),format.raw/*127.75*/("""
        
        $.getJSON(""""),_display_(Seq[Any](/*129.21*/routes/*129.27*/.Assets.at("data/Zips.json"))),format.raw/*129.55*/("""", function(data) """),format.raw/*129.73*/("""{"""),format.raw/*129.74*/("""
            var zipCodes = [];
            $.each(data, function(i, item) """),format.raw/*131.44*/("""{"""),format.raw/*131.45*/("""zipCodes.push(item);"""),format.raw/*131.65*/("""}"""),format.raw/*131.66*/(""");
            $('#zipCode')
                .typeahead("""),format.raw/*133.28*/("""{"""),format.raw/*133.29*/("""source: zipCodes, items: 10"""),format.raw/*133.56*/("""}"""),format.raw/*133.57*/(""")
                .blur(function() """),format.raw/*134.34*/("""{"""),format.raw/*134.35*/("""if($.inArray($(this).val(), zipCodes) == -1) """),format.raw/*134.80*/("""{"""),format.raw/*134.81*/("""$('#zipCode').val('');"""),format.raw/*134.103*/("""}"""),format.raw/*134.104*/("""}"""),format.raw/*134.105*/(""");
        """),format.raw/*135.9*/("""}"""),format.raw/*135.10*/(""");
    	
        $('#email').tooltip("""),format.raw/*137.29*/("""{"""),format.raw/*137.30*/("""placement: "bottom", title: "Must be between 1 and 63 characters.""""),format.raw/*137.96*/("""}"""),format.raw/*137.97*/(""")
        $('#newPassword').tooltip("""),format.raw/*138.35*/("""{"""),format.raw/*138.36*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*138.102*/("""}"""),format.raw/*138.103*/(""")
        $('#newPasswordRepeat').tooltip("""),format.raw/*139.41*/("""{"""),format.raw/*139.42*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*139.108*/("""}"""),format.raw/*139.109*/(""")
        $('#age').tooltip("""),format.raw/*140.27*/("""{"""),format.raw/*140.28*/("""placement: "bottom", title: "Match with videos for your age group.""""),format.raw/*140.95*/("""}"""),format.raw/*140.96*/(""")
        $('#zipCode').tooltip("""),format.raw/*141.31*/("""{"""),format.raw/*141.32*/("""placement: "bottom", title: "Match with videos in your area.""""),format.raw/*141.93*/("""}"""),format.raw/*141.94*/(""")
        $('#male').tooltip("""),format.raw/*142.28*/("""{"""),format.raw/*142.29*/("""placement: "bottom", title: "Match you with videos for guys.""""),format.raw/*142.90*/("""}"""),format.raw/*142.91*/(""")
        $('#female').tooltip("""),format.raw/*143.30*/("""{"""),format.raw/*143.31*/("""placement: "bottom", title: "Match you with videos for gals.""""),format.raw/*143.92*/("""}"""),format.raw/*143.93*/(""")
        $('.occupation').tooltip("""),format.raw/*144.34*/("""{"""),format.raw/*144.35*/("""placement: "bottom", title: "Match with videos related to your job.""""),format.raw/*144.103*/("""}"""),format.raw/*144.104*/(""")
        $('.interest').tooltip("""),format.raw/*145.32*/("""{"""),format.raw/*145.33*/("""placement: "bottom", title: "Match with videos about your interests.""""),format.raw/*145.102*/("""}"""),format.raw/*145.103*/(""")
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Profile.ProfileForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Profile.ProfileForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 04 21:21:08 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: b3bf9c5ad8a7c88a09531a6322c19eff03d16a09
                    MATRIX: 749->1|871->46|910->51|939->72|978->74|1100->161|1114->167|1150->182|1785->781|1807->794|1835->800|2471->1407|2501->1408|2534->1412|2564->1413|2838->1650|2861->1663|2890->1669|2931->1681|2961->1682|2994->1686|3024->1687|3211->1845|3241->1846|3274->1850|3304->1851|3510->2028|3540->2029|3573->2033|3603->2034|3982->2384|4012->2385|4045->2389|4075->2390|4448->2734|4478->2735|4511->2739|4541->2740|4856->3019|4895->3049|4949->3065|5104->3184|5123->3194|5189->3237|5306->3318|5325->3328|5391->3371|5581->3524|5602->3535|5616->3539|5670->3554|5724->3571|5744->3581|5775->3589|5815->3592|5892->3659|5933->3661|5975->3670|6014->3672|6034->3682|6067->3692|6110->3702|6297->3852|6318->3863|6332->3867|6386->3882|6440->3899|6460->3909|6491->3917|6531->3920|6608->3987|6649->3989|6691->3998|6730->4000|6750->4010|6783->4020|6826->4030|6920->4092|7260->4396|7297->4424|7349->4438|7503->4556|7523->4567|7551->4573|7668->4654|7692->4669|7720->4675|7834->4753|7872->4782|7912->4784|7977->4816|8087->4890|8125->4919|8165->4921|8232->4955|8345->5032|8362->5040|8426->5081|8648->5266|8669->5277|8698->5283|8903->5451|8928->5466|8957->5472|9139->5617|9178->5646|9219->5648|9260->5656|9482->5841|9521->5870|9562->5872|9603->5880|9819->6059|9838->6068|9852->6072|9904->6085|9958->6102|9976->6110|10007->6118|10047->6121|10120->6184|10161->6186|10203->6195|10242->6197|10260->6205|10293->6215|10336->6225|10534->6387|10551->6395|10615->6436|10801->6585|10820->6594|10834->6598|10886->6611|10940->6628|10958->6636|10989->6644|11029->6647|11102->6710|11143->6712|11185->6721|11224->6723|11242->6731|11275->6741|11318->6751|11515->6912|11532->6920|11596->6961|11782->7110|11801->7119|11815->7123|11867->7136|11921->7153|11939->7161|11970->7169|12010->7172|12083->7235|12124->7237|12166->7246|12205->7248|12223->7256|12256->7266|12299->7276|12496->7437|12513->7445|12577->7486|12763->7635|12782->7644|12796->7648|12848->7661|12902->7678|12920->7686|12951->7694|12991->7697|13064->7760|13105->7762|13147->7771|13186->7773|13204->7781|13237->7791|13280->7801|13374->7863|14105->8566|14134->8567|14211->8616|14240->8617|14486->8835|14515->8836|14563->8855|14593->8856|14719->8953|14749->8954|14883->9059|14913->9060|14962->9080|14992->9081|15129->9189|15159->9190|15284->9286|15314->9287|15352->9297|15382->9298|15458->9345|15488->9346|15576->9405|15606->9406|15779->9550|15809->9551|15857->9570|15887->9571|16060->9715|16090->9716|16128->9726|16158->9727|16207->9739|16243->9765|16284->9767|16337->9787|16381->9795|16427->9831|16468->9833|16531->9863|16600->9895|16616->9901|16667->9929|16714->9947|16744->9948|16850->10025|16880->10026|16929->10046|16959->10047|17046->10105|17076->10106|17132->10133|17162->10134|17227->10170|17257->10171|17331->10216|17361->10217|17413->10239|17444->10240|17475->10241|17515->10253|17545->10254|17613->10293|17643->10294|17738->10360|17768->10361|17834->10398|17864->10399|17960->10465|17991->10466|18063->10509|18093->10510|18189->10576|18220->10577|18278->10606|18308->10607|18404->10674|18434->10675|18496->10708|18526->10709|18616->10770|18646->10771|18705->10801|18735->10802|18825->10863|18855->10864|18916->10896|18946->10897|19036->10958|19066->10959|19131->10995|19161->10996|19259->11064|19290->11065|19353->11099|19383->11100|19482->11169|19513->11170
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|42->14|42->14|42->14|48->20|48->20|48->20|48->20|51->23|51->23|51->23|51->23|51->23|51->23|51->23|52->24|52->24|52->24|52->24|53->25|53->25|53->25|53->25|58->30|58->30|58->30|58->30|62->34|62->34|62->34|62->34|67->39|67->39|67->39|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|74->46|81->53|81->53|81->53|83->55|83->55|83->55|84->56|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|99->71|99->71|99->71|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|103->75|103->75|103->75|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|106->78|120->92|120->92|121->93|121->93|127->99|127->99|128->100|128->100|130->102|130->102|133->105|133->105|134->106|134->106|137->109|137->109|140->112|140->112|141->113|141->113|142->114|142->114|143->115|143->115|147->119|147->119|148->120|148->120|152->124|152->124|153->125|153->125|154->126|154->126|154->126|154->126|155->127|155->127|155->127|155->127|157->129|157->129|157->129|157->129|157->129|159->131|159->131|159->131|159->131|161->133|161->133|161->133|161->133|162->134|162->134|162->134|162->134|162->134|162->134|162->134|163->135|163->135|165->137|165->137|165->137|165->137|166->138|166->138|166->138|166->138|167->139|167->139|167->139|167->139|168->140|168->140|168->140|168->140|169->141|169->141|169->141|169->141|170->142|170->142|170->142|170->142|171->143|171->143|171->143|171->143|172->144|172->144|172->144|172->144|173->145|173->145|173->145|173->145
                    -- GENERATED --
                */
            