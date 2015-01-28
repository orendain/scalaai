package scalaai

import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js
//import js.Dynamic.global
import org.scalajs.dom

@JSExport
object ScalaAIJS extends js.JSApp {
  @JSExport
  def main(): Unit = {
    dom.document.getElementById("shoutout").textContent = "Hello, friends!"
  }
}
