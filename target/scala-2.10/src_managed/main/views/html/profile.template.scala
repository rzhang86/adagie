
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
                        <div class="row password-div"><div class="span3"><input class="span3" type="password" id="password" name="password" placeholder="Current password" pattern="."""),format.raw/*17.182*/("""{"""),format.raw/*17.183*/("""6,31"""),format.raw/*17.187*/("""}"""),format.raw/*17.188*/(""""></div></div>
                        <div class="row password-div">
                            <div class="span3"><input class="span3" type="password" id="newPassword" name="newPassword" placeholder="New password" pattern="."""),format.raw/*19.158*/("""{"""),format.raw/*19.159*/("""6,31"""),format.raw/*19.163*/("""}"""),format.raw/*19.164*/(""""></div>
                            <div class="span3"><input class="span3" type="password" id="newPasswordRepeat" name="newPasswordRepeat" placeholder="Repeat new password" pattern="."""),format.raw/*20.177*/("""{"""),format.raw/*20.178*/("""6,31"""),format.raw/*20.182*/("""}"""),format.raw/*20.183*/(""""></div>
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
                        <div class="row form-div"><div class="span2"><input class="span2" type="text" id="zipCode" name="zipCode" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*49.176*/form("zipCode")/*49.191*/.value)),format.raw/*49.197*/("""" autocomplete="off"></div></div>
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
    	
        $('#age').tooltip("""),format.raw/*143.27*/("""{"""),format.raw/*143.28*/("""placement: "bottom", title: "Match with ads for your age group.""""),format.raw/*143.92*/("""}"""),format.raw/*143.93*/(""")
        $('#zipCode').tooltip("""),format.raw/*144.31*/("""{"""),format.raw/*144.32*/("""placement: "bottom", title: "Match with ads in your area.""""),format.raw/*144.90*/("""}"""),format.raw/*144.91*/(""")
        $('#male').tooltip("""),format.raw/*145.28*/("""{"""),format.raw/*145.29*/("""placement: "bottom", title: "Match with ads for guys.""""),format.raw/*145.83*/("""}"""),format.raw/*145.84*/(""")
        $('#female').tooltip("""),format.raw/*146.30*/("""{"""),format.raw/*146.31*/("""placement: "bottom", title: "Match with ads for gals.""""),format.raw/*146.85*/("""}"""),format.raw/*146.86*/(""")
        $('.occupation').tooltip("""),format.raw/*147.34*/("""{"""),format.raw/*147.35*/("""placement: "bottom", title: "Match with ads related to your job.""""),format.raw/*147.100*/("""}"""),format.raw/*147.101*/(""")
        $('.interest').tooltip("""),format.raw/*148.32*/("""{"""),format.raw/*148.33*/("""placement: "bottom", title: "Match with ads about your interests.""""),format.raw/*148.99*/("""}"""),format.raw/*148.100*/(""")
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Profile.ProfileForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Profile.ProfileForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 06 15:42:21 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: 6933c89679bec59943ce244054a81ddf57e1661c
                    MATRIX: 749->1|871->46|910->51|939->72|978->74|1100->161|1114->167|1150->182|1630->626|1643->630|1676->641|2473->1409|2503->1410|2536->1414|2566->1415|2824->1644|2854->1645|2887->1649|2917->1650|3132->1836|3162->1837|3195->1841|3225->1842|3749->2330|3788->2360|3842->2376|3996->2494|4015->2504|4081->2547|4190->2620|4209->2630|4275->2673|4553->2914|4574->2925|4588->2929|4642->2944|4696->2961|4716->2971|4747->2979|4787->2982|4864->3049|4905->3051|4947->3060|4986->3062|5006->3072|5039->3082|5082->3092|5281->3254|5302->3265|5316->3269|5370->3284|5424->3301|5444->3311|5475->3319|5515->3322|5592->3389|5633->3391|5675->3400|5714->3402|5734->3412|5767->3422|5810->3432|5916->3506|6254->3808|6274->3819|6303->3825|6540->4025|6561->4036|6590->4042|6880->4296|6905->4311|6934->4317|7164->4510|7189->4525|7218->4531|7542->4819|7580->4848|7620->4850|7698->4895|7790->4951|7828->4980|7868->4982|7948->5029|8207->5251|8246->5280|8287->5282|8328->5290|8558->5483|8597->5512|8638->5514|8679->5522|8988->5795|9025->5823|9077->5837|9201->5925|9218->5933|9282->5974|9422->6078|9439->6086|9503->6127|9643->6231|9660->6239|9724->6280|9864->6384|9881->6392|9945->6433|10161->6612|10180->6621|10194->6625|10246->6638|10300->6655|10318->6663|10349->6671|10389->6674|10462->6737|10503->6739|10545->6748|10584->6750|10602->6758|10635->6768|10678->6778|10899->6962|10918->6971|10932->6975|10984->6988|11038->7005|11056->7013|11087->7021|11127->7024|11200->7087|11241->7089|11283->7098|11322->7100|11340->7108|11373->7118|11416->7128|11637->7312|11656->7321|11670->7325|11722->7338|11776->7355|11794->7363|11825->7371|11865->7374|11938->7437|11979->7439|12021->7448|12060->7450|12078->7458|12111->7468|12154->7478|12375->7662|12394->7671|12408->7675|12460->7688|12514->7705|12532->7713|12563->7721|12603->7724|12676->7787|12717->7789|12759->7798|12798->7800|12816->7808|12849->7818|12892->7828|12972->7876|13607->8483|13636->8484|13713->8533|13742->8534|13996->8760|14025->8761|14072->8780|14101->8781|14270->8922|14299->8923|14433->9028|14463->9029|14512->9049|14542->9050|14679->9158|14709->9159|14792->9213|14822->9214|14860->9224|14890->9225|14964->9270|14994->9271|15070->9318|15100->9319|15583->9774|15612->9775|15654->9788|15684->9789|16170->10247|16199->10248|16234->10255|16263->10256|16313->10269|16349->10295|16390->10297|16443->10317|16487->10325|16533->10361|16574->10363|16634->10390|16703->10422|16719->10428|16770->10456|16817->10474|16847->10475|16953->10552|16983->10553|17032->10573|17062->10574|17149->10632|17179->10633|17235->10660|17265->10661|17330->10697|17360->10698|17434->10743|17464->10744|17516->10766|17547->10767|17578->10768|17618->10780|17648->10781|17714->10818|17744->10819|17837->10883|17867->10884|17929->10917|17959->10918|18046->10976|18076->10977|18135->11007|18165->11008|18248->11062|18278->11063|18339->11095|18369->11096|18452->11150|18482->11151|18547->11187|18577->11188|18672->11253|18703->11254|18766->11288|18796->11289|18891->11355|18922->11356
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|39->11|39->11|39->11|45->17|45->17|45->17|45->17|47->19|47->19|47->19|47->19|48->20|48->20|48->20|48->20|56->28|56->28|56->28|58->30|58->30|58->30|59->31|59->31|59->31|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|63->35|65->37|71->43|71->43|71->43|72->44|72->44|72->44|76->48|76->48|76->48|77->49|77->49|77->49|82->54|82->54|82->54|82->54|83->55|83->55|83->55|83->55|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|101->73|116->88|116->88|117->89|117->89|123->95|123->95|124->96|124->96|127->99|127->99|130->102|130->102|131->103|131->103|134->106|134->106|136->108|136->108|137->109|137->109|138->110|138->110|139->111|139->111|148->120|148->120|149->121|149->121|158->130|158->130|159->131|159->131|160->132|160->132|160->132|160->132|161->133|161->133|161->133|161->133|163->135|163->135|163->135|163->135|163->135|165->137|165->137|165->137|165->137|167->139|167->139|167->139|167->139|168->140|168->140|168->140|168->140|168->140|168->140|168->140|169->141|169->141|171->143|171->143|171->143|171->143|172->144|172->144|172->144|172->144|173->145|173->145|173->145|173->145|174->146|174->146|174->146|174->146|175->147|175->147|175->147|175->147|176->148|176->148|176->148|176->148
                    -- GENERATED --
                */
            