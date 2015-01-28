package actors

import akka.actor.Actor
import play.api.Logger

import models.commands._

class FightClient extends Actor {

  def receive = {
    case _ =>
  }

  override def postStop() = {
    Logger.debug("FightClient: postStop")
  }
}
