package models.commands

import models.fight.FightPlayer
import models.dotrace.Matrix

// Incoming commands
case class RunIDCmd(id: Int) extends Command
case class StepCmd(nothing: Int) extends Command
case class TestCmd(id: Int) extends Command


// Outgoing commands
case class OutFightState(players: Iterable[FightPlayer]) extends Command
case class OutDotRaceState(state: Matrix) extends Command
case class OutDotRaceDone(ticks: Int) extends Command
case class OutReady() extends Command


// Actor-related
case class Update(playerS: Iterable[FightPlayer])
case class StepOnce()

case class RunID(id: Int)
case class Step()
