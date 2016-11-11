package controllers

import javax.inject.Inject

import akka.actor.ActorSystem
import play.api.mvc._
import shared.User
import upickle.default._

import scala.util.Random

class Application @Inject()(webJarAssets: WebJarAssets, system: ActorSystem) extends Controller {

  def index = Action {
    Ok(views.html.index(webJarAssets))
  }

  private def randomSalary = (Random.nextInt(8) + 1) * 15000

  def users = Action {
    val firstnames = Random.shuffle(
      List("Dan", "Bob", "Debbie", "Minnie", "Steve", "Virindra"))
    val lastnames = Random.shuffle(
      List("Smith", "LeBeef", "Archer", "Mango", "Dreth", "Seth"))
    val us = (0 until 5).map { i =>
      User(firstnames(i), lastnames(i), randomSalary)
    }
    Ok(write(us)).as("application/json")
  }

}
