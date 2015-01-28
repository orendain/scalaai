package models.commands

import play.api.libs.json._

object CommandImplicits {

  // Generic
  implicit val commandWrite: Writes[Command] = new Writes[Command] {
    def writes(cmd: Command) = { Json.obj() }
  }


  implicit val runIDRead =
    (__ \ "id").read[Int].map(RunIDCmd(_))

  implicit val stepRead =
    (__ \ "id").read[Int].map(StepCmd(_))

  implicit val test =
    (__ \ "id").read[Int].map(TestCmd(_))



  implicit val fightStateWrite = new Writes[OutFightState] {
    def writes(cmd: OutFightState) = Json.obj(
      "cmd" -> "ftst",
      "data" -> ""
    )
  }

  implicit val dotRaceStateWrite = new Writes[OutDotRaceState] {
    def writes(cmd: OutDotRaceState) = Json.obj(
      "cmd" -> "drst",
      "data" -> Json.arr(
        Json.obj("typ" -> "plr", "data" -> Json.obj("x" -> cmd.state.player.x, "y" -> cmd.state.player.y)),
        Json.obj("typ" -> "dot", "data" -> Json.obj("x" -> cmd.state.dot.x, "y" -> cmd.state.dot.y))
      )
    )
  }

  implicit val readyWrite = new Writes[OutReady] {
    def writes(cmd: OutReady) = Json.obj(
      "cmd" -> "rdy",
      "data" -> ""
    )
  }

  implicit val dotRaceDoneWrite = new Writes[OutDotRaceDone] {
    def writes(cmd: OutDotRaceDone) = Json.obj(
      "cmd" -> "drdn",
      "data" -> Json.obj(
        "tks" -> cmd.ticks
      )
    )
  }

}
