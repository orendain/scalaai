
package views.html

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
object submit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[models.SubmitForm],play.filters.csrf.CSRF.Token,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(submitForm: Form[models.SubmitForm])(implicit token: play.filters.csrf.CSRF.Token):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._
implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(helpers.bootstrapInputField.f) }};
Seq[Any](format.raw/*1.85*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.81*/("""

"""),_display_(/*7.2*/main(title = "Submit your AI | Scala AI")/*7.43*/ {_display_(Seq[Any](format.raw/*7.45*/("""

  """),_display_(/*9.4*/helper/*9.10*/.form(action = routes.Application.submitCode,
    'id -> "submit-form",
    'enctype -> "multipart/form-data")/*11.39*/ {_display_(Seq[Any](format.raw/*11.41*/("""

      """),_display_(/*13.8*/CSRF/*13.12*/.formField),format.raw/*13.22*/("""

      """),_display_(/*15.8*/textarea(submitForm("code"),
        '_label -> "_none",
        'placeholder -> "Paste your AI code here"
      )),format.raw/*18.8*/("""

      """),_display_(/*20.8*/inputText(submitForm("id"),
        '_label -> "_none",
        'placeholder -> "Enter an integer ID"
      )),format.raw/*23.8*/("""

      """),format.raw/*25.7*/("""<button type="submit" class="btn btn-big btn-submit">Submit</button>
  """)))}),format.raw/*26.4*/("""
""")))}),format.raw/*27.2*/("""
"""))}
  }

  def render(submitForm:Form[models.SubmitForm],token:play.filters.csrf.CSRF.Token): play.twirl.api.HtmlFormat.Appendable = apply(submitForm)(token)

  def f:((Form[models.SubmitForm]) => (play.filters.csrf.CSRF.Token) => play.twirl.api.HtmlFormat.Appendable) = (submitForm) => (token) => apply(submitForm)(token)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jan 27 19:22:48 PST 2015
                  SOURCE: /home/edgar/Projects/scalaai/app/scalajvm/app/views/submit.scala.html
                  HASH: 1493304aa54b92558aff0ec4a3c9ddb821a55ec7
                  MATRIX: 552->1|730->105|762->129|847->84|875->103|903->184|931->187|980->228|1019->230|1049->235|1063->241|1182->351|1222->353|1257->362|1270->366|1301->376|1336->385|1470->499|1505->508|1634->617|1669->625|1771->697|1803->699
                  LINES: 19->1|21->5|21->5|22->1|24->4|25->5|27->7|27->7|27->7|29->9|29->9|31->11|31->11|33->13|33->13|33->13|35->15|38->18|40->20|43->23|45->25|46->26|47->27
                  -- GENERATED --
              */
          