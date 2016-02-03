package tutorial

import scala.util.Random
import scala.scalajs.js
import scala.scalajs.js.JSApp
import org.scalajs.jquery.jQuery

object Greeting extends JSApp {

  def main(): Unit = {
    jQuery(setupUI _)
  }

  def setupUI(): Unit = {
    jQuery("#greeting").append("Hello World")
    genTable()
    jQuery("#click-me-button").click(addClickedMessage _)
  }

  // I shouldn't couple the fading out/in of the refreshing component with
  // the code that draws it.  This feels like a mix-in to me..
//  def genTable(): Unit = {
//    jQuery("#data").fadeOut(100, "linear", callback = { (data: js.Any) =>
//      jQuery("#data").empty()
//      User.genUsers().foreach { u =>
//        jQuery("#data").append(userRow(u))
//      }
//      jQuery("#data").fadeIn(900) })
//  }
//  def genTable(): Unit = {
//    jQuery("#data").fadeOut(100, "linear", callback = { (data: js.Any) =>
//      jQuery("#data").empty()
//      User.genUsers().foreach { u =>
//        jQuery("#data").append(userRow(u))
//      }
//      jQuery("#data").fadeIn(900) })
//  }

  def genTable(): Unit = {
    jQuery("#data").empty()
    User.genUsers().foreach { u =>
      jQuery("#data").append(userRow(u))
    }
  }

  def addClickedMessage(): Unit = {
    genTable()
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

  def genUsers() = {
    val firstnames = Random.shuffle(List("Dan", "Bob", "Debbie", "Minnie", "Steve", "Virindra"))
    val lastnames = Random.shuffle(List("Smith","LeBeef","Archer","Mango","Dreth", "Seth"))
    for (i <- 0 to 5) yield User(firstnames(i), lastnames(i), (Random.nextInt(6) + 1) * 15000)
  }

}