package models.commands

import play.api.libs.json._
import play.api.libs.functional.syntax._

import models.commands.CommandImplicits._

trait Command

object Command {

  def parse(json: JsValue): Command = {
    val str = (json \ "cmd").as[String]
    val ty: Command = str match {
      case "runid" => (json \ "data").validate[RunIDCmd].get
      case "step" => (json \ "data").validate[StepCmd].get
      case "test" => (json \ "data").validate[TestCmd].get
    }
    ty
  }

  def build[T <: Command](cmd: T) = {
    cmd match {
      case c: OutFightState => Json.toJson(c)(fightStateWrite)
      case c: OutDotRaceState => Json.toJson(c)(dotRaceStateWrite)
      case c: OutReady => Json.toJson(c)(readyWrite)
      case c: OutDotRaceDone => Json.toJson(c)(dotRaceDoneWrite)
      case _ => Json.toJson(cmd)
    }
  }
}
