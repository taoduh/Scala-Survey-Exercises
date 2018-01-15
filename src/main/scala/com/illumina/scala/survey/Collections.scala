package com.illumina.scala.survey

import scala.collection.SortedMap
import scala.collection.mutable.ListBuffer

class Collections {

  val someNumbers: Seq[Int] = Seq(4, -40, 900, 42, 47, 46, 8, -1000, 81)

  // return the matching element or None using someNumbers as your source
  // e.g. x=42 results in Some(42)
  // e.g. x=43 results in None
  def numberMatching(x: Int): Option[Int] = ???

  // return all values of someNumbers except the one passed in
  // naturally a number not in the Seq will return all of someNumbers
  def numbersNotMatching(x: Int): Seq[Int] = ???

  // return all values of someNumbers greater than the one passed in
  def numbersGreaterThan(x: Int): Seq[Int] = ???

  // data structure for a softball players
  final case class Player(id: Int, teamId: Int, firstName: String, lastName: String) {
    def name: String = s"$firstName $lastName"
  }

  // a few players
  val captains: Seq[Player] = Seq[Player](
    new Player(1,1, "Brian", "Steffy"),
    new Player(2,2, "Casey", "Turk"),
    new Player(3,3, "Jared", "Peace"),
    new Player(4,4, "Nathalie", "Becker"),
    new Player(5,5, "Nikki", "Chu"),
    new Player(6,6, "Ryan", "Roth"),
    new Player(7,7, "Tyler", "Aragon"),
    new Player(8,8, "William", "Withers"),
    new Player(9,9, "Alex", "McKelvey"),
    new Player(10,10, "Andy", "Fang"),
    new Player(11,11, "Ashley", "Ginbey"),
    new Player(12,12, "Chris", "Wilson"),
    new Player(13,13, "Joe", "Storms"),
    new Player(14,14, "Margaret", "Porter"),
    new Player(15,15, "Stephen", "Madden"),
    new Player(16,16, "Ted", "Nguyen"))

  // return just the names of the captains
  def captainNames(): Seq[String] = ???

  // return a map of the id to first name of the captains
  def captainIdToFirstName(): Map[Int, String] = ???

  /*
   * More advanced exercises
   * Google will be your friend for these
   */

  // return a map of letters in a string to how many times it appears
  // e.g. "ohio" would return Map("o" -> 2, "h" -> 1, "i" -> 1)
  def groupByLetter(sourceVal: String): Map[Char, Int] = ???

  // same as the above but the keys are sorted
  // e.g. "ohio" would return Map("h" -> 1, "i" -> 1, "o" -> 2)
  def groupByLetterSorted(sourceVal: String): SortedMap[Char, Int] = ???

  // copy every other element of a list to a new list
  def everyOtherElement[T](sourceList: List[T]): List[T] = {
    ???
  }

  // given the Map in the function below, return a Seq of the values corresponding to the passed in names
  // e.g. Seq("Tom", "Joseph", "Harry") would return Seq(3, 5)
  // HINT: flatMap is good for removing None values from a collection
  def numbersFromName(names: Seq[String]): Seq[Int] = {
    val namesMap = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
    ???
  }

}
