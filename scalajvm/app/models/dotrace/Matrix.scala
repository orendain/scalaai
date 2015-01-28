package models.dotrace

/**
 *
 */
class Matrix(val width: Int, val height: Int, val player: Position, val dot: Position) {

  def to2DArray = {
    val arr = Array.fill(width, height)(DotRaceEntity.Empty)
    arr(player.x)(player.y) = DotRaceEntity.Player
    arr(dot.x)(dot.y) = DotRaceEntity.Dot
    arr
  }

  def move(dir: DotRaceAction.Value) {
    player.move(dir)
  }
}


/**
 *
 */
object Matrix {

  implicit def MatrixToIntArray(matrix: Matrix) = {
    val arr = Array.fill(matrix.width, matrix.height)(0)
    arr(matrix.player.x)(matrix.player.y) = 1
    arr(matrix.dot.x)(matrix.dot.y) = 2
    arr
  }

  implicit def IntArrayToMatrixArray(intArr: Array[Array[Int]]): Array[Array[DotRaceEntity.Value]] = {
    var player, dot = (-1, -1)
    (0 until intArr.length) foreach { x =>
      (0 until intArr(x).length) foreach { y =>
        intArr(x)(y) match {
          case 1 => { player = (x,y) }
          case 2 => { dot = (x,y) }
          case _ =>
        }
      }
    }

    val arr = Array.fill(intArr.length, intArr(0).length)(DotRaceEntity.Empty)
    arr(player._1)(player._2) = DotRaceEntity.Player
    arr(dot._1)(dot._2) = DotRaceEntity.Dot
    arr
  }
}


/**
 *
 */
class Position(var x: Int, var y: Int) {

  def move(dir: DotRaceAction.Value) = {
    dir match {
      case DotRaceAction.Up => { y = (y + 1) % 10 }
      case DotRaceAction.Down => { y = (y - 1) % 10 }
      case DotRaceAction.Left => { x = (x - 1) % 10 }
      case DotRaceAction.Right => { x = (x + 1) % 10 }
    }

    if (y < 0) y = 10 + y
    if (x < 0) x = 10 + x
  }

  override def equals(other: Any) = other match {
    case o: Position => (x == o.x && y == o.y)
    case _ => false
  }
}
