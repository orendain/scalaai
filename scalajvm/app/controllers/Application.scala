package controllers

import akka.actor.{ActorRef, Props}
import play.api._
import play.api.mvc._
import play.api.libs.json.JsValue
import play.api.Play.current
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation._
import play.filters.csrf.CSRF

import models.SubmitForm
import services.Submitter

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {

  val submitForm = Form(
    mapping(
      "code" -> nonEmptyText,
      "id" -> number
    )(SubmitForm.apply)(SubmitForm.unapply)
  )

  /**
   *
   */
  def index = Action {
    Ok(views.html.index())
  }

  def dotrace = Action {
    Ok(views.html.dotrace())
  }

  def submit = Action { request =>
    Ok(views.html.submit(submitForm)(CSRF.getToken(request).get))
  }

  def websocket = WebSocket.tryAcceptWithActor[JsValue, JsValue] { request =>
    Future { Right((out: ActorRef) => connect(out)) }
  }

  def submitCode = Action { implicit request =>
    submitForm.bindFromRequest.fold (
      formWithErrors =>
        BadRequest(views.html.submit(formWithErrors)(CSRF.getToken(request).get)),
      subForm => {
        Submitter.submitCode(subForm.code, subForm.id)
        Redirect(routes.Application.dotrace)
      }
    )
  }

  private def connect(out: ActorRef) = {
    Props(classOf[actors.ClientWS], 2, out)
  }
}
