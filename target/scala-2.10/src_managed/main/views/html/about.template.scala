
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
object about extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply/*1.2*/():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),_display_(Seq[Any](/*3.2*/main(null, "about")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
    <div class="row">
	    <div class="span12 well">
            <h4>A cool website.</h4>
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
                    DATE: Sat Jul 06 15:50:11 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/about.scala.html
                    HASH: bedc8eaa19cbeeb7b8b51b8eecb637895c97c4db
                    MATRIX: 716->1|794->3|833->8|860->27|899->29
                    LINES: 26->1|29->1|31->3|31->3|31->3
                    -- GENERATED --
                */
            