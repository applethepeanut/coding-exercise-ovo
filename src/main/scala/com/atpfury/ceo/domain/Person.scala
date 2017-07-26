package com.atpfury.ceo.domain

case class Person(name: String, gender: String, dob: String)

object Person {

  def apply(s: String): Option[Person] = s.trim match {
    case "" => None
    case _ => None
  }

}
