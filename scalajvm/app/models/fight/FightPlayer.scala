package models.fight

class FightPlayer(val id: Int, val health: Int, val action: FightAction) {

  def attack(p: FightPlayer) = {
    val nh = p.action match {
      case Defend() => p.health - 5
      case _ => p.health - 10
    }
    new FightPlayer(p.id, nh, p.action)
  }

  def penalize() = new FightPlayer(id, health - 5, action)

  def withAction(newAction: FightAction) = new FightPlayer(id, health, newAction)
}
