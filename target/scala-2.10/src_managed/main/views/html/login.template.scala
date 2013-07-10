
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
                        <div class="row"><div class="span4"><input type="text" class="span4" id="email" name="email" placeholder="Email address" value=""""),_display_(Seq[Any](/*10.154*/form("email")/*10.167*/.value)),format.raw/*10.173*/("""" pattern="."""),format.raw/*10.185*/("""{"""),format.raw/*10.186*/("""1,63"""),format.raw/*10.190*/("""}"""),format.raw/*10.191*/("""" maxlength="63"required></div></div>
                    </div>
                    <div class="span6">
                        <div class="row nonform-height2"><div class="span7">Password:</div></div>
                        <div class="row password-div">
                            <div class="span3"><input type="password" class="span3" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*15.148*/("""{"""),format.raw/*15.149*/("""6,31"""),format.raw/*15.153*/("""}"""),format.raw/*15.154*/("""" maxlength="31" required></div>
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
        
        $('#email').tooltip("""),format.raw/*53.29*/("""{"""),format.raw/*53.30*/("""placement: "bottom", animation: false, title: "Required. 1-63 characters.""""),format.raw/*53.104*/("""}"""),format.raw/*53.105*/(""")
        $('#password').tooltip("""),format.raw/*54.32*/("""{"""),format.raw/*54.33*/("""placement: "bottom", animation: false, title: "Required. 6-31 characters.""""),format.raw/*54.107*/("""}"""),format.raw/*54.108*/(""")
    </script>
""")))})))}
    }
    
    def render(form:Form[Login.LoginForm]): play.api.templates.Html = apply(form)
    
    def f:((Form[Login.LoginForm]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jul 09 23:19:30 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/login.scala.html
                    HASH: 0abe386f31649ad6faa0e620a84bdfd44984c0a8
                    MATRIX: 738->1|844->30|883->35|910->54|949->56|1068->140|1082->146|1116->159|1504->510|1527->523|1556->529|1597->541|1627->542|1660->546|1690->547|2129->957|2159->958|2192->962|2222->963|3112->1825|3141->1826|3222->1879|3251->1880|3491->2092|3520->2093|3567->2112|3596->2113|3833->2322|3862->2323|3899->2333|3928->2334|3977->2347|4022->2383|4062->2385|4121->2412|4189->2444|4204->2450|4254->2478|4300->2496|4329->2497|4434->2574|4463->2575|4511->2595|4540->2596|4626->2654|4655->2655|4710->2682|4739->2683|4803->2719|4832->2720|4905->2765|4934->2766|4985->2788|5015->2789|5045->2790|5084->2802|5113->2803|5183->2845|5212->2846|5315->2920|5345->2921|5407->2955|5436->2956|5539->3030|5569->3031
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|38->10|38->10|38->10|38->10|38->10|38->10|38->10|43->15|43->15|43->15|43->15|57->29|57->29|58->30|58->30|63->35|63->35|64->36|64->36|69->41|69->41|70->42|70->42|71->43|71->43|71->43|71->43|73->45|73->45|73->45|73->45|73->45|75->47|75->47|75->47|75->47|77->49|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|78->50|78->50|79->51|79->51|81->53|81->53|81->53|81->53|82->54|82->54|82->54|82->54
                    -- GENERATED --
                */
            