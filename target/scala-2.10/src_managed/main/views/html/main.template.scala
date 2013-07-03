
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
                            <li """),_display_(Seq[Any](/*59.34*/if(activeClass.equals("home"))/*59.64*/ {_display_(Seq[Any](format.raw/*59.66*/("""class="active"""")))})),format.raw/*59.81*/("""><a href=""""),_display_(Seq[Any](/*59.92*/routes/*59.98*/.Application.home())),format.raw/*59.117*/("""">Home</a></li>
                            <li """),_display_(Seq[Any](/*60.34*/if(activeClass.equals("myVideos"))/*60.68*/ {_display_(Seq[Any](format.raw/*60.70*/("""class="active"""")))})),format.raw/*60.85*/("""><a href=""""),_display_(Seq[Any](/*60.96*/routes/*60.102*/.Application.myVideos())),format.raw/*60.125*/("""">Videos</a></li>
                            <li """),_display_(Seq[Any](/*61.34*/if(activeClass.equals("myProfile"))/*61.69*/ {_display_(Seq[Any](format.raw/*61.71*/("""class="active"""")))})),format.raw/*61.86*/(""")><a href=""""),_display_(Seq[Any](/*61.98*/routes/*61.104*/.Application.myProfile())),format.raw/*61.128*/("""">Profile</a></li>
                            <li><a href=""""),_display_(Seq[Any](/*62.43*/routes/*62.49*/.Application.logout())),format.raw/*62.70*/("""">Log out</a></li>
                        </ul>
                        
                    </div>
                    <div class="span3" style="height: 30px; line-height: 30px;">
                        """),_display_(Seq[Any](/*67.26*/if(flash.contains("success"))/*67.55*/ {_display_(Seq[Any](_display_(Seq[Any](/*67.58*/flash/*67.63*/.get("success")))))})),format.raw/*67.79*/("""
                        """),_display_(Seq[Any](/*68.26*/if(flash.contains("failure"))/*68.55*/ {_display_(Seq[Any](_display_(Seq[Any](/*68.58*/flash/*68.63*/.get("failure")))))})),format.raw/*68.79*/("""
                    </div>
                """)))}/*70.19*/else/*70.24*/{_display_(Seq[Any](format.raw/*70.25*/("""
                    <div class="span3" style="height: 30px; line-height: 30px;">
                        """),_display_(Seq[Any](/*72.26*/if(flash.contains("success"))/*72.55*/ {_display_(Seq[Any](_display_(Seq[Any](/*72.58*/flash/*72.63*/.get("success")))))})),format.raw/*72.79*/("""
                        """),_display_(Seq[Any](/*73.26*/if(flash.contains("failure"))/*73.55*/ {_display_(Seq[Any](_display_(Seq[Any](/*73.58*/flash/*73.63*/.get("failure")))))})),format.raw/*73.79*/("""
                    </div>
                    <div class="span9 form-horizontal text-right">
                        <form action=""""),_display_(Seq[Any](/*76.40*/routes/*76.46*/.Lobby.postIndex())),format.raw/*76.64*/("""" method="post">
                            <input type="text" class="span3" name="username" placeholder="Username" maxlength=31>
                            <input type="password" class="span3" name="password" placeholder="Password" maxlength=31>
                            <button type="submit" class="btn btn-info">Log in</button>
                            <a class="btn btn-warning" href=""""),_display_(Seq[Any](/*80.63*/routes/*80.69*/.Lobby.getSignup())),format.raw/*80.87*/("""">Sign up</a>
                        </form>
                    </div>
                """)))})),format.raw/*83.18*/("""
            </div>
            
            """),_display_(Seq[Any](/*86.14*/content)),format.raw/*86.21*/("""
            
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
                    DATE: Tue Jul 02 22:27:38 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/main.scala.html
                    HASH: 36593961852964e82420cb4198d9f60da2c39348
                    MATRIX: 732->1|857->49|1554->710|1569->716|1622->747|1700->789|1715->795|1779->837|1857->879|1872->885|1920->911|2017->981|2046->982|2097->1005|2126->1006|2203->1055|2232->1056|2288->1084|2317->1085|2363->1103|2392->1104|2434->1118|2463->1119|2534->1163|2563->1164|2625->1198|2654->1199|2695->1212|2724->1213|2766->1227|2795->1228|2846->1251|2875->1252|2920->1269|2949->1270|2997->1290|3026->1291|3070->1307|3099->1308|3150->1331|3179->1332|3223->1348|3252->1349|3340->1401|3355->1407|3430->1460|3644->1638|3659->1644|3718->1680|3801->1727|3816->1733|3871->1766|3942->1801|3957->1807|4003->1831|4165->1965|4194->1966|4422->2166|4451->2167|5005->2685|5028->2699|5068->2701|5233->2830|5272->2860|5312->2862|5359->2877|5406->2888|5421->2894|5463->2913|5549->2963|5592->2997|5632->2999|5679->3014|5726->3025|5742->3031|5788->3054|5876->3106|5920->3141|5960->3143|6007->3158|6055->3170|6071->3176|6118->3200|6216->3262|6231->3268|6274->3289|6522->3501|6560->3530|6609->3533|6623->3538|6665->3554|6728->3581|6766->3610|6815->3613|6829->3618|6871->3634|6937->3682|6950->3687|6989->3688|7134->3797|7172->3826|7221->3829|7235->3834|7277->3850|7340->3877|7378->3906|7427->3909|7441->3914|7483->3930|7656->4067|7671->4073|7711->4091|8149->4493|8164->4499|8204->4517|8329->4610|8414->4659|8443->4666
                    LINES: 26->1|29->1|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|49->21|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|52->24|52->24|53->25|53->25|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|61->33|61->33|61->33|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|69->41|69->41|71->43|71->43|84->56|84->56|84->56|87->59|87->59|87->59|87->59|87->59|87->59|87->59|88->60|88->60|88->60|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|89->61|89->61|89->61|90->62|90->62|90->62|95->67|95->67|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|98->70|98->70|98->70|100->72|100->72|100->72|100->72|100->72|101->73|101->73|101->73|101->73|101->73|104->76|104->76|104->76|108->80|108->80|108->80|111->83|114->86|114->86
                    -- GENERATED --
                */
            