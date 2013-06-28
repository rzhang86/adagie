
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
object financialInstitutionLoginItem extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,FinancialInstitutionLogin,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, financialInstitutionLogin: FinancialInstitutionLogin):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.68*/("""

<div>
    <h5>"""),_display_(Seq[Any](/*4.10*/financialInstitutionLogin/*4.35*/.financialInstitution.name)),format.raw/*4.61*/("""</h5>
    <p>"""),_display_(Seq[Any](/*5.9*/financialInstitutionLogin/*5.34*/.username)),format.raw/*5.43*/("""</p>
    """),_display_(Seq[Any](/*6.6*/if(financialInstitutionLogin.user.equals(user))/*6.53*/ {_display_(Seq[Any](format.raw/*6.55*/("""
        (<a href=""""),_display_(Seq[Any](/*7.20*/routes/*7.26*/.Application.deleteFinancialInstitutionLogin(financialInstitutionLogin.id))),format.raw/*7.100*/("""">Delete</a>)
    """)))})),format.raw/*8.6*/("""
</div>"""))}
    }
    
    def render(user:User,financialInstitutionLogin:FinancialInstitutionLogin): play.api.templates.Html = apply(user,financialInstitutionLogin)
    
    def f:((User,FinancialInstitutionLogin) => play.api.templates.Html) = (user,financialInstitutionLogin) => apply(user,financialInstitutionLogin)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 28 01:17:08 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/financialInstitutionLoginItem.scala.html
                    HASH: b7c0fea4515432acfbff00c6a7c2fbb8bbe721cf
                    MATRIX: 771->1|914->67|969->87|1002->112|1049->138|1098->153|1131->178|1161->187|1206->198|1261->245|1300->247|1356->268|1370->274|1466->348|1516->368
                    LINES: 26->1|29->1|32->4|32->4|32->4|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|36->8
                    -- GENERATED --
                */
            