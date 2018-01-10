package com.illumina.scala.survey

class Variables {

  // extract these values from a string
  val someString = "Some string value"
  val firstStringCharacter = ???
  val lastStringCharacter = ???
  val firstThreeStringCharacters = ???

  // what is happening here? Where is this method defined?
  val whatHappened = "crazy" * 3

  // implement a function called signum with one parameter "value"
  // value > 0 returns 1
  // value < 0 returns -1
  // 0 returns 0

  // what type is whatAmI?  Specify the correct type
  val whatAmI = {}

  // write a recursive function to compute the product of the unicode values of the letters in a string
  // HINT: head/tail and toLong string methods are your friends
  def strProduct(s: String): Long = ???

  // return a tuple of the smallest and largest numbers in values
  def minmax(values: Array[Int]): (Int, Int) = ???
}

// implement the before method (returns true if this is before that)
class Time(val hours: Int, val minutes: Int) {
  require(hours >=0 && hours < 24, "Hour must be 0 to 23")
  require(minutes >=0 && minutes < 60, "Minute must be 0 to 59")

  def before(other: Time): Boolean = {
    ???
  }
}

class BankAccount(initialBalance: Double) {
  protected var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

// override deposit and withdraw methods such that a service charge of $1 is added to each transaction
class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance: Double) { }

class Patterns {
  // save this for collections?
  // using pattern matching, swap the first two elements of an array
  // but only if the array has at least 2 elements
  def swapFirstTwo(values: Array[Int]): Array[Int] = ???
}

sealed abstract class BinaryTree
case class Leaf(value: Int) extends BinaryTree
case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

object TreePattern {
  // using pattern matching, implement sum for BinaryTree
  def sum(tree: BinaryTree): Int = ???
}