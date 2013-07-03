
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
object accounts extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Form[Accounts.FinancialInstitutionLoginForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, form: Form[Accounts.FinancialInstitutionLoginForm]):play.api.templates.Html = {
        _display_ {
def /*3.2*/financialInstitutionLoginItem/*3.31*/(financialInstitutionLogin: FinancialInstitutionLogin):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*3.89*/("""
    <div>
        <h5>"""),_display_(Seq[Any](/*5.14*/financialInstitutionLogin/*5.39*/.financialInstitution.name)),format.raw/*5.65*/("""</h5>
        <p>"""),_display_(Seq[Any](/*6.13*/financialInstitutionLogin/*6.38*/.username)),format.raw/*6.47*/("""</p>
        """),_display_(Seq[Any](/*7.10*/if(financialInstitutionLogin.user.equals(user))/*7.57*/ {_display_(Seq[Any](format.raw/*7.59*/("""
            (<a href=""""),_display_(Seq[Any](/*8.24*/routes/*8.30*/.Accounts.delete(financialInstitutionLogin.id))),format.raw/*8.76*/("""">Delete</a>)
        """)))})),format.raw/*9.10*/("""
    </div>
""")))};
Seq[Any](format.raw/*1.66*/("""

"""),format.raw/*11.2*/("""

"""),_display_(Seq[Any](/*13.2*/main(user, "accounts")/*13.24*/ {_display_(Seq[Any](format.raw/*13.26*/("""
    <div class="row-fluid">            
        <div class="span12 well">
            <h4>Add institution login</h4>
            <form action=""""),_display_(Seq[Any](/*17.28*/routes/*17.34*/.Accounts.post())),format.raw/*17.50*/("""" method="post">
                <p><input type="text" id="name" name="name" placeholder="Institution" value=""""),_display_(Seq[Any](/*18.95*/form("name")/*18.107*/.value)),format.raw/*18.113*/("""" autocomplete="off"></p>
                <p><input type="text" name="username" placeholder="Username" value=""""),_display_(Seq[Any](/*19.86*/form("username")/*19.102*/.value)),format.raw/*19.108*/("""" maxlength=31></p>
                <p><input type="password" name="password" placeholder="Password" maxlength=31></p>
                <p><input type="password" name="passwordRepeat" placeholder="Repeat password" maxlength=31></p>
                <p><button type="submit" class="btn btn-primary">Save</button></p>
            </form>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12 well">
            """),_display_(Seq[Any](/*28.14*/user/*28.18*/.financialInstitutionLogins.map/*28.49*/ {financialInstitutionLogin =>_display_(Seq[Any](format.raw/*28.79*/(""" """),_display_(Seq[Any](/*28.81*/financialInstitutionLoginItem(financialInstitutionLogin)))))})),format.raw/*28.138*/("""
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
                    """),_display_(Seq[Any](/*45.22*/defining(user.userVariables)/*45.50*/ {userVariables =>_display_(Seq[Any](format.raw/*45.68*/("""
                        """),_display_(Seq[Any](/*46.26*/userVariables/*46.39*/.map/*46.43*/ {userVariable =>_display_(Seq[Any](format.raw/*46.60*/("""
                            <tr>
                                <td>"""),_display_(Seq[Any](/*48.38*/userVariable/*48.50*/.code)),format.raw/*48.55*/("""</td>
                                <td>"""),_display_(Seq[Any](/*49.38*/userVariable/*49.50*/.timepoint)),format.raw/*49.60*/("""</td>
                                <td>"""),_display_(Seq[Any](/*50.38*/if(userVariable.isDebit)/*50.62*/ {_display_(Seq[Any](format.raw/*50.64*/("""debit""")))}/*50.71*/else/*50.76*/{_display_(Seq[Any](format.raw/*50.77*/("""credit""")))})),format.raw/*50.84*/("""</td>
                                <td>"""),_display_(Seq[Any](/*51.38*/Application/*51.49*/.centsToDollars(userVariable.amount))),format.raw/*51.85*/("""</td>
                                <td>"""),_display_(Seq[Any](/*52.38*/userVariable/*52.50*/.frequency)),format.raw/*52.60*/("""</td>
                            </tr>
                        """)))})),format.raw/*54.26*/("""
                    """)))})),format.raw/*55.22*/("""
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        $.getJSON(""""),_display_(Seq[Any](/*61.21*/routes/*61.27*/.Assets.at("data/FinancialInstitutions.json"))),format.raw/*61.72*/("""", function(data) """),format.raw/*61.90*/("""{"""),format.raw/*61.91*/("""
            var names = [];
            $.each(data, function(key, value) """),format.raw/*63.47*/("""{"""),format.raw/*63.48*/("""names.push(value);"""),format.raw/*63.66*/("""}"""),format.raw/*63.67*/(""");
            $('#name')
                .typeahead("""),format.raw/*65.28*/("""{"""),format.raw/*65.29*/("""
                    source: names,
                    items: 64
                """),format.raw/*68.17*/("""}"""),format.raw/*68.18*/(""")
                .blur(function() """),format.raw/*69.34*/("""{"""),format.raw/*69.35*/("""
                    if($.inArray($(this).val(), names) == -1) """),format.raw/*70.63*/("""{"""),format.raw/*70.64*/("""$('#name').val('');"""),format.raw/*70.83*/("""}"""),format.raw/*70.84*/("""
                """),format.raw/*71.17*/("""}"""),format.raw/*71.18*/(""");
        """),format.raw/*72.9*/("""}"""),format.raw/*72.10*/(""");
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Accounts.FinancialInstitutionLoginForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Accounts.FinancialInstitutionLoginForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 03 12:02:09 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/accounts.scala.html
                    HASH: 8252dd8c91393497d06cda231df9fd1c216d9e59
                    MATRIX: 769->1|893->70|930->99|1051->157|1112->183|1145->208|1192->234|1246->253|1279->278|1309->287|1359->302|1414->349|1453->351|1513->376|1527->382|1594->428|1649->452|1703->65|1734->467|1774->472|1805->494|1845->496|2030->645|2045->651|2083->667|2231->779|2253->791|2282->797|2430->909|2456->925|2485->931|2965->1375|2978->1379|3018->1410|3086->1440|3124->1442|3208->1499|3761->2016|3798->2044|3854->2062|3917->2089|3939->2102|3952->2106|4007->2123|4116->2196|4137->2208|4164->2213|4244->2257|4265->2269|4297->2279|4377->2323|4410->2347|4450->2349|4475->2356|4488->2361|4527->2362|4566->2369|4646->2413|4666->2424|4724->2460|4804->2504|4825->2516|4857->2526|4956->2593|5011->2616|5182->2751|5197->2757|5264->2802|5310->2820|5339->2821|5444->2898|5473->2899|5519->2917|5548->2918|5631->2973|5660->2974|5773->3059|5802->3060|5866->3096|5895->3097|5987->3161|6016->3162|6063->3181|6092->3182|6138->3200|6167->3201|6206->3213|6235->3214
                    LINES: 26->1|28->3|28->3|30->3|32->5|32->5|32->5|33->6|33->6|33->6|34->7|34->7|34->7|35->8|35->8|35->8|36->9|39->1|41->11|43->13|43->13|43->13|47->17|47->17|47->17|48->18|48->18|48->18|49->19|49->19|49->19|58->28|58->28|58->28|58->28|58->28|58->28|75->45|75->45|75->45|76->46|76->46|76->46|76->46|78->48|78->48|78->48|79->49|79->49|79->49|80->50|80->50|80->50|80->50|80->50|80->50|80->50|81->51|81->51|81->51|82->52|82->52|82->52|84->54|85->55|91->61|91->61|91->61|91->61|91->61|93->63|93->63|93->63|93->63|95->65|95->65|98->68|98->68|99->69|99->69|100->70|100->70|100->70|100->70|101->71|101->71|102->72|102->72
                    -- GENERATED --
                */
            