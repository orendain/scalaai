import sbt._
import Keys._
import play.Play._
import play.Play.autoImport._
import PlayKeys._
import scala.scalajs.sbtplugin.ScalaJSPlugin._
import ScalaJSKeys._
import com.typesafe.sbt.packager.universal.UniversalKeys

object ApplicationBuild extends Build with UniversalKeys {

  val AppName = "scalaai"
  val SharedSrcDir = "scala"
  val PlayStart = "playStart"

  val scalajsOutputDir = Def.settingKey[File]("directory for javascript files output by scalajs")

  override def rootProject = Some(scalajvm)

  lazy val scalajvm = Project(
    id = "scalajvm",
    base = file("scalajvm")
  ) enablePlugins (play.PlayScala) settings (scalajvmSettings: _*) aggregate (scalajs) aggregate (sharedScala)

  lazy val scalajs = Project(
    id = "scalajs",
    base = file("scalajs")
  ) settings (scalajsSettings: _*)

  lazy val sharedScala = Project(
    id = "scala",
    base = file(SharedSrcDir)
  ) settings (sharedScalaSettings: _*)

  lazy val scalajvmSettings =
    Seq(
      name := "play-" + AppName,
      version := Versions.app,
      scalaVersion := Versions.scala,
      //scalacOptions ++= Seq("-feature"),
      //routesImport += "config.Routes._",
      scalajsOutputDir := (classDirectory in Compile).value / "public" / "javascripts",
      compile in Compile <<= (compile in Compile) dependsOn (fastOptJS in (scalajs, Compile)) dependsOn copySourceMapsTask,
      dist <<= dist dependsOn (fullOptJS in (scalajs, Compile)),
      stage <<= stage dependsOn (fullOptJS in (scalajs, Compile)),
      libraryDependencies ++= Dependencies.scalajvm.value,
      commands ++= Seq(playStartCommand, startCommand)
    ) ++ (
      // ask scalajs project to put its outputs in scalajsOutputDir
      Seq(packageLauncher, fastOptJS, fullOptJS) map { packageJSKey =>
        crossTarget in (scalajs, Compile, packageJSKey) := scalajsOutputDir.value
      }
    ) ++ sharedDirectorySettings

  lazy val scalajsSettings =
    scalaJSSettings ++ Seq(
      name := "scalajs-" + AppName,
      version := Versions.app,
      scalaVersion := Versions.scala,
      persistLauncher := true,
      persistLauncher in Test := false,
      relativeSourceMaps := true,
      libraryDependencies ++= Dependencies.scalajs.value
    ) ++ sharedDirectorySettings

  lazy val sharedScalaSettings =
    Seq(
      name := "shared-scala-" + AppName,
      //scalaVersion := Versions.scala,
      libraryDependencies ++= Dependencies.shared.value
    )

  lazy val sharedDirectorySettings = Seq(
    unmanagedSourceDirectories in Compile += new File((file(".") / SharedSrcDir / "src" / "main" / "scala").getCanonicalPath),
    unmanagedSourceDirectories in Test += new File((file(".") / SharedSrcDir / "src" / "test" / "scala").getCanonicalPath),
    unmanagedResourceDirectories in Compile += file(".") / SharedSrcDir / "src" / "main" / "resources",
    unmanagedResourceDirectories in Test += file(".") / SharedSrcDir / "src" / "test" / "resources"
  )

  val copySourceMapsTask = Def.task {
    val scalaFiles = (Seq(sharedScala.base, scalajs.base) ** ("*.scala")).get
    for (scalaFile <- scalaFiles) {
      val target = new File((classDirectory in Compile).value, scalaFile.getPath)
      IO.copyFile(scalaFile, target)
    }
  }

  // Use reflection to rename the 'start' command to 'playStart'
  //Option(play.Play.playStartCommand.getClass.getDeclaredField("name")) map { field =>
  //  field.setAccessible(true)
  //  field.set(playStartCommand, PlayStart)
  //}

  // The new 'start' command optimises the JS before calling 'playStart'
  val startCommand = Command.args("start", "<port>") { (state: State, args: Seq[String]) =>
    Project.runTask(fullOptJS in (scalajs, Compile), state)
    state.copy(remainingCommands = s"$PlayStart ${args.mkString(" ")}" +: state.remainingCommands)
  }
  val playStartCommand = Command.make(PlayStart)(play.Play.playStartCommand.parser)
}

object Dependencies {
  val shared = Def.setting(Seq())

  val scalajvm = Def.setting(shared.value ++ Seq(
    filters,
    "org.webjars" % "jquery" % "1.11.2",
    "org.scala-lang" % "scala-compiler" % Versions.scala
  ))

  val scalajs = Def.setting(shared.value ++ Seq(
    "org.scala-lang.modules.scalajs" %%% "scalajs-dom" % Versions.scalajsDom,
    "com.scalatags" %%% "scalatags" % "0.4.2"
    //"org.scala-js" % "scalajs-library_2.11" % "0.6.0-RC1"
  ))
}

object Versions {
  val app = "0.1.0"
  val scala = "2.11.5"
  val scalajsDom = "0.6"
}
