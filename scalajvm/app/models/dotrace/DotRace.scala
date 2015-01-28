package models.dotrace

import akka.actor.ActorRef
import scala.collection.mutable.Set
import scala.util.Random
import play.api.Logger

import models.commands._
import models.{Module, ModuleState}

import services.EvaluatorManager.DotRaceEval

import utils.Eval

class DotRace extends Module {
  type aiType = DotRaceAI

  var aiMap = Map[Int, DotRaceAI]()
  var evals = Iterable[DotRaceEval]()

  var playerStates = Map[Int, Matrix]()

  var levelStates = Seq[Matrix]()
  val levels = 10

  val levelDimensions = (10, 10)

  def loadAI(ais: Iterable[aiType]) {
    aiMap = ((1 to ais.size) zip ais) toMap
  }

  def loadEvaluators(ev: Iterable[DotRaceEval]) {
    evals = ev
    Logger.debug("DotRace: done loading evals")
  }

  private def nextPosition() = {
    (Random.nextInt(levelDimensions._1), Random.nextInt(levelDimensions._2))
  }

  def getUpdateCommand() = {
    Logger.debug("DotRace: UpdateCmd is ...")
    Logger.debug("DotRace: UpdateCmd is " + playerStates(1))
    OutDotRaceState(playerStates(1))
  }

  private def nextPositionSet(num: Int): Set[(Int, Int)] = {
    var points = Set[(Int, Int)]()
    do {
      points += nextPosition()
    } while (points.size < num)
    points
  }

  def preStart() {}
  def onStart() {
    // Pregenerate all levels
    levelStates = (1 to levels) map { case level =>
      val set = nextPositionSet(2).toArray

      val playerPos = new Position(set(0)._1, set(0)._2)
      val dotPos = new Position(set(1)._1, set(1)._2)

      new Matrix(levelDimensions._1, levelDimensions._2, playerPos, dotPos)
    }

    /*
    playerStates = evals map {
      case (id, _) => (id, levelStates(0))
    }*/

    playerStates += (1 -> levelStates(0))
  }

  def tick() = {
    //playerStates foreach { case (id, state) =>
      Logger.debug("DotRace: In tick()")
      playerStates.head match { case (id, state) =>

        //val move = evals.head.act(playerStates(id).to2DArray)
        val intArr = Matrix.MatrixToIntArray(state)
        Logger.debug("DotRace: IntLength " + intArr.length + " and " + intArr(0).length)

        var move = -1


        Logger.debug("Player is: " + state.player.x + ", " + state.player.y)
        Logger.debug("Dot is: " + state.dot.x + ", " + state.dot.y)

        try {
          move = evals.head(intArr)

          Logger.debug("EVALSIZE: " + evals.size)

          //move = evals.head(Array(Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 1, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 2, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)))
          Logger.debug("DotRace: Answer is: " + move)
        }
        catch {
          case x: Throwable => Logger.debug("DotRace: Err - " + x)
        }


        Logger.debug("DotRace: Move is " + move)


        /*
        Logger.debug("Key: IDLE-" + DotRaceAction.Idle.id)
        Logger.debug("Key: IDLE-" + DotRaceAction.Up.id)
        Logger.debug("Key: IDLE-" + DotRaceAction.Down.id)
        */


        //val move = aiMap(id).act(playerStates(id).to2DArray)


        playerStates(id).move(DotRaceAction(move))


        if (playerStates(id).player != playerStates(id).dot) {
          ModuleState.Continue
        } else {
          Logger.debug("DotRace: Win")
          ModuleState.End
        }
      }
    //}
  }

  def onStop() {}
  def postStop() {}
}
