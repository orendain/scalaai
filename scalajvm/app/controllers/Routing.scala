package controllers

import play.api._
import play.api.mvc._

object Routing extends Controller {

  /**
   *
   */
  def javascriptRoutes = Action { implicit request =>
    Ok(Routes.javascriptRouter("jsRoutes")(
      routes.javascript.Application.index
    )).as("text/javascript")
  }
}
