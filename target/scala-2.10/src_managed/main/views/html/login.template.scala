
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
object login extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Login.LoginForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(form: Form[Login.LoginForm]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.31*/("""

"""),_display_(Seq[Any](/*3.2*/main(null, "login")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
    <div class="row">
	    <div class="span12 well">
            <form action=""""),_display_(Seq[Any](/*6.28*/routes/*6.34*/.Login.post())),format.raw/*6.47*/("""" method="post">
                <div class="row">
                    <div class="span4 offset1">
                        <div class="row nonform-height2"><div class="span4">Email:</div></div>
                        <div class="row"><div class="span4"><input type="text" class="span4" id="email" name="email" placeholder="Email address" value=""""),_display_(Seq[Any](/*10.154*/form("email")/*10.167*/.value)),format.raw/*10.173*/("""" pattern="."""),format.raw/*10.185*/("""{"""),format.raw/*10.186*/("""1,63"""),format.raw/*10.190*/("""}"""),format.raw/*10.191*/("""" required></div></div>
                    </div>
                    <div class="span6">
                        <div class="row nonform-height2"><div class="span7">Password:</div></div>
                        <div class="row password-div">
                            <div class="span3"><input type="password" class="span3" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*15.148*/("""{"""),format.raw/*15.149*/("""6,31"""),format.raw/*15.153*/("""}"""),format.raw/*15.154*/("""" required></div>
                            <div class="span3"><button type="submit" class="btn btn-info">Log in</button></div>
                        </div>
                        <div class="row nonpassword-div"><div class="span3"><button type="submit" class="btn btn-warning">Reset password</button></div></div>
                    </div>
                </div>
                <div class="row"><div class="span4 offset1 text-warning"><label class="checkbox"><input type="checkbox" id="change-password-box" name="changePassword" value="1"> Forgot password?</label></div></div>
            </form>
	    </div>
    </div>
    <script type="text/javascript">
    	$('.nonpassword-div').hide();
    	$('.password-div').show();
        var changePasswordBox = $('#change-password-box');
        changePasswordBox.change(function() """),format.raw/*29.45*/("""{"""),format.raw/*29.46*/("""
            if (changePasswordBox.prop('checked')) """),format.raw/*30.52*/("""{"""),format.raw/*30.53*/("""
                $('#password').prop('disabled', true);
                $('#password').prop('required', false);
            	$('.password-div').hide();
            	$('.nonpassword-div').show();
            """),format.raw/*35.13*/("""}"""),format.raw/*35.14*/("""
            else """),format.raw/*36.18*/("""{"""),format.raw/*36.19*/("""
            	$('#password').prop('disabled', false);
                $('#password').prop('required', true);
            	$('.nonpassword-div').hide();
            	$('.password-div').show();
            """),format.raw/*41.13*/("""}"""),format.raw/*41.14*/("""
        """),format.raw/*42.9*/("""}"""),format.raw/*42.10*/(""");
        """),_display_(Seq[Any](/*43.10*/if(flash.contains("changePassword"))/*43.46*/ {_display_(Seq[Any](format.raw/*43.48*/("""changePasswordBox.click();""")))})),format.raw/*43.75*/("""
        
        $.getJSON(""""),_display_(Seq[Any](/*45.21*/routes/*45.27*/.Assets.at("data/Zips.json"))),format.raw/*45.55*/("""", function(data) """),format.raw/*45.73*/("""{"""),format.raw/*45.74*/("""
            var zipCodes = [];
            $.each(data, function(i, item) """),format.raw/*47.44*/("""{"""),format.raw/*47.45*/("""zipCodes.push(item);"""),format.raw/*47.65*/("""}"""),format.raw/*47.66*/(""");
            $('#zipCode')
                .typeahead("""),format.raw/*49.28*/("""{"""),format.raw/*49.29*/("""source: zipCodes, items: 10"""),format.raw/*49.56*/("""}"""),format.raw/*49.57*/(""")
                .blur(function() """),format.raw/*50.34*/("""{"""),format.raw/*50.35*/("""if($.inArray($(this).val(), zipCodes) == -1) """),format.raw/*50.80*/("""{"""),format.raw/*50.81*/("""$('#zipCode').val('');"""),format.raw/*50.103*/("""}"""),format.raw/*50.104*/("""}"""),format.raw/*50.105*/(""");
        """),format.raw/*51.9*/("""}"""),format.raw/*51.10*/(""");
    </script>
""")))})))}
    }
    
    def render(form:Form[Login.LoginForm]): play.api.templates.Html = apply(form)
    
    def f:((Form[Login.LoginForm]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 06 15:44:14 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/login.scala.html
                    HASH: 478472d16b366a37e679d39eebcff00d77ef39da
                    MATRIX: 738->1|844->30|883->35|910->54|949->56|1068->140|1082->146|1116->159|1504->510|1527->523|1556->529|1597->541|1627->542|1660->546|1690->547|2115->943|2145->944|2178->948|2208->949|3083->1796|3112->1797|3193->1850|3222->1851|3462->2063|3491->2064|3538->2083|3567->2084|3804->2293|3833->2294|3870->2304|3899->2305|3948->2318|3993->2354|4033->2356|4092->2383|4160->2415|4175->2421|4225->2449|4271->2467|4300->2468|4405->2545|4434->2546|4482->2566|4511->2567|4597->2625|4626->2626|4681->2653|4710->2654|4774->2690|4803->2691|4876->2736|4905->2737|4956->2759|4986->2760|5016->2761|5055->2773|5084->2774
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|38->10|38->10|38->10|38->10|38->10|38->10|38->10|43->15|43->15|43->15|43->15|57->29|57->29|58->30|58->30|63->35|63->35|64->36|64->36|69->41|69->41|70->42|70->42|71->43|71->43|71->43|71->43|73->45|73->45|73->45|73->45|73->45|75->47|75->47|75->47|75->47|77->49|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|78->50|78->50|79->51|79->51
                    -- GENERATED --
                */
            