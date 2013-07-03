// @SOURCE:C:/programs/ray/adagie/conf/routes
// @HASH:d8e7615165839265510891e6f4ad9507384fd0c6
// @DATE:Tue Jul 02 22:25:11 EDT 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._
import java.net.URLEncoder

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:15
def readChallengeAnswerForm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "answer")
}
                                                

// @LINE:11
def postProfile(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "p")
}
                                                

// @LINE:22
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:16
def myProfile(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "profile")
}
                                                

// @LINE:17
def readFinancialInstitutionLoginForm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "profile")
}
                                                

// @LINE:14
def readVideoEndedForm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "home")
}
                                                

// @LINE:21
def deleteVideo(videoId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "delete/" + implicitly[PathBindable[Long]].unbind("videoId", videoId))
}
                                                

// @LINE:19
def myVideos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "videos")
}
                                                

// @LINE:20
def readUploadVideoForm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "videos")
}
                                                

// @LINE:18
def deleteFinancialInstitutionLogin(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deleteLogin/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:13
def home(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "home")
}
                                                

// @LINE:10
def getProfile(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "p")
}
                                                
    
}
                          

// @LINE:25
class ReverseAssets {
    

// @LINE:25
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
def getSignup(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "signup")
}
                                                

// @LINE:6
def getIndex(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:9
def postSignup(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "signup")
}
                                                

// @LINE:7
def postIndex(): Call = {
   Call("POST", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:15
def readChallengeAnswerForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.readChallengeAnswerForm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "answer"})
      }
   """
)
                        

// @LINE:11
def postProfile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.postProfile",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "p"})
      }
   """
)
                        

// @LINE:22
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:16
def myProfile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.myProfile",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile"})
      }
   """
)
                        

// @LINE:17
def readFinancialInstitutionLoginForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.readFinancialInstitutionLoginForm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "profile"})
      }
   """
)
                        

// @LINE:14
def readVideoEndedForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.readVideoEndedForm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "home"})
      }
   """
)
                        

// @LINE:21
def deleteVideo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteVideo",
   """
      function(videoId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "delete/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("videoId", videoId)})
      }
   """
)
                        

// @LINE:19
def myVideos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.myVideos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "videos"})
      }
   """
)
                        

// @LINE:20
def readUploadVideoForm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.readUploadVideoForm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "videos"})
      }
   """
)
                        

// @LINE:18
def deleteFinancialInstitutionLogin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteFinancialInstitutionLogin",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteLogin/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:13
def home : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.home",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "home"})
      }
   """
)
                        

// @LINE:10
def getProfile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getProfile",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "p"})
      }
   """
)
                        
    
}
              

// @LINE:25
class ReverseAssets {
    

// @LINE:25
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
def getSignup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lobby.getSignup",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:6
def getIndex : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lobby.getIndex",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:9
def postSignup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lobby.postSignup",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:7
def postIndex : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Lobby.postIndex",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:25
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:15
def readChallengeAnswerForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.readChallengeAnswerForm(), HandlerDef(this, "controllers.Application", "readChallengeAnswerForm", Seq(), "POST", """""", _prefix + """answer""")
)
                      

// @LINE:11
def postProfile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.postProfile(), HandlerDef(this, "controllers.Application", "postProfile", Seq(), "POST", """""", _prefix + """p""")
)
                      

// @LINE:22
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:16
def myProfile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.myProfile(), HandlerDef(this, "controllers.Application", "myProfile", Seq(), "GET", """""", _prefix + """profile""")
)
                      

// @LINE:17
def readFinancialInstitutionLoginForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.readFinancialInstitutionLoginForm(), HandlerDef(this, "controllers.Application", "readFinancialInstitutionLoginForm", Seq(), "POST", """""", _prefix + """profile""")
)
                      

// @LINE:14
def readVideoEndedForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.readVideoEndedForm(), HandlerDef(this, "controllers.Application", "readVideoEndedForm", Seq(), "POST", """""", _prefix + """home""")
)
                      

// @LINE:21
def deleteVideo(videoId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteVideo(videoId), HandlerDef(this, "controllers.Application", "deleteVideo", Seq(classOf[Long]), "GET", """""", _prefix + """delete/$videoId<[^/]+>""")
)
                      

// @LINE:19
def myVideos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.myVideos(), HandlerDef(this, "controllers.Application", "myVideos", Seq(), "GET", """""", _prefix + """videos""")
)
                      

// @LINE:20
def readUploadVideoForm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.readUploadVideoForm(), HandlerDef(this, "controllers.Application", "readUploadVideoForm", Seq(), "POST", """""", _prefix + """videos""")
)
                      

// @LINE:18
def deleteFinancialInstitutionLogin(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteFinancialInstitutionLogin(id), HandlerDef(this, "controllers.Application", "deleteFinancialInstitutionLogin", Seq(classOf[Long]), "GET", """""", _prefix + """deleteLogin/$id<[^/]+>""")
)
                      

// @LINE:13
def home(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.home(), HandlerDef(this, "controllers.Application", "home", Seq(), "GET", """""", _prefix + """home""")
)
                      

// @LINE:10
def getProfile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getProfile(), HandlerDef(this, "controllers.Application", "getProfile", Seq(), "GET", """""", _prefix + """p""")
)
                      
    
}
                          

// @LINE:25
class ReverseAssets {
    

// @LINE:25
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
def getSignup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lobby.getSignup(), HandlerDef(this, "controllers.Lobby", "getSignup", Seq(), "GET", """""", _prefix + """signup""")
)
                      

// @LINE:6
def getIndex(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lobby.getIndex(), HandlerDef(this, "controllers.Lobby", "getIndex", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:9
def postSignup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lobby.postSignup(), HandlerDef(this, "controllers.Lobby", "postSignup", Seq(), "POST", """""", _prefix + """signup""")
)
                      

// @LINE:7
def postIndex(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Lobby.postIndex(), HandlerDef(this, "controllers.Lobby", "postIndex", Seq(), "POST", """""", _prefix + """""")
)
                      
    
}
                          
}
                  
      