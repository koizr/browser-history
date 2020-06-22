package com.koizr.browser_history

import org.scalatest._

class HistorySpec extends FlatSpec {
  "it that has not visited anywhere" should "be start page" in {
    assert(History(Page("start-page")).current == Page("start-page"))
  }

  "it" should "visit page" in {
    val history = History(Page("start-page"))

    history.visit(Page("first visit"))
    assert(history.current == Page("first visit"))

    history.visit(Page("second visit"))
    assert(history.current == Page("second visit"))
  }

  "it" should "back page" in {
    val history = History(Page("start-page"))
    history.visit(Page("first visit"))
    history.visit(Page("second visit"))
    history.visit(Page("third visit"))

    assert(history.current == Page("third visit"))

    history.back(2)
    assert(history.current == Page("first visit"))

    history.back(100)
    assert(history.current == Page("start-page"))
  }

  "it" should "forward page" in {
    val history = History(Page("start-page"))
    history.visit(Page("first visit"))
    history.visit(Page("second visit"))
    history.visit(Page("third visit"))

    assert(history.current == Page("third visit"))

    history.back(2)
    assert(history.current == Page("first visit"))

    history.forward(1)
    assert(history.current == Page("second visit"))
  }

  "it" should "replace history" in {
    val history = History(Page("start-page"))
    history.visit(Page("first visit"))
    history.visit(Page("second visit"))
    history.visit(Page("third visit"))

    assert(history.current == Page("third visit"))

    history.back(2)
    assert(history.current == Page("first visit"))

    history.visit(Page("new second visit"))
    assert(history.current == Page("new second visit"))

    history.forward(1)
    assert(history.current == Page("new second visit"))

    history.back((1))
    assert(history.current == Page("first visit"))
  }
}
