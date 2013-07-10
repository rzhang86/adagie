
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
                <div class="row"><div class="span12 text-right"><button type="button" class="btn btn-info" id="edit-button" data-toggle="button">Edit</button></div></div>
                <div class="row">
                    <div class="span4 offset1">
                        <div class="row nonform-height2"><div class="span4">Email:</div></div>
                        <div class="row"><div class="span4 text-info"><i>"""),_display_(Seq[Any](/*11.75*/user/*11.79*/.getEmail())),format.raw/*11.90*/("""</i></div></div>
                    </div>
                    <div class="span7">
                        <div class="row nonform-height2"><div class="span7">Password: <label class="checkbox pull-right text-warning" id="change-password-label"><input type="checkbox" id="change-password-box" name="changePassword" value="1"> Change password</label></div></div>
                        <div class="row nonpassword-div"><div class="span7 text-info"><i>(not shown of course...)</i></div></div>
                        <div class="row nonpassword-div"><div class="span7"></div></div>
                        <div class="row password-div"><div class="span3"><input class="span3" type="password" id="password" name="password" placeholder="Current password" pattern="."""),format.raw/*17.182*/("""{"""),format.raw/*17.183*/("""6,31"""),format.raw/*17.187*/("""}"""),format.raw/*17.188*/("""" maxlength="31"></div></div>
                        <div class="row password-div">
                            <div class="span3"><input class="span3" type="password" id="newPassword" name="newPassword" placeholder="New password" pattern="."""),format.raw/*19.158*/("""{"""),format.raw/*19.159*/("""6,31"""),format.raw/*19.163*/("""}"""),format.raw/*19.164*/("""" maxlength="31"></div>
                            <div class="span3"><input class="span3" type="password" id="newPasswordRepeat" name="newPasswordRepeat" placeholder="Repeat new password" pattern="."""),format.raw/*20.177*/("""{"""),format.raw/*20.178*/("""6,31"""),format.raw/*20.182*/("""}"""),format.raw/*20.183*/("""" maxlength="31"></div>
                        </div>
                    </div>
                </div>
                <br><div class="row"><div class="span10 offset1"><strong>- Optional fields: </strong><i>(These fields help match you with higher-paying ads)</i><strong> -</strong></div></div><br>
                <div class="row">
                    <div class="span10 offset1">
                        <div class="row"><div class="span10">Occupations:</div></div>
                        """),_display_(Seq[Any](/*28.26*/defining(Occupation.findAll())/*28.56*/ {occupations =>_display_(Seq[Any](format.raw/*28.72*/("""
                        <div class="row nonform-div">
                            <div class="span5 text-info"><i>"""),_display_(Seq[Any](/*30.62*/Occupation/*30.72*/.getNameByString(form("occupation1").value))),format.raw/*30.115*/("""</i></div>
                            <div class="span5 text-info"><i>"""),_display_(Seq[Any](/*31.62*/Occupation/*31.72*/.getNameByString(form("occupation2").value))),format.raw/*31.115*/("""</i></div>
                        </div>
                        <div class="row form-div">
                            <div class="span5"><select class="span5 occupation" id="occupation1" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*34.146*/occupations/*34.157*/.map/*34.161*/ {occupation =>_display_(Seq[Any](format.raw/*34.176*/(""" <option value=""""),_display_(Seq[Any](/*34.193*/occupation/*34.203*/.getId())),format.raw/*34.211*/("""" """),_display_(Seq[Any](/*34.214*/if(occupation.getId().toString().equals(form("occupation1").value))/*34.281*/ {_display_(Seq[Any](format.raw/*34.283*/("""selected""")))})),format.raw/*34.292*/(""">"""),_display_(Seq[Any](/*34.294*/occupation/*34.304*/.getName())),format.raw/*34.314*/("""</option>""")))})),format.raw/*34.324*/("""</select></div>
                            <div class="span5"><select class="span5 occupation" id="occupation2" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*35.146*/occupations/*35.157*/.map/*35.161*/ {occupation =>_display_(Seq[Any](format.raw/*35.176*/(""" <option value=""""),_display_(Seq[Any](/*35.193*/occupation/*35.203*/.getId())),format.raw/*35.211*/("""" """),_display_(Seq[Any](/*35.214*/if(occupation.getId().toString().equals(form("occupation2").value))/*35.281*/ {_display_(Seq[Any](format.raw/*35.283*/("""selected""")))})),format.raw/*35.292*/(""">"""),_display_(Seq[Any](/*35.294*/occupation/*35.304*/.getName())),format.raw/*35.314*/("""</option>""")))})),format.raw/*35.324*/("""</select></div>
                        </div>
                        """)))})),format.raw/*37.26*/("""
                    </div>
                </div>
                <div class="row">
                    <div class="span2 offset1">
                        <div class="row"><div class="span2">Age:</div></div>
                        <div class="row nonform-div"><div class="span2 text-info"><i>"""),_display_(Seq[Any](/*43.87*/form("age")/*43.98*/.value)),format.raw/*43.104*/("""</i></div></div>
                        <div class="row form-div"><div class="span2"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*44.183*/form("age")/*44.194*/.value)),format.raw/*44.200*/(""""></div></div>
                    </div>
                    <div class="span2">
                        <div class="row"><div class="span2">Zip code:</div></div>
                        <div class="row nonform-div"><div class="span2 text-info"><i>"""),_display_(Seq[Any](/*48.87*/form("zipCode")/*48.102*/.value)),format.raw/*48.108*/("""</i></div></div>
                        <div class="row form-div"><div class="span2"><input class="span2" type="text" id="zipCode" name="zipCode" placeholder="Zip code" pattern="."""),format.raw/*49.164*/("""{"""),format.raw/*49.165*/("""5,5"""),format.raw/*49.168*/("""}"""),format.raw/*49.169*/("""" maxlength="5" value=""""),_display_(Seq[Any](/*49.193*/form("zipCode")/*49.208*/.value)),format.raw/*49.214*/("""" autocomplete="off"></div></div>
                    </div>
                    <div class="span2">
                        <div class="row"><div class="span2">Gender:</div></div>
                        <div class="row nonform-div">
                            <div class="span1">"""),_display_(Seq[Any](/*54.49*/if(form("gender").value=="M")/*54.78*/ {_display_(Seq[Any](format.raw/*54.80*/("""<img src="assets/img/male.png" width="15px">""")))})),format.raw/*54.125*/("""</div>
                            <div class="span1">"""),_display_(Seq[Any](/*55.49*/if(form("gender").value=="F")/*55.78*/ {_display_(Seq[Any](format.raw/*55.80*/("""<img src="assets/img/female.png" width="15px">""")))})),format.raw/*55.127*/("""</div>
                        </div>
                        <div class="row form-div">
                            <div class="span1"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*58.131*/if(form("gender").value=="M")/*58.160*/ {_display_(Seq[Any](format.raw/*58.162*/("""checked""")))})),format.raw/*58.170*/("""><img src="assets/img/male.png" width="15px"></label></div>
                            <div class="span1"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*59.133*/if(form("gender").value=="F")/*59.162*/ {_display_(Seq[Any](format.raw/*59.164*/("""checked""")))})),format.raw/*59.172*/("""><img src="assets/img/female.png" width="15px"></label></div>
                        </div>
                    </div>
                    <div class="span4">
                        <div class="row"><div class="span4">Interests:</div></div>
                        """),_display_(Seq[Any](/*64.26*/defining(Interest.findAll())/*64.54*/ {interests =>_display_(Seq[Any](format.raw/*64.68*/("""
                        <div class="row nonform-div"><div class="span4 text-info"><i>"""),_display_(Seq[Any](/*65.87*/Interest/*65.95*/.getNameByString(form("interest1").value))),format.raw/*65.136*/("""</i></div></div>
                        <div class="row nonform-div"><div class="span4 text-info"><i>"""),_display_(Seq[Any](/*66.87*/Interest/*66.95*/.getNameByString(form("interest2").value))),format.raw/*66.136*/("""</i></div></div>
                        <div class="row nonform-div"><div class="span4 text-info"><i>"""),_display_(Seq[Any](/*67.87*/Interest/*67.95*/.getNameByString(form("interest3").value))),format.raw/*67.136*/("""</i></div></div>
                        <div class="row nonform-div"><div class="span4 text-info"><i>"""),_display_(Seq[Any](/*68.87*/Interest/*68.95*/.getNameByString(form("interest4").value))),format.raw/*68.136*/("""</i></div></div>
                        <div class="row form-div"><div class="span4"><select class="span4 interest" id="interest1" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*69.162*/interests/*69.171*/.map/*69.175*/ {interest =>_display_(Seq[Any](format.raw/*69.188*/(""" <option value=""""),_display_(Seq[Any](/*69.205*/interest/*69.213*/.getId())),format.raw/*69.221*/("""" """),_display_(Seq[Any](/*69.224*/if(interest.getId().toString().equals(form("interest1").value))/*69.287*/ {_display_(Seq[Any](format.raw/*69.289*/("""selected""")))})),format.raw/*69.298*/(""">"""),_display_(Seq[Any](/*69.300*/interest/*69.308*/.getName())),format.raw/*69.318*/("""</option>""")))})),format.raw/*69.328*/("""</select></div></div>
                        <div class="row form-div"><div class="span4"><select class="span4 interest" id="interest2" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*70.162*/interests/*70.171*/.map/*70.175*/ {interest =>_display_(Seq[Any](format.raw/*70.188*/(""" <option value=""""),_display_(Seq[Any](/*70.205*/interest/*70.213*/.getId())),format.raw/*70.221*/("""" """),_display_(Seq[Any](/*70.224*/if(interest.getId().toString().equals(form("interest2").value))/*70.287*/ {_display_(Seq[Any](format.raw/*70.289*/("""selected""")))})),format.raw/*70.298*/(""">"""),_display_(Seq[Any](/*70.300*/interest/*70.308*/.getName())),format.raw/*70.318*/("""</option>""")))})),format.raw/*70.328*/("""</select></div></div>
                        <div class="row form-div"><div class="span4"><select class="span4 interest" id="interest3" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*71.162*/interests/*71.171*/.map/*71.175*/ {interest =>_display_(Seq[Any](format.raw/*71.188*/(""" <option value=""""),_display_(Seq[Any](/*71.205*/interest/*71.213*/.getId())),format.raw/*71.221*/("""" """),_display_(Seq[Any](/*71.224*/if(interest.getId().toString().equals(form("interest3").value))/*71.287*/ {_display_(Seq[Any](format.raw/*71.289*/("""selected""")))})),format.raw/*71.298*/(""">"""),_display_(Seq[Any](/*71.300*/interest/*71.308*/.getName())),format.raw/*71.318*/("""</option>""")))})),format.raw/*71.328*/("""</select></div></div>
                        <div class="row form-div"><div class="span4"><select class="span4 interest" id="interest4" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*72.162*/interests/*72.171*/.map/*72.175*/ {interest =>_display_(Seq[Any](format.raw/*72.188*/(""" <option value=""""),_display_(Seq[Any](/*72.205*/interest/*72.213*/.getId())),format.raw/*72.221*/("""" """),_display_(Seq[Any](/*72.224*/if(interest.getId().toString().equals(form("interest4").value))/*72.287*/ {_display_(Seq[Any](format.raw/*72.289*/("""selected""")))})),format.raw/*72.298*/(""">"""),_display_(Seq[Any](/*72.300*/interest/*72.308*/.getName())),format.raw/*72.318*/("""</option>""")))})),format.raw/*72.328*/("""</select></div></div>
                        """)))})),format.raw/*73.26*/("""
                    </div>
                </div>
                <div class="row form-div"><div class="span12 text-center"><button type="submit" class="btn btn-large btn-warning">Save</button></div></div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        var editButton = $('#edit-button');
        var changePasswordBox = $('#change-password-box');
    	$('.form-div').hide();
    	$('.password-div').hide();
    	$('#change-password-label').hide();
    	$('.nonform-div').show();
    	$('.nonpassword-div').show();
    	editButton.click(function() """),format.raw/*88.34*/("""{"""),format.raw/*88.35*/("""
            if (editButton.hasClass('active')) """),format.raw/*89.48*/("""{"""),format.raw/*89.49*/("""
            	$('.form-div').hide();
            	$('.password-div').hide();
            	$('#change-password-label').hide();
            	$('.nonform-div').show();
            	$('.nonpassword-div').show();
            """),format.raw/*95.13*/("""}"""),format.raw/*95.14*/("""
            else """),format.raw/*96.18*/("""{"""),format.raw/*96.19*/("""
            	$('.form-div').show();
            	$('#change-password-label').show();
            	if (changePasswordBox.prop('checked')) """),format.raw/*99.53*/("""{"""),format.raw/*99.54*/("""
                	$('.password-div').show();
                	$('.nonpassword-div').hide();
        		"""),format.raw/*102.11*/("""}"""),format.raw/*102.12*/("""
            	else """),format.raw/*103.19*/("""{"""),format.raw/*103.20*/("""
                	$('.password-div').hide();
                	$('.nonpassword-div').show();
            	"""),format.raw/*106.14*/("""}"""),format.raw/*106.15*/("""
            	$('.nonform-div').hide();
            """),format.raw/*108.13*/("""}"""),format.raw/*108.14*/("""
        """),format.raw/*109.9*/("""}"""),format.raw/*109.10*/(""");
    	changePasswordBox.change(function() """),format.raw/*110.42*/("""{"""),format.raw/*110.43*/("""
    		if (changePasswordBox.prop('checked')) """),format.raw/*111.46*/("""{"""),format.raw/*111.47*/("""
            	$('.nonpassword-div').hide();
            	$('.password-div').show();
            	$('#password').prop('disabled', false);
                $('#password').prop('required', true);
                $('#newPassword').prop('disabled', false);
                $('#newPassword').prop('required', true);
                $('#newPpasswordRepeat').prop('disabled', false);
                $('#newPpasswordRepeat').prop('required', true);
    		"""),format.raw/*120.7*/("""}"""),format.raw/*120.8*/("""
    		else """),format.raw/*121.12*/("""{"""),format.raw/*121.13*/("""
                $('.nonpassword-div').show();
            	$('.password-div').hide();
            	$('#password').prop('disabled', true);
                $('#password').prop('required', false);
                $('#newPassword').prop('disabled', true);
                $('#newPassword').prop('required', false);
                $('#newPpasswordRepeat').prop('disabled', true);
                $('#newPpasswordRepeat').prop('required', false);
    		"""),format.raw/*130.7*/("""}"""),format.raw/*130.8*/("""
    	"""),format.raw/*131.6*/("""}"""),format.raw/*131.7*/(""");
        """),_display_(Seq[Any](/*132.10*/if(flash.contains("edit"))/*132.36*/ {_display_(Seq[Any](format.raw/*132.38*/("""editButton.click();""")))})),format.raw/*132.58*/("""
    	"""),_display_(Seq[Any](/*133.7*/if(flash.contains("changePassword"))/*133.43*/ {_display_(Seq[Any](format.raw/*133.45*/("""changePasswordBox.click();""")))})),format.raw/*133.72*/("""
        
        $.getJSON(""""),_display_(Seq[Any](/*135.21*/routes/*135.27*/.Assets.at("data/Zips.json"))),format.raw/*135.55*/("""", function(data) """),format.raw/*135.73*/("""{"""),format.raw/*135.74*/("""
            var zipCodes = [];
            $.each(data, function(i, item) """),format.raw/*137.44*/("""{"""),format.raw/*137.45*/("""zipCodes.push(item);"""),format.raw/*137.65*/("""}"""),format.raw/*137.66*/(""");
            $('#zipCode')
                .typeahead("""),format.raw/*139.28*/("""{"""),format.raw/*139.29*/("""source: zipCodes, items: 10"""),format.raw/*139.56*/("""}"""),format.raw/*139.57*/(""")
                .blur(function() """),format.raw/*140.34*/("""{"""),format.raw/*140.35*/("""if($.inArray($(this).val(), zipCodes) == -1) """),format.raw/*140.80*/("""{"""),format.raw/*140.81*/("""$('#zipCode').val('');"""),format.raw/*140.103*/("""}"""),format.raw/*140.104*/("""}"""),format.raw/*140.105*/(""");
        """),format.raw/*141.9*/("""}"""),format.raw/*141.10*/(""");
    	
        $('#email').tooltip("""),format.raw/*143.29*/("""{"""),format.raw/*143.30*/("""placement: "bottom", animation: false, title: "Required. 1-63 characters.""""),format.raw/*143.104*/("""}"""),format.raw/*143.105*/(""")
        $('#password').tooltip("""),format.raw/*144.32*/("""{"""),format.raw/*144.33*/("""placement: "bottom", animation: false, title: "Required. 6-31 characters.""""),format.raw/*144.107*/("""}"""),format.raw/*144.108*/(""")
        $('#newPassword').tooltip("""),format.raw/*145.35*/("""{"""),format.raw/*145.36*/("""placement: "bottom", animation: false, title: "Required. 6-31 characters.""""),format.raw/*145.110*/("""}"""),format.raw/*145.111*/(""")
        $('#newPasswordRepeat').tooltip("""),format.raw/*146.41*/("""{"""),format.raw/*146.42*/("""placement: "bottom", animation: false, title: "Required. 6-31 characters.""""),format.raw/*146.116*/("""}"""),format.raw/*146.117*/(""")
        $('#age').tooltip("""),format.raw/*147.27*/("""{"""),format.raw/*147.28*/("""placement: "bottom", animation: false, title: "Optional. Match with ads for your age group.""""),format.raw/*147.120*/("""}"""),format.raw/*147.121*/(""")
        $('#zipCode').tooltip("""),format.raw/*148.31*/("""{"""),format.raw/*148.32*/("""placement: "bottom", animation: false, title: "Optional. Match with ads in your area.""""),format.raw/*148.118*/("""}"""),format.raw/*148.119*/(""")
        $('#male').tooltip("""),format.raw/*149.28*/("""{"""),format.raw/*149.29*/("""placement: "bottom", animation: false, title: "Optional. Match with ads for guys.""""),format.raw/*149.111*/("""}"""),format.raw/*149.112*/(""")
        $('#female').tooltip("""),format.raw/*150.30*/("""{"""),format.raw/*150.31*/("""placement: "bottom", animation: false, title: "Optional. Match with ads for gals.""""),format.raw/*150.113*/("""}"""),format.raw/*150.114*/(""")
        $('.occupation').tooltip("""),format.raw/*151.34*/("""{"""),format.raw/*151.35*/("""placement: "bottom", animation: false, title: "Optional. Match with ads related to your job.""""),format.raw/*151.128*/("""}"""),format.raw/*151.129*/(""")
        $('.interest').tooltip("""),format.raw/*152.32*/("""{"""),format.raw/*152.33*/("""placement: "bottom", animation: false, title: "Optional. Match with ads about your interests.""""),format.raw/*152.127*/("""}"""),format.raw/*152.128*/(""")
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Profile.ProfileForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Profile.ProfileForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jul 09 23:23:58 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: 863cdd7f0d1d15ca23ce68ac4cb19b176c1408a6
                    MATRIX: 749->1|871->46|910->51|939->72|978->74|1100->161|1114->167|1150->182|1630->626|1643->630|1676->641|2473->1409|2503->1410|2536->1414|2566->1415|2839->1659|2869->1660|2902->1664|2932->1665|3162->1866|3192->1867|3225->1871|3255->1872|3794->2375|3833->2405|3887->2421|4041->2539|4060->2549|4126->2592|4235->2665|4254->2675|4320->2718|4598->2959|4619->2970|4633->2974|4687->2989|4741->3006|4761->3016|4792->3024|4832->3027|4909->3094|4950->3096|4992->3105|5031->3107|5051->3117|5084->3127|5127->3137|5326->3299|5347->3310|5361->3314|5415->3329|5469->3346|5489->3356|5520->3364|5560->3367|5637->3434|5678->3436|5720->3445|5759->3447|5779->3457|5812->3467|5855->3477|5961->3551|6299->3853|6319->3864|6348->3870|6585->4070|6606->4081|6635->4087|6925->4341|6950->4356|6979->4362|7189->4543|7219->4544|7251->4547|7281->4548|7342->4572|7367->4587|7396->4593|7720->4881|7758->4910|7798->4912|7876->4957|7968->5013|8006->5042|8046->5044|8126->5091|8385->5313|8424->5342|8465->5344|8506->5352|8736->5545|8775->5574|8816->5576|8857->5584|9166->5857|9203->5885|9255->5899|9379->5987|9396->5995|9460->6036|9600->6140|9617->6148|9681->6189|9821->6293|9838->6301|9902->6342|10042->6446|10059->6454|10123->6495|10339->6674|10358->6683|10372->6687|10424->6700|10478->6717|10496->6725|10527->6733|10567->6736|10640->6799|10681->6801|10723->6810|10762->6812|10780->6820|10813->6830|10856->6840|11077->7024|11096->7033|11110->7037|11162->7050|11216->7067|11234->7075|11265->7083|11305->7086|11378->7149|11419->7151|11461->7160|11500->7162|11518->7170|11551->7180|11594->7190|11815->7374|11834->7383|11848->7387|11900->7400|11954->7417|11972->7425|12003->7433|12043->7436|12116->7499|12157->7501|12199->7510|12238->7512|12256->7520|12289->7530|12332->7540|12553->7724|12572->7733|12586->7737|12638->7750|12692->7767|12710->7775|12741->7783|12781->7786|12854->7849|12895->7851|12937->7860|12976->7862|12994->7870|13027->7880|13070->7890|13150->7938|13785->8545|13814->8546|13891->8595|13920->8596|14174->8822|14203->8823|14250->8842|14279->8843|14448->8984|14477->8985|14611->9090|14641->9091|14690->9111|14720->9112|14857->9220|14887->9221|14970->9275|15000->9276|15038->9286|15068->9287|15142->9332|15172->9333|15248->9380|15278->9381|15761->9836|15790->9837|15832->9850|15862->9851|16348->10309|16377->10310|16412->10317|16441->10318|16491->10331|16527->10357|16568->10359|16621->10379|16665->10387|16711->10423|16752->10425|16812->10452|16881->10484|16897->10490|16948->10518|16995->10536|17025->10537|17131->10614|17161->10615|17210->10635|17240->10636|17327->10694|17357->10695|17413->10722|17443->10723|17508->10759|17538->10760|17612->10805|17642->10806|17694->10828|17725->10829|17756->10830|17796->10842|17826->10843|17894->10882|17924->10883|18028->10957|18059->10958|18122->10992|18152->10993|18256->11067|18287->11068|18353->11105|18383->11106|18487->11180|18518->11181|18590->11224|18620->11225|18724->11299|18755->11300|18813->11329|18843->11330|18965->11422|18996->11423|19058->11456|19088->11457|19204->11543|19235->11544|19294->11574|19324->11575|19436->11657|19467->11658|19528->11690|19558->11691|19670->11773|19701->11774|19766->11810|19796->11811|19919->11904|19950->11905|20013->11939|20043->11940|20167->12034|20198->12035
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|39->11|39->11|39->11|45->17|45->17|45->17|45->17|47->19|47->19|47->19|47->19|48->20|48->20|48->20|48->20|56->28|56->28|56->28|58->30|58->30|58->30|59->31|59->31|59->31|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|65->37|71->43|71->43|71->43|72->44|72->44|72->44|76->48|76->48|76->48|77->49|77->49|77->49|77->49|77->49|77->49|77->49|82->54|82->54|82->54|82->54|83->55|83->55|83->55|83->55|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|101->73|116->88|116->88|117->89|117->89|123->95|123->95|124->96|124->96|127->99|127->99|130->102|130->102|131->103|131->103|134->106|134->106|136->108|136->108|137->109|137->109|138->110|138->110|139->111|139->111|148->120|148->120|149->121|149->121|158->130|158->130|159->131|159->131|160->132|160->132|160->132|160->132|161->133|161->133|161->133|161->133|163->135|163->135|163->135|163->135|163->135|165->137|165->137|165->137|165->137|167->139|167->139|167->139|167->139|168->140|168->140|168->140|168->140|168->140|168->140|168->140|169->141|169->141|171->143|171->143|171->143|171->143|172->144|172->144|172->144|172->144|173->145|173->145|173->145|173->145|174->146|174->146|174->146|174->146|175->147|175->147|175->147|175->147|176->148|176->148|176->148|176->148|177->149|177->149|177->149|177->149|178->150|178->150|178->150|178->150|179->151|179->151|179->151|179->151|180->152|180->152|180->152|180->152
                    -- GENERATED --
                */
            