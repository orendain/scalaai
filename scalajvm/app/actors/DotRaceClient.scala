package actors

import akka.actor.{Actor, ActorRef}
import play.api.Logger

import models.commands._
import models.dotrace._
import models.ModuleState
import services._



class DotRaceClient(out: ActorRef) extends Actor {

  def receive = {
    case RunID(id) => {
      run(id)
    }
    case Step() => {
      if (canStart) {
        step()
      }
    }
  }

  var canStart = false

  val dr = new DotRace()
  val em = new EvaluatorManager()
  var ticks = 0

  def run(id: Int) = {
    Logger.debug("DotRaceClient: run()")
    em.load("dotrace", id.toString)

    dr.loadEvaluators(em.evals.toIterable)
    dr.onStart()

    Logger.debug("DotRaceClient: Just started.")

    // Tell client about first position
    val cmd = dr.getUpdateCommand()
    out ! Command.build(cmd)

    // Tell client we're ready to start
    out ! Command.build(OutReady())

    canStart = true
  }


  def step() = {
    Logger.debug("DotRaceClient: Performing step")
    val state = dr.tick()
    ticks += 1

    // Update client screen
    val cmd = dr.getUpdateCommand()
    out ! Command.build(cmd)

    state match {
      case ModuleState.End => {
        Logger.debug("DotRaceClient: Verified Win - " + ticks + " - ticks")
        dr.onStop()
        out ! Command.build(OutDotRaceDone(ticks))
      }
      case _ =>
    }
  }


  override def postStop() = {
    Logger.debug("DotRaceClient: postStop")
  }
}
