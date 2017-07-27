package com.atpfury.ceo.service


import com.atpfury.ceo.domain.{Gender, Male, Person}
import org.joda.time.Days

import scala.io.Source

trait Search {

  val people: List[Person]

  def numberOfGender(g: Gender) = (l: List[Person]) => l.count(_.gender == g)

  def numberOfMen: Int = numberOfGender(Male)(people)

  def oldestPerson: Option[Person] = people.sortWith { (a, b) =>
    a.dateOfBirth.toDateTimeAtCurrentTime.getMillis <= b.dateOfBirth.toDateTimeAtCurrentTime.getMillis
  }.headOption

  def ageDifference(a: Person, b: Person): Int = Days.daysBetween(a.dateOfBirth, b.dateOfBirth).getDays

  def find(name: String): List[Person] = people.filter(_.name == name)
}

object Search extends Search {

  override val people = Source.fromResource("AddressBook").getLines.map(Person(_)).toList
}
