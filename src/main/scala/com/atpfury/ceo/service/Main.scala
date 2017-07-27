package com.atpfury.ceo.service

case class Result(index: Int, answer: Any)

object Main extends App {

  val answers = Seq(
    Result(1, Search.numberOfMen),
    Result(2, Search.oldestPerson.getOrElse("unknown"))
  )

  answers.foreach{ a =>
    println(s"${a.index}. ${a.answer}")
  }

}
