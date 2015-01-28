package services

import play.api.Logger
import scala.collection.mutable.ArrayBuffer
import java.io.File

import utils.Eval

import models.dotrace.DotRaceAI

class EvaluatorManager {

  val evals = ArrayBuffer[EvaluatorManager.DotRaceEval]()

  /**
   *
   */
  def load(gameName: String, id: String) = {
    Logger.debug("EvaluatorManager: load()")
    FileManager.findFiles(gameName, id) foreach { fileName =>
      Logger.info("EvaluatorManager: Loading AI (" + fileName + ")")
      evals += (new Eval).apply[EvaluatorManager.DotRaceEval](new File(fileName))
    }
    evals.size
  }

}

/**
 *
 */
object EvaluatorManager {
  type DotRaceEval = ((Array[Array[Int]]) => Int)
}
