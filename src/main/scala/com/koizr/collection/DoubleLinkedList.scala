package com.koizr.collection

case class DoubleLinkedList[A](value: A) {
  private var _prev: Option[DoubleLinkedList[A]] = Option.empty
  private var _next: Option[DoubleLinkedList[A]] = Option.empty

  def prev: Option[DoubleLinkedList[A]] = _prev

  def next: Option[DoubleLinkedList[A]] = _next

  def isFirst: Boolean = prev.isEmpty

  def isLast: Boolean = next.isEmpty

  def linkPrev(prev: DoubleLinkedList[A]): DoubleLinkedList[A] = {
    prev._next = Some(this)
    this._prev = Some(prev)
    prev
  }

  def linkNext(next: DoubleLinkedList[A]): DoubleLinkedList[A] = {
    next._prev = Some(this)
    this._next = Some(next)
    next
  }

  def add(next: A): DoubleLinkedList[A] = linkNext(DoubleLinkedList(next))

  def back(n: Int): DoubleLinkedList[A] =
    if (n == 0) {
      this
    } else {
      this.prev match {
        case Some(p) => p.back(n - 1)
        case None => this
      }
    }

  def forward(n: Int): DoubleLinkedList[A] =
    if (n == 0) {
      this
    } else {
      this.next match {
        case Some(p) => p.forward(n - 1)
        case None => this
      }
    }
}
