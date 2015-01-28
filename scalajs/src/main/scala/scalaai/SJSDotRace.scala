package scalaai

import scala.scalajs.js.annotation.JSExport
import scala.scalajs.js
import scala.scalajs.js.JSON
import js.Dynamic.{literal => lit}

import scalatags.JsDom.all._
import org.scalajs.dom
import org.scalajs.dom.{CloseEvent, ErrorEvent, Event, MessageEvent}

@JSExport
object SJSDotRace {

  // Short on time!
  // Shamelessly setting references to null :(
  var canvas: dom.HTMLCanvasElement = null
  var renderer: dom.CanvasRenderingContext2D = null
  var idInput: org.scalajs.dom.HTMLInputElement = null
  var ws: dom.WebSocket = null
  var playerPosition = (-1, -1)
  var dotPosition = (-1, -1)

  @JSExport
  def launch(target: dom.HTMLDivElement, canvas: dom.HTMLCanvasElement): Unit = {
    drawSubmissionElements(target)
    initWS()
    initBoardDimensions(canvas)
    initRenderer()
    linkInteractiveElements()
    drawBoard()
  }

  /**
   *
   */
  def displayEndMessage(ticks: Int) {
    clearBoard()

    renderer.fillStyle = "green"
    renderer.fillText(
      "Completed in " + ticks + " ticks.",
      canvas.width / 2,
      canvas.height / 2
    )
  }

  /**
   *
   */
  def initWS() {
    ws = new dom.WebSocket("ws://localhost:9000/ws")

    ws.onopen = (e: Event) => Console.println("Websocket open")
    ws.onclose = (e: CloseEvent) => Console.println("WebSocket closed")
    ws.onerror = (e: ErrorEvent) => Console.println("Websocket error: " + e.message)
    ws.onmessage = (e: MessageEvent) => processWSMsg(e)
  }


  /**
   *
   */
  def linkInteractiveElements() {
    dom.document.getElementById("id_submit").onclick = (e: dom.MouseEvent) => {
      idInput.value.toInt match {
        case i if i > 0 =>
          ws.send( JSON.stringify(lit(cmd = "runid", data = lit(id = i))) )
        case _ =>
      }
    }

    dom.document.getElementById("step").onclick = (e: dom.MouseEvent) => {
      ws.send(JSON.stringify(lit(cmd = "step", data = lit(id = 5))))
    }
  }


  /**
   *
   */
  def drawSubmissionElements(target: dom.HTMLDivElement) {
    idInput = input(
      `type`:="text",
      id:="id_input",
      placeholder:="Enter your AI ID"
    ).render

    val submit = a(
      id:="id_submit")(
        p("SUBMIT!")
    )

    target.appendChild(
      div(
        div(idInput),
        div(submit)
      ).render
    )
  }

    /*
     * Rendering
     */

    var drLineWidth = 0
    var drCellWidth = 0
    var drCellHeight = 0
    var drEntityWidth = 0
    var drEntityHeight = 0

    def initBoardDimensions(newCanvas: dom.HTMLCanvasElement) {
      canvas = newCanvas
      canvas.width = 700
      canvas.height = 400

      drLineWidth = 5
      drCellWidth = canvas.width / 10
      drCellHeight = canvas.height / 10

      drEntityWidth = drCellWidth * 2 / 3;
      drEntityHeight = drCellHeight * 2 / 3;
    }

    def initRenderer() {
      renderer = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
      renderer.font = "50px sans-serif"
      renderer.textAlign = "center"
      renderer.textBaseline = "middle"
      renderer.fillStyle = "darkblue"
    }

    def clearBoard() { renderer.clearRect(0, 0, canvas.width, canvas.height) }

    def drawBoard() {
      renderer.fillStyle = "darkblue"

      (0 to 10) foreach { i =>
        renderer.fillRect(drCellWidth * i, 0, drLineWidth, canvas.height)
        renderer.fillRect(0, drCellHeight * i, canvas.width, drLineWidth)
      }
    }

    def updateBoard() {
      clearBoard()
      drawBoard()
      renderPlayer()
      renderDot()
    }

    /**
     * Returns a tuple, x and y coordinates
     */
    def calculateRenderAchorPoint(x: Int, y: Int) = {
      val dx = x * drCellWidth + ((drCellWidth) / 2)
      val dy = y * drCellHeight + ((drCellHeight) / 2)
      (dx, dy)
    }

    def renderPlayer() {
      renderer.fillStyle = "green"
      val pt = calculateRenderAchorPoint(playerPosition._1, playerPosition._2)
      renderer.fillRect(pt._1, pt._2, drEntityWidth, drEntityHeight)
    }

    def renderDot() {
      renderer.fillStyle = "red"
      val pt = calculateRenderAchorPoint(dotPosition._1, dotPosition._2)
      renderer.fillRect(pt._1, pt._2, drEntityWidth, drEntityHeight)
    }





    /*
     * TODO: Cleanup!
     */

    def processWSMsg(msg: MessageEvent) = {

    val obj = JSON.parse(msg.data.toString)

    obj.cmd.toString match {
      case "drdn" => displayEndMessage(obj.data.tks.toString.toInt)
      case "drst" => {

        var bt = obj.data.pop()

        var x = bt.data.x.toString.toInt
        var y = bt.data.y.toString.toInt

        bt.typ.toString match {
          case "plr" => playerPosition = (x, y)
          case "dot" => dotPosition = (x, y)
          case _ =>
        }


        bt = obj.data.pop()

        x = bt.data.x.toString.toInt
        y = bt.data.y.toString.toInt

        bt.typ.toString match {
          case "plr" => playerPosition = (x, y)
          case "dot" => dotPosition = (x, y)
          case _ =>
        }

        updateBoard()

      }
      case _ =>
    }


  }

  /*def processUpdatePoint(msg) {
    val x = msg.data.x.toString.toInt
    val y = msg.data.y.toString.toInt

    msg.typ.toString match {
      case "plr" => playerPosition = (x, y)
      case "dot" => dotPosition = (x, y)
      case _ =>
    }
  }*/

}
