package com.illumina.scala.survey

import java.util.Date

/*
 * Classes supporting all the worksheet demos
 * Look there to see this code in action
 */

class MethodSyntax {
  val pi = 3.14159

  // return value is last statement
  def diameter(radius: Double) = {
    val x = radius * 2 * pi
    x
  }
  // reminder that the entire "if" is one statement
  def isEven(num: Int) = {
    if (num % 2 == 0)
      "yeah for " + num
    else
      "nope with " + num
  }

  // null object = Unit
  def console(): Unit = {
    println("Nothing is returned")
  }

  // ??? = to implement later
  def writeCodeForMe() = ???
}

// interfaces are called traits
trait PrintDates {
  // import wildcard is underscore (_)
  // also notice they can be anywhere
  import java.time.format._

  // traits can contain implementation code
  val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")
}

// notice the class name and file name need not be related
// class constructor parameters are specified here with the class definition
class ClassSyntax(constructorParam: Date) extends PrintDates {

  // constructors with alternate parameters call the primary constructor
  def this() = this(new Date)

  // body statements are the constructor code
  import java.time._
  val ldt: LocalDateTime = constructorParam.toInstant.atOffset(ZoneOffset.UTC).toLocalDateTime
  println("ClassSyntax instantiated with " + ldt.format(formatter))

  // Use def to create methods.  The val keyword is legal but is not what you want
  def timeToMastery() = "30 years, always 30 years"
}

// object = singleton
object ObjectSyntax extends ClassSyntax

// type hierarchy for pattern matching code below
sealed abstract class Notification
case class Email(sender: String, title: String, body: String) extends Notification
case class SMS(caller: String, message: String) extends Notification
case class VoiceRecording(contactName: String, link: String) extends Notification

// another type hierarchy for pattern matching code below
sealed abstract class Exp
case class Fun(e: Exp) extends Exp
case class Number(n: Int) extends Exp
case class Sum(exp1: Exp, exp2: Exp) extends Exp
case class Product(exp1: Exp, exp2: Exp) extends Exp

class PatternSyntax {

  def showNotification(notification: Notification): String = {
    notification match {
      // case is the type: deconstructed parameters available
      case Email(email, title, _) =>
        s"You got an email from $email with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      // case is an instance of type, the whole instance is available
      case n: VoiceRecording =>
        s"you received a Voice Recording from ${n.contactName}! Click the link to hear it: ${n.link}"
    }
  }

  // prints a string representation of the expression
  def print(e: Exp): String = e match {
    case Number(x) => x.toString
    case Sum(e1, e2) => "(+ " + print(e1) + " " + print(e2) + ")"
    case Product(e1, e2) => "(* " + print(e1) + " " + print(e2) + ")"
    case Fun(e) => "(fn [] " + print(e) + ")"
  }

  // calculates an expression result
  def calculate(e: Exp): Int = e match {
    case Number(x) => x
    case Sum(e1, e2) => calculate(e1) + calculate(e2)
    case Product(e1, e2) => calculate(e1) * calculate(e2)
    case Fun(e) => calculate(e)
  }
}

class ListCollectionSyntax {
  /*
   * operator overloading, thus 1 to 10, myList sorted, implicit classes
   *
   * collection initializers -> Vector(2, 3)
   * collection convenience methods: sum, sorted, mkString, reverse (for interviews)
   * indexed (Vector) demo
   * not-indexed (List) demo
   * head/tail demo
   * filter, etc
   */

  // list all combinations of numbers x and y where x is drawn from
  // 1 to 7 and y is drawn from 1 to 4
  val forComp1 =
  for (x <- 1 to 7; y <- 1 to 4)
    yield (x, y)
  // equivalent to
  // (1 to 4) flatMap (x => (1 to 7) map (y => (x, y)))
  // but easier to read IMO

  // generates pairs of numbers up to n that sum to v
  def genForComp(n: Int, v: Int) =
    for (i <- 0 until n;
         j <- i until n if i + j == v)
      yield (i, j)

  // equivalent with maps
  def genForCompEquiv(n: Int, v: Int) =
    (0 until n).flatMap(i => (i until n).map(j => (i, j))).filter(x => x._1 + x._2 == v)

  genForComp(10, 10) foreach {
    case (i, j) =>
      print(s"($i, $j) ")  // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)
  }
}

class SetCollectionSyntax {
  /*

   */
}

class MapCollectionSyntax {
  /*
   * same ideas with maps
   * Map(k1 -> v1, ...)
   * ((k,v) <- myMap) { match here }
   * toMap
   */
}
