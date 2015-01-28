package services

import java.nio.file._
import play.Play.application
import play.api.Logger
import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer

object FileManager {

  /**
   *
   */
  def findFiles(gameName: String, id: String) = {

    val path = Paths.get(application.path.toString)
      .resolve(application.configuration.getString("files.submissions.basePath"))
      .resolve(gameName + "/")

    val fileNames = ArrayBuffer[String]()

    try {
      Files.newDirectoryStream(path, id + "-*") foreach { file =>
        Logger.debug("FileManager: Added file (" + file + ")")
        fileNames += file.toString
      }
    } catch {
      case ex: DirectoryIteratorException => Logger.debug("FileManager: " + ex)
      case ex: Throwable => Logger.debug("FileManager: Uncaught" + ex)
    }

    fileNames
  }

}
