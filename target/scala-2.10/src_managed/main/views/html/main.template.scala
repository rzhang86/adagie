
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
                """),_display_(Seq[Any](/*56.18*/if(user!=null)/*56.32*/ {_display_(Seq[Any](format.raw/*56.34*/("""
                    <div class="span9">
                        <ul class="nav nav-pills ">
                            <li """),_display_(Seq[Any](/*59.34*/if(activeClass.equals("home"))/*59.64*/ {_display_(Seq[Any](format.raw/*59.66*/("""class="active"""")))})),format.raw/*59.81*/("""><a href=""""),_display_(Seq[Any](/*59.92*/routes/*59.98*/.Home.get())),format.raw/*59.109*/("""">Home</a></li>
                            <li """),_display_(Seq[Any](/*60.34*/if(activeClass.equals("profile"))/*60.67*/ {_display_(Seq[Any](format.raw/*60.69*/("""class="active"""")))})),format.raw/*60.84*/(""")><a href=""""),_display_(Seq[Any](/*60.96*/routes/*60.102*/.Profile.get())),format.raw/*60.116*/("""">Profile</a></li>
                            <li """),_display_(Seq[Any](/*61.34*/if(activeClass.equals("uploads"))/*61.67*/ {_display_(Seq[Any](format.raw/*61.69*/("""class="active"""")))})),format.raw/*61.84*/("""><a href=""""),_display_(Seq[Any](/*61.95*/routes/*61.101*/.Uploads.get())),format.raw/*61.115*/("""">Uploads</a></li>
                            <li """),_display_(Seq[Any](/*62.34*/if(activeClass.equals("accounts"))/*62.68*/ {_display_(Seq[Any](format.raw/*62.70*/("""class="active"""")))})),format.raw/*62.85*/(""")><a href=""""),_display_(Seq[Any](/*62.97*/routes/*62.103*/.Accounts.get())),format.raw/*62.118*/("""">Accounts</a></li>
                            <li """),_display_(Seq[Any](/*63.34*/if(activeClass.equals("notifications"))/*63.73*/ {_display_(Seq[Any](format.raw/*63.75*/("""class="active"""")))})),format.raw/*63.90*/(""")><a href=""""),_display_(Seq[Any](/*63.102*/routes/*63.108*/.Notifications.get())),format.raw/*63.128*/("""">Notifications</a></li>
                            <li><a href=""""),_display_(Seq[Any](/*64.43*/routes/*64.49*/.Logout.get())),format.raw/*64.62*/("""">Log out</a></li>
                        </ul>
                        
                    </div>
                    <div class="span3" style="height: 30px; line-height: 30px;">
                        """),_display_(Seq[Any](/*69.26*/if(flash.contains("success"))/*69.55*/ {_display_(Seq[Any](_display_(Seq[Any](/*69.58*/flash/*69.63*/.get("success")))))})),format.raw/*69.79*/("""
                        """),_display_(Seq[Any](/*70.26*/if(flash.contains("failure"))/*70.55*/ {_display_(Seq[Any](_display_(Seq[Any](/*70.58*/flash/*70.63*/.get("failure")))))})),format.raw/*70.79*/("""
                    </div>
                """)))}/*72.19*/else/*72.24*/{_display_(Seq[Any](format.raw/*72.25*/("""
                    <div class="span3" style="height: 30px; line-height: 30px;">
                        """),_display_(Seq[Any](/*74.26*/if(flash.contains("success"))/*74.55*/ {_display_(Seq[Any](_display_(Seq[Any](/*74.58*/flash/*74.63*/.get("success")))))})),format.raw/*74.79*/("""
                        """),_display_(Seq[Any](/*75.26*/if(flash.contains("failure"))/*75.55*/ {_display_(Seq[Any](_display_(Seq[Any](/*75.58*/flash/*75.63*/.get("failure")))))})),format.raw/*75.79*/("""
                    </div>
                    <div class="span9 form-horizontal text-right">
                        <form action=""""),_display_(Seq[Any](/*78.40*/routes/*78.46*/.Login.post())),format.raw/*78.59*/("""" method="post">
                            <input type="text" class="span3" name="username" placeholder="Username" maxlength=31>
                            <input type="password" class="span3" name="password" placeholder="Password" maxlength=31>
                            <button type="submit" class="btn btn-info">Log in</button>
                            <a class="btn btn-warning" href=""""),_display_(Seq[Any](/*82.63*/routes/*82.69*/.Signup.get())),format.raw/*82.82*/("""">Sign up</a>
                        </form>
                    </div>
                """)))})),format.raw/*85.18*/("""
            </div>
            
            """),_display_(Seq[Any](/*88.14*/content)),format.raw/*88.21*/("""
            
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
                    DATE: Wed Jul 03 12:11:59 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/main.scala.html
                    HASH: c17bb8deb03f43b36edf62d98ce7f0a0bcacf488
                    MATRIX: 732->1|857->49|1554->710|1569->716|1622->747|1700->789|1715->795|1779->837|1857->879|1872->885|1920->911|2017->981|2046->982|2097->1005|2126->1006|2203->1055|2232->1056|2288->1084|2317->1085|2363->1103|2392->1104|2434->1118|2463->1119|2534->1163|2563->1164|2625->1198|2654->1199|2695->1212|2724->1213|2766->1227|2795->1228|2846->1251|2875->1252|2920->1269|2949->1270|2997->1290|3026->1291|3070->1307|3099->1308|3150->1331|3179->1332|3223->1348|3252->1349|3340->1401|3355->1407|3430->1460|3644->1638|3659->1644|3718->1680|3801->1727|3816->1733|3871->1766|3942->1801|3957->1807|4003->1831|4165->1965|4194->1966|4422->2166|4451->2167|5005->2685|5028->2699|5068->2701|5233->2830|5272->2860|5312->2862|5359->2877|5406->2888|5421->2894|5455->2905|5541->2955|5583->2988|5623->2990|5670->3005|5718->3017|5734->3023|5771->3037|5860->3090|5902->3123|5942->3125|5989->3140|6036->3151|6052->3157|6089->3171|6178->3224|6221->3258|6261->3260|6308->3275|6356->3287|6372->3293|6410->3308|6500->3362|6548->3401|6588->3403|6635->3418|6684->3430|6700->3436|6743->3456|6847->3524|6862->3530|6897->3543|7145->3755|7183->3784|7232->3787|7246->3792|7288->3808|7351->3835|7389->3864|7438->3867|7452->3872|7494->3888|7560->3936|7573->3941|7612->3942|7757->4051|7795->4080|7844->4083|7858->4088|7900->4104|7963->4131|8001->4160|8050->4163|8064->4168|8106->4184|8279->4321|8294->4327|8329->4340|8767->4742|8782->4748|8817->4761|8942->4854|9027->4903|9056->4910
                    LINES: 26->1|29->1|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|49->21|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|52->24|52->24|53->25|53->25|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|61->33|61->33|61->33|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|69->41|69->41|71->43|71->43|84->56|84->56|84->56|87->59|87->59|87->59|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|92->64|92->64|92->64|97->69|97->69|97->69|97->69|97->69|98->70|98->70|98->70|98->70|98->70|100->72|100->72|100->72|102->74|102->74|102->74|102->74|102->74|103->75|103->75|103->75|103->75|103->75|106->78|106->78|106->78|110->82|110->82|110->82|113->85|116->88|116->88
                    -- GENERATED --
                */
            