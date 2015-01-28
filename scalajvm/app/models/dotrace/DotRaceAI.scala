package models.dotrace

import models.AI

trait DotRaceAI extends AI {
  val name: String
  def act(matrix: Array[Array[DotRaceEntity.Value]]): DotRaceAction.Value
}
