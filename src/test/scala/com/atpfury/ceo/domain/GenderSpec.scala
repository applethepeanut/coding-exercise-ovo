package com.atpfury.ceo.domain

import org.scalatest.{Matchers, WordSpecLike}

class GenderSpec extends WordSpecLike with Matchers {

  "apply" should {

    "return Male given a valid string" in {
      Gender(" male") shouldBe Male
    }

    "return Female given a valid string" in {
      Gender(" Female") shouldBe Female
    }

    "throw an exception when the gender cannot be parsed" in {
      an[IllegalArgumentException] shouldBe thrownBy {
        Gender("m")
      }
    }
  }
}
