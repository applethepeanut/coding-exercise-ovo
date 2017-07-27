package com.atpfury.ceo.service

case class Result(index: Int, answer: Any)

object Main extends App {

  private val bill = Search.find("Bill McKnight").head
  private val paul = Search.find("Paul Robinson").head

  val answers = Seq(
    Result(1, Search.numberOfMen),
    Result(2, Search.oldestPerson.getOrElse("unknown")),
    Result(3, Search.ageDifference(bill, paul))
  )

  answers.foreach(a => println(s"${a.index}. ${a.answer}"))

}
