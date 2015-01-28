
package views.html.components

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
object footer extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div id="footer-wrapper">
  <footer id="footer" role="contentinfo" class="container">
    <div class="row">
      <div class="col-sm-4">
        <div id="riots-version">Scala AI.  Version """),_display_(/*5.53*/play/*5.57*/.Play.application.configuration.getString("application.version")),format.raw/*5.121*/("""</div>
      </div>

      <div class="col-sm-8">
        <p class="madeby">Build with love but in a hurry.</p>
      </div>
    </div>
  </footer>
</div>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jan 27 15:59:16 PST 2015
                  SOURCE: /home/edgar/Projects/scalaai/app/scalajvm/app/views/components/footer.scala.html
                  HASH: ab6459e3f9c329235391b219224700890bc787eb
                  MATRIX: 592->0|807->189|819->193|904->257
                  LINES: 22->1|26->5|26->5|26->5
                  -- GENERATED --
              */
          