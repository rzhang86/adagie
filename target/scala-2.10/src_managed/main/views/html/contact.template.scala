
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
object contact extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply/*1.2*/():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),_display_(Seq[Any](/*3.2*/main(null, "contact")/*3.23*/ {_display_(Seq[Any](format.raw/*3.25*/("""
    <div class="row">
	    <div class="span12 well">
            <h4>Call me maybe.</h4>
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
                    SOURCE: C:/programs/ray/adagie/app/views/contact.scala.html
                    HASH: 26f2c68c456a15092f0f25cb358542c00d57c70b
                    MATRIX: 718->1|796->3|835->8|864->29|903->31
                    LINES: 26->1|29->1|31->3|31->3|31->3
                    -- GENERATED --
                */
            