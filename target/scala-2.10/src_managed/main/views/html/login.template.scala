
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
object login extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply/*1.2*/():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),_display_(Seq[Any](/*3.2*/main(null, "")/*3.16*/ {_display_(Seq[Any](format.raw/*3.18*/("""
    <div class="row-fluid">
	    <div class="span12 well">
	        <h2>Welcome!</h2>
	        <p class="lead">This is Rays cool site</p>
	    </div>
    </div>
""")))})))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 04 13:31:16 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/login.scala.html
                    HASH: a1cdf38ca4cc75f99058ccf1be7eb6e1d2242822
                    MATRIX: 716->1|794->3|833->8|855->22|894->24
                    LINES: 26->1|29->1|31->3|31->3|31->3
                    -- GENERATED --
                */
            