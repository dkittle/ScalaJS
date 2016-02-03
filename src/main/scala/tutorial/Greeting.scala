package tutorial

import scala.util.Random
import scala.scalajs.js.JSApp
import org.scalajs.jquery.jQuery

object Greeting extends JSApp {

  def main(): Unit = {
    jQuery(setupUI _)
  }

  def genTable(): Unit = {
    jQuery("#data").empty()
    val names = Array("Dan", "Bob", "Debbie", "Minnie", "Steve")
    val lastnames = Random.shuffle(List("Smith","LeBeef","Archer","Mango","Dreth"))

    (0 until 5).foreach { x =>

      val username = jQuery("<span></span>")
        .text(s"${names(x)} ${lastnames(x)}")

      val salary = jQuery("<span></span>")
        .attr("style", "float: right; marginTop: -5")
        .text("$" + ((Random.nextInt(6) + 1) * 15000))

      val row = jQuery("<li></li>")
        .addClass("list-group-item")
        .append(username)
        .append(salary)

      jQuery("#data").append(row)
    }
  }

  def addClickedMessage(): Unit = {
    jQuery("body").append("<p>You clicked the button.</p>")
    genTable()
  }

  def setupUI(): Unit = {
    jQuery("#greeting").append("Hello World")
    genTable()
    jQuery("#click-me-button").click(addClickedMessage _)
  }
}
