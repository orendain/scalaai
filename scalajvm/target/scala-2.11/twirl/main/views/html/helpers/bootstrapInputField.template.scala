
package views.html.helpers

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object bootstrapInputField extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[helper.FieldElements,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(element: helper.FieldElements):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
def /*36.2*/isSelectElement/*36.17*/(inputBody: String) = {{
  ("select".r findFirstIn inputBody) != None
}};
Seq[Any](format.raw/*1.33*/("""

"""),format.raw/*3.1*/("""<div class="form-group """),_display_(/*3.25*/if(element.hasErrors)/*3.46*/{_display_(Seq[Any](format.raw/*3.47*/("""has-error""")))}),format.raw/*3.57*/("""">

  """),_display_(/*5.4*/if(element.label != "_none")/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
    """),format.raw/*6.5*/("""<label for=""""),_display_(/*6.18*/element/*6.25*/.id),format.raw/*6.28*/("""" class="control-label """),_display_(/*6.52*/if(!element.args.contains('_vertical))/*6.90*/{_display_(Seq[Any](format.raw/*6.91*/("""col-sm-3""")))}),format.raw/*6.100*/("""">"""),_display_(/*6.103*/element/*6.110*/.label),format.raw/*6.116*/("""</label>
  """)))}),format.raw/*7.4*/("""

  """),_display_(/*9.4*/if(element.args.contains('_horizontal))/*9.43*/ {_display_(Seq[Any](format.raw/*9.45*/("""
    """),format.raw/*10.5*/("""<div class=""""),_display_(/*10.18*/if(element.label != "_none")/*10.46*/ {_display_(Seq[Any](format.raw/*10.48*/("""col-sm-9""")))}/*10.58*/else/*10.63*/{_display_(Seq[Any](format.raw/*10.64*/("""col-sm-12""")))}),format.raw/*10.74*/("""">
  """)))}),format.raw/*11.4*/("""

  """),_display_(/*13.4*/if(isSelectElement(element.input.body))/*13.43*/ {_display_(Seq[Any](format.raw/*13.45*/("""
    """),_display_(/*14.6*/Html(element.input.toString().replaceFirst("(<select)", "$1 class=\"form-control\""))),format.raw/*14.91*/("""
  """)))}/*15.5*/else/*15.10*/{_display_(Seq[Any](format.raw/*15.11*/("""
    """),_display_(/*16.6*/if(element.input.toString().contains("class="))/*16.53*/ {_display_(Seq[Any](format.raw/*16.55*/("""
      """),_display_(/*17.8*/Html(element.input.toString().replaceFirst("(class=\")", "$1form-control "))),format.raw/*17.84*/("""
    """)))}/*18.7*/else/*18.12*/{_display_(Seq[Any](format.raw/*18.13*/("""
      """),_display_(/*19.8*/Html(element.input.toString().replaceFirst("(<\\w+ )", "$1class=\"form-control\" "))),format.raw/*19.92*/("""
    """)))}),format.raw/*20.6*/("""
  """)))}),format.raw/*21.4*/("""

  """),_display_(/*23.4*/if(element.hasErrors)/*23.25*/ {_display_(Seq[Any](format.raw/*23.27*/("""
    """),format.raw/*24.5*/("""<span class="help-block">"""),_display_(/*24.31*/element/*24.38*/.errors.mkString(", ")),format.raw/*24.60*/("""</span>
    """),format.raw/*25.40*/("""
    """),format.raw/*26.43*/("""
    """),format.raw/*27.28*/("""
  """)))}),format.raw/*28.4*/("""

  """),_display_(/*30.4*/if(element.args.contains('_horizontal))/*30.43*/ {_display_(Seq[Any](format.raw/*30.45*/("""
    """),format.raw/*31.5*/("""</div>
  """)))}),format.raw/*32.4*/("""

"""),format.raw/*34.1*/("""</div>

"""),format.raw/*38.2*/("""
"""))}
  }

  def render(element:helper.FieldElements): play.twirl.api.HtmlFormat.Appendable = apply(element)

  def f:((helper.FieldElements) => play.twirl.api.HtmlFormat.Appendable) = (element) => apply(element)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Jan 24 09:55:53 PST 2015
                  SOURCE: /home/edgar/Projects/scalaai/app/scalajvm/app/views/helpers/bootstrapInputField.scala.html
                  HASH: 52ff9e6e33432b4c1d95f0cf8cc1bdaab72b99a2
                  MATRIX: 541->1|644->1065|668->1080|769->32|797->34|847->58|876->79|914->80|954->90|986->97|1022->125|1061->127|1092->132|1131->145|1146->152|1169->155|1219->179|1265->217|1303->218|1343->227|1373->230|1389->237|1416->243|1457->255|1487->260|1534->299|1573->301|1605->306|1645->319|1682->347|1722->349|1750->359|1763->364|1802->365|1843->375|1879->381|1910->386|1958->425|1998->427|2030->433|2136->518|2158->523|2171->528|2210->529|2242->535|2298->582|2338->584|2372->592|2469->668|2493->675|2506->680|2545->681|2579->689|2684->773|2720->779|2754->783|2785->788|2815->809|2855->811|2887->816|2940->842|2956->849|2999->871|3039->918|3072->961|3105->989|3139->993|3170->998|3218->1037|3258->1039|3290->1044|3330->1054|3359->1056|3394->1151
                  LINES: 19->1|21->36|21->36|24->1|26->3|26->3|26->3|26->3|26->3|28->5|28->5|28->5|29->6|29->6|29->6|29->6|29->6|29->6|29->6|29->6|29->6|29->6|29->6|30->7|32->9|32->9|32->9|33->10|33->10|33->10|33->10|33->10|33->10|33->10|33->10|34->11|36->13|36->13|36->13|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|40->17|40->17|41->18|41->18|41->18|42->19|42->19|43->20|44->21|46->23|46->23|46->23|47->24|47->24|47->24|47->24|48->25|49->26|50->27|51->28|53->30|53->30|53->30|54->31|55->32|57->34|59->38
                  -- GENERATED --
              */
          