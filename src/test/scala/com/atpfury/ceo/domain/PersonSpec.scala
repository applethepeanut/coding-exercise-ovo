package com.atpfury.ceo.domain

import org.joda.time.LocalDate
import org.scalatest.{Matchers, WordSpecLike}

class PersonSpec extends WordSpecLike with Matchers {

  "apply" should {

    "return a female person given a valid string" in {
      val person = Person(" Gemma Lane, Female , 20/11/91 ")
      person.name shouldBe "Gemma Lane"
      person.gender shouldBe Female
      person.dateOfBirth shouldBe new LocalDate(1991, 11, 20)
    }

    "return a male person given a valid string" in {
      val person = Person("Bill McKnight, male, 16/03/77")
      person.name shouldBe "Bill McKnight"
      person.gender shouldBe Male
      person.dateOfBirth shouldBe new LocalDate(1977, 3, 16)
    }

    "throw an exception when the date of birth cannot be parsed" in {
      an[IllegalArgumentException] shouldBe thrownBy {
        Person("some name,female,blah")
      }
    }

    "throw an exception when given an empty string" in {
      an[IllegalArgumentException] shouldBe thrownBy {
        Person("")
      }
    }

    "throw an exception when given a white space only string" in {
      an[IllegalArgumentException] shouldBe thrownBy {
        Person("  ")
      }
    }
  }
}
