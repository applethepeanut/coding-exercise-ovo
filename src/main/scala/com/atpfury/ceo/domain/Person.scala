package com.atpfury.ceo.domain

import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat

case class Person(name: String, gender: Gender, dateOfBirth: LocalDate)

object Person {

  private val person = """(.+),(.+),(.+)""".r
  private val dobFormatter = DateTimeFormat.forPattern("dd/MM/yy")

  def apply(s: String): Person = s match {
    case person(name, gender, dob) =>
      val g = Gender(gender)
      val dateOfBirth = LocalDate.parse(dob.trim, dobFormatter)
      Person(name.trim, g, dateOfBirth)
    case _ => throw new IllegalArgumentException(s"Failed to parse Person from '$s'")
  }

}
