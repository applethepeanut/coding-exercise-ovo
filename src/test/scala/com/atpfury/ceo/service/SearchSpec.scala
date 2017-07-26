package com.atpfury.ceo.service

import com.atpfury.ceo.domain.Person
import org.scalatest.{Matchers, WordSpecLike}

class SearchSpec extends WordSpecLike with Matchers {

  trait Setup {

    val allPeople = List.empty[Person]

    val search = new Search {
      override val people = allPeople
    }

  }

  "numberOfMen" should {

    "return 0 when there are none" in new Setup {
      search.numberOfMen shouldBe 0
    }
  }

}
