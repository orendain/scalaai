package models.fight

trait FightAction

case class Attack(target: Int) extends FightAction
case class Defend() extends FightAction
case class Idle() extends FightAction
