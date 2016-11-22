package example

import org.scalajs.jquery.{jQuery => $}
import scalatags.JsDom.all._
import shared.User
import upickle.default._

object UserComponents {

  val Heading = "#greeting"
  val Button = "#click-me-button"
  val Data = "#data"
  val Error = "#errors"

  def headerRow() = {
    li(`class` := "list-group-item tableheader",
      span("Name"),
      span(`class` := "floatright", "Salary")
    )
  }

  def userRow(u: User) = {
    li(`class` := "list-group-item tablerow",
      span(s"${u.lastname}, ${u.firstname}"),
      span(`class` := "floatright", s"$$${u.salary}")
    )


  }

  def displayUserTable(userJson: String): Unit = {
    $(Data).empty()
    $(Data).append(headerRow().toString())
    read[Seq[User]](userJson).map { u =>
      $(Data).append(userRow(u).toString())
    }
  }

  def redBox(message: String) = {
    div(`class` := "alert alert-danger",
      a(`class` := "close glyphicon glyphicon-remove-circle alertred", href := "#", attr("data-dismiss") := "alert"),
      strong(`class` := "glyphicon glyphicon-exclamation-sign"),
      s" SNAP: $message"
    )
  }

  def displayError(message: String): Unit = {
    $(Error).empty()
    $(Error).append(redBox(message).toString())
  }
}
