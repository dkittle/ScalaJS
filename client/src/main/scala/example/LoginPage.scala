package example

import example.LoginComponents._
import org.scalajs.dom
import org.scalajs.jquery._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

@JSExport
object LoginPage {

//  def main(): Unit = {
//    jQuery(setupUI _)
//  }
//
//  def setupUI(): Unit = {
////    jQuery(Button).click(login _)
//  }

  @JSExport
  def login(): Unit = {
    dom.ext.Ajax
      .get("http://localhost:9000/users")
      .map { xhr =>
        displayUserTable(xhr.responseText)
      }
      .recover {
        case e: Exception =>
          displayError(e.toString)
      }
  }

}
