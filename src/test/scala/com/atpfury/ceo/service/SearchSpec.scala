package com.atpfury.ceo.service

import com.atpfury.ceo.domain.{Male, Female, Person}
import org.joda.time.LocalDate
import org.scalatest.{Matchers, WordSpecLike}

class SearchSpec extends WordSpecLike with Matchers {

  trait Setup {

    val allPeople = List(
      Person("Bill McKnight", Male, new LocalDate(1977, 2, 3)),
      Person("Paul Robinson", Male, new LocalDate(1985, 1, 15)),
      Person("Gemma Lane", Female, new LocalDate(1991, 11, 20)),
      Person("Sarah Stone", Female, new LocalDate(1980, 9, 20)),
      Person("Wes Jackson", Male, new LocalDate(1974, 8, 14))
    )

    lazy val search = new Search {
      override val people = allPeople
    }
  }

  "ageDifference" should {

    "return the age difference between 2 people" in new Setup {
      val bill = Person("Bill McKnight", Male, new LocalDate(1977, 2, 3))
      val paul = Person("Paul Robinson", Male, new LocalDate(1985, 1, 15))

      search.ageDifference(bill, paul) shouldBe 2903
    }

    "return the age difference between 2 people as a negative number" in new Setup {
      val a = Person("C D", Male, new LocalDate(2000, 2, 5))
      val b = Person("A B", Male, new LocalDate(2000, 2, 3))

      search.ageDifference(a, b) shouldBe -2
    }
  }

  "oldestPerson" should {

    "return the oldest person in the list" in new Setup {
      search.oldestPerson shouldBe Some(Person("Wes Jackson", Male, new LocalDate(1974, 8, 14)))
    }

    "return the None if the list is empty" in new Setup {
      override val allPeople = List.empty[Person]
      search.oldestPerson shouldBe None
    }
  }

  "numberOfMen" should {

    "return the count of all men in the list" in new Setup {
      search.numberOfMen shouldBe 3
    }

    "return 0 when there are no men" in new Setup {
      override val allPeople = List(Person("Some Lady", Female, new LocalDate(2000, 1, 1)))
      search.numberOfMen shouldBe 0
    }

    "return 0 when there are no people" in new Setup {
      override val allPeople = List.empty[Person]
      search.numberOfMen shouldBe 0
    }
  }

}
