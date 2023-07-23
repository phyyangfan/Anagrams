package Anagrams

import scala.collection.mutable

object App {
  def main(args: Array[String]): Unit = {
    val anagramGroups = anagrams("Angel, dog, God, doggy, glean, gleam, meal")
    println("Words grouped with their anagrams are:")
    anagramGroups.foreach(println)
  }

  /**
   * Method for parsing comma separated words/tokens from the input string and returning
   * a List of Sets of Strings containing the words from the input, grouped with their anagrams.
   * The words/tokens in the input string contains upper case and/or lower case English letters.
   * The input string can also contain white space characters.
   *
   * @param s : input string
   * @return a List of Sets of Strings containing the words from the input, grouped with their anagrams
   */
  def anagrams(s: String): List[Set[String]] = {
    // parse the input string and prepare the array of words
    val wordArray = s.replaceAll("\\s+", "").split(",")

    // set up a Map holding the mapping between a standardized
    // string key and the corresponding group of anagrams
    val anagramGroupMap = mutable.Map.empty[String, mutable.Set[String]]

    // process each input string
    for (word <- wordArray) {
      // create an Array to count the occurrences of each letter in string word
      val charCountArray = new Array[Int](26)
      for (c <- word) charCountArray(c.toLower - 'a') += 1
      // build the standardized string key for the anagram group
      // which string word belongs to
      val sb = new mutable.StringBuilder
      for (c <- 'a' to 'z') {
        if (charCountArray(c - 'a') > 0) sb.append(c).append(charCountArray(c - 'a'))
      }
      // update the anagram group map
      val key = sb.toString
      if (!anagramGroupMap.contains(key)) anagramGroupMap.put(key, mutable.Set.empty[String])
      anagramGroupMap(key) += word
    }

    // construct and return the results
    anagramGroupMap.values.map(v => v.toSet).toList
  }

}
