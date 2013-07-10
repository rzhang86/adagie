// @SOURCE:C:/programs/ray/adagie/conf/routes
// @HASH:34bcce54af61ef30c5890cbca16e0a35d3d4b283
// @DATE:Tue Jul 09 23:58:17 EDT 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._
import java.net.URLEncoder

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:28
// @LINE:25
// @LINE:24
// @LINE:23
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
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:10
class ReverseAbout {
    

// @LINE:10
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "about")
}
                                                
    
}
                          

// @LINE:19
// @LINE:18
// @LINE:17
class ReverseUploads {
    

// @LINE:18
def post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "uploads")
}
                                                

// @LINE:19
def delete(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "uploads/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:17
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "uploads")
}
                                                
    
}
                          

// @LINE:12
class ReverseContact {
    

// @LINE:12
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "contact")
}
                                                
    
}
                          

// @LINE:14
// @LINE:13
class ReverseHome {
    

// @LINE:14
def post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "home")
}
                                                

// @LINE:13
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "home")
}
                                                
    
}
                          

// @LINE:16
// @LINE:15
class ReverseProfile {
    

// @LINE:16
def post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "profile")
}
                                                

// @LINE:15
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "profile")
}
                                                
    
}
                          

// @LINE:25
class ReverseLogout {
    

// @LINE:25
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                
    
}
                          

// @LINE:22
// @LINE:21
// @LINE:20
class ReverseAccounts {
    

// @LINE:21
def post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "accounts")
}
                                                

// @LINE:22
def delete(id:Long): Call = {
   Call("DELETE", _prefix + { _defaultPrefix } + "accounts/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:20
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "accounts")
}
                                                
    
}
                          

// @LINE:7
// @LINE:6
class ReverseLogin {
    

// @LINE:7
def post(): Call = {
   Call("POST", _prefix)
}
                                                

// @LINE:6
def get(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:11
class ReverseFaq {
    

// @LINE:11
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "faq")
}
                                                
    
}
                          

// @LINE:9
// @LINE:8
class ReverseSignup {
    

// @LINE:9
def post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "signup")
}
                                                

// @LINE:8
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "signup")
}
                                                
    
}
                          

// @LINE:24
// @LINE:23
class ReverseNotifications {
    

// @LINE:24
def post(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "notifications")
}
                                                

// @LINE:23
def get(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "notifications")
}
                                                
    
}
                          
}
                  


// @LINE:28
// @LINE:25
// @LINE:24
// @LINE:23
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
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:10
class ReverseAbout {
    

// @LINE:10
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.About.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "about"})
      }
   """
)
                        
    
}
              

// @LINE:19
// @LINE:18
// @LINE:17
class ReverseUploads {
    

// @LINE:18
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Uploads.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploads"})
      }
   """
)
                        

// @LINE:19
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Uploads.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploads/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:17
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Uploads.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "uploads"})
      }
   """
)
                        
    
}
              

// @LINE:12
class ReverseContact {
    

// @LINE:12
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Contact.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contact"})
      }
   """
)
                        
    
}
              

// @LINE:14
// @LINE:13
class ReverseHome {
    

// @LINE:14
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Home.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "home"})
      }
   """
)
                        

// @LINE:13
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Home.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "home"})
      }
   """
)
                        
    
}
              

// @LINE:16
// @LINE:15
class ReverseProfile {
    

// @LINE:16
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Profile.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "profile"})
      }
   """
)
                        

// @LINE:15
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Profile.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile"})
      }
   """
)
                        
    
}
              

// @LINE:25
class ReverseLogout {
    

// @LINE:25
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Logout.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        
    
}
              

// @LINE:22
// @LINE:21
// @LINE:20
class ReverseAccounts {
    

// @LINE:21
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Accounts.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accounts"})
      }
   """
)
                        

// @LINE:22
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Accounts.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "accounts/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:20
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Accounts.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accounts"})
      }
   """
)
                        
    
}
              

// @LINE:7
// @LINE:6
class ReverseLogin {
    

// @LINE:7
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Login.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:6
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Login.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:11
class ReverseFaq {
    

// @LINE:11
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Faq.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "faq"})
      }
   """
)
                        
    
}
              

// @LINE:9
// @LINE:8
class ReverseSignup {
    

// @LINE:9
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Signup.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:8
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Signup.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:23
class ReverseNotifications {
    

// @LINE:24
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Notifications.post",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "notifications"})
      }
   """
)
                        

// @LINE:23
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Notifications.get",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "notifications"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:28
// @LINE:25
// @LINE:24
// @LINE:23
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
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:10
class ReverseAbout {
    

// @LINE:10
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.About.get(), HandlerDef(this, "controllers.About", "get", Seq(), "GET", """""", _prefix + """about""")
)
                      
    
}
                          

// @LINE:19
// @LINE:18
// @LINE:17
class ReverseUploads {
    

// @LINE:18
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Uploads.post(), HandlerDef(this, "controllers.Uploads", "post", Seq(), "POST", """""", _prefix + """uploads""")
)
                      

// @LINE:19
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Uploads.delete(id), HandlerDef(this, "controllers.Uploads", "delete", Seq(classOf[Long]), "POST", """""", _prefix + """uploads/$id<[^/]+>""")
)
                      

// @LINE:17
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Uploads.get(), HandlerDef(this, "controllers.Uploads", "get", Seq(), "GET", """""", _prefix + """uploads""")
)
                      
    
}
                          

// @LINE:12
class ReverseContact {
    

// @LINE:12
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Contact.get(), HandlerDef(this, "controllers.Contact", "get", Seq(), "GET", """""", _prefix + """contact""")
)
                      
    
}
                          

// @LINE:14
// @LINE:13
class ReverseHome {
    

// @LINE:14
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Home.post(), HandlerDef(this, "controllers.Home", "post", Seq(), "POST", """""", _prefix + """home""")
)
                      

// @LINE:13
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Home.get(), HandlerDef(this, "controllers.Home", "get", Seq(), "GET", """""", _prefix + """home""")
)
                      
    
}
                          

// @LINE:16
// @LINE:15
class ReverseProfile {
    

// @LINE:16
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Profile.post(), HandlerDef(this, "controllers.Profile", "post", Seq(), "POST", """""", _prefix + """profile""")
)
                      

// @LINE:15
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Profile.get(), HandlerDef(this, "controllers.Profile", "get", Seq(), "GET", """""", _prefix + """profile""")
)
                      
    
}
                          

// @LINE:25
class ReverseLogout {
    

// @LINE:25
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Logout.get(), HandlerDef(this, "controllers.Logout", "get", Seq(), "GET", """""", _prefix + """logout""")
)
                      
    
}
                          

// @LINE:22
// @LINE:21
// @LINE:20
class ReverseAccounts {
    

// @LINE:21
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Accounts.post(), HandlerDef(this, "controllers.Accounts", "post", Seq(), "POST", """""", _prefix + """accounts""")
)
                      

// @LINE:22
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Accounts.delete(id), HandlerDef(this, "controllers.Accounts", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """accounts/$id<[^/]+>""")
)
                      

// @LINE:20
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Accounts.get(), HandlerDef(this, "controllers.Accounts", "get", Seq(), "GET", """""", _prefix + """accounts""")
)
                      
    
}
                          

// @LINE:7
// @LINE:6
class ReverseLogin {
    

// @LINE:7
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Login.post(), HandlerDef(this, "controllers.Login", "post", Seq(), "POST", """""", _prefix + """""")
)
                      

// @LINE:6
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Login.get(), HandlerDef(this, "controllers.Login", "get", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:11
class ReverseFaq {
    

// @LINE:11
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Faq.get(), HandlerDef(this, "controllers.Faq", "get", Seq(), "GET", """""", _prefix + """faq""")
)
                      
    
}
                          

// @LINE:9
// @LINE:8
class ReverseSignup {
    

// @LINE:9
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Signup.post(), HandlerDef(this, "controllers.Signup", "post", Seq(), "POST", """""", _prefix + """signup""")
)
                      

// @LINE:8
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Signup.get(), HandlerDef(this, "controllers.Signup", "get", Seq(), "GET", """""", _prefix + """signup""")
)
                      
    
}
                          

// @LINE:24
// @LINE:23
class ReverseNotifications {
    

// @LINE:24
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Notifications.post(), HandlerDef(this, "controllers.Notifications", "post", Seq(), "POST", """""", _prefix + """notifications""")
)
                      

// @LINE:23
def get(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Notifications.get(), HandlerDef(this, "controllers.Notifications", "get", Seq(), "GET", """""", _prefix + """notifications""")
)
                      
    
}
                          
}
                  
      