package com.atpfury.ceo.domain

case class Person(name: String, gender: Gender, dob: String)

object Person {

  private val person = """(.+),(.+),(.+)""".r

  def apply(s: String): Option[Person] = s match {
    case person(name, gender, dob) => Some(Person(name.trim, Gender(gender), dob.trim))
    case _ => None
  }

}
