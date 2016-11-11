package example

import org.scalajs.jquery.{jQuery => $}
import shared.User
import upickle.default._

object UserComponents {

  val Heading = "#greeting"
  val Button = "#click-me-button"
  val Data = "#data"
  val Error = "#errors"

  val DIV = "<div />"
  val STRONG = "<strong />"
  val SPAN = "<span />"
  val A = "<a />"
  val SPAN_RIGHT = "<span class=\"floatright\" />"
  val LIST_ITEM = "<li />"

  def headerRow() = {
    $(LIST_ITEM)
      .addClass("list-group-item tableheader")
      .append($(SPAN).text("Name"))
      .append($(SPAN_RIGHT).text("Salary"))
  }

  def userRow(u: User) = {
    val username = $(SPAN).text(s"${u.lastname}, ${u.firstname}")
    val salary = $(SPAN_RIGHT).text(s"$$${u.salary}")

    $(LIST_ITEM)
      .addClass("list-group-item tablerow")
      .append(username)
      .append(salary)
  }

  def displayUserTable(userJson: String): Unit = {
    $(Data).empty()
    $(Data).append(headerRow())
    read[Seq[User]](userJson).map { u =>
      $(Data).append(userRow(u))
    }
  }

  def displayError(message: String): Unit = {
    $(Error).empty()
    val redBox = $(DIV).addClass("alert alert-danger")
    val close = $(A).addClass("close glyphicon glyphicon-remove-circle alertred").attr("href", "#").attr("data-dismiss", "alert")
    val error = $(STRONG).addClass("glyphicon glyphicon-exclamation-sign")
    redBox.append(close).append(error).append(s" $message")
    $(Error).append(redBox)
  }
}
