package com.atpfury.ceo.service

import com.atpfury.ceo.domain.{Male, Female, Person}
import org.joda.time.LocalDate
import org.scalatest.{Matchers, WordSpecLike}

class SearchSpec extends WordSpecLike with Matchers {

  trait Setup {

    val oldest = Person("Oldest Guy", Male, new LocalDate(1904, 1, 1))
    val lady = Person("A Lady", Female, new LocalDate(1988, 2, 9))

    val allPeople = List(
      Person("Some guy", Male, new LocalDate(1988, 4, 9)),
      lady,
      oldest
    )

    lazy val search = new Search {
      override val people = allPeople
    }
  }

  "find" should {

    "return a list of people who's name exactly match the given name" in new Setup {
      override val allPeople = List(
        Person("Jane", Female, new LocalDate(2000, 1, 1)),
        Person("Steve", Male, new LocalDate(2000, 1, 1)),
        Person("Jane", Female, new LocalDate(2000, 2, 2))
      )

      search.find("Jane") shouldBe List(
        Person("Jane", Female, new LocalDate(2000, 1, 1)),
        Person("Jane", Female, new LocalDate(2000, 2, 2))
      )
    }

    "return an empty list when no people are found but he given name" in new Setup {
      search.find("zzz") shouldBe empty
    }
  }

  "ageDifference" should {

    "return 0 when 2 people are of the same age" in new Setup {
      val a = Person("C D", Male, new LocalDate(2000, 2, 5))
      val b = Person("A B", Male, new LocalDate(2000, 2, 5))

      search.ageDifference(a, b) shouldBe 0
    }

    "return the age difference between 2 people" in new Setup {
      val a = Person("A", Male, new LocalDate(1977, 2, 3))
      val b = Person("B", Female, new LocalDate(1977, 2, 15))

      search.ageDifference(a, b) shouldBe 12
    }

    "return the age difference between 2 people as a negative number" in new Setup {
      val a = Person("C D", Male, new LocalDate(2000, 2, 5))
      val b = Person("A B", Male, new LocalDate(2000, 2, 3))

      search.ageDifference(a, b) shouldBe -2
    }
  }

  "oldestPerson" should {

    "return the oldest person in the list" in new Setup {
      search.oldestPerson shouldBe Some(oldest)
    }

    "return the None if the list is empty" in new Setup {
      override val allPeople = List.empty[Person]
      search.oldestPerson shouldBe None
    }
  }

  "numberOfMen" should {

    "return the count of all men in the list" in new Setup {
      search.numberOfMen shouldBe 2
    }

    "return 0 when there are no men" in new Setup {
      override val allPeople = List(lady)
      search.numberOfMen shouldBe 0
    }

    "return 0 when there are no people" in new Setup {
      override val allPeople = List.empty[Person]
      search.numberOfMen shouldBe 0
    }
  }

  "numberOfGender" should {

    "return the number of men" in new Setup {
      val menIn = search.numberOfGender(Male)
      menIn(allPeople) shouldBe 2
    }

    "return the number of women" in new Setup {
      val womenIn = search.numberOfGender(Female)
      womenIn(allPeople) shouldBe 1
    }
  }

}
