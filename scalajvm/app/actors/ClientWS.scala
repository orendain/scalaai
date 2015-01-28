package actors

import akka.actor.{Actor, ActorRef, Props}
import play.api.libs.json.JsValue
import play.api.Logger

import models.commands._
import services.GameClients

class ClientWS(gameID: Int, out: ActorRef) extends Actor {

  val client = context.actorOf(GameClients(gameID, out))

  def receive = {
    case cmd: JsValue => {
      Command.parse(cmd) match {
        case RunIDCmd(id) => client ! RunID(id)
        case StepCmd(id) => client ! Step()
      }
    }
  }

  override def postStop() = {
    Logger.debug("ClientWS: postStop")
  }
}
