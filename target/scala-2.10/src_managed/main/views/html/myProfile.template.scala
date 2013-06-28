
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
object myProfile extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Form[Application.FinancialInstitutionLoginForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, form: Form[Application.FinancialInstitutionLoginForm]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.69*/("""

"""),_display_(Seq[Any](/*3.2*/main(user, "myProfile")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
    <div class="row-fluid">            
        <div class="span12 well">
            <h4>Add institution login</h4>
            <form action=""""),_display_(Seq[Any](/*7.28*/routes/*7.34*/.Application.readFinancialInstitutionLoginForm())),format.raw/*7.82*/("""" method="post">
                <p><input type="text" id="name" name="name" placeholder="Institution" value=""""),_display_(Seq[Any](/*8.95*/form("name")/*8.107*/.value)),format.raw/*8.113*/("""" autocomplete="off"></p>
                <p><input type="text" name="username" placeholder="Username" value=""""),_display_(Seq[Any](/*9.86*/form("username")/*9.102*/.value)),format.raw/*9.108*/("""" maxlength=31></p>
                <p><input type="password" name="password" placeholder="Password" maxlength=31></p>
                <p><input type="password" name="passwordRepeat" placeholder="Repeat password" maxlength=31></p>
                <p><button type="submit" class="btn btn-primary">Save</button></p>
            </form>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12 well">
            """),_display_(Seq[Any](/*18.14*/user/*18.18*/.financialInstitutionLogins.map/*18.49*/ {financialInstitutionLogin =>_display_(Seq[Any](format.raw/*18.79*/(""" """),_display_(Seq[Any](/*18.81*/views/*18.86*/.html.financialInstitutionLoginItem(user,financialInstitutionLogin)))))})),format.raw/*18.154*/("""
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12 well">
            <h4>Your combined profile:</h4>
            <table class="table">
                <thead>
                  <tr>
                    <th>Category</th>
                    <th>Days Ago</th>
                    <th>Debit/Credit</th>
                    <th>Amount</th>
                    <th>Frquency</th>
                  </tr>
                </thead>
                <tbody>
                    """),_display_(Seq[Any](/*35.22*/defining(user.userVariables)/*35.50*/ {userVariables =>_display_(Seq[Any](format.raw/*35.68*/("""
                        """),_display_(Seq[Any](/*36.26*/userVariables/*36.39*/.map/*36.43*/ {userVariable =>_display_(Seq[Any](format.raw/*36.60*/("""
                            <tr>
                                <td>"""),_display_(Seq[Any](/*38.38*/userVariable/*38.50*/.code)),format.raw/*38.55*/("""</td>
                                <td>"""),_display_(Seq[Any](/*39.38*/userVariable/*39.50*/.timepoint)),format.raw/*39.60*/("""</td>
                                <td>"""),_display_(Seq[Any](/*40.38*/if(userVariable.isDebit)/*40.62*/ {_display_(Seq[Any](format.raw/*40.64*/("""debit""")))}/*40.71*/else/*40.76*/{_display_(Seq[Any](format.raw/*40.77*/("""credit""")))})),format.raw/*40.84*/("""</td>
                                <td>"""),_display_(Seq[Any](/*41.38*/Application/*41.49*/.centsToDollars(userVariable.amount))),format.raw/*41.85*/("""</td>
                                <td>"""),_display_(Seq[Any](/*42.38*/userVariable/*42.50*/.frequency)),format.raw/*42.60*/("""</td>
                            </tr>
                        """)))})),format.raw/*44.26*/("""
                    """)))})),format.raw/*45.22*/("""
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        $.getJSON(""""),_display_(Seq[Any](/*51.21*/routes/*51.27*/.Assets.at("data/FinancialInstitutions.json"))),format.raw/*51.72*/("""", function(data) """),format.raw/*51.90*/("""{"""),format.raw/*51.91*/("""
            var names = [];
            $.each(data, function(key, value) """),format.raw/*53.47*/("""{"""),format.raw/*53.48*/("""names.push(value);"""),format.raw/*53.66*/("""}"""),format.raw/*53.67*/(""");
            $('#name')
                .typeahead("""),format.raw/*55.28*/("""{"""),format.raw/*55.29*/("""
                    source: names,
                    items: 64
                """),format.raw/*58.17*/("""}"""),format.raw/*58.18*/(""")
                .blur(function() """),format.raw/*59.34*/("""{"""),format.raw/*59.35*/("""
                    if($.inArray($(this).val(), names) == -1) """),format.raw/*60.63*/("""{"""),format.raw/*60.64*/("""$('#name').val('');"""),format.raw/*60.83*/("""}"""),format.raw/*60.84*/("""
                """),format.raw/*61.17*/("""}"""),format.raw/*61.18*/(""");
        """),format.raw/*62.9*/("""}"""),format.raw/*62.10*/(""");
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Application.FinancialInstitutionLoginForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Application.FinancialInstitutionLoginForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 28 01:17:08 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/myProfile.scala.html
                    HASH: 6153abcc5eff52800c83dfb20cf7e1fb39799b2a
                    MATRIX: 773->1|917->68|956->73|987->96|1026->98|1210->247|1224->253|1293->301|1440->413|1461->425|1489->431|1636->543|1661->559|1689->565|2169->1009|2182->1013|2222->1044|2290->1074|2328->1076|2342->1081|2437->1149|2990->1666|3027->1694|3083->1712|3146->1739|3168->1752|3181->1756|3236->1773|3345->1846|3366->1858|3393->1863|3473->1907|3494->1919|3526->1929|3606->1973|3639->1997|3679->1999|3704->2006|3717->2011|3756->2012|3795->2019|3875->2063|3895->2074|3953->2110|4033->2154|4054->2166|4086->2176|4185->2243|4240->2266|4411->2401|4426->2407|4493->2452|4539->2470|4568->2471|4673->2548|4702->2549|4748->2567|4777->2568|4860->2623|4889->2624|5002->2709|5031->2710|5095->2746|5124->2747|5216->2811|5245->2812|5292->2831|5321->2832|5367->2850|5396->2851|5435->2863|5464->2864
                    LINES: 26->1|29->1|31->3|31->3|31->3|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|46->18|46->18|46->18|46->18|46->18|46->18|46->18|63->35|63->35|63->35|64->36|64->36|64->36|64->36|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|68->40|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|72->44|73->45|79->51|79->51|79->51|79->51|79->51|81->53|81->53|81->53|81->53|83->55|83->55|86->58|86->58|87->59|87->59|88->60|88->60|88->60|88->60|89->61|89->61|90->62|90->62
                    -- GENERATED --
                */
            