
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
object videoItem extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Video,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, video: Video):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.28*/("""

<div>
    <video width="320" height="240" controls>
        <source src="assets/uploads/"""),_display_(Seq[Any](/*5.38*/(video.id))),format.raw/*5.48*/(""".webm" type='video/webm'>
        <source src="assets/uploads/"""),_display_(Seq[Any](/*6.38*/(video.id))),format.raw/*6.48*/(""".mp4" type="video/mp4">
        Your browser does not support the HTML5 video.
    </video>
    <h4>"""),_display_(Seq[Any](/*9.10*/video/*9.15*/.title)),format.raw/*9.21*/("""</h4>
    <p>"""),_display_(Seq[Any](/*10.9*/video/*10.14*/.description)),format.raw/*10.26*/("""</p>
    """),_display_(Seq[Any](/*11.6*/if(video.user.equals(user))/*11.33*/ {_display_(Seq[Any](format.raw/*11.35*/("""
        (<a href=""""),_display_(Seq[Any](/*12.20*/routes/*12.26*/.Application.deleteVideo(video.id))),format.raw/*12.60*/("""">Delete</a>)
    """)))})),format.raw/*13.6*/("""
</div>"""))}
    }
    
    def render(user:User,video:Video): play.api.templates.Html = apply(user,video)
    
    def f:((User,Video) => play.api.templates.Html) = (user,video) => apply(user,video)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 28 01:17:08 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/videoItem.scala.html
                    HASH: c1634b94cbe273b0d83ee75f48174972597da68a
                    MATRIX: 731->1|834->27|964->122|995->132|1094->196|1125->206|1264->310|1277->315|1304->321|1354->336|1368->341|1402->353|1448->364|1484->391|1524->393|1581->414|1596->420|1652->454|1703->474
                    LINES: 26->1|29->1|33->5|33->5|34->6|34->6|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13
                    -- GENERATED --
                */
            