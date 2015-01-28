
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/main("Home | Scala AI")/*1.25*/ {_display_(Seq[Any](format.raw/*1.27*/("""
  """),format.raw/*2.3*/("""<div class="row">
    <div class="col-xs-12">
      <div id="shoutout">
      </div>
    </div>
  </div>
""")))}),format.raw/*8.2*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jan 27 19:24:19 PST 2015
                  SOURCE: /home/edgar/Projects/scalaai/app/scalajvm/app/views/index.scala.html
                  HASH: 8af4d3a0426d28a11e00a150b0c7b5335f3dd234
                  MATRIX: 580->1|611->24|650->26|679->29|814->135
                  LINES: 22->1|22->1|22->1|23->2|29->8
                  -- GENERATED --
              */
          