package com.atpfury.ceo.service


import com.atpfury.ceo.domain.{Female, Gender, Male, Person}
import org.joda.time.LocalDate

trait Search {

  val people: List[Person]

  def numberOf(g: Gender) = (l: List[Person]) => l.count(_.gender == g)

  def numberOfMen: Int = numberOf(Male)(people)

  def oldestPerson: Option[Person] = people.sortWith { (a, b) =>
    a.dateOfBirth.toDateTimeAtCurrentTime.getMillis <= b.dateOfBirth.toDateTimeAtCurrentTime.getMillis
  }.headOption
}

object Search extends Search {

  override val people = List(
    Person("Bill McKnight", Male, new LocalDate(1997, 2, 3)),
    Person("Paul Robinson", Male, new LocalDate(1985, 1, 15)),
    Person("Gemma Lane", Female, new LocalDate(1991, 11, 20)),
    Person("Sarah Stone", Female, new LocalDate(1980, 9, 20)),
    Person("Wes Jackson", Male, new LocalDate(1974, 8, 14))
  )
}
