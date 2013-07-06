
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
object faq extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply/*1.2*/():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),_display_(Seq[Any](/*3.2*/main(null, "faq")/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""
    <div class="row">
	    <div class="span12 well">
            <h4>Q: Is this website safe?</h4>
            <p>A: This website is so safe.</p>
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
                    DATE: Sat Jul 06 15:59:59 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/faq.scala.html
                    HASH: 111e49a56c4e7b0b36fd450cee99123adf41449b
                    MATRIX: 714->1|792->3|831->8|856->25|895->27
                    LINES: 26->1|29->1|31->3|31->3|31->3
                    -- GENERATED --
                */
            