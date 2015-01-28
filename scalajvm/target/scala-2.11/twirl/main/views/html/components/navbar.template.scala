
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
object navbar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {
def /*33.2*/links/*33.7*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](_display_(/*33.12*/menuLinks/*33.21*/.map/*33.25*/ { case (title, cls) =>_display_(Seq[Any](format.raw/*33.48*/("""
  """),format.raw/*34.3*/("""<li>
    <a href="#" class="""),_display_(/*35.24*/cls),format.raw/*35.27*/(""">
      <span class="link_title">"""),_display_(/*36.33*/title),format.raw/*36.38*/("""</span>
    </a>
  </li>
""")))})))};def /*29.2*/menuLinks/*29.11*/ = {{Seq[(String, String)](
  ("""<3""", "/")
)}};
Seq[Any](format.raw/*1.1*/("""<div class="navbar navbar-scalaai navbar-static-top">
  <div class="container"> <!-- necessary? -->

    <!-- Navigation header -->
    <div class="navbar-header">
      <div id="site-title">
        <h1>Scala AI</h1>
      </div>

      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <div class="icon-bar-container">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </div>
        <span class="navbar-brand">Menu</span>
      </button>
    </div>

    <!-- Navigation links -->
    <nav class="navbar-collapse collapse" role="navigation">
      <ul class="nav navbar-nav navbar-right">"""),_display_(/*23.48*/links),format.raw/*23.53*/("""</ul>
    </nav>

  </div>
</div>

"""),format.raw/*31.3*/("""

"""),format.raw/*39.3*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jan 27 20:10:45 PST 2015
                  SOURCE: /home/edgar/Projects/scalaai/app/scalajvm/app/views/components/navbar.scala.html
                  HASH: 915681e78902cf5eeffa3eb8b726b60f6850ce71
                  MATRIX: 577->885|590->890|671->895|689->904|702->908|763->931|793->934|848->962|872->965|933->999|959->1004|1012->825|1030->834|1107->0|1918->784|1944->789|2006->882|2035->1031
                  LINES: 21->33|21->33|23->33|23->33|23->33|23->33|24->34|25->35|25->35|26->36|26->36|29->29|29->29|32->1|54->23|54->23|60->31|62->39
                  -- GENERATED --
              */
          