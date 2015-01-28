class MyDotRacer {
  val name = "RandomNameForNow"

  def act(matrix: Array[Array[Int]]): Int = {

    var me, dot = (-1, -1)

    (0 until matrix.length) foreach { x =>
      (0 until matrix(x).length) foreach { y =>
        matrix(x)(y) match {
          case 1 => { me = (x,y) }
          case 2 => { dot = (x,y) }
          case _ =>
        }
      }
    }

    val xd = (dot._1 - me._1)
    val yd = (dot._2 - me._2)

    xd match {
      case x if x > 0 => 3
      case x if x < 0 => 4
      case _ => yd match {
        case y if y > 0 => 1
        case y if y < 0 => 2
        case _ => 0
      }
    }
  }
}

(new MyDotRacer).act _
