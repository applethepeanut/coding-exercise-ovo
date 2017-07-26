package com.atpfury.ceo.domain

case class Person(name: String, gender: String, dob: String)

object Person {

  private val person = """(.+),(.+),(.+)""".r

  def apply(s: String): Option[Person] = s match {
    case person(name, gender, dob) => Some(Person(name.trim, gender.trim, dob.trim))
    case _ => None
  }

}
