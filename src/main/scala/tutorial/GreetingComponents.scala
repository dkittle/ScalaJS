package tutorial

import org.scalajs.jquery._

object GreetingComponents {

  val Heading = "#greeting"
  val Button = "#click-me-button"
  val Data = "#data"

  val SPAN = "<span></span>"
  val SPAN_RIGHT = "<span class=\"floatright\"></span>"
  val LIST_ITEM = "<li></li>"

  def headerRow() = {
    jQuery(LIST_ITEM)
      .addClass("list-group-item tableheader")
      .append(jQuery(SPAN).text("Name"))
      .append(jQuery(SPAN_RIGHT).text("Salary"))
  }

}
