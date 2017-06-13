package example

import example.UserComponents._
import org.scalajs.dom
import org.scalajs.jquery.{jQuery => $}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object UserPage extends JSApp {

  def main(): Unit = {
    $(setupUI _)
  }

  def setupUI(): Unit = {
    $(Heading).append("Users")
    regenerateEmployees()
    $(Button).click(regenerateEmployees _)
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
          displayError(e.toString)
      }
  }

}
