// @SOURCE:C:/programs/ray/adagie/conf/routes
// @HASH:d8e7615165839265510891e6f4ad9507384fd0c6
// @DATE:Tue Jul 02 22:25:11 EDT 2013


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
private[this] lazy val controllers_Lobby_getIndex0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Lobby_postIndex1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Lobby_getSignup2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:9
private[this] lazy val controllers_Lobby_postSignup3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:10
private[this] lazy val controllers_Application_getProfile4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("p"))))
        

// @LINE:11
private[this] lazy val controllers_Application_postProfile5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("p"))))
        

// @LINE:13
private[this] lazy val controllers_Application_home6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("home"))))
        

// @LINE:14
private[this] lazy val controllers_Application_readVideoEndedForm7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("home"))))
        

// @LINE:15
private[this] lazy val controllers_Application_readChallengeAnswerForm8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("answer"))))
        

// @LINE:16
private[this] lazy val controllers_Application_myProfile9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profile"))))
        

// @LINE:17
private[this] lazy val controllers_Application_readFinancialInstitutionLoginForm10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profile"))))
        

// @LINE:18
private[this] lazy val controllers_Application_deleteFinancialInstitutionLogin11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteLogin/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:19
private[this] lazy val controllers_Application_myVideos12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("videos"))))
        

// @LINE:20
private[this] lazy val controllers_Application_readUploadVideoForm13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("videos"))))
        

// @LINE:21
private[this] lazy val controllers_Application_deleteVideo14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delete/"),DynamicPart("videoId", """[^/]+""",true))))
        

// @LINE:22
private[this] lazy val controllers_Application_logout15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:25
private[this] lazy val controllers_Assets_at16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Lobby.getIndex()"""),("""POST""", prefix,"""controllers.Lobby.postIndex()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Lobby.getSignup()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Lobby.postSignup()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """p""","""controllers.Application.getProfile()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """p""","""controllers.Application.postProfile()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """home""","""controllers.Application.home()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """home""","""controllers.Application.readVideoEndedForm()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """answer""","""controllers.Application.readChallengeAnswerForm()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profile""","""controllers.Application.myProfile()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profile""","""controllers.Application.readFinancialInstitutionLoginForm()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteLogin/$id<[^/]+>""","""controllers.Application.deleteFinancialInstitutionLogin(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """videos""","""controllers.Application.myVideos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """videos""","""controllers.Application.readUploadVideoForm()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delete/$videoId<[^/]+>""","""controllers.Application.deleteVideo(videoId:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Lobby_getIndex0(params) => {
   call { 
        invokeHandler(controllers.Lobby.getIndex(), HandlerDef(this, "controllers.Lobby", "getIndex", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Lobby_postIndex1(params) => {
   call { 
        invokeHandler(controllers.Lobby.postIndex(), HandlerDef(this, "controllers.Lobby", "postIndex", Nil,"POST", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Lobby_getSignup2(params) => {
   call { 
        invokeHandler(controllers.Lobby.getSignup(), HandlerDef(this, "controllers.Lobby", "getSignup", Nil,"GET", """""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:9
case controllers_Lobby_postSignup3(params) => {
   call { 
        invokeHandler(controllers.Lobby.postSignup(), HandlerDef(this, "controllers.Lobby", "postSignup", Nil,"POST", """""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:10
case controllers_Application_getProfile4(params) => {
   call { 
        invokeHandler(controllers.Application.getProfile(), HandlerDef(this, "controllers.Application", "getProfile", Nil,"GET", """""", Routes.prefix + """p"""))
   }
}
        

// @LINE:11
case controllers_Application_postProfile5(params) => {
   call { 
        invokeHandler(controllers.Application.postProfile(), HandlerDef(this, "controllers.Application", "postProfile", Nil,"POST", """""", Routes.prefix + """p"""))
   }
}
        

// @LINE:13
case controllers_Application_home6(params) => {
   call { 
        invokeHandler(controllers.Application.home(), HandlerDef(this, "controllers.Application", "home", Nil,"GET", """""", Routes.prefix + """home"""))
   }
}
        

// @LINE:14
case controllers_Application_readVideoEndedForm7(params) => {
   call { 
        invokeHandler(controllers.Application.readVideoEndedForm(), HandlerDef(this, "controllers.Application", "readVideoEndedForm", Nil,"POST", """""", Routes.prefix + """home"""))
   }
}
        

// @LINE:15
case controllers_Application_readChallengeAnswerForm8(params) => {
   call { 
        invokeHandler(controllers.Application.readChallengeAnswerForm(), HandlerDef(this, "controllers.Application", "readChallengeAnswerForm", Nil,"POST", """""", Routes.prefix + """answer"""))
   }
}
        

// @LINE:16
case controllers_Application_myProfile9(params) => {
   call { 
        invokeHandler(controllers.Application.myProfile(), HandlerDef(this, "controllers.Application", "myProfile", Nil,"GET", """""", Routes.prefix + """profile"""))
   }
}
        

// @LINE:17
case controllers_Application_readFinancialInstitutionLoginForm10(params) => {
   call { 
        invokeHandler(controllers.Application.readFinancialInstitutionLoginForm(), HandlerDef(this, "controllers.Application", "readFinancialInstitutionLoginForm", Nil,"POST", """""", Routes.prefix + """profile"""))
   }
}
        

// @LINE:18
case controllers_Application_deleteFinancialInstitutionLogin11(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Application.deleteFinancialInstitutionLogin(id), HandlerDef(this, "controllers.Application", "deleteFinancialInstitutionLogin", Seq(classOf[Long]),"GET", """""", Routes.prefix + """deleteLogin/$id<[^/]+>"""))
   }
}
        

// @LINE:19
case controllers_Application_myVideos12(params) => {
   call { 
        invokeHandler(controllers.Application.myVideos(), HandlerDef(this, "controllers.Application", "myVideos", Nil,"GET", """""", Routes.prefix + """videos"""))
   }
}
        

// @LINE:20
case controllers_Application_readUploadVideoForm13(params) => {
   call { 
        invokeHandler(controllers.Application.readUploadVideoForm(), HandlerDef(this, "controllers.Application", "readUploadVideoForm", Nil,"POST", """""", Routes.prefix + """videos"""))
   }
}
        

// @LINE:21
case controllers_Application_deleteVideo14(params) => {
   call(params.fromPath[Long]("videoId", None)) { (videoId) =>
        invokeHandler(controllers.Application.deleteVideo(videoId), HandlerDef(this, "controllers.Application", "deleteVideo", Seq(classOf[Long]),"GET", """""", Routes.prefix + """delete/$videoId<[^/]+>"""))
   }
}
        

// @LINE:22
case controllers_Application_logout15(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:25
case controllers_Assets_at16(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        