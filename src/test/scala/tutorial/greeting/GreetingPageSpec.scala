package tutorial.greeting

import org.scalatest.concurrent.{IntegrationPatience, Eventually}
import org.scalatest.selenium.{WebBrowser, Driver}
import org.scalatest.{BeforeAndAfterAll, Matchers, FlatSpec}

import org.openqa.selenium.WebDriver
//import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver

class GreetingPageSpec extends FlatSpec with Eventually with Matchers with
  IntegrationPatience with BeforeAndAfterAll with WebBrowser with Driver {

  implicit val webDriver: WebDriver = new PhantomJSDriver
  val greetingPage = new GreetingPage

  "Navigating to homepage" should "display the homepage with Hello World" in {
    go to greetingPage
    currentUrl should be (greetingPage.url)
    pageTitle should be (greetingPage.pageTitle)
    find(id("greeting")).get.text should be ("Hello World")
  }

  override def afterAll {
    quit()
  }

}
