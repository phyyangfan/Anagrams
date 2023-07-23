package Anagrams

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AppSuite extends AnyFunSuite {
  test("Unit test for App.anagrams") {
    assertResult(List(Set("Angel", "glean"), Set("dog", "God"), Set("doggy"), Set("gleam"), Set("meal")).toSet) {
      App.anagrams("Angel, dog, God, doggy, glean, gleam, meal").toSet
    }

    assertResult(List(Set("a")).toSet) {
      App.anagrams("a").toSet
    }

    assertResult(List(Set("a", "A")).toSet) {
      App.anagrams("a, A").toSet
    }

    assertResult(List(Set("a", "A"), Set("aA")).toSet) {
      App.anagrams("a, A, aA").toSet
    }

    assertResult(List(Set("abcd", "ABCD", "AbCd"), Set("ABC", "abC")).toSet) {
      App.anagrams("  AbCd,  abcd  ,   ABC ,  ABCD  ,   abC").toSet
    }

    assertResult(List(Set("abcd", "ABCD", "AbCd"), Set("ABC", "abC")).toSet) {
      App.anagrams("  AbCd,  abcd  ,   ABC ,  ABCD  ,   abC,abcd,ABCD,   abcd").toSet
    }

  }
}
