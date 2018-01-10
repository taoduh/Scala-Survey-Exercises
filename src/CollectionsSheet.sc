val fruits = List("apples", "oranges", "pears")
fruits.head   // "apples"
fruits.tail   // List("oranges", "pears")
fruits sortWith (_.length < _.length) // List("pears", "apples", "oranges")
fruits groupBy (_.head)   // returns a map where first letter is the key

val empty1 = List()
val empty2 = Nil

val nums = Vector("louis", "frank", "hiromi")
nums(1)                     // element at index 1, returns "frank", complexity O(log(n))
nums.updated(2, "helena")   // new vector with a different string at index 2, complexity O(log(n))

val fruitSet = Set("apple", "banana", "pear", "banana")
fruitSet.size    // returns 3: there are no duplicates, only one banana

val r1: Range = 1 until 5 // 1, 2, 3, 4
val r2: Range = 1 to 5    // 1, 2, 3, 4, 5
1 to 10 by 3  // 1, 4, 7, 10
6 to 1 by -2  // 6, 4, 2

val s = (1 to 6).toSet
s map (_ + 2) // adds 2 to each element of the set

val str = "Hello World"
str filter (c => c.isUpper) // returns "HW"; strings can be treated as Seq[Char]

// Operations on sequences
val xs1 = List(5, 6, 7, 2, 9, 14, 44)
val n = 3
val x = 9
val p: Int => Boolean = _ < 7
xs1.length   // number of elements, complexity O(n)
xs1.head     // first element
xs1.tail     // all but first element (useful for recursion, pattern matching)
xs1.last     // last element (exception if xs1 is empty), complexity O(n)
xs1.init     // all elements of xs1 but the last (exception if xs1 is empty), complexity O(n)
xs1 take n   // first n elements of xs1
xs1 drop n   // the rest of the collection after taking n elements
xs1(n)       // the nth element of xs1, complexity O(n)
xs1 ++ List(99, 55)    // concatenation, complexity O(n)
xs1.reverse  // reverse the order, complexity O(n)
xs1 updated(n, x)  // same list than xs1, except at index n where it contains x, complexity O(n)
xs1 indexOf x      // the index of the first element equal to x (-1 otherwise)
xs1 contains x     // same as xs1 indexOf x >= 0
xs1 filter p       // returns a list of the elements that satisfy the predicate p
xs1 filterNot p    // filter with negated p
xs1 partition p    // same as (xs1 filter p, xs1 filterNot p)
xs1 takeWhile p    // the longest prefix consisting of elements that satisfy p
xs1 dropWhile p    // the remainder of the list after any leading element satisfying p have been removed
val spanned = xs1 span p         // same as (xs1 takeWhile p, xs1 dropWhile p)

xs1 reduceLeft (_ - _)  // (...(x1 op x2) op x3) op ...) op xn
xs1.foldLeft (50)(_ - _)  // (...(x1 op x2) op x3) op ...) op xn
xs1 reduceRight (_ - _)  // x1 op (... (x{n-1} op xn) ...)
xs1.foldRight (50)(_ - _)  // x1 op (... (    xn op  z) ...)

xs1 exists p    // true if there is at least one element for which predicate p is true
xs1 forall p    // true if p(x) is true for all elements
val zipped = xs1 zip List("5a", "6a", "7a", "2a", "9a", "14a", "44a")      // returns a list of pairs which groups elements with same index together
zipped.unzip       // opposite of zip: returns a pair of two lists
xs1.flatMap(elem => List(elem, elem * 2))   // applies the function to all elements and concatenates the result
xs1.sum         // sum of elements of the numeric collection
xs1.product     // product of elements of the numeric collection
xs1.max         // maximum of collection
xs1.min         // minimum of collection
List(List(4, 5, 6), List(9, 1)).flatten
xs1 distinct    // sequence of distinct entries (removes duplicates)

val x1 = 60
x1 +: xs1  // creates a new collection with leading element x
xs1 :+ x1  // creates a new collection with trailing element x

// Operations on maps
val myMap = Map("I" -> 1, "V" -> 5, "X" -> 10)  // create a map
myMap("I")      // => 1
// myMap("A")      // => java.util.NoSuchElementException
myMap get "A"   // => None
myMap get "I"   // => Some(1)
myMap.updated("V", 15)  // returns a new map where "V" maps to 15 (entry is updated)
// if the key ("V" here) does not exist, a new entry is added
myMap("V") // myMap is immutable, still 5
for ((k,v) <- myMap) println("I know the value for " + k)
