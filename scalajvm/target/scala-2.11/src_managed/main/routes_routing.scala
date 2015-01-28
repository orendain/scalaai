// @SOURCE:/home/edgar/Projects/scalaai/app/scalajvm/conf/routes
// @HASH:274853ab0eeebfa5449494581e6315cd8f73388f
// @DATE:Tue Jan 27 17:44:46 PST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_dotrace1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dotrace"))))
private[this] lazy val controllers_Application_dotrace1_invoker = createInvoker(
controllers.Application.dotrace,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "dotrace", Nil,"GET", """""", Routes.prefix + """dotrace"""))
        

// @LINE:8
private[this] lazy val controllers_Application_websocket2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ws"))))
private[this] lazy val controllers_Application_websocket2_invoker = createInvoker(
controllers.Application.websocket,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "websocket", Nil,"GET", """""", Routes.prefix + """ws"""))
        

// @LINE:9
private[this] lazy val controllers_Application_submit3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("submit"))))
private[this] lazy val controllers_Application_submit3_invoker = createInvoker(
controllers.Application.submit,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "submit", Nil,"GET", """""", Routes.prefix + """submit"""))
        

// @LINE:11
private[this] lazy val controllers_Application_submitCode4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("submit"))))
private[this] lazy val controllers_Application_submitCode4_invoker = createInvoker(
controllers.Application.submitCode,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "submitCode", Nil,"POST", """""", Routes.prefix + """submit"""))
        

// @LINE:13
private[this] lazy val controllers_Routing_javascriptRoutes5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/javascripts/routes"))))
private[this] lazy val controllers_Routing_javascriptRoutes5_invoker = createInvoker(
controllers.Routing.javascriptRoutes,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Routing", "javascriptRoutes", Nil,"GET", """""", Routes.prefix + """assets/javascripts/routes"""))
        

// @LINE:16
private[this] lazy val controllers_Assets_at6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at6_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dotrace""","""controllers.Application.dotrace"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ws""","""controllers.Application.websocket"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """submit""","""controllers.Application.submit"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """submit""","""controllers.Application.submitCode"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/javascripts/routes""","""controllers.Routing.javascriptRoutes"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:7
case controllers_Application_dotrace1_route(params) => {
   call { 
        controllers_Application_dotrace1_invoker.call(controllers.Application.dotrace)
   }
}
        

// @LINE:8
case controllers_Application_websocket2_route(params) => {
   call { 
        controllers_Application_websocket2_invoker.call(controllers.Application.websocket)
   }
}
        

// @LINE:9
case controllers_Application_submit3_route(params) => {
   call { 
        controllers_Application_submit3_invoker.call(controllers.Application.submit)
   }
}
        

// @LINE:11
case controllers_Application_submitCode4_route(params) => {
   call { 
        controllers_Application_submitCode4_invoker.call(controllers.Application.submitCode)
   }
}
        

// @LINE:13
case controllers_Routing_javascriptRoutes5_route(params) => {
   call { 
        controllers_Routing_javascriptRoutes5_invoker.call(controllers.Routing.javascriptRoutes)
   }
}
        

// @LINE:16
case controllers_Assets_at6_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at6_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     