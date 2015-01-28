package models.fight

import akka.actor.ActorRef
//import scala.collection.mutable.Map

import models.commands._
import models.{Module, ModuleState}

class Fight extends Module {

  var aiMap = Map[Int, FightAI]()
  var playerStates = Map[Int, FightPlayer]()

  type aiType = FightAI
  def loadAI(ais: Iterable[FightAI]) {
    aiMap = ((1 to ais.size) zip ais) toMap
  }

  //def loadAI(ais: Iterable[aiType]): Unit

  def preStart() {}

  def onStart() {
    playerStates = aiMap map {
      case (id, _) => (id, new FightPlayer(id, 100, Idle()))
    }
  }

  private[this] def isValidPlayer(id: Int) =
    playerStates.get(id) match { case Some(_) => true }

  def output(actr: ActorRef) {
    actr ! Update(playerStates.values)
  }

  def tick() = {
    var newStates = playerStates map { case (id, player) =>
      val otherPlayers = playerStates - id
      val state = aiMap(id).act(player, otherPlayers.values)
      player.withAction(state)
      (id, player)
    }

    var penalize = true

    // process attacks
    newStates foreach { case (id, p) =>
      p.action match {
        case (a: Attack) => {
          val target = a.target
          if (isValidPlayer(target)) {
            newStates += (target -> p.attack(newStates(target)))
            penalize = false
          }
          else {
            // change attack to idle
          }
        }
      }
    }

    // if no attackers, penalize
    if (penalize) { newStates = newStates map { case (id, p) =>
      (id -> p.penalize()) }
    }

    // remove dead players
    newStates filter { case (id, p) => p.health > 0 }

    // check for game-ending conditions
    newStates.size match {
      case 0 => {
        // all players died simultaneously -- considered a tie
        ModuleState.End
      }
      case 1 => {
        playerStates = newStates
        ModuleState.End
      }
      case _ => {
        playerStates = newStates
        ModuleState.Continue
      }
    }
  }

  def onStop() {
    aiMap.values
  }

  def postStop() {}
}
