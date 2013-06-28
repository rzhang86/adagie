// @SOURCE:C:/programs/ray/adagie/conf/routes
// @HASH:26d70af7f0aa12ef43c6d6115ca096b04dd1cdbe
// @DATE:Fri Jun 28 01:17:08 EDT 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._
import java.net.URLEncoder

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseApplication {
    

// @LINE:13
def readChallengeAnswerForm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "answer")
}
                                                

// @LINE:20
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:14
def myProfile(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "profile")
}
                                                

// @LINE:15
def readFinancialInstitutionLoginForm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "profile")
}
                                                

// @LINE:12
def readVideoEndedForm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "home")
}
                                                

// @LINE:19
def deleteVideo(videoId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "delete/" + implicitly[PathBindable[Long]].unbind("videoId", videoId))
}
                                                

// @LINE:17
def myVideos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "videos")
}
                                                

// @LINE:18
def readUploadVideoForm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "videos")
}
                                                

// @LINE:16
def deleteFinancialInstitutionLogin(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deleteLogin/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:11
def home(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "home")
}
                                                
    
}
                          

// @LINE:23
class ReverseAssets {
    

// @LINE:23
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseLobby {
    

// @LINE:8
def signup(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "signup")
}
                                                

// @LINE:7
def readLoginForm(): Call = {
   Call("POST", _prefix)
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:9
def readSignupForm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "signup")
}
                                                
    
}
                          
}
                  


// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseApplication {
    

// @LINE:13
def readChallengeAnswerForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.readChallengeAnswerForm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "answer"})
      }
   """
)
                        

// @LINE:20
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:14
def myProfile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.myProfile",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile"})
      }
   """
)
                        

// @LINE:15
def readFinancialInstitutionLoginForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.readFinancialInstitutionLoginForm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "profile"})
      }
   """
)
                        

// @LINE:12
def readVideoEndedForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.readVideoEndedForm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "home"})
      }
   """
)
                        

// @LINE:19
def deleteVideo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteVideo",
   """
      function(videoId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "delete/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("videoId", videoId)})
      }
   """
)
                        

// @LINE:17
def myVideos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.myVideos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "videos"})
      }
   """
)
                        

// @LINE:18
def readUploadVideoForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.readUploadVideoForm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "videos"})
      }
   """
)
                        

// @LINE:16
def deleteFinancialInstitutionLogin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteFinancialInstitutionLogin",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteLogin/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:11
def home : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.home",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "home"})
      }
   """
)
                        
    
}
              

// @LINE:23
class ReverseAssets {
    

// @LINE:23
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseLobby {
    

// @LINE:8
def signup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lobby.signup",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:7
def readLoginForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lobby.readLoginForm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lobby.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:9
def readSignupForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lobby.readSignupForm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:23
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseApplication {
    

// @LINE:13
def readChallengeAnswerForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.readChallengeAnswerForm(), HandlerDef(this, "controllers.Application", "readChallengeAnswerForm", Seq(), "POST", """""", _prefix + """answer""")
)
                      

// @LINE:20
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:14
def myProfile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.myProfile(), HandlerDef(this, "controllers.Application", "myProfile", Seq(), "GET", """""", _prefix + """profile""")
)
                      

// @LINE:15
def readFinancialInstitutionLoginForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.readFinancialInstitutionLoginForm(), HandlerDef(this, "controllers.Application", "readFinancialInstitutionLoginForm", Seq(), "POST", """""", _prefix + """profile""")
)
                      

// @LINE:12
def readVideoEndedForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.readVideoEndedForm(), HandlerDef(this, "controllers.Application", "readVideoEndedForm", Seq(), "POST", """""", _prefix + """home""")
)
                      

// @LINE:19
def deleteVideo(videoId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteVideo(videoId), HandlerDef(this, "controllers.Application", "deleteVideo", Seq(classOf[Long]), "GET", """""", _prefix + """delete/$videoId<[^/]+>""")
)
                      

// @LINE:17
def myVideos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.myVideos(), HandlerDef(this, "controllers.Application", "myVideos", Seq(), "GET", """""", _prefix + """videos""")
)
                      

// @LINE:18
def readUploadVideoForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.readUploadVideoForm(), HandlerDef(this, "controllers.Application", "readUploadVideoForm", Seq(), "POST", """""", _prefix + """videos""")
)
                      

// @LINE:16
def deleteFinancialInstitutionLogin(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteFinancialInstitutionLogin(id), HandlerDef(this, "controllers.Application", "deleteFinancialInstitutionLogin", Seq(classOf[Long]), "GET", """""", _prefix + """deleteLogin/$id<[^/]+>""")
)
                      

// @LINE:11
def home(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.home(), HandlerDef(this, "controllers.Application", "home", Seq(), "GET", """""", _prefix + """home""")
)
                      
    
}
                          

// @LINE:23
class ReverseAssets {
    

// @LINE:23
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseLobby {
    

// @LINE:8
def signup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lobby.signup(), HandlerDef(this, "controllers.Lobby", "signup", Seq(), "GET", """""", _prefix + """signup""")
)
                      

// @LINE:7
def readLoginForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lobby.readLoginForm(), HandlerDef(this, "controllers.Lobby", "readLoginForm", Seq(), "POST", """""", _prefix + """""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lobby.index(), HandlerDef(this, "controllers.Lobby", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:9
def readSignupForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lobby.readSignupForm(), HandlerDef(this, "controllers.Lobby", "readSignupForm", Seq(), "POST", """""", _prefix + """signup""")
)
                      
    
}
                          
}
                  
      