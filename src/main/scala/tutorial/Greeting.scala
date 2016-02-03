package tutorial

import scala.util.Random
import scala.scalajs.js.JSApp
import org.scalajs.jquery.jQuery

object Greeting extends JSApp {

  val users = User.genUsers()

  def main(): Unit = {
    jQuery(setupUI _)
  }

  def setupUI(): Unit = {
    jQuery("#greeting").append("Hello World")
    genTable()
    jQuery("#click-me-button").click(addClickedMessage _)
  }

  def genTable(): Unit = {
//    jQuery("#data").empty()
    users.foreach { u =>
      jQuery("#data").append(userRow(u))
    }
  }

  def addClickedMessage(): Unit = {
    jQuery("body").append("<p>You clicked the button.</p>")
  }

  def userRow(u: User) = {
    val username = jQuery("<span></span>")
      .text(s"${u.lastname}, ${u.firstname}")

    val salary = jQuery("<span></span>")
      .attr("style", "float: right; marginTop: -5")
      .text("$" + u.salary)

    jQuery("<li></li>")
      .addClass("list-group-item")
      .append(username)
      .append(salary)
  }

}

case class User(firstname: String, lastname: String, salary: Double)

object User {
  val firstnames = List("Dan", "Bob", "Debbie", "Minnie", "Steve")
  val lastnames = Random.shuffle(List("Smith","LeBeef","Archer","Mango","Dreth"))

  def genUsers() = {
    for (i <- 0 to 4) yield User(firstnames(i), lastnames(i), (Random.nextInt(6) + 1) * 15000)
  }

}