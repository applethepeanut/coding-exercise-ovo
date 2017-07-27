package com.atpfury.ceo.domain

import org.scalatest.{Matchers, WordSpecLike}

class GenderSpec extends WordSpecLike with Matchers {

  "apply" should {

    "return Male given a string with lower case 'male'" in {
      Gender("male") shouldBe Male
    }

    "return Male given a string with trailing white space" in {
      Gender("Male ") shouldBe Male
    }

    "return Female given a string with lower case 'female'" in {
      Gender("female") shouldBe Female
    }

    "return Female given a string with leading white space" in {
      Gender(" Female") shouldBe Female
    }

    "throw an exception when the gender cannot be parsed" in {
      an[IllegalArgumentException] shouldBe thrownBy {
        Gender("m ale")
      }
    }

    "throw an exception when given an empty string" in {
      an[IllegalArgumentException] shouldBe thrownBy {
        Gender("")
      }
    }
  }
}
