
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[User,String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, activeClass: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.50*/("""

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Adagie</title>
        <meta name="author" content="Ray">
        <meta name="description" content="Adder">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href=""""),_display_(Seq[Any](/*16.39*/routes/*16.45*/.Assets.at("css/bootstrap.css"))),format.raw/*16.76*/("""">
        <link rel="stylesheet" href=""""),_display_(Seq[Any](/*17.39*/routes/*17.45*/.Assets.at("css/bootstrap-responsive.css"))),format.raw/*17.87*/("""">
        <link rel="stylesheet" href=""""),_display_(Seq[Any](/*18.39*/routes/*18.45*/.Assets.at("css/main.css"))),format.raw/*18.71*/("""">
        
        <style>
            @media (min-width: 768px) """),format.raw/*21.40*/("""{"""),format.raw/*21.41*/("""
                .col """),format.raw/*22.22*/("""{"""),format.raw/*22.23*/("""margin-bottom: -99999px; padding-bottom: 99999px;"""),format.raw/*22.72*/("""}"""),format.raw/*22.73*/("""
                .col-base """),format.raw/*23.27*/("""{"""),format.raw/*23.28*/("""margin-top: -15px;"""),format.raw/*23.46*/("""}"""),format.raw/*23.47*/("""
            """),format.raw/*24.13*/("""}"""),format.raw/*24.14*/("""   
            @media (max-width: 767px) """),format.raw/*25.40*/("""{"""),format.raw/*25.41*/("""
                .row-fluid.base """),format.raw/*26.33*/("""{"""),format.raw/*26.34*/("""display:none;"""),format.raw/*26.47*/("""}"""),format.raw/*26.48*/("""
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/("""
            .col-wrap """),format.raw/*28.23*/("""{"""),format.raw/*28.24*/("""overflow: hidden;"""),format.raw/*28.41*/("""}"""),format.raw/*28.42*/("""
            input """),format.raw/*29.19*/("""{"""),format.raw/*29.20*/("""max-width: 100%;"""),format.raw/*29.36*/("""}"""),format.raw/*29.37*/("""
            textarea """),format.raw/*30.22*/("""{"""),format.raw/*30.23*/("""max-width: 100%;"""),format.raw/*30.39*/("""}"""),format.raw/*30.40*/("""
            
            .nonform-div """),format.raw/*32.26*/("""{"""),format.raw/*32.27*/("""height: 40px;"""),format.raw/*32.40*/("""}"""),format.raw/*32.41*/("""
            .form-div """),format.raw/*33.23*/("""{"""),format.raw/*33.24*/("""height: 40px;"""),format.raw/*33.37*/("""}"""),format.raw/*33.38*/("""
            .nonpassword-div """),format.raw/*34.30*/("""{"""),format.raw/*34.31*/("""height: 40px;"""),format.raw/*34.44*/("""}"""),format.raw/*34.45*/("""
            .password-div """),format.raw/*35.27*/("""{"""),format.raw/*35.28*/("""height: 40px;"""),format.raw/*35.41*/("""}"""),format.raw/*35.42*/("""
            .nonform-height """),format.raw/*36.29*/("""{"""),format.raw/*36.30*/("""height: 40px;"""),format.raw/*36.43*/("""}"""),format.raw/*36.44*/("""
            .nonform-height2 """),format.raw/*37.30*/("""{"""),format.raw/*37.31*/("""height: 30px;"""),format.raw/*37.44*/("""}"""),format.raw/*37.45*/("""
        </style>
        
        <script src=""""),_display_(Seq[Any](/*40.23*/routes/*40.29*/.Assets.at("js/modernizr-2.6.2-respond-1.1.0.min.js"))),format.raw/*40.82*/(""""></script>
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src=""""),_display_(Seq[Any](/*43.64*/routes/*43.70*/.Assets.at("js/jquery-1.9.1.min.js"))),format.raw/*43.106*/(""""><\/script>')</script>
        <script src=""""),_display_(Seq[Any](/*44.23*/routes/*44.29*/.Assets.at("js/bootstrap.min.js"))),format.raw/*44.62*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*45.23*/routes/*45.29*/.Assets.at("js/main.js"))),format.raw/*45.53*/(""""></script>
        <script>
            //var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
            //(function(d,t)"""),format.raw/*48.29*/("""{"""),format.raw/*48.30*/("""var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
            //g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
            //s.parentNode.insertBefore(g,s)"""),format.raw/*50.45*/("""}"""),format.raw/*50.46*/("""(document,'script'));
        </script>
        
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <br><br><br><br>
        <div class="container">
            <div class="row">
                """),_display_(Seq[Any](/*62.18*/if(user!=null)/*62.32*/ {_display_(Seq[Any](format.raw/*62.34*/("""
                    <ul class="nav nav-pills">
                        <li """),_display_(Seq[Any](/*64.30*/if(activeClass.equals("home"))/*64.60*/ {_display_(Seq[Any](format.raw/*64.62*/("""class="active"""")))})),format.raw/*64.77*/("""><a href=""""),_display_(Seq[Any](/*64.88*/routes/*64.94*/.Home.get())),format.raw/*64.105*/("""">Home</a></li>
                        <li """),_display_(Seq[Any](/*65.30*/if(activeClass.equals("profile"))/*65.63*/ {_display_(Seq[Any](format.raw/*65.65*/("""class="active"""")))})),format.raw/*65.80*/(""")><a href=""""),_display_(Seq[Any](/*65.92*/routes/*65.98*/.Profile.get())),format.raw/*65.112*/("""">Profile</a></li>
                        <li """),_display_(Seq[Any](/*66.30*/if(activeClass.equals("uploads"))/*66.63*/ {_display_(Seq[Any](format.raw/*66.65*/("""class="active"""")))})),format.raw/*66.80*/("""><a href=""""),_display_(Seq[Any](/*66.91*/routes/*66.97*/.Uploads.get())),format.raw/*66.111*/("""">Uploads</a></li>
                        <li """),_display_(Seq[Any](/*67.30*/if(activeClass.equals("accounts"))/*67.64*/ {_display_(Seq[Any](format.raw/*67.66*/("""class="active"""")))})),format.raw/*67.81*/(""")><a href=""""),_display_(Seq[Any](/*67.93*/routes/*67.99*/.Accounts.get())),format.raw/*67.114*/("""">Accounts</a></li>
                        <li """),_display_(Seq[Any](/*68.30*/if(activeClass.equals("notifications"))/*68.69*/ {_display_(Seq[Any](format.raw/*68.71*/("""class="active"""")))})),format.raw/*68.86*/(""")><a href=""""),_display_(Seq[Any](/*68.98*/routes/*68.104*/.Notifications.get())),format.raw/*68.124*/("""">Notifications</a></li>
                        <li><a href=""""),_display_(Seq[Any](/*69.39*/routes/*69.45*/.Logout.get())),format.raw/*69.58*/("""">Log out</a></li>
                    </ul>
                """)))}/*71.19*/else/*71.24*/{_display_(Seq[Any](format.raw/*71.25*/("""
                    <ul class="nav nav-pills">
                        <li """),_display_(Seq[Any](/*73.30*/if(activeClass.equals("login"))/*73.61*/ {_display_(Seq[Any](format.raw/*73.63*/("""class="active"""")))})),format.raw/*73.78*/("""><a href=""""),_display_(Seq[Any](/*73.89*/routes/*73.95*/.Login.get())),format.raw/*73.107*/("""">Login</a></li>
                        <li """),_display_(Seq[Any](/*74.30*/if(activeClass.equals("signup"))/*74.62*/ {_display_(Seq[Any](format.raw/*74.64*/("""class="active"""")))})),format.raw/*74.79*/(""")><a href=""""),_display_(Seq[Any](/*74.91*/routes/*74.97*/.Signup.get())),format.raw/*74.110*/("""">Signup</a></li>
                        <li """),_display_(Seq[Any](/*75.30*/if(activeClass.equals("about"))/*75.61*/ {_display_(Seq[Any](format.raw/*75.63*/("""class="active"""")))})),format.raw/*75.78*/(""")><a href=""""),_display_(Seq[Any](/*75.90*/routes/*75.96*/.About.get())),format.raw/*75.108*/("""">About</a></li>
                        <li """),_display_(Seq[Any](/*76.30*/if(activeClass.equals("faq"))/*76.59*/ {_display_(Seq[Any](format.raw/*76.61*/("""class="active"""")))})),format.raw/*76.76*/(""")><a href=""""),_display_(Seq[Any](/*76.88*/routes/*76.94*/.Faq.get())),format.raw/*76.104*/("""">FAQ</a></li>
                        <li """),_display_(Seq[Any](/*77.30*/if(activeClass.equals("contact"))/*77.63*/ {_display_(Seq[Any](format.raw/*77.65*/("""class="active"""")))})),format.raw/*77.80*/(""")><a href=""""),_display_(Seq[Any](/*77.92*/routes/*77.98*/.Contact.get())),format.raw/*77.112*/("""">Contact</a></li>
                    </ul>
                """)))})),format.raw/*79.18*/("""
            </div>
            """),_display_(Seq[Any](/*81.14*/content)),format.raw/*81.21*/("""
            <div class="footer">
                <p>by Ray</p>
                <p>
                    """),_display_(Seq[Any](/*85.22*/if(flash.contains("success"))/*85.51*/ {_display_(Seq[Any](_display_(Seq[Any](/*85.54*/flash/*85.59*/.get("success")))))})),format.raw/*85.75*/("""
                    """),_display_(Seq[Any](/*86.22*/if(flash.contains("failure"))/*86.51*/ {_display_(Seq[Any](_display_(Seq[Any](/*86.54*/flash/*86.59*/.get("failure")))))})),format.raw/*86.75*/("""
                </p>
            </div>      
        </div>
        
        <!-- /container -->

    </body>
</html>
"""))}
    }
    
    def render(user:User,activeClass:String,content:Html): play.api.templates.Html = apply(user,activeClass)(content)
    
    def f:((User,String) => (Html) => play.api.templates.Html) = (user,activeClass) => (content) => apply(user,activeClass)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 06 15:53:35 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/main.scala.html
                    HASH: eb82b1bb7e6846a8bce46e675cdf8ea18daadc1c
                    MATRIX: 732->1|857->49|1554->710|1569->716|1622->747|1700->789|1715->795|1779->837|1857->879|1872->885|1920->911|2017->981|2046->982|2097->1005|2126->1006|2203->1055|2232->1056|2288->1084|2317->1085|2363->1103|2392->1104|2434->1118|2463->1119|2534->1163|2563->1164|2625->1198|2654->1199|2695->1212|2724->1213|2766->1227|2795->1228|2847->1252|2876->1253|2921->1270|2950->1271|2998->1291|3027->1292|3071->1308|3100->1309|3151->1332|3180->1333|3224->1349|3253->1350|3322->1391|3351->1392|3392->1405|3421->1406|3473->1430|3502->1431|3543->1444|3572->1445|3631->1476|3660->1477|3701->1490|3730->1491|3786->1519|3815->1520|3856->1533|3885->1534|3943->1564|3972->1565|4013->1578|4042->1579|4101->1610|4130->1611|4171->1624|4200->1625|4288->1677|4303->1683|4378->1736|4592->1914|4607->1920|4666->1956|4749->2003|4764->2009|4819->2042|4890->2077|4905->2083|4951->2107|5113->2241|5142->2242|5370->2442|5399->2443|5951->2959|5974->2973|6014->2975|6129->3054|6168->3084|6208->3086|6255->3101|6302->3112|6317->3118|6351->3129|6433->3175|6475->3208|6515->3210|6562->3225|6610->3237|6625->3243|6662->3257|6747->3306|6789->3339|6829->3341|6876->3356|6923->3367|6938->3373|6975->3387|7060->3436|7103->3470|7143->3472|7190->3487|7238->3499|7253->3505|7291->3520|7377->3570|7425->3609|7465->3611|7512->3626|7560->3638|7576->3644|7619->3664|7719->3728|7734->3734|7769->3747|7852->3812|7865->3817|7904->3818|8019->3897|8059->3928|8099->3930|8146->3945|8193->3956|8208->3962|8243->3974|8326->4021|8367->4053|8407->4055|8454->4070|8502->4082|8517->4088|8553->4101|8637->4149|8677->4180|8717->4182|8764->4197|8812->4209|8827->4215|8862->4227|8945->4274|8983->4303|9023->4305|9070->4320|9118->4332|9133->4338|9166->4348|9247->4393|9289->4426|9329->4428|9376->4443|9424->4455|9439->4461|9476->4475|9572->4539|9643->4574|9672->4581|9817->4690|9855->4719|9904->4722|9918->4727|9960->4743|10019->4766|10057->4795|10106->4798|10120->4803|10162->4819
                    LINES: 26->1|29->1|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|49->21|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|52->24|52->24|53->25|53->25|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|60->32|60->32|60->32|60->32|61->33|61->33|61->33|61->33|62->34|62->34|62->34|62->34|63->35|63->35|63->35|63->35|64->36|64->36|64->36|64->36|65->37|65->37|65->37|65->37|68->40|68->40|68->40|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45|76->48|76->48|78->50|78->50|90->62|90->62|90->62|92->64|92->64|92->64|92->64|92->64|92->64|92->64|93->65|93->65|93->65|93->65|93->65|93->65|93->65|94->66|94->66|94->66|94->66|94->66|94->66|94->66|95->67|95->67|95->67|95->67|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|97->69|97->69|97->69|99->71|99->71|99->71|101->73|101->73|101->73|101->73|101->73|101->73|101->73|102->74|102->74|102->74|102->74|102->74|102->74|102->74|103->75|103->75|103->75|103->75|103->75|103->75|103->75|104->76|104->76|104->76|104->76|104->76|104->76|104->76|105->77|105->77|105->77|105->77|105->77|105->77|105->77|107->79|109->81|109->81|113->85|113->85|113->85|113->85|113->85|114->86|114->86|114->86|114->86|114->86
                    -- GENERATED --
                */
            