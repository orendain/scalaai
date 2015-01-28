
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(mainContent: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.api.Play
import components._
def /*6.2*/siteDescription/*6.17*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*6.19*/("""TODO""")))};def /*7.2*/siteLogo/*7.10*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.12*/("""http://scalai.edeloa.com"""),_display_(/*7.37*/routes/*7.43*/.Assets.at("images/logo_square_large.png"))))};
Seq[Any](format.raw/*1.36*/("""

"""),format.raw/*5.1*/("""
"""),format.raw/*6.24*/("""
"""),format.raw/*7.86*/("""

"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html itemscope itemtype="http://schema.org/WebPage">
  <head>
    <meta charset="utf=8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content=""""),_display_(/*16.40*/siteDescription),format.raw/*16.55*/("""">
    <meta name="keywords" content="TODO">
    <meta name="author" content="Edgar DeLoa">

    <meta itemprop="name" content="Scala AI">
    <meta itemprop="description" content=""""),_display_(/*21.44*/siteDescription),format.raw/*21.59*/("""">
    <meta itemprop="image" content=""""),_display_(/*22.38*/siteLogo),format.raw/*22.46*/("""">

    <meta property="og:title" content="ScalaAI">
    <meta property="og:site_name" content="ScalaAI">
    <meta property="og:description" content=""""),_display_(/*26.47*/siteDescription),format.raw/*26.62*/("""">
    <meta property="og:url" content="http://scalaai.edeloa.com">
    <meta property="og:image" content=""""),_display_(/*28.41*/siteLogo),format.raw/*28.49*/("""">

    <title>"""),_display_(/*30.13*/title),format.raw/*30.18*/("""</title>

    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*32.55*/routes/*32.61*/.Assets.at("images/favicon.png")),format.raw/*32.93*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(/*33.50*/routes/*33.56*/.Assets.at("stylesheets/scalaai.css")),format.raw/*33.93*/("""">

    """),format.raw/*36.92*/("""

    """),format.raw/*38.5*/("""<script src=""""),_display_(/*38.19*/routes/*38.25*/.Routing.javascriptRoutes),format.raw/*38.50*/("""" type="text/javascript"></script>

    <script src=""""),_display_(/*40.19*/routes/*40.25*/.Assets.at("lib/jquery/jquery.min.js")),format.raw/*40.63*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*41.19*/routes/*41.25*/.Assets.at("javascripts/bootstrap.min.js")),format.raw/*41.67*/("""" type="text/javascript"></script>

    """),_display_(/*43.6*/if(Play.isDev(Play.current))/*43.34*/ {_display_(Seq[Any](format.raw/*43.36*/("""
      """),format.raw/*44.7*/("""<script src=""""),_display_(/*44.21*/routes/*44.27*/.Assets.at("javascripts/scalajs-scalaai-fastopt.js")),format.raw/*44.79*/("""" type="text/javascript"></script>
    """)))}/*45.7*/else/*45.12*/{_display_(Seq[Any](format.raw/*45.13*/("""
      """),format.raw/*46.7*/("""<script src=""""),_display_(/*46.21*/routes/*46.27*/.Assets.at("javascripts/scalajs-scalaai-opt.js")),format.raw/*46.75*/("""" type="text/javascript"></script>
    """)))}),format.raw/*47.6*/("""
  """),format.raw/*48.3*/("""</head>

  <body>
    <a class="sr-only" href="#content">Skip to main content</a>

    <div id="body-wrapper">
      <header id="header" role="banner">
        """),_display_(/*55.10*/navbar()),format.raw/*55.18*/("""
      """),format.raw/*56.7*/("""</header>

      <main id="content" role="main" class="container">
        """),_display_(/*59.10*/mainContent),format.raw/*59.21*/("""
      """),format.raw/*60.7*/("""</main>

      <div id="push"></div>
    </div>

    """),_display_(/*65.6*/footer()),format.raw/*65.14*/("""

  """),format.raw/*67.3*/("""</body>
</html>
"""))}
  }

  def render(title:String,mainContent:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(mainContent)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (mainContent) => apply(title)(mainContent)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jan 27 19:20:13 PST 2015
                  SOURCE: /home/edgar/Projects/scalaai/app/scalajvm/app/views/main.scala.html
                  HASH: ad64540f93ba39483984cdc9a6f78bf334c2df61
                  MATRIX: 509->1|654->82|677->97|757->99|784->106|800->114|880->116|931->141|945->147|1020->35|1048->80|1076->104|1104->190|1132->192|1436->469|1472->484|1681->666|1717->681|1784->721|1813->729|1992->881|2028->896|2163->1004|2192->1012|2235->1028|2261->1033|2352->1097|2367->1103|2420->1135|2499->1187|2514->1193|2572->1230|2608->1416|2641->1422|2682->1436|2697->1442|2743->1467|2824->1521|2839->1527|2898->1565|2978->1618|2993->1624|3056->1666|3123->1707|3160->1735|3200->1737|3234->1744|3275->1758|3290->1764|3363->1816|3421->1857|3434->1862|3473->1863|3507->1870|3548->1884|3563->1890|3632->1938|3702->1978|3732->1981|3920->2142|3949->2150|3983->2157|4086->2233|4118->2244|4152->2251|4232->2305|4261->2313|4292->2317
                  LINES: 19->1|22->6|22->6|24->6|24->7|24->7|26->7|26->7|26->7|27->1|29->5|30->6|31->7|33->9|40->16|40->16|45->21|45->21|46->22|46->22|50->26|50->26|52->28|52->28|54->30|54->30|56->32|56->32|56->32|57->33|57->33|57->33|59->36|61->38|61->38|61->38|61->38|63->40|63->40|63->40|64->41|64->41|64->41|66->43|66->43|66->43|67->44|67->44|67->44|67->44|68->45|68->45|68->45|69->46|69->46|69->46|69->46|70->47|71->48|78->55|78->55|79->56|82->59|82->59|83->60|88->65|88->65|90->67
                  -- GENERATED --
              */
          