package example

import example.UserComponents._
import org.scalajs.dom
import org.scalajs.jquery._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object UserPage extends JSApp {

  def main(): Unit = {
    jQuery(setupUI _)
  }

  def setupUI(): Unit = {
    jQuery(Heading).append("Hello World")
    regenerateEmployees()
    jQuery(Button).click(regenerateEmployees _)
  }

  @JSExport
  def regenerateEmployees(): Unit = {
    dom.ext.Ajax
      .get("http://localhost:9000/users")
      .map { xhr =>
        displayUserTable(xhr.responseText)
      }
      .recover {
        case e: Exception =>
          dom.console.log(s"ERROR ------------- ${e.toString}")
      }
  }

}
