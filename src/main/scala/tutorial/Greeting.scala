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
    jQuery("#click-me-button").click(addClickedMessage _)
  }

  def genTable(): Unit = {
    jQuery("#data").empty()
    jQuery("#data").append(headerRow())
    User.genUsers().foreach { u =>
      jQuery("#data").append(userRow(u))
    }
  }

  def addClickedMessage(): Unit = {
    genTable()
  }

  def headerRow() = {
    val username = jQuery("<span></span>")
      .text("Name")

    val salary = jQuery("<span></span>")
      .attr("style", "float: right")
      .text("Salary")

    jQuery("<li></li>")
      .addClass("list-group-item")
      .attr("style", "background-color: #3BAFDA; color: #ffffff; font-weight: bold;")
      .append(username)
      .append(salary)
  }

  def userRow(u: User) = {
    val username = jQuery("<span></span>")
      .text(s"${u.lastname}, ${u.firstname}")

    val salary = jQuery("<span></span>")
      .attr("style", "float: right;")
      .text("$" + u.salary)

    jQuery("<li></li>")
      .addClass("list-group-item")
      .attr("style", "background-color: #f4f4f4;")
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