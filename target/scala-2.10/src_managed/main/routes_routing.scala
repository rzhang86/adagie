// @SOURCE:C:/programs/ray/adagie/conf/routes
// @HASH:b0661e07aab0e5fa576bd1c7b27fcb0addaf9827
// @DATE:Wed Jul 03 12:11:02 EDT 2013


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
private[this] lazy val controllers_Login_get0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Login_post1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Signup_get2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:9
private[this] lazy val controllers_Signup_post3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:10
private[this] lazy val controllers_Home_get4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("home"))))
        

// @LINE:11
private[this] lazy val controllers_Home_post5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("home"))))
        

// @LINE:12
private[this] lazy val controllers_Profile_get6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profile"))))
        

// @LINE:13
private[this] lazy val controllers_Profile_post7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profile"))))
        

// @LINE:14
private[this] lazy val controllers_Uploads_get8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("uploads"))))
        

// @LINE:15
private[this] lazy val controllers_Uploads_post9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("uploads"))))
        

// @LINE:16
private[this] lazy val controllers_Uploads_delete10 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("uploads/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:17
private[this] lazy val controllers_Accounts_get11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accounts"))))
        

// @LINE:18
private[this] lazy val controllers_Accounts_post12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accounts"))))
        

// @LINE:19
private[this] lazy val controllers_Accounts_delete13 = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("accounts/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:20
private[this] lazy val controllers_Notifications_get14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("notifications"))))
        

// @LINE:21
private[this] lazy val controllers_Notifications_post15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("notifications"))))
        

// @LINE:22
private[this] lazy val controllers_Logout_get16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:25
private[this] lazy val controllers_Assets_at17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Login.get()"""),("""POST""", prefix,"""controllers.Login.post()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Signup.get()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Signup.post()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """home""","""controllers.Home.get()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """home""","""controllers.Home.post()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profile""","""controllers.Profile.get()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profile""","""controllers.Profile.post()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """uploads""","""controllers.Uploads.get()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """uploads""","""controllers.Uploads.post()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """uploads/$id<[^/]+>""","""controllers.Uploads.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accounts""","""controllers.Accounts.get()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accounts""","""controllers.Accounts.post()"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """accounts/$id<[^/]+>""","""controllers.Accounts.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """notifications""","""controllers.Notifications.get()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """notifications""","""controllers.Notifications.post()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Logout.get()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Login_get0(params) => {
   call { 
        invokeHandler(controllers.Login.get(), HandlerDef(this, "controllers.Login", "get", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Login_post1(params) => {
   call { 
        invokeHandler(controllers.Login.post(), HandlerDef(this, "controllers.Login", "post", Nil,"POST", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Signup_get2(params) => {
   call { 
        invokeHandler(controllers.Signup.get(), HandlerDef(this, "controllers.Signup", "get", Nil,"GET", """""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:9
case controllers_Signup_post3(params) => {
   call { 
        invokeHandler(controllers.Signup.post(), HandlerDef(this, "controllers.Signup", "post", Nil,"POST", """""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:10
case controllers_Home_get4(params) => {
   call { 
        invokeHandler(controllers.Home.get(), HandlerDef(this, "controllers.Home", "get", Nil,"GET", """""", Routes.prefix + """home"""))
   }
}
        

// @LINE:11
case controllers_Home_post5(params) => {
   call { 
        invokeHandler(controllers.Home.post(), HandlerDef(this, "controllers.Home", "post", Nil,"POST", """""", Routes.prefix + """home"""))
   }
}
        

// @LINE:12
case controllers_Profile_get6(params) => {
   call { 
        invokeHandler(controllers.Profile.get(), HandlerDef(this, "controllers.Profile", "get", Nil,"GET", """""", Routes.prefix + """profile"""))
   }
}
        

// @LINE:13
case controllers_Profile_post7(params) => {
   call { 
        invokeHandler(controllers.Profile.post(), HandlerDef(this, "controllers.Profile", "post", Nil,"POST", """""", Routes.prefix + """profile"""))
   }
}
        

// @LINE:14
case controllers_Uploads_get8(params) => {
   call { 
        invokeHandler(controllers.Uploads.get(), HandlerDef(this, "controllers.Uploads", "get", Nil,"GET", """""", Routes.prefix + """uploads"""))
   }
}
        

// @LINE:15
case controllers_Uploads_post9(params) => {
   call { 
        invokeHandler(controllers.Uploads.post(), HandlerDef(this, "controllers.Uploads", "post", Nil,"POST", """""", Routes.prefix + """uploads"""))
   }
}
        

// @LINE:16
case controllers_Uploads_delete10(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Uploads.delete(id), HandlerDef(this, "controllers.Uploads", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """uploads/$id<[^/]+>"""))
   }
}
        

// @LINE:17
case controllers_Accounts_get11(params) => {
   call { 
        invokeHandler(controllers.Accounts.get(), HandlerDef(this, "controllers.Accounts", "get", Nil,"GET", """""", Routes.prefix + """accounts"""))
   }
}
        

// @LINE:18
case controllers_Accounts_post12(params) => {
   call { 
        invokeHandler(controllers.Accounts.post(), HandlerDef(this, "controllers.Accounts", "post", Nil,"POST", """""", Routes.prefix + """accounts"""))
   }
}
        

// @LINE:19
case controllers_Accounts_delete13(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(controllers.Accounts.delete(id), HandlerDef(this, "controllers.Accounts", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """accounts/$id<[^/]+>"""))
   }
}
        

// @LINE:20
case controllers_Notifications_get14(params) => {
   call { 
        invokeHandler(controllers.Notifications.get(), HandlerDef(this, "controllers.Notifications", "get", Nil,"GET", """""", Routes.prefix + """notifications"""))
   }
}
        

// @LINE:21
case controllers_Notifications_post15(params) => {
   call { 
        invokeHandler(controllers.Notifications.post(), HandlerDef(this, "controllers.Notifications", "post", Nil,"POST", """""", Routes.prefix + """notifications"""))
   }
}
        

// @LINE:22
case controllers_Logout_get16(params) => {
   call { 
        invokeHandler(controllers.Logout.get(), HandlerDef(this, "controllers.Logout", "get", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:25
case controllers_Assets_at17(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        