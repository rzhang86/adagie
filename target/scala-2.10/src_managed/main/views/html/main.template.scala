
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
            .nonform-height """),format.raw/*33.29*/("""{"""),format.raw/*33.30*/("""height: 40px;"""),format.raw/*33.43*/("""}"""),format.raw/*33.44*/("""
        </style>
        
        <script src=""""),_display_(Seq[Any](/*36.23*/routes/*36.29*/.Assets.at("js/modernizr-2.6.2-respond-1.1.0.min.js"))),format.raw/*36.82*/(""""></script>
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src=""""),_display_(Seq[Any](/*39.64*/routes/*39.70*/.Assets.at("js/jquery-1.9.1.min.js"))),format.raw/*39.106*/(""""><\/script>')</script>
        <script src=""""),_display_(Seq[Any](/*40.23*/routes/*40.29*/.Assets.at("js/bootstrap.min.js"))),format.raw/*40.62*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*41.23*/routes/*41.29*/.Assets.at("js/main.js"))),format.raw/*41.53*/(""""></script>
        <script>
            //var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
            //(function(d,t)"""),format.raw/*44.29*/("""{"""),format.raw/*44.30*/("""var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
            //g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
            //s.parentNode.insertBefore(g,s)"""),format.raw/*46.45*/("""}"""),format.raw/*46.46*/("""(document,'script'));
        </script>
        
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <br><br><br><br>
        <div class="container">
            <div class="row">
                """),_display_(Seq[Any](/*58.18*/if(user!=null)/*58.32*/ {_display_(Seq[Any](format.raw/*58.34*/("""
                    <ul class="nav nav-pills">
                        <li """),_display_(Seq[Any](/*60.30*/if(activeClass.equals("home"))/*60.60*/ {_display_(Seq[Any](format.raw/*60.62*/("""class="active"""")))})),format.raw/*60.77*/("""><a href=""""),_display_(Seq[Any](/*60.88*/routes/*60.94*/.Home.get())),format.raw/*60.105*/("""">Home</a></li>
                        <li """),_display_(Seq[Any](/*61.30*/if(activeClass.equals("profile"))/*61.63*/ {_display_(Seq[Any](format.raw/*61.65*/("""class="active"""")))})),format.raw/*61.80*/(""")><a href=""""),_display_(Seq[Any](/*61.92*/routes/*61.98*/.Profile.get())),format.raw/*61.112*/("""">Profile</a></li>
                        <li """),_display_(Seq[Any](/*62.30*/if(activeClass.equals("uploads"))/*62.63*/ {_display_(Seq[Any](format.raw/*62.65*/("""class="active"""")))})),format.raw/*62.80*/("""><a href=""""),_display_(Seq[Any](/*62.91*/routes/*62.97*/.Uploads.get())),format.raw/*62.111*/("""">Uploads</a></li>
                        <li """),_display_(Seq[Any](/*63.30*/if(activeClass.equals("accounts"))/*63.64*/ {_display_(Seq[Any](format.raw/*63.66*/("""class="active"""")))})),format.raw/*63.81*/(""")><a href=""""),_display_(Seq[Any](/*63.93*/routes/*63.99*/.Accounts.get())),format.raw/*63.114*/("""">Accounts</a></li>
                        <li """),_display_(Seq[Any](/*64.30*/if(activeClass.equals("notifications"))/*64.69*/ {_display_(Seq[Any](format.raw/*64.71*/("""class="active"""")))})),format.raw/*64.86*/(""")><a href=""""),_display_(Seq[Any](/*64.98*/routes/*64.104*/.Notifications.get())),format.raw/*64.124*/("""">Notifications</a></li>
                        <li><a href=""""),_display_(Seq[Any](/*65.39*/routes/*65.45*/.Logout.get())),format.raw/*65.58*/("""">Log out</a></li>
                    </ul>
                """)))}/*67.19*/else/*67.24*/{_display_(Seq[Any](format.raw/*67.25*/("""
                    <div class="form-horizontal text-right">
                        <form action=""""),_display_(Seq[Any](/*69.40*/routes/*69.46*/.Login.post())),format.raw/*69.59*/("""" method="post">
                            <input type="text" class="span4" name="email" placeholder="Email address" maxlength=63>
                            <input type="password" class="span3" name="password" placeholder="Password" maxlength=31>
                            <button type="submit" class="btn btn-info">Log in</button>
                            <a class="btn btn-warning" href=""""),_display_(Seq[Any](/*73.63*/routes/*73.69*/.Signup.get())),format.raw/*73.82*/("""">Sign up</a>
                        </form>
                    </div>
                """)))})),format.raw/*76.18*/("""
            </div>
            <div class="row">
                <div class="span12">
                    """),_display_(Seq[Any](/*80.22*/if(flash.contains("success"))/*80.51*/ {_display_(Seq[Any](_display_(Seq[Any](/*80.54*/flash/*80.59*/.get("success")))))})),format.raw/*80.75*/("""
                    """),_display_(Seq[Any](/*81.22*/if(flash.contains("failure"))/*81.51*/ {_display_(Seq[Any](_display_(Seq[Any](/*81.54*/flash/*81.59*/.get("failure")))))})),format.raw/*81.75*/("""
                </div>
            </div>
            """),_display_(Seq[Any](/*84.14*/content)),format.raw/*84.21*/("""
            <div class="footer">
                <p>by Ray</p>
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
                    DATE: Thu Jul 04 14:04:33 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/main.scala.html
                    HASH: c4a8179017cee09698c6f9283fd47af5e9fe2498
                    MATRIX: 732->1|857->49|1554->710|1569->716|1622->747|1700->789|1715->795|1779->837|1857->879|1872->885|1920->911|2017->981|2046->982|2097->1005|2126->1006|2203->1055|2232->1056|2288->1084|2317->1085|2363->1103|2392->1104|2434->1118|2463->1119|2534->1163|2563->1164|2625->1198|2654->1199|2695->1212|2724->1213|2766->1227|2795->1228|2847->1252|2876->1253|2921->1270|2950->1271|2998->1291|3027->1292|3071->1308|3100->1309|3151->1332|3180->1333|3224->1349|3253->1350|3322->1391|3351->1392|3392->1405|3421->1406|3479->1436|3508->1437|3549->1450|3578->1451|3666->1503|3681->1509|3756->1562|3970->1740|3985->1746|4044->1782|4127->1829|4142->1835|4197->1868|4268->1903|4283->1909|4329->1933|4491->2067|4520->2068|4748->2268|4777->2269|5329->2785|5352->2799|5392->2801|5507->2880|5546->2910|5586->2912|5633->2927|5680->2938|5695->2944|5729->2955|5811->3001|5853->3034|5893->3036|5940->3051|5988->3063|6003->3069|6040->3083|6125->3132|6167->3165|6207->3167|6254->3182|6301->3193|6316->3199|6353->3213|6438->3262|6481->3296|6521->3298|6568->3313|6616->3325|6631->3331|6669->3346|6755->3396|6803->3435|6843->3437|6890->3452|6938->3464|6954->3470|6997->3490|7097->3554|7112->3560|7147->3573|7230->3638|7243->3643|7282->3644|7421->3747|7436->3753|7471->3766|7911->4170|7926->4176|7961->4189|8086->4282|8234->4394|8272->4423|8321->4426|8335->4431|8377->4447|8436->4470|8474->4499|8523->4502|8537->4507|8579->4523|8674->4582|8703->4589
                    LINES: 26->1|29->1|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|49->21|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|52->24|52->24|53->25|53->25|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|60->32|60->32|60->32|60->32|61->33|61->33|61->33|61->33|64->36|64->36|64->36|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|72->44|72->44|74->46|74->46|86->58|86->58|86->58|88->60|88->60|88->60|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|92->64|92->64|92->64|93->65|93->65|93->65|95->67|95->67|95->67|97->69|97->69|97->69|101->73|101->73|101->73|104->76|108->80|108->80|108->80|108->80|108->80|109->81|109->81|109->81|109->81|109->81|112->84|112->84
                    -- GENERATED --
                */
            