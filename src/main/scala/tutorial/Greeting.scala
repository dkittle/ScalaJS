package tutorial

import scala.util.Random
import scala.scalajs.js
import scala.scalajs.js.JSApp
import org.scalajs.jquery.{JQuery, jQuery}

object Greeting extends JSApp {

  def main(): Unit = {
    jQuery(setupUI _)
  }

  def setupUI(): Unit = {
    jQuery("#greeting").append("Hello World")
    genTable()
    jQuery("#click-me-button").click(regenerateEmployees _)
  }

  def genTable(): Unit = {
    jQuery("#data").empty()
    jQuery("#data").append(headerRow())
    User.genUsers().foreach { u =>
      jQuery("#data").append(userRow(u))
    }
  }

  def regenerateEmployees(): Unit = {
    genTable()
  }

  val SPAN = "<span></span>"
  val SPAN_RIGHT = "<span class=\"floatright\"></span>"
  val LIST_ITEM = "<li></li>"

  def headerRow() = {
    val username = jQuery(SPAN).text("Name")
    val salary = jQuery(SPAN_RIGHT).text("Salary")

    jQuery(LIST_ITEM)
      .addClass("list-group-item tableheader")
      .append(username)
      .append(salary)
  }

  def userRow(u: User) = {
    val username = jQuery(SPAN).text(s"${u.lastname}, ${u.firstname}")
    val salary = jQuery(SPAN_RIGHT).text("$" + u.salary)

    jQuery(LIST_ITEM)
      .addClass("list-group-item tablerow")
      .append(username)
      .append(salary)
  }

}

case class User(firstname: String, lastname: String, salary: Double)

object User {

  def genUsers() = {
    val firstnames = Random.shuffle(List("Dan", "Bob", "Debbie", "Minnie", "Steve", "Virindra"))
    val lastnames = Random.shuffle(List("Smith","LeBeef","Archer","Mango","Dreth", "Seth"))
    for (i <- 0 to 5) yield User(firstnames(i), lastnames(i), (Random.nextInt(6) + 1) * 15000)
  }

}
