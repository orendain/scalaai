package models.fight

import models.AI

trait FightAI extends AI {
  val name: String
  def act(my: FightPlayer, players: Iterable[FightPlayer]): FightAction
}
