package tutorial

import org.scalajs.jquery.jQuery
import tutorial.GreetingComponents._

import scala.scalajs.js.JSApp
import scala.util.Random

object Greeting extends JSApp {

  def main(): Unit = {
    jQuery(setupUI _)
  }

  def setupUI(): Unit = {
    jQuery(Heading).append("Hello World")
    genTable()
    jQuery(Button).click(regenerateEmployees _)
  }

  def genTable(): Unit = {
    jQuery(Data).empty()
    jQuery(Data).append(headerRow())
    User.genUsers().foreach { u =>
      jQuery(Data).append(userRow(u))
    }
  }

  def regenerateEmployees(): Unit = {
    genTable()
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

  def randomNameIndex = Random.nextInt(5) + 1

  def randomSalary = (Random.nextInt(8) + 1) * 15000

  def genUsers() = {
    val firstnames = Random.shuffle(List("Dan", "Bob", "Debbie", "Minnie", "Steve", "Virindra"))
    val lastnames = Random.shuffle(List("Smith", "LeBeef", "Archer", "Mango", "Dreth", "Seth"))
    for (i <- 0 to 5) yield User(firstnames(randomNameIndex), lastnames(randomNameIndex), randomSalary)
  }

}
