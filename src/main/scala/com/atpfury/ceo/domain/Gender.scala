package com.atpfury.ceo.domain

sealed abstract class Gender(val description: String)
case object Male extends Gender("Male")
case object Female extends Gender("Female")

object Gender {

  def apply(s: String): Gender = s.trim.toLowerCase match {
    case "male" => Male
    case _ => Female
  }
}
