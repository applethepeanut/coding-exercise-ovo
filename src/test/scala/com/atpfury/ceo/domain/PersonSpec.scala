package com.atpfury.ceo.domain

import org.scalatest.{Matchers, WordSpecLike}

class PersonSpec extends WordSpecLike with Matchers {

  "apply" should {

    "return None when given an empty string" in {
      Person("") shouldBe None
    }

    "return None when given a white space only string" in {
      Person("  ") shouldBe None
    }
  }
}