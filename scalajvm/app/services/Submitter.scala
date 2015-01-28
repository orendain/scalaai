package services

import play.api._
import play.api.mvc._
import play.Play.application

import java.nio.file._
import java.nio.charset.StandardCharsets

object Submitter {

  /**
   * Very first method written for our team for the Scala.JS hackathon!
   * Hurray!
   */
  def submitCode(code: String, id: Int)(implicit request: RequestHeader) {
    val filePath = generateFilePath(id)
    saveCodeToFile(code, filePath)
  }

  /**
   * @TODO: Handle exceptions
   */
  private def saveCodeToFile(code: String, filePath: Path) {
    prepareFilePath(filePath)
    val writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)
    writer.write(code, 0, code.length)
    writer.close()
    Logger.debug("Submitter: Code saved to: " + filePath)
  }

  /**
   *
   */
  private def prepareFilePath(filePath: Path) {
    if (!Files.exists(filePath.getParent)) {
      Files.createDirectories(filePath.getParent)
    }
  }

  /**
   *
   */
  private def generateFilePath(id: Int) = {
    val timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new java.util.Date)
    Paths.get(application.path.toString)
      .resolve(application.configuration.getString("files.submissions.basePath"))
      .resolve("dotrace")
      .resolve(id + "-" + timestamp + ".scala")
  }

}
