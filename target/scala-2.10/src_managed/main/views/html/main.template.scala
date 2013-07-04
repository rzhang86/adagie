
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
            .col-wrap"""),format.raw/*28.22*/("""{"""),format.raw/*28.23*/("""overflow: hidden;"""),format.raw/*28.40*/("""}"""),format.raw/*28.41*/("""
            input """),format.raw/*29.19*/("""{"""),format.raw/*29.20*/("""max-width: 100%;"""),format.raw/*29.36*/("""}"""),format.raw/*29.37*/("""
            textarea """),format.raw/*30.22*/("""{"""),format.raw/*30.23*/("""max-width: 100%;"""),format.raw/*30.39*/("""}"""),format.raw/*30.40*/("""
        </style>
        
        <script src=""""),_display_(Seq[Any](/*33.23*/routes/*33.29*/.Assets.at("js/modernizr-2.6.2-respond-1.1.0.min.js"))),format.raw/*33.82*/(""""></script>
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src=""""),_display_(Seq[Any](/*36.64*/routes/*36.70*/.Assets.at("js/jquery-1.9.1.min.js"))),format.raw/*36.106*/(""""><\/script>')</script>
        <script src=""""),_display_(Seq[Any](/*37.23*/routes/*37.29*/.Assets.at("js/bootstrap.min.js"))),format.raw/*37.62*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*38.23*/routes/*38.29*/.Assets.at("js/main.js"))),format.raw/*38.53*/(""""></script>
        <script>
            //var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
            //(function(d,t)"""),format.raw/*41.29*/("""{"""),format.raw/*41.30*/("""var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
            //g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
            //s.parentNode.insertBefore(g,s)"""),format.raw/*43.45*/("""}"""),format.raw/*43.46*/("""(document,'script'));
        </script>
        
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <br><br><br><br>
        <div class="container">
            <div class="row">
                """),_display_(Seq[Any](/*55.18*/if(user!=null)/*55.32*/ {_display_(Seq[Any](format.raw/*55.34*/("""
                    <ul class="nav nav-pills">
                        <li """),_display_(Seq[Any](/*57.30*/if(activeClass.equals("home"))/*57.60*/ {_display_(Seq[Any](format.raw/*57.62*/("""class="active"""")))})),format.raw/*57.77*/("""><a href=""""),_display_(Seq[Any](/*57.88*/routes/*57.94*/.Home.get())),format.raw/*57.105*/("""">Home</a></li>
                        <li """),_display_(Seq[Any](/*58.30*/if(activeClass.equals("profile"))/*58.63*/ {_display_(Seq[Any](format.raw/*58.65*/("""class="active"""")))})),format.raw/*58.80*/(""")><a href=""""),_display_(Seq[Any](/*58.92*/routes/*58.98*/.Profile.get())),format.raw/*58.112*/("""">Profile</a></li>
                        <li """),_display_(Seq[Any](/*59.30*/if(activeClass.equals("uploads"))/*59.63*/ {_display_(Seq[Any](format.raw/*59.65*/("""class="active"""")))})),format.raw/*59.80*/("""><a href=""""),_display_(Seq[Any](/*59.91*/routes/*59.97*/.Uploads.get())),format.raw/*59.111*/("""">Uploads</a></li>
                        <li """),_display_(Seq[Any](/*60.30*/if(activeClass.equals("accounts"))/*60.64*/ {_display_(Seq[Any](format.raw/*60.66*/("""class="active"""")))})),format.raw/*60.81*/(""")><a href=""""),_display_(Seq[Any](/*60.93*/routes/*60.99*/.Accounts.get())),format.raw/*60.114*/("""">Accounts</a></li>
                        <li """),_display_(Seq[Any](/*61.30*/if(activeClass.equals("notifications"))/*61.69*/ {_display_(Seq[Any](format.raw/*61.71*/("""class="active"""")))})),format.raw/*61.86*/(""")><a href=""""),_display_(Seq[Any](/*61.98*/routes/*61.104*/.Notifications.get())),format.raw/*61.124*/("""">Notifications</a></li>
                        <li><a href=""""),_display_(Seq[Any](/*62.39*/routes/*62.45*/.Logout.get())),format.raw/*62.58*/("""">Log out</a></li>
                    </ul>
                """)))}/*64.19*/else/*64.24*/{_display_(Seq[Any](format.raw/*64.25*/("""
                    <div class="form-horizontal text-right">
                        <form action=""""),_display_(Seq[Any](/*66.40*/routes/*66.46*/.Login.post())),format.raw/*66.59*/("""" method="post">
                            <input type="text" class="span3" name="username" placeholder="Username" maxlength=31>
                            <input type="password" class="span3" name="password" placeholder="Password" maxlength=31>
                            <button type="submit" class="btn btn-info">Log in</button>
                            <a class="btn btn-warning" href=""""),_display_(Seq[Any](/*70.63*/routes/*70.69*/.Signup.get())),format.raw/*70.82*/("""">Sign up</a>
                        </form>
                    </div>
                """)))})),format.raw/*73.18*/("""
            </div>
            <div class="row">
                <div class="span12">
                    """),_display_(Seq[Any](/*77.22*/if(flash.contains("success"))/*77.51*/ {_display_(Seq[Any](_display_(Seq[Any](/*77.54*/flash/*77.59*/.get("success")))))})),format.raw/*77.75*/("""
                    """),_display_(Seq[Any](/*78.22*/if(flash.contains("failure"))/*78.51*/ {_display_(Seq[Any](_display_(Seq[Any](/*78.54*/flash/*78.59*/.get("failure")))))})),format.raw/*78.75*/("""
                </div>
            </div>
            """),_display_(Seq[Any](/*81.14*/content)),format.raw/*81.21*/("""
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
                    DATE: Wed Jul 03 21:46:54 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/main.scala.html
                    HASH: f71b398ebe844d74d8547b9358c8299d5e3df7c5
                    MATRIX: 732->1|857->49|1554->710|1569->716|1622->747|1700->789|1715->795|1779->837|1857->879|1872->885|1920->911|2017->981|2046->982|2097->1005|2126->1006|2203->1055|2232->1056|2288->1084|2317->1085|2363->1103|2392->1104|2434->1118|2463->1119|2534->1163|2563->1164|2625->1198|2654->1199|2695->1212|2724->1213|2766->1227|2795->1228|2846->1251|2875->1252|2920->1269|2949->1270|2997->1290|3026->1291|3070->1307|3099->1308|3150->1331|3179->1332|3223->1348|3252->1349|3340->1401|3355->1407|3430->1460|3644->1638|3659->1644|3718->1680|3801->1727|3816->1733|3871->1766|3942->1801|3957->1807|4003->1831|4165->1965|4194->1966|4422->2166|4451->2167|5003->2683|5026->2697|5066->2699|5181->2778|5220->2808|5260->2810|5307->2825|5354->2836|5369->2842|5403->2853|5485->2899|5527->2932|5567->2934|5614->2949|5662->2961|5677->2967|5714->2981|5799->3030|5841->3063|5881->3065|5928->3080|5975->3091|5990->3097|6027->3111|6112->3160|6155->3194|6195->3196|6242->3211|6290->3223|6305->3229|6343->3244|6429->3294|6477->3333|6517->3335|6564->3350|6612->3362|6628->3368|6671->3388|6771->3452|6786->3458|6821->3471|6904->3536|6917->3541|6956->3542|7095->3645|7110->3651|7145->3664|7583->4066|7598->4072|7633->4085|7758->4178|7906->4290|7944->4319|7993->4322|8007->4327|8049->4343|8108->4366|8146->4395|8195->4398|8209->4403|8251->4419|8346->4478|8375->4485
                    LINES: 26->1|29->1|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|49->21|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|52->24|52->24|53->25|53->25|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|61->33|61->33|61->33|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|69->41|69->41|71->43|71->43|83->55|83->55|83->55|85->57|85->57|85->57|85->57|85->57|85->57|85->57|86->58|86->58|86->58|86->58|86->58|86->58|86->58|87->59|87->59|87->59|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|89->61|89->61|89->61|90->62|90->62|90->62|92->64|92->64|92->64|94->66|94->66|94->66|98->70|98->70|98->70|101->73|105->77|105->77|105->77|105->77|105->77|106->78|106->78|106->78|106->78|106->78|109->81|109->81
                    -- GENERATED --
                */
            