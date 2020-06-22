package com.koizr.collection

import org.scalatest._

class DoubleLinkedListSpec extends FlatSpec {
  "it is linked prev then it" should "have previous item" in {
    val a = DoubleLinkedList(1)
    val b = DoubleLinkedList(2)
    a.linkPrev(b)

    assert(a.prev.get == b)
    assert(b.next.get == a)
  }

  "it is linked next then it" should "have next item" in {
    val a = DoubleLinkedList(1)
    val b = DoubleLinkedList(2)
    a.linkNext(b)

    assert(a.next.get == b)
    assert(b.prev.get == a)
  }

  "it has not prev then it" should "be first" in {
    assert(DoubleLinkedList(1).isFirst)
    assert(DoubleLinkedList(2).linkPrev(DoubleLinkedList(1)).isFirst)
  }

  "it has not next then it" should "be last" in {
    assert(DoubleLinkedList(1).isLast)
    assert(DoubleLinkedList(1).linkNext(DoubleLinkedList(2)).isLast)
  }

  "3 previous items" can "back 3" in {
    val a = DoubleLinkedList(1)
    val b = DoubleLinkedList(2)
    val c = DoubleLinkedList(3)
    val d = DoubleLinkedList(4)

    d.linkPrev(c).linkPrev(b).linkPrev(a)
    assert(d.back(1) == c)
    assert(d.back(2) == b)
    assert(d.back(3) == a)
    assert(d.back(4) == a)
  }

  "3 next items" can "forward 3" in {
    val a = DoubleLinkedList(1)
    val b = DoubleLinkedList(2)
    val c = DoubleLinkedList(3)
    val d = DoubleLinkedList(4)

    a.linkNext(b).linkNext(c).linkNext(d)
    assert(a.forward(1) == b)
    assert(a.forward(2) == c)
    assert(a.forward(3) == d)
    assert(a.forward(4) == d)
  }
}
