package example

import org.scalatest._

class HelloSpec extends FlatSpec {
  "The Hello object" should "say hello" in {
    assert(Hello.greeting == "hello")
  }
}
