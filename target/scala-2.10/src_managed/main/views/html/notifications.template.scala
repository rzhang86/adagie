
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
object notifications extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.14*/("""

"""),_display_(Seq[Any](/*3.2*/main(user, "notifications")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""
    <div class="row-fluid">
        <div class="span12 well">
            """),_display_(Seq[Any](/*6.14*/user/*6.18*/.financialInstitutionLogins.map/*6.49*/ {financialInstitutionLogin =>_display_(Seq[Any](format.raw/*6.79*/("""
                """),_display_(Seq[Any](/*7.18*/financialInstitutionLogin/*7.43*/.loginChallenges.map/*7.63*/ {loginChallenge =>_display_(Seq[Any](format.raw/*7.82*/("""
                    """),_display_(Seq[Any](/*8.22*/if(loginChallenge.answer==null)/*8.53*/ {_display_(Seq[Any](format.raw/*8.55*/("""
                        <h4>Your credit card accounts require confirmation</h4>
                        <p>"""),_display_(Seq[Any](/*10.29*/loginChallenge/*10.43*/.challengeQuestion.value)),format.raw/*10.67*/("""</p>
                        <form action=""""),_display_(Seq[Any](/*11.40*/routes/*11.46*/.Notifications.post())),format.raw/*11.67*/("""" method="post" id="challengeAnswerForm">
                            <input type="hidden" name="id" value=""""),_display_(Seq[Any](/*12.68*/loginChallenge/*12.82*/.id)),format.raw/*12.85*/("""">
                            <input type="text" name="answer" placeholder="Enter your answer">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    """)))})),format.raw/*16.22*/("""
                """)))})),format.raw/*17.18*/("""
            """)))})),format.raw/*18.14*/("""
        </div>
    </div>
""")))})))}
    }
    
    def render(user:User): play.api.templates.Html = apply(user)
    
    def f:((User) => play.api.templates.Html) = (user) => apply(user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 03 12:11:03 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/notifications.scala.html
                    HASH: cbe6f7ed68b7604ded9f7ae2a19e1a4097e806d5
                    MATRIX: 729->1|818->13|857->18|892->45|931->47|1045->126|1057->130|1096->161|1163->191|1217->210|1250->235|1278->255|1334->274|1392->297|1431->328|1470->330|1617->441|1640->455|1686->479|1767->524|1782->530|1825->551|1971->661|1994->675|2019->678|2295->922|2346->941|2393->956
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|34->6|35->7|35->7|35->7|35->7|36->8|36->8|36->8|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|44->16|45->17|46->18
                    -- GENERATED --
                */
            