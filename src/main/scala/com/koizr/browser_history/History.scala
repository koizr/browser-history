package com.koizr.browser_history

import com.koizr.collection.DoubleLinkedList


class History(private var currentPage: DoubleLinkedList[Page]) {
  def current: Page = currentPage.value

  def visit(url: Page): Unit = currentPage = currentPage.add(url)

  def back(n: Int): Unit = currentPage = currentPage.back(n)

  def forward(n: Int): Unit = currentPage = currentPage.forward(n)
}

object History {
  def apply(startPage: Page): History = new History(DoubleLinkedList(startPage))
}

case class Page(value: String) extends AnyVal
