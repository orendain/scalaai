package services

import akka.actor.{ActorRef, Props}

import actors._

object GameClients {

  def apply(gameID: Int, out: ActorRef) = {
    gameID match {
      case 1 => Props(classOf[FightClient], out)
      case 2 => Props(classOf[DotRaceClient], out)
    }
  }
}
