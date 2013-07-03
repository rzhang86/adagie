
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
object profile extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Form[Profile.ProfileForm],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: User, form: Form[Profile.ProfileForm]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""

"""),_display_(Seq[Any](/*3.2*/main(user, "profile")/*3.23*/ {_display_(Seq[Any](format.raw/*3.25*/("""
    <div class="row">
        <div class="span12 well">
            <div class="row"><div class="span12 text-right"><button type="button" class="btn btn-primary" id="edit-button" data-toggle="button">Edit</button></div></div>
            <div id="nonform-div">
                <div class="row"><div class="span12 text-center"><strong>Required fields:</strong></div></div>
                <div class="row">
                    <div class="span3 offset2">"""),_display_(Seq[Any](/*10.49*/form("username")/*10.65*/.value)),format.raw/*10.71*/("""</div>
                    <div class="span3"></div>
                    <div class="span3"></div>
                </div>
                <div class="row">
                    <div class="span5 offset2">"""),_display_(Seq[Any](/*15.49*/form("email")/*15.62*/.value)),format.raw/*15.68*/("""</div>
                </div>
                <br>
                <div class="row"><div class="span12 text-center"><strong>Optional fields: *</strong></div></div>
                <div class="row">
                    <div class="span2 offset2">"""),_display_(Seq[Any](/*20.49*/form("age")/*20.60*/.value)),format.raw/*20.66*/(""""</div>
                    <div class="span2">"""),_display_(Seq[Any](/*21.41*/form("zip")/*21.52*/.value)),format.raw/*21.58*/("""</div>
                    <div class="span1">"""),_display_(Seq[Any](/*22.41*/if(form("gender").value=="M")/*22.70*/ {_display_(Seq[Any](format.raw/*22.72*/("""<img src="assets/img/male.png">""")))})),format.raw/*22.104*/("""</div>
                    <div class="span1">"""),_display_(Seq[Any](/*23.41*/if(form("gender").value=="F")/*23.70*/ {_display_(Seq[Any](format.raw/*23.72*/("""<img src="assets/img/female.png">""")))})),format.raw/*23.106*/("""</div>
                </div>
                """),_display_(Seq[Any](/*25.18*/defining(Occupation.findAll())/*25.48*/ {occupations =>_display_(Seq[Any](format.raw/*25.64*/("""
                    <div class="row">
                        <div class="span2 text-right">Occupations:</div>
                        <div class="span7">"""),_display_(Seq[Any](/*28.45*/occupations/*28.56*/.map/*28.60*/ {occupation =>_display_(Seq[Any](format.raw/*28.75*/(""" """),_display_(Seq[Any](/*28.77*/if(form("occupation1").value==occupation.id.toString())/*28.132*/ {_display_(Seq[Any](_display_(Seq[Any](/*28.135*/occupation/*28.145*/.name))))}))))})),format.raw/*28.152*/("""</div>
                    </div>
                    <div class="row">
                        <div class="span7 offset2">"""),_display_(Seq[Any](/*31.53*/occupations/*31.64*/.map/*31.68*/ {occupation =>_display_(Seq[Any](format.raw/*31.83*/(""" """),_display_(Seq[Any](/*31.85*/if(form("occupation2").value==occupation.id.toString())/*31.140*/ {_display_(Seq[Any](_display_(Seq[Any](/*31.143*/occupation/*31.153*/.name))))}))))})),format.raw/*31.160*/("""</div>
                    </div>
                """)))})),format.raw/*33.18*/("""
                """),_display_(Seq[Any](/*34.18*/defining(Interest.findAll())/*34.46*/ {interests =>_display_(Seq[Any](format.raw/*34.60*/("""
                    <div class="row">
                        <div class="span2 text-right">Interests:</div>
                        <div class="span4">"""),_display_(Seq[Any](/*37.45*/interests/*37.54*/.map/*37.58*/ {interest =>_display_(Seq[Any](format.raw/*37.71*/(""" """),_display_(Seq[Any](/*37.73*/if(form("interest1").value==interest.id.toString())/*37.124*/ {_display_(Seq[Any](_display_(Seq[Any](/*37.127*/interest/*37.135*/.name))))}))))})),format.raw/*37.142*/("""</div>
                        <div class="span4">"""),_display_(Seq[Any](/*38.45*/interests/*38.54*/.map/*38.58*/ {interest =>_display_(Seq[Any](format.raw/*38.71*/(""" """),_display_(Seq[Any](/*38.73*/if(form("interest2").value==interest.id.toString())/*38.124*/ {_display_(Seq[Any](_display_(Seq[Any](/*38.127*/interest/*38.135*/.name))))}))))})),format.raw/*38.142*/("""</div>
                    </div>
                    <div class="row">
                        <div class="span4 offset2">"""),_display_(Seq[Any](/*41.53*/interests/*41.62*/.map/*41.66*/ {interest =>_display_(Seq[Any](format.raw/*41.79*/(""" """),_display_(Seq[Any](/*41.81*/if(form("interest3").value==interest.id.toString())/*41.132*/ {_display_(Seq[Any](_display_(Seq[Any](/*41.135*/interest/*41.143*/.name))))}))))})),format.raw/*41.150*/("""</div>
                        <div class="span4">"""),_display_(Seq[Any](/*42.45*/interests/*42.54*/.map/*42.58*/ {interest =>_display_(Seq[Any](format.raw/*42.71*/(""" """),_display_(Seq[Any](/*42.73*/if(form("interest4").value==interest.id.toString())/*42.124*/ {_display_(Seq[Any](_display_(Seq[Any](/*42.127*/interest/*42.135*/.name))))}))))})),format.raw/*42.142*/("""</div>
                    </div>
                """)))})),format.raw/*44.18*/("""
                <p class="text-center"><i>* Optional fields help match you with higher-paying videos!</i><p>
            </div>
            <div id="form-div" hidden>
                <form action=""""),_display_(Seq[Any](/*48.32*/routes/*48.38*/.Profile.post())),format.raw/*48.53*/("""" method="post">
                    <div class="row"><div class="span12 text-center"><strong>Required fields:</strong></div></div>
                    <div class="row">
                        <div class="span3 offset2"><input class="span3" type="text" id="username" name="username" placeholder="Username" value=""""),_display_(Seq[Any](/*51.146*/form("username")/*51.162*/.value)),format.raw/*51.168*/("""" pattern="."""),format.raw/*51.180*/("""{"""),format.raw/*51.181*/("""1,31"""),format.raw/*51.185*/("""}"""),format.raw/*51.186*/(""""></div>
                        <div class="span3"><input class="span3" type="password" id="password" name="password" placeholder="Password" pattern="."""),format.raw/*52.144*/("""{"""),format.raw/*52.145*/("""6,31"""),format.raw/*52.149*/("""}"""),format.raw/*52.150*/(""""></div>
                        <div class="span3"><input class="span3" type="password" id="passwordRepeat" name="passwordRepeat" placeholder="Repeat password" pattern="."""),format.raw/*53.163*/("""{"""),format.raw/*53.164*/("""6,31"""),format.raw/*53.168*/("""}"""),format.raw/*53.169*/(""""></div>
                    </div>
                    <div class="row">
                        <div class="span5 offset2"><input class="span5" type="email" id="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*56.138*/form("email")/*56.151*/.value)),format.raw/*56.157*/("""" pattern="."""),format.raw/*56.169*/("""{"""),format.raw/*56.170*/("""1,63"""),format.raw/*56.174*/("""}"""),format.raw/*56.175*/(""""></div>
                    </div>
                    <br>
                    <div class="row"><div class="span12 text-center"><strong>Optional fields: *</strong></div></div>
                    <div class="row">
                        <div class="span2 offset2"><input class="span2" type="number" id="age" name="age" placeholder="Age" maxlength="3" min="0" max="999" value=""""),_display_(Seq[Any](/*61.165*/form("age")/*61.176*/.value)),format.raw/*61.182*/(""""></div>
                        <div class="span2"><input class="span2" type="text" id="zip" name="zip" placeholder="Zip code" maxlength="5" value=""""),_display_(Seq[Any](/*62.142*/form("zip")/*62.153*/.value)),format.raw/*62.159*/(""""></div>
                        <div class="span1"><label class="radio inline" id="male"><input type="radio" name="gender" value="M" """),_display_(Seq[Any](/*63.127*/if(form("gender").value=="M")/*63.156*/ {_display_(Seq[Any](format.raw/*63.158*/("""checked""")))})),format.raw/*63.166*/("""><img src="assets/img/male.png"></label></div>
                        <div class="span1"><label class="radio inline" id="female"><input type="radio" name="gender" value="F" """),_display_(Seq[Any](/*64.129*/if(form("gender").value=="F")/*64.158*/ {_display_(Seq[Any](format.raw/*64.160*/("""checked""")))})),format.raw/*64.168*/("""><img src="assets/img/female.png"></label></div>
                    </div>
                    """),_display_(Seq[Any](/*66.22*/defining(Occupation.findAll())/*66.52*/ {occupations =>_display_(Seq[Any](format.raw/*66.68*/("""
                        <div class="row">
                            <div class="span2 text-right">Occupations:</div>
                            <div class="span7"><select class="span7 occupation" name="occupation1"><option value="-1"></option>"""),_display_(Seq[Any](/*69.129*/occupations/*69.140*/.map/*69.144*/ {occupation =>_display_(Seq[Any](format.raw/*69.159*/(""" <option value=""""),_display_(Seq[Any](/*69.176*/occupation/*69.186*/.id)),format.raw/*69.189*/("""" """),_display_(Seq[Any](/*69.192*/if(form("occupation1").value==occupation.id.toString())/*69.247*/ {_display_(Seq[Any](format.raw/*69.249*/("""selected""")))})),format.raw/*69.258*/(""">"""),_display_(Seq[Any](/*69.260*/occupation/*69.270*/.name)),format.raw/*69.275*/("""</option>""")))})),format.raw/*69.285*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span7 offset2"><select class="span7 occupation" name="occupation2"><option value="-1"></option>"""),_display_(Seq[Any](/*72.137*/occupations/*72.148*/.map/*72.152*/ {occupation =>_display_(Seq[Any](format.raw/*72.167*/(""" <option value=""""),_display_(Seq[Any](/*72.184*/occupation/*72.194*/.id)),format.raw/*72.197*/("""" """),_display_(Seq[Any](/*72.200*/if(form("occupation2").value==occupation.id.toString())/*72.255*/ {_display_(Seq[Any](format.raw/*72.257*/("""selected""")))})),format.raw/*72.266*/(""">"""),_display_(Seq[Any](/*72.268*/occupation/*72.278*/.name)),format.raw/*72.283*/("""</option>""")))})),format.raw/*72.293*/("""</select></div>
                        </div>
                    """)))})),format.raw/*74.22*/("""
                    """),_display_(Seq[Any](/*75.22*/defining(Interest.findAll())/*75.50*/ {interests =>_display_(Seq[Any](format.raw/*75.64*/("""
                        <div class="row">
                            <div class="span2 text-right">Interests:</div>
                            <div class="span4"><select class="span4 interest" name="interest1"><option value="-1"></option>"""),_display_(Seq[Any](/*78.125*/interests/*78.134*/.map/*78.138*/ {interest =>_display_(Seq[Any](format.raw/*78.151*/(""" <option value=""""),_display_(Seq[Any](/*78.168*/interest/*78.176*/.id)),format.raw/*78.179*/("""" """),_display_(Seq[Any](/*78.182*/if(form("interest1").value==interest.id.toString())/*78.233*/ {_display_(Seq[Any](format.raw/*78.235*/("""selected""")))})),format.raw/*78.244*/(""">"""),_display_(Seq[Any](/*78.246*/interest/*78.254*/.name)),format.raw/*78.259*/("""</option>""")))})),format.raw/*78.269*/("""</select></div>
                            <div class="span4"><select class="span4 interest" name="interest2"><option value="-1"></option>"""),_display_(Seq[Any](/*79.125*/interests/*79.134*/.map/*79.138*/ {interest =>_display_(Seq[Any](format.raw/*79.151*/(""" <option value=""""),_display_(Seq[Any](/*79.168*/interest/*79.176*/.id)),format.raw/*79.179*/("""" """),_display_(Seq[Any](/*79.182*/if(form("interest2").value==interest.id.toString())/*79.233*/ {_display_(Seq[Any](format.raw/*79.235*/("""selected""")))})),format.raw/*79.244*/(""">"""),_display_(Seq[Any](/*79.246*/interest/*79.254*/.name)),format.raw/*79.259*/("""</option>""")))})),format.raw/*79.269*/("""</select></div>
                        </div>
                        <div class="row">
                            <div class="span4 offset2"><select class="span4 interest" name="interest3"><option value="-1"></option>"""),_display_(Seq[Any](/*82.133*/interests/*82.142*/.map/*82.146*/ {interest =>_display_(Seq[Any](format.raw/*82.159*/(""" <option value=""""),_display_(Seq[Any](/*82.176*/interest/*82.184*/.id)),format.raw/*82.187*/("""" """),_display_(Seq[Any](/*82.190*/if(form("interest3").value==interest.id.toString())/*82.241*/ {_display_(Seq[Any](format.raw/*82.243*/("""selected""")))})),format.raw/*82.252*/(""">"""),_display_(Seq[Any](/*82.254*/interest/*82.262*/.name)),format.raw/*82.267*/("""</option>""")))})),format.raw/*82.277*/("""</select></div>
                            <div class="span4"><select class="span4 interest" name="interest4"><option value="-1"></option>"""),_display_(Seq[Any](/*83.125*/interests/*83.134*/.map/*83.138*/ {interest =>_display_(Seq[Any](format.raw/*83.151*/(""" <option value=""""),_display_(Seq[Any](/*83.168*/interest/*83.176*/.id)),format.raw/*83.179*/("""" """),_display_(Seq[Any](/*83.182*/if(form("interest4").value==interest.id.toString())/*83.233*/ {_display_(Seq[Any](format.raw/*83.235*/("""selected""")))})),format.raw/*83.244*/(""">"""),_display_(Seq[Any](/*83.246*/interest/*83.254*/.name)),format.raw/*83.259*/("""</option>""")))})),format.raw/*83.269*/("""</select></div>
                        </div>
                    """)))})),format.raw/*85.22*/("""
                    <p class="text-center"><i>* Optional fields help match you with higher-paying videos!</i><p>
                    <p class="text-center"><button type="submit" class="btn btn-large btn-success">Submit</button></p>
                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript">
    	var editButton = $('#edit-button')
    	editButton.click(function() """),format.raw/*94.34*/("""{"""),format.raw/*94.35*/("""
            //b.button('toggle')
            if (editButton.hasClass('active')) """),format.raw/*96.48*/("""{"""),format.raw/*96.49*/("""
            	$('#nonform-div').show()
            	$('#form-div').hide()
            """),format.raw/*99.13*/("""}"""),format.raw/*99.14*/("""
            else """),format.raw/*100.18*/("""{"""),format.raw/*100.19*/("""
            	$('#nonform-div').hide()
            	$('#form-div').show()
            """),format.raw/*103.13*/("""}"""),format.raw/*103.14*/("""
        """),format.raw/*104.9*/("""}"""),format.raw/*104.10*/(""")
        
        $('#username').tooltip("""),format.raw/*106.32*/("""{"""),format.raw/*106.33*/("""placement: "top", title: "Must be between 1 and 31 characters.""""),format.raw/*106.96*/("""}"""),format.raw/*106.97*/(""")
        $('#email').tooltip("""),format.raw/*107.29*/("""{"""),format.raw/*107.30*/("""placement: "top", title: "Must be between 1 and 63 characters.""""),format.raw/*107.93*/("""}"""),format.raw/*107.94*/(""")
        $('#password').tooltip("""),format.raw/*108.32*/("""{"""),format.raw/*108.33*/("""placement: "top", title: "Must be between 6 and 31 characters.""""),format.raw/*108.96*/("""}"""),format.raw/*108.97*/(""")
        $('#passwordRepeat').tooltip("""),format.raw/*109.38*/("""{"""),format.raw/*109.39*/("""placement: "top", title: "Must be between 6 and 31 characters.""""),format.raw/*109.102*/("""}"""),format.raw/*109.103*/(""")
        $('#age').tooltip("""),format.raw/*110.27*/("""{"""),format.raw/*110.28*/("""placement: "top", title: "Match with videos for your age group.""""),format.raw/*110.92*/("""}"""),format.raw/*110.93*/(""")
        $('#zip').tooltip("""),format.raw/*111.27*/("""{"""),format.raw/*111.28*/("""placement: "top", title: "Match with videos in your area.""""),format.raw/*111.86*/("""}"""),format.raw/*111.87*/(""")
        $('#male').tooltip("""),format.raw/*112.28*/("""{"""),format.raw/*112.29*/("""placement: "top", title: "Match you with videos for guys.""""),format.raw/*112.87*/("""}"""),format.raw/*112.88*/(""")
        $('#female').tooltip("""),format.raw/*113.30*/("""{"""),format.raw/*113.31*/("""placement: "top", title: "Match you with videos for gals.""""),format.raw/*113.89*/("""}"""),format.raw/*113.90*/(""")
        $('.occupation').tooltip("""),format.raw/*114.34*/("""{"""),format.raw/*114.35*/("""placement: "top", title: "Match with videos related to your job.""""),format.raw/*114.100*/("""}"""),format.raw/*114.101*/(""")
        $('.interest').tooltip("""),format.raw/*115.32*/("""{"""),format.raw/*115.33*/("""placement: "top", title: "Match with videos about your interests.""""),format.raw/*115.99*/("""}"""),format.raw/*115.100*/(""")
    </script>
""")))})))}
    }
    
    def render(user:User,form:Form[Profile.ProfileForm]): play.api.templates.Html = apply(user,form)
    
    def f:((User,Form[Profile.ProfileForm]) => play.api.templates.Html) = (user,form) => apply(user,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 03 18:50:01 EDT 2013
                    SOURCE: C:/programs/ray/adagie/app/views/profile.scala.html
                    HASH: baf7604e7b38a7352885de12c426137c78e89687
                    MATRIX: 749->1|871->46|910->51|939->72|978->74|1476->536|1501->552|1529->558|1774->767|1796->780|1824->786|2111->1037|2131->1048|2159->1054|2244->1103|2264->1114|2292->1120|2376->1168|2414->1197|2454->1199|2519->1231|2603->1279|2641->1308|2681->1310|2748->1344|2833->1393|2872->1423|2926->1439|3121->1598|3141->1609|3154->1613|3207->1628|3245->1630|3310->1685|3360->1688|3380->1698|3418->1705|3581->1832|3601->1843|3614->1847|3667->1862|3705->1864|3770->1919|3820->1922|3840->1932|3878->1939|3963->1992|4018->2011|4055->2039|4107->2053|4300->2210|4318->2219|4331->2223|4382->2236|4420->2238|4481->2289|4531->2292|4549->2300|4587->2307|4675->2359|4693->2368|4706->2372|4757->2385|4795->2387|4856->2438|4906->2441|4924->2449|4962->2456|5125->2583|5143->2592|5156->2596|5207->2609|5245->2611|5306->2662|5356->2665|5374->2673|5412->2680|5500->2732|5518->2741|5531->2745|5582->2758|5620->2760|5681->2811|5731->2814|5749->2822|5787->2829|5872->2882|6111->3085|6126->3091|6163->3106|6518->3424|6544->3440|6573->3446|6614->3458|6644->3459|6677->3463|6707->3464|6889->3617|6919->3618|6952->3622|6982->3623|7183->3795|7213->3796|7246->3800|7276->3801|7527->4015|7550->4028|7579->4034|7620->4046|7650->4047|7683->4051|7713->4052|8135->4437|8156->4448|8185->4454|8373->4605|8394->4616|8423->4622|8596->4758|8635->4787|8676->4789|8717->4797|8930->4973|8969->5002|9010->5004|9051->5012|9186->5111|9225->5141|9279->5157|9567->5408|9588->5419|9602->5423|9656->5438|9710->5455|9730->5465|9756->5468|9796->5471|9861->5526|9902->5528|9944->5537|9983->5539|10003->5549|10031->5554|10074->5564|10339->5792|10360->5803|10374->5807|10428->5822|10482->5839|10502->5849|10528->5852|10568->5855|10633->5910|10674->5912|10716->5921|10755->5923|10775->5933|10803->5938|10846->5948|10948->6018|11007->6041|11044->6069|11096->6083|11378->6328|11397->6337|11411->6341|11463->6354|11517->6371|11535->6379|11561->6382|11601->6385|11662->6436|11703->6438|11745->6447|11784->6449|11802->6457|11830->6462|11873->6472|12051->6613|12070->6622|12084->6626|12136->6639|12190->6656|12208->6664|12234->6667|12274->6670|12335->6721|12376->6723|12418->6732|12457->6734|12475->6742|12503->6747|12546->6757|12807->6981|12826->6990|12840->6994|12892->7007|12946->7024|12964->7032|12990->7035|13030->7038|13091->7089|13132->7091|13174->7100|13213->7102|13231->7110|13259->7115|13302->7125|13480->7266|13499->7275|13513->7279|13565->7292|13619->7309|13637->7317|13663->7320|13703->7323|13764->7374|13805->7376|13847->7385|13886->7387|13904->7395|13932->7400|13975->7410|14077->7480|14525->7900|14554->7901|14665->7984|14694->7985|14811->8074|14840->8075|14888->8094|14918->8095|15036->8184|15066->8185|15104->8195|15134->8196|15207->8240|15237->8241|15329->8304|15359->8305|15419->8336|15449->8337|15541->8400|15571->8401|15634->8435|15664->8436|15756->8499|15786->8500|15855->8540|15885->8541|15978->8604|16009->8605|16067->8634|16097->8635|16190->8699|16220->8700|16278->8729|16308->8730|16395->8788|16425->8789|16484->8819|16514->8820|16601->8878|16631->8879|16692->8911|16722->8912|16809->8970|16839->8971|16904->9007|16934->9008|17029->9073|17060->9074|17123->9108|17153->9109|17248->9175|17279->9176
                    LINES: 26->1|29->1|31->3|31->3|31->3|38->10|38->10|38->10|43->15|43->15|43->15|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|51->23|53->25|53->25|53->25|56->28|56->28|56->28|56->28|56->28|56->28|56->28|56->28|56->28|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|59->31|61->33|62->34|62->34|62->34|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|66->38|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|69->41|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|72->44|76->48|76->48|76->48|79->51|79->51|79->51|79->51|79->51|79->51|79->51|80->52|80->52|80->52|80->52|81->53|81->53|81->53|81->53|84->56|84->56|84->56|84->56|84->56|84->56|84->56|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|94->66|94->66|94->66|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|102->74|103->75|103->75|103->75|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|113->85|122->94|122->94|124->96|124->96|127->99|127->99|128->100|128->100|131->103|131->103|132->104|132->104|134->106|134->106|134->106|134->106|135->107|135->107|135->107|135->107|136->108|136->108|136->108|136->108|137->109|137->109|137->109|137->109|138->110|138->110|138->110|138->110|139->111|139->111|139->111|139->111|140->112|140->112|140->112|140->112|141->113|141->113|141->113|141->113|142->114|142->114|142->114|142->114|143->115|143->115|143->115|143->115
                    -- GENERATED --
                */
            