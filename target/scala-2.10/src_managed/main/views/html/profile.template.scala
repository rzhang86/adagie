
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
                <div class="row"><div class="span6 offset3 text-center"><strong>Required fields:</strong></div></div>
                <div class="row nonform-height2">
                    <div class="span4 offset1">Email:</div>
                    <div class="span3">Password:</div>
                    <div class="span4 form-div text-warning">
                        <label class="checkbox pull-right"><input type="checkbox" id="change-password-box" name="changePassword" value="1"> Change password</label>
                    </div>
                </div>
                <div class="row">
                    <div class="span4 offset1 nonform-height text-info"><i>"""),_display_(Seq[Any](/*17.77*/form("email")/*17.90*/.value)),format.raw/*17.96*/("""</i></div>
                    <div class="span5 nonpassword-div text-info"><i>(not shown of course...)</i></div>
                    <div class="span3 password-div"><input class="span3" type="password" id="password" name="password" placeholder="Current password" pattern="."""),format.raw/*19.161*/("""{"""),format.raw/*19.162*/("""6,31"""),format.raw/*19.166*/("""}"""),format.raw/*19.167*/(""""></div>
                    <!--
                    <div class="span3 nonform-div"></div>
                    <div class="span4 offset1 form-div"><input class="span4" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*22.143*/form("email")/*22.156*/.value)),format.raw/*22.162*/("""" pattern="."""),format.raw/*22.174*/("""{"""),format.raw/*22.175*/("""1,63"""),format.raw/*22.179*/("""}"""),format.raw/*22.180*/(""""></div>
                    <div class="span3 form-div"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*23.149*/("""{"""),format.raw/*23.150*/("""6,31"""),format.raw/*23.154*/("""}"""),format.raw/*23.155*/(""""></div>
                    <div class="span3 form-div"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*24.168*/("""{"""),format.raw/*24.169*/("""6,31"""),format.raw/*24.173*/("""}"""),format.raw/*24.174*/(""""></div>
                    -->
                </div>
                <div class="row">
                    <div class="span6 offset5 nonform-height nonpassword-div"></div>
                    <div class="span3 offset5 password-div"><input class="span3" type="password" id="newPassword" name="newPassword" placeholder="New password" pattern="."""),format.raw/*29.171*/("""{"""),format.raw/*29.172*/("""6,31"""),format.raw/*29.176*/("""}"""),format.raw/*29.177*/(""""></div>
                    <div class="span3 password-div"><input class="span3" type="password" id="newPasswordRepeat" name="newPasswordRepeat" placeholder="Repeat new password" pattern="."""),format.raw/*30.182*/("""{"""),format.raw/*30.183*/("""6,31"""),format.raw/*30.187*/("""}"""),format.raw/*30.188*/(""""></div>
                </div>
                <div class="row"><div class="span6 offset3 text-center"><strong>Optional fields *:</strong></div></div>
                <br>
                <div class="row"><div class="span5 offset1">Occupations:</div></div>
                """),_display_(Seq[Any](/*35.18*/defining(Occupation.findAll())/*35.48*/ {occupations =>_display_(Seq[Any](format.raw/*35.64*/("""
                    <div class="row ">
                        <div class="span5 offset1 nonform-div text-info"><i>"""),_display_(Seq[Any](/*37.78*/Occupation/*37.88*/.getNameByString(form("occupation1").value))),format.raw/*37.131*/("""</i></div>
                        <div class="span5 nonform-div text-info"><i>"""),_display_(Seq[Any](/*38.70*/Occupation/*38.80*/.getNameByString(form("occupation2").value))),format.raw/*38.123*/("""</i></div>
                        <div class="span5 offset1 form-div"><select class="span5 occupation" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*39.142*/occupations/*39.153*/.map/*39.157*/ {occupation =>_display_(Seq[Any](format.raw/*39.172*/(""" <option value=""""),_display_(Seq[Any](/*39.189*/occupation/*39.199*/.getId())),format.raw/*39.207*/("""" """),_display_(Seq[Any](/*39.210*/if(occupation.getId().toString().equals(form("occupation1").value))/*39.277*/ {_display_(Seq[Any](format.raw/*39.279*/("""selected""")))})),format.raw/*39.288*/(""">"""),_display_(Seq[Any](/*39.290*/occupation/*39.300*/.getName())),format.raw/*39.310*/("""</option>""")))})),format.raw/*39.320*/("""</select></div>
                        <div class="span5 form-div"><select class="span5 occupation" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*40.134*/occupations/*40.145*/.map/*40.149*/ {occupation =>_display_(Seq[Any](format.raw/*40.164*/(""" <option value=""""),_display_(Seq[Any](/*40.181*/occupation/*40.191*/.getId())),format.raw/*40.199*/("""" """),_display_(Seq[Any](/*40.202*/if(occupation.getId().toString().equals(form("occupation2").value))/*40.269*/ {_display_(Seq[Any](format.raw/*40.271*/("""selected""")))})),format.raw/*40.280*/(""">"""),_display_(Seq[Any](/*40.282*/occupation/*40.292*/.getName())),format.raw/*40.302*/("""</option>""")))})),format.raw/*40.312*/("""</select></div>
                    </div>
                """)))})),format.raw/*42.18*/("""
                <div class="row">
                    <div class="span2 offset1">Age:</div>
                    <div class="span2">Zip code:</div>
                    <div class="span2">Gender:</div>
                    <div class="span4">Interests:</div>
                </div>
                """),_display_(Seq[Any](/*49.18*/defining(Interest.findAll())/*49.46*/ {interests =>_display_(Seq[Any](format.raw/*49.60*/("""
                    <div class="row">
                        <div class="span2 offset1 nonform-div text-info"><i>"""),_display_(Seq[Any](/*51.78*/form("age")/*51.89*/.value)),format.raw/*51.95*/("""</i></div>
                        <div class="span2 nonform-div text-info"><i>"""),_display_(Seq[Any](/*52.70*/form("zipCode")/*52.85*/.value)),format.raw/*52.91*/("""</i></div>
                        <div class="span1 nonform-div text-info">"""),_display_(Seq[Any](/*53.67*/if(form("gender").value=="M")/*53.96*/ {_display_(Seq[Any](format.raw/*53.98*/("""<img src="assets/img/male.png" width="15px">""")))})),format.raw/*53.143*/("""</div>
                        <div class="span1 nonform-div text-info">"""),_display_(Seq[Any](/*54.67*/if(form("gender").value=="F")/*54.96*/ {_display_(Seq[Any](format.raw/*54.98*/("""<img src="assets/img/female.png" width="15px">""")))})),format.raw/*54.145*/("""</div>
                        <div class="span4 nonform-div text-info"><i>"""),_display_(Seq[Any](/*55.70*/Interest/*55.78*/.getNameByString(form("interest1").value))),format.raw/*55.119*/("""</i></div>
                        <div class="span2 offset1 form-div"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*56.174*/form("age")/*56.185*/.value)),format.raw/*56.191*/(""""></div>
                        <div class="span2 form-div"><input class="span2" type="text" id="zipCode" name="zipCode" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*57.159*/form("zipCode")/*57.174*/.value)),format.raw/*57.180*/(""""></div>
                        <div class="span1 form-div"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*58.136*/if(form("gender").value=="M")/*58.165*/ {_display_(Seq[Any](format.raw/*58.167*/("""checked""")))})),format.raw/*58.175*/("""><img src="assets/img/male.png" width="15px"></label></div>
                        <div class="span1 form-div"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*59.138*/if(form("gender").value=="F")/*59.167*/ {_display_(Seq[Any](format.raw/*59.169*/("""checked""")))})),format.raw/*59.177*/("""><img src="assets/img/female.png" width="15px"></label></div>
                        <div class="span4 form-div"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*60.130*/interests/*60.139*/.map/*60.143*/ {interest =>_display_(Seq[Any](format.raw/*60.156*/(""" <option value=""""),_display_(Seq[Any](/*60.173*/interest/*60.181*/.getId())),format.raw/*60.189*/("""" """),_display_(Seq[Any](/*60.192*/if(interest.getId().toString().equals(form("interest1").value))/*60.255*/ {_display_(Seq[Any](format.raw/*60.257*/("""selected""")))})),format.raw/*60.266*/(""">"""),_display_(Seq[Any](/*60.268*/interest/*60.276*/.getName())),format.raw/*60.286*/("""</option>""")))})),format.raw/*60.296*/("""</select></div>
                    </div>
                    <div class="row ">
                        <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*63.78*/Interest/*63.86*/.getNameByString(form("interest2").value))),format.raw/*63.127*/("""</i></div>
                        <div class="span4 offset7 form-div"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*64.138*/interests/*64.147*/.map/*64.151*/ {interest =>_display_(Seq[Any](format.raw/*64.164*/(""" <option value=""""),_display_(Seq[Any](/*64.181*/interest/*64.189*/.getId())),format.raw/*64.197*/("""" """),_display_(Seq[Any](/*64.200*/if(interest.getId().toString().equals(form("interest2").value))/*64.263*/ {_display_(Seq[Any](format.raw/*64.265*/("""selected""")))})),format.raw/*64.274*/(""">"""),_display_(Seq[Any](/*64.276*/interest/*64.284*/.getName())),format.raw/*64.294*/("""</option>""")))})),format.raw/*64.304*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*67.78*/Interest/*67.86*/.getNameByString(form("interest3").value))),format.raw/*67.127*/("""</i></div>
                        <div class="span4 offset7 form-div"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*68.138*/interests/*68.147*/.map/*68.151*/ {interest =>_display_(Seq[Any](format.raw/*68.164*/(""" <option value=""""),_display_(Seq[Any](/*68.181*/interest/*68.189*/.getId())),format.raw/*68.197*/("""" """),_display_(Seq[Any](/*68.200*/if(interest.getId().toString().equals(form("interest3").value))/*68.263*/ {_display_(Seq[Any](format.raw/*68.265*/("""selected""")))})),format.raw/*68.274*/(""">"""),_display_(Seq[Any](/*68.276*/interest/*68.284*/.getName())),format.raw/*68.294*/("""</option>""")))})),format.raw/*68.304*/("""</select></div>
                    </div>
                    <div class="row">
                        <div class="span4 offset7 nonform-div text-info"><i>"""),_display_(Seq[Any](/*71.78*/Interest/*71.86*/.getNameByString(form("interest4").value))),format.raw/*71.127*/("""</i></div>
                        <div class="span4 offset7 form-div"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*72.138*/interests/*72.147*/.map/*72.151*/ {interest =>_display_(Seq[Any](format.raw/*72.164*/(""" <option value=""""),_display_(Seq[Any](/*72.181*/interest/*72.189*/.getId())),format.raw/*72.197*/("""" """),_display_(Seq[Any](/*72.200*/if(interest.getId().toString().equals(form("interest4").value))/*72.263*/ {_display_(Seq[Any](format.raw/*72.265*/("""selected""")))})),format.raw/*72.274*/(""">"""),_display_(Seq[Any](/*72.276*/interest/*72.284*/.getName())),format.raw/*72.294*/("""</option>""")))})),format.raw/*72.304*/("""</select></div>
                    </div>
                """)))})),format.raw/*74.18*/("""
                <div class="row"><div class="span12 text-center"><i>* Optional fields help match you with higher-paying videos!</i></div></div>
                <div class="row"><div class="span12 text-center"><button type="submit" class="btn btn-large btn-success" id="submit-button">Save</button></div></div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        var editButton = $('#edit-button');
    	var submitButton = $('#submit-button'); 
        var changePasswordBox = $('#change-password-box');
		submitButton.hide();
    	$('.form-div').hide();
    	$('.password-div').hide();
    	$('.nonform-div').show();
    	$('.nonpassword-div').show();
    	editButton.click(function() """),format.raw/*89.34*/("""{"""),format.raw/*89.35*/("""
            if (editButton.hasClass('active')) """),format.raw/*90.48*/("""{"""),format.raw/*90.49*/("""
            	$('.form-div').hide();
            	$('.password-div').hide();
            	$('#submit-button').hide();
            	$('.nonform-div').show();
            	$('.nonpassword-div').show();
            """),format.raw/*96.13*/("""}"""),format.raw/*96.14*/("""
            else """),format.raw/*97.18*/("""{"""),format.raw/*97.19*/("""
            	$('.form-div').show();
            	if (changePasswordBox.prop('checked')) """),format.raw/*99.53*/("""{"""),format.raw/*99.54*/("""
                	$('.password-div').show();
                	$('.nonpassword-div').hide();
        		"""),format.raw/*102.11*/("""}"""),format.raw/*102.12*/("""
            	else """),format.raw/*103.19*/("""{"""),format.raw/*103.20*/("""
                	$('.password-div').hide();
                	$('.nonpassword-div').show();
            	"""),format.raw/*106.14*/("""}"""),format.raw/*106.15*/("""
            	$('#submit-button').show();
            	$('.nonform-div').hide();
            """),format.raw/*109.13*/("""}"""),format.raw/*109.14*/("""
        """),format.raw/*110.9*/("""}"""),format.raw/*110.10*/(""");
    	changePasswordBox.change(function() """),format.raw/*111.42*/("""{"""),format.raw/*111.43*/("""
    		if (changePasswordBox.prop('checked')) """),format.raw/*112.46*/("""{"""),format.raw/*112.47*/("""
    			changePasswordBox.val('1');
            	$('.nonpassword-div').hide();
            	$('.password-div').show();
    		"""),format.raw/*116.7*/("""}"""),format.raw/*116.8*/("""
    		else """),format.raw/*117.12*/("""{"""),format.raw/*117.13*/("""
    			changePasswordBox.val('0');
            	$('.nonpassword-div').show();
            	$('.password-div').hide();
    		"""),format.raw/*121.7*/("""}"""),format.raw/*121.8*/("""
    	"""),format.raw/*122.6*/("""}"""),format.raw/*122.7*/(""");
        """),_display_(Seq[Any](/*123.10*/if(flash.contains("edit"))/*123.36*/ {_display_(Seq[Any](format.raw/*123.38*/("""editButton.click();""")))})),format.raw/*123.58*/("""
    	"""),_display_(Seq[Any](/*124.7*/if(flash.contains("changePassword"))/*124.43*/ {_display_(Seq[Any](format.raw/*124.45*/("""changePasswordBox.click();""")))})),format.raw/*124.72*/("""
        
        $.getJSON(""""),_display_(Seq[Any](/*126.21*/routes/*126.27*/.Assets.at("data/Zips.json"))),format.raw/*126.55*/("""", function(data) """),format.raw/*126.73*/("""{"""),format.raw/*126.74*/("""
            var zipCodes = [];
            $.each(data, function(i, item) """),format.raw/*128.44*/("""{"""),format.raw/*128.45*/("""zipCodes.push(item);"""),format.raw/*128.65*/("""}"""),format.raw/*128.66*/(""");
            $('#zipCode')
                .typeahead("""),format.raw/*130.28*/("""{"""),format.raw/*130.29*/("""source: zipCodes, items: 10"""),format.raw/*130.56*/("""}"""),format.raw/*130.57*/(""")
                .blur(function() """),format.raw/*131.34*/("""{"""),format.raw/*131.35*/("""if($.inArray($(this).val(), zipCodes) == -1) """),format.raw/*131.80*/("""{"""),format.raw/*131.81*/("""$('#zipCode').val('');"""),format.raw/*131.103*/("""}"""),format.raw/*131.104*/("""}"""),format.raw/*131.105*/(""");
        """),format.raw/*132.9*/("""}"""),format.raw/*132.10*/(""");
    	
        $('#email').tooltip("""),format.raw/*134.29*/("""{"""),format.raw/*134.30*/("""placement: "bottom", title: "Must be between 1 and 63 characters.""""),format.raw/*134.96*/("""}"""),format.raw/*134.97*/(""")
        $('#newPassword').tooltip("""),format.raw/*135.35*/("""{"""),format.raw/*135.36*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*135.102*/("""}"""),format.raw/*135.103*/(""")
        $('#newPasswordRepeat').tooltip("""),format.raw/*136.41*/("""{"""),format.raw/*136.42*/("""placement: "bottom", title: "Must be between 6 and 31 characters.""""),format.raw/*136.108*/("""}"""),format.raw/*136.109*/(""")
        $('#age').tooltip("""),format.raw/*137.27*/("""{"""),format.raw/*137.28*/("""placement: "bottom", title: "Match with videos for your age group.""""),format.raw/*137.95*/("""}"""),format.raw/*137.96*/(""")
        $('#zipCode').tooltip("""),format.raw/*138.31*/("""{"""),format.raw/*138.32*/("""placement: "bottom", title: "Match with videos in your area.""""),format.raw/*138.93*/("""}"""),format.raw/*138.94*/(""")
        $('#male').tooltip("""),format.raw/*139.28*/("""{"""),format.raw/*139.29*/("""placement: "bottom", title: "Match you with videos for guys.""""),format.raw/*139.90*/("""}"""),format.raw/*139.91*/(""")
        $('#female').tooltip("""),format.raw/*140.30*/("""{"""),format.raw/*140.31*/("""placement: "bottom", title: "Match you with videos for gals.""""),format.raw/*140.92*/("""}"""),format.raw/*140.93*/(""")
        $('.occupation').tooltip("""),format.raw/*141.34*/("""{"""),format.raw/*141.35*/("""placement: "bottom", title: "Match with videos related to your job.""""),format.raw/*141.103*/("""}"""),format.raw/*141.104*/(""")
        $('.interest').tooltip("""),format.raw/*142.32*/("""{"""),format.raw/*142.33*/("""placement: "bottom", title: "Match with videos about your interests.""""),format.raw/*142.102*/("""}"""),format.raw/*142.103*/(""")
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Profile.ProfileForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Profile.ProfileForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 05 19:04:10 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: 8f7d40021cae7ef0f6698bf74dc725abdad2e004
                    MATRIX: 749->1|871->46|910->51|939->72|978->74|1100->161|1114->167|1150->182|2054->1050|2076->1063|2104->1069|2409->1345|2439->1346|2472->1350|2502->1351|2776->1588|2799->1601|2828->1607|2869->1619|2899->1620|2932->1624|2962->1625|3149->1783|3179->1784|3212->1788|3242->1789|3448->1966|3478->1967|3511->1971|3541->1972|3920->2322|3950->2323|3983->2327|4013->2328|4233->2519|4263->2520|4296->2524|4326->2525|4642->2805|4681->2835|4735->2851|4890->2970|4909->2980|4975->3023|5092->3104|5111->3114|5177->3157|5367->3310|5388->3321|5402->3325|5456->3340|5510->3357|5530->3367|5561->3375|5601->3378|5678->3445|5719->3447|5761->3456|5800->3458|5820->3468|5853->3478|5896->3488|6083->3638|6104->3649|6118->3653|6172->3668|6226->3685|6246->3695|6277->3703|6317->3706|6394->3773|6435->3775|6477->3784|6516->3786|6536->3796|6569->3806|6612->3816|6706->3878|7046->4182|7083->4210|7135->4224|7289->4342|7309->4353|7337->4359|7454->4440|7478->4455|7506->4461|7620->4539|7658->4568|7698->4570|7776->4615|7886->4689|7924->4718|7964->4720|8044->4767|8157->4844|8174->4852|8238->4893|8460->5078|8481->5089|8510->5095|8715->5263|8740->5278|8769->5284|8951->5429|8990->5458|9031->5460|9072->5468|9307->5666|9346->5695|9387->5697|9428->5705|9657->5897|9676->5906|9690->5910|9742->5923|9796->5940|9814->5948|9845->5956|9885->5959|9958->6022|9999->6024|10041->6033|10080->6035|10098->6043|10131->6053|10174->6063|10372->6225|10389->6233|10453->6274|10639->6423|10658->6432|10672->6436|10724->6449|10778->6466|10796->6474|10827->6482|10867->6485|10940->6548|10981->6550|11023->6559|11062->6561|11080->6569|11113->6579|11156->6589|11353->6750|11370->6758|11434->6799|11620->6948|11639->6957|11653->6961|11705->6974|11759->6991|11777->6999|11808->7007|11848->7010|11921->7073|11962->7075|12004->7084|12043->7086|12061->7094|12094->7104|12137->7114|12334->7275|12351->7283|12415->7324|12601->7473|12620->7482|12634->7486|12686->7499|12740->7516|12758->7524|12789->7532|12829->7535|12902->7598|12943->7600|12985->7609|13024->7611|13042->7619|13075->7629|13118->7639|13212->7701|13979->8440|14008->8441|14085->8490|14114->8491|14360->8709|14389->8710|14436->8729|14465->8730|14584->8821|14613->8822|14747->8927|14777->8928|14826->8948|14856->8949|14993->9057|15023->9058|15148->9154|15178->9155|15216->9165|15246->9166|15320->9211|15350->9212|15426->9259|15456->9260|15613->9389|15642->9390|15684->9403|15714->9404|15871->9533|15900->9534|15935->9541|15964->9542|16014->9555|16050->9581|16091->9583|16144->9603|16188->9611|16234->9647|16275->9649|16335->9676|16404->9708|16420->9714|16471->9742|16518->9760|16548->9761|16654->9838|16684->9839|16733->9859|16763->9860|16850->9918|16880->9919|16936->9946|16966->9947|17031->9983|17061->9984|17135->10029|17165->10030|17217->10052|17248->10053|17279->10054|17319->10066|17349->10067|17417->10106|17447->10107|17542->10173|17572->10174|17638->10211|17668->10212|17764->10278|17795->10279|17867->10322|17897->10323|17993->10389|18024->10390|18082->10419|18112->10420|18208->10487|18238->10488|18300->10521|18330->10522|18420->10583|18450->10584|18509->10614|18539->10615|18629->10676|18659->10677|18720->10709|18750->10710|18840->10771|18870->10772|18935->10808|18965->10809|19063->10877|19094->10878|19157->10912|19187->10913|19286->10982|19317->10983
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|45->17|45->17|45->17|47->19|47->19|47->19|47->19|50->22|50->22|50->22|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|52->24|52->24|52->24|52->24|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|63->35|63->35|63->35|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|68->40|70->42|77->49|77->49|77->49|79->51|79->51|79->51|80->52|80->52|80->52|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|91->63|91->63|91->63|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|99->71|99->71|99->71|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|102->74|117->89|117->89|118->90|118->90|124->96|124->96|125->97|125->97|127->99|127->99|130->102|130->102|131->103|131->103|134->106|134->106|137->109|137->109|138->110|138->110|139->111|139->111|140->112|140->112|144->116|144->116|145->117|145->117|149->121|149->121|150->122|150->122|151->123|151->123|151->123|151->123|152->124|152->124|152->124|152->124|154->126|154->126|154->126|154->126|154->126|156->128|156->128|156->128|156->128|158->130|158->130|158->130|158->130|159->131|159->131|159->131|159->131|159->131|159->131|159->131|160->132|160->132|162->134|162->134|162->134|162->134|163->135|163->135|163->135|163->135|164->136|164->136|164->136|164->136|165->137|165->137|165->137|165->137|166->138|166->138|166->138|166->138|167->139|167->139|167->139|167->139|168->140|168->140|168->140|168->140|169->141|169->141|169->141|169->141|170->142|170->142|170->142|170->142
                    -- GENERATED --
                */
            