
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
object dotrace extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/main("Dot Race | Scala AI")/*1.29*/ {_display_(Seq[Any](format.raw/*1.31*/("""
  """),format.raw/*2.3*/("""<div id="dotrace_screen">
    <canvas style="display: block;" id="maincanvas" width="700" height="400px">
  </canvas>
    <button id="step" class="btn btn-big">Step</button>
  </div>

  <script>
    SJSDotRace().launch(
      document.getElementById("dotrace_screen"),
      document.getElementById("maincanvas")
    );
  </script>
""")))}),format.raw/*14.2*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jan 27 20:05:53 PST 2015
                  SOURCE: /home/edgar/Projects/scalaai/app/scalajvm/app/views/dotrace.scala.html
                  HASH: 00698aab9c5cd994a79894b329d0f11626553215
                  MATRIX: 582->1|617->28|656->30|685->33|1048->366
                  LINES: 22->1|22->1|22->1|23->2|35->14
                  -- GENERATED --
              */
          