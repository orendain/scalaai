class DotRace_1 extends DotRaceAI {
  val name = "Edgar1"

  def act(matrix: Array[Array[DotRaceEntity.Value]]): DotRaceAction.Value = {

    var me, dot = (-1, -1)

    (1 to matrix.length) foreach { x =>
      (1 to matrix(x).length) foreach { y =>
        matrix(x)(y) match {
          case DotRaceEntity.Player => { me = (x,y) }
          case DotRaceEntity.Dot => { dot = (x,y) }
        }
      }
    }

    val xd = (dot._1 - me._1)
    val yd = (dot._2 - me._2)

    xd match {
      case x if x > 0 => DotRaceAction.Right
      case x if x < 0 => DotRaceAction.Left
      case _ => yd match {
        case y if y > 0 => DotRaceAction.Down
        case y if y < 0 => DotRaceAction.Up
        case _ => DotRaceAction.Idle
      }
    }
  }
}

trait DotRaceAI {
  val name: String
  def act(matrix: Array[Array[DotRaceEntity.Value]]): DotRaceAction.Value
}

object DotRaceAction extends Enumeration {
  val Idle, Up, Down, Right, Left = Value
}

object DotRaceEntity extends Enumeration {
  val Empty, Dot, Wall, Player = Value
}
