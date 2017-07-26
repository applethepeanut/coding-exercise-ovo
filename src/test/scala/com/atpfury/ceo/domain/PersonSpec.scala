package com.atpfury.ceo.domain

import org.scalatest.{Matchers, WordSpecLike}

class PersonSpec extends WordSpecLike with Matchers {

  "apply" should {

    "return some female person given a valid string" in {
      val Some(person) = Person(" Gemma Lane, Female , 20/11/91 ")
      person.name shouldBe "Gemma Lane"
      person.gender shouldBe "Female"
      person.dob shouldBe "20/11/91"
    }

    "return some male person given a valid string" in {
      val Some(person) = Person("Bill McKnight, Male, 16/03/77")
      person.name shouldBe "Bill McKnight"
      person.gender shouldBe "Male"
      person.dob shouldBe "16/03/77"
    }

    "return None when given an empty string" in {
      Person("") shouldBe None
    }

    "return None when given a white space only string" in {
      Person("  ") shouldBe None
    }
  }
}
