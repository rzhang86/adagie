
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
            .nonform-height2 """),format.raw/*34.30*/("""{"""),format.raw/*34.31*/("""height: 30px;"""),format.raw/*34.44*/("""}"""),format.raw/*34.45*/("""
        </style>
        
        <script src=""""),_display_(Seq[Any](/*37.23*/routes/*37.29*/.Assets.at("js/modernizr-2.6.2-respond-1.1.0.min.js"))),format.raw/*37.82*/(""""></script>
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src=""""),_display_(Seq[Any](/*40.64*/routes/*40.70*/.Assets.at("js/jquery-1.9.1.min.js"))),format.raw/*40.106*/(""""><\/script>')</script>
        <script src=""""),_display_(Seq[Any](/*41.23*/routes/*41.29*/.Assets.at("js/bootstrap.min.js"))),format.raw/*41.62*/(""""></script>
        <script src=""""),_display_(Seq[Any](/*42.23*/routes/*42.29*/.Assets.at("js/main.js"))),format.raw/*42.53*/(""""></script>
        <script>
            //var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
            //(function(d,t)"""),format.raw/*45.29*/("""{"""),format.raw/*45.30*/("""var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
            //g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
            //s.parentNode.insertBefore(g,s)"""),format.raw/*47.45*/("""}"""),format.raw/*47.46*/("""(document,'script'));
        </script>
        
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <br><br><br><br>
        <div class="container">
            <div class="row">
                """),_display_(Seq[Any](/*59.18*/if(user!=null)/*59.32*/ {_display_(Seq[Any](format.raw/*59.34*/("""
                    <ul class="nav nav-pills">
                        <li """),_display_(Seq[Any](/*61.30*/if(activeClass.equals("home"))/*61.60*/ {_display_(Seq[Any](format.raw/*61.62*/("""class="active"""")))})),format.raw/*61.77*/("""><a href=""""),_display_(Seq[Any](/*61.88*/routes/*61.94*/.Home.get())),format.raw/*61.105*/("""">Home</a></li>
                        <li """),_display_(Seq[Any](/*62.30*/if(activeClass.equals("profile"))/*62.63*/ {_display_(Seq[Any](format.raw/*62.65*/("""class="active"""")))})),format.raw/*62.80*/(""")><a href=""""),_display_(Seq[Any](/*62.92*/routes/*62.98*/.Profile.get())),format.raw/*62.112*/("""">Profile</a></li>
                        <li """),_display_(Seq[Any](/*63.30*/if(activeClass.equals("uploads"))/*63.63*/ {_display_(Seq[Any](format.raw/*63.65*/("""class="active"""")))})),format.raw/*63.80*/("""><a href=""""),_display_(Seq[Any](/*63.91*/routes/*63.97*/.Uploads.get())),format.raw/*63.111*/("""">Uploads</a></li>
                        <li """),_display_(Seq[Any](/*64.30*/if(activeClass.equals("accounts"))/*64.64*/ {_display_(Seq[Any](format.raw/*64.66*/("""class="active"""")))})),format.raw/*64.81*/(""")><a href=""""),_display_(Seq[Any](/*64.93*/routes/*64.99*/.Accounts.get())),format.raw/*64.114*/("""">Accounts</a></li>
                        <li """),_display_(Seq[Any](/*65.30*/if(activeClass.equals("notifications"))/*65.69*/ {_display_(Seq[Any](format.raw/*65.71*/("""class="active"""")))})),format.raw/*65.86*/(""")><a href=""""),_display_(Seq[Any](/*65.98*/routes/*65.104*/.Notifications.get())),format.raw/*65.124*/("""">Notifications</a></li>
                        <li><a href=""""),_display_(Seq[Any](/*66.39*/routes/*66.45*/.Logout.get())),format.raw/*66.58*/("""">Log out</a></li>
                    </ul>
                """)))}/*68.19*/else/*68.24*/{_display_(Seq[Any](format.raw/*68.25*/("""
                    <div class="form-horizontal text-right">
                        <form action=""""),_display_(Seq[Any](/*70.40*/routes/*70.46*/.Login.post())),format.raw/*70.59*/("""" method="post">
                            <input type="text" class="span4" name="email" placeholder="Email address" maxlength=63>
                            <input type="password" class="span3" name="password" placeholder="Password" maxlength=31>
                            <button type="submit" class="btn btn-info">Log in</button>
                            <a class="btn btn-warning" href=""""),_display_(Seq[Any](/*74.63*/routes/*74.69*/.Signup.get())),format.raw/*74.82*/("""">Sign up</a>
                        </form>
                    </div>
                """)))})),format.raw/*77.18*/("""
            </div>
            <div class="row">
                <div class="span12">
                    """),_display_(Seq[Any](/*81.22*/if(flash.contains("success"))/*81.51*/ {_display_(Seq[Any](_display_(Seq[Any](/*81.54*/flash/*81.59*/.get("success")))))})),format.raw/*81.75*/("""
                    """),_display_(Seq[Any](/*82.22*/if(flash.contains("failure"))/*82.51*/ {_display_(Seq[Any](_display_(Seq[Any](/*82.54*/flash/*82.59*/.get("failure")))))})),format.raw/*82.75*/("""
                </div>
            </div>
            """),_display_(Seq[Any](/*85.14*/content)),format.raw/*85.21*/("""
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
                    DATE: Fri Jul 05 18:43:42 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/main.scala.html
                    HASH: 189064b0474f0fdf5c7e7a84a83f14a4dbb4ca78
                    MATRIX: 732->1|857->49|1554->710|1569->716|1622->747|1700->789|1715->795|1779->837|1857->879|1872->885|1920->911|2017->981|2046->982|2097->1005|2126->1006|2203->1055|2232->1056|2288->1084|2317->1085|2363->1103|2392->1104|2434->1118|2463->1119|2534->1163|2563->1164|2625->1198|2654->1199|2695->1212|2724->1213|2766->1227|2795->1228|2847->1252|2876->1253|2921->1270|2950->1271|2998->1291|3027->1292|3071->1308|3100->1309|3151->1332|3180->1333|3224->1349|3253->1350|3322->1391|3351->1392|3392->1405|3421->1406|3479->1436|3508->1437|3549->1450|3578->1451|3637->1482|3666->1483|3707->1496|3736->1497|3824->1549|3839->1555|3914->1608|4128->1786|4143->1792|4202->1828|4285->1875|4300->1881|4355->1914|4426->1949|4441->1955|4487->1979|4649->2113|4678->2114|4906->2314|4935->2315|5487->2831|5510->2845|5550->2847|5665->2926|5704->2956|5744->2958|5791->2973|5838->2984|5853->2990|5887->3001|5969->3047|6011->3080|6051->3082|6098->3097|6146->3109|6161->3115|6198->3129|6283->3178|6325->3211|6365->3213|6412->3228|6459->3239|6474->3245|6511->3259|6596->3308|6639->3342|6679->3344|6726->3359|6774->3371|6789->3377|6827->3392|6913->3442|6961->3481|7001->3483|7048->3498|7096->3510|7112->3516|7155->3536|7255->3600|7270->3606|7305->3619|7388->3684|7401->3689|7440->3690|7579->3793|7594->3799|7629->3812|8069->4216|8084->4222|8119->4235|8244->4328|8392->4440|8430->4469|8479->4472|8493->4477|8535->4493|8594->4516|8632->4545|8681->4548|8695->4553|8737->4569|8832->4628|8861->4635
                    LINES: 26->1|29->1|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|49->21|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|52->24|52->24|53->25|53->25|54->26|54->26|54->26|54->26|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|60->32|60->32|60->32|60->32|61->33|61->33|61->33|61->33|62->34|62->34|62->34|62->34|65->37|65->37|65->37|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|73->45|73->45|75->47|75->47|87->59|87->59|87->59|89->61|89->61|89->61|89->61|89->61|89->61|89->61|90->62|90->62|90->62|90->62|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|92->64|92->64|92->64|93->65|93->65|93->65|93->65|93->65|93->65|93->65|94->66|94->66|94->66|96->68|96->68|96->68|98->70|98->70|98->70|102->74|102->74|102->74|105->77|109->81|109->81|109->81|109->81|109->81|110->82|110->82|110->82|110->82|110->82|113->85|113->85
                    -- GENERATED --
                */
            