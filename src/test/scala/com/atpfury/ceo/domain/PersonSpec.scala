package com.atpfury.ceo.domain

import org.joda.time.LocalDate
import org.scalatest.prop.TableDrivenPropertyChecks._
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

    "return a person with a single name given a valid string" in {
      val person = Person("bob,male,16/3/77")
      person.name shouldBe "bob"
      person.gender shouldBe Male
      person.dateOfBirth shouldBe new LocalDate(1977, 3, 16)
    }

    val invalidLines = Table(
      "line",
      "some name,female,0/12/1999",
      "some name,female,12/0/1999",
      "some name,female,/12/1999",
      "some name,female,12//1999",
      "some name,female,12/12/",
      "some name,female,12/12",
      "some name,female,/12/12",
      "some name,female,44/12/1999",
      "some name,female,12/44/1999"
    )

    forAll(invalidLines) { (line) =>

      s"throw an exception when parsing an invalid date from the line '$line'" in {
        an[IllegalArgumentException] shouldBe thrownBy {
          Person(line)
        }
      }

    }

    "throw an exception when given an invalid gender" in {
      an[IllegalArgumentException] shouldBe thrownBy {
        Person("some name, blah, 12/12/12")
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
