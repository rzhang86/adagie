// @SOURCE:C:/programs/ray/adagie/conf/routes
// @HASH:26d70af7f0aa12ef43c6d6115ca096b04dd1cdbe
// @DATE:Fri Jun 28 01:17:08 EDT 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

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
private[this] lazy val controllers_Lobby_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Lobby_readLoginForm1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Lobby_signup2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:9
private[this] lazy val controllers_Lobby_readSignupForm3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:11
private[this] lazy val controllers_Application_home4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("home"))))
        

// @LINE:12
private[this] lazy val controllers_Application_readVideoEndedForm5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("home"))))
        

// @LINE:13
private[this] lazy val controllers_Application_readChallengeAnswerForm6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("answer"))))
        

// @LINE:14
private[this] lazy val controllers_Application_myProfile7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profile"))))
        

// @LINE:15
private[this] lazy val controllers_Application_readFinancialInstitutionLoginForm8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profile"))))
        

// @LINE:16
private[this] lazy val controllers_Application_deleteFinancialInstitutionLogin9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteLogin/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:17
private[this] lazy val controllers_Application_myVideos10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("videos"))))
        

// @LINE:18
private[this] lazy val controllers_Application_readUploadVideoForm11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("videos"))))
        

// @LINE:19
private[this] lazy val controllers_Application_deleteVideo12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delete/"),DynamicPart("videoId", """[^/]+""",true))))
        

// @LINE:20
private[this] lazy val controllers_Application_logout13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:23
private[this] lazy val controllers_Assets_at14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Lobby.index()"""),("""POST""", prefix,"""controllers.Lobby.readLoginForm()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Lobby.signup()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Lobby.readSignupForm()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """home""","""controllers.Application.home()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """home""","""controllers.Application.readVideoEndedForm()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """answer""","""controllers.Application.readChallengeAnswerForm()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profile""","""controllers.Application.myProfile()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profile""","""controllers.Application.readFinancialInstitutionLoginForm()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteLogin/$id<[^/]+>""","""controllers.Application.deleteFinancialInstitutionLogin(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """videos""","""controllers.Application.myVideos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """videos""","""controllers.Application.readUploadVideoForm()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delete/$videoId<[^/]+>""","""controllers.Application.deleteVideo(videoId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Lobby_index0(params) => {
   call { 
        invokeHandler(controllers.Lobby.index(), HandlerDef(this, "controllers.Lobby", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Lobby_readLoginForm1(params) => {
   call { 
        invokeHandler(controllers.Lobby.readLoginForm(), HandlerDef(this, "controllers.Lobby", "readLoginForm", Nil,"POST", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Lobby_signup2(params) => {
   call { 
        invokeHandler(controllers.Lobby.signup(), HandlerDef(this, "controllers.Lobby", "signup", Nil,"GET", """""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:9
case controllers_Lobby_readSignupForm3(params) => {
   call { 
        invokeHandler(controllers.Lobby.readSignupForm(), HandlerDef(this, "controllers.Lobby", "readSignupForm", Nil,"POST", """""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:11
case controllers_Application_home4(params) => {
   call { 
        invokeHandler(controllers.Application.home(), HandlerDef(this, "controllers.Application", "home", Nil,"GET", """""", Routes.prefix + """home"""))
   }
}
        

// @LINE:12
case controllers_Application_readVideoEndedForm5(params) => {
   call { 
        invokeHandler(controllers.Application.readVideoEndedForm(), HandlerDef(this, "controllers.Application", "readVideoEndedForm", Nil,"POST", """""", Routes.prefix + """home"""))
   }
}
        

// @LINE:13
case controllers_Application_readChallengeAnswerForm6(params) => {
   call { 
        invokeHandler(controllers.Application.readChallengeAnswerForm(), HandlerDef(this, "controllers.Application", "readChallengeAnswerForm", Nil,"POST", """""", Routes.prefix + """answer"""))
   }
}
        

// @LINE:14
case controllers_Application_myProfile7(params) => {
   call { 
        invokeHandler(controllers.Application.myProfile(), HandlerDef(this, "controllers.Application", "myProfile", Nil,"GET", """""", Routes.prefix + """profile"""))
   }
}
        

// @LINE:15
case controllers_Application_readFinancialInstitutionLoginForm8(params) => {
   call { 
        invokeHandler(controllers.Application.readFinancialInstitutionLoginForm(), HandlerDef(this, "controllers.Application", "readFinancialInstitutionLoginForm", Nil,"POST", """""", Routes.prefix + """profile"""))
   }
}
        

// @LINE:16
case controllers_Application_deleteFinancialInstitutionLogin9(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Application.deleteFinancialInstitutionLogin(id), HandlerDef(this, "controllers.Application", "deleteFinancialInstitutionLogin", Seq(classOf[Long]),"GET", """""", Routes.prefix + """deleteLogin/$id<[^/]+>"""))
   }
}
        

// @LINE:17
case controllers_Application_myVideos10(params) => {
   call { 
        invokeHandler(controllers.Application.myVideos(), HandlerDef(this, "controllers.Application", "myVideos", Nil,"GET", """""", Routes.prefix + """videos"""))
   }
}
        

// @LINE:18
case controllers_Application_readUploadVideoForm11(params) => {
   call { 
        invokeHandler(controllers.Application.readUploadVideoForm(), HandlerDef(this, "controllers.Application", "readUploadVideoForm", Nil,"POST", """""", Routes.prefix + """videos"""))
   }
}
        

// @LINE:19
case controllers_Application_deleteVideo12(params) => {
   call(params.fromPath[Long]("videoId", None)) { (videoId) =>
        invokeHandler(controllers.Application.deleteVideo(videoId), HandlerDef(this, "controllers.Application", "deleteVideo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """delete/$videoId<[^/]+>"""))
   }
}
        

// @LINE:20
case controllers_Application_logout13(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:23
case controllers_Assets_at14(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        