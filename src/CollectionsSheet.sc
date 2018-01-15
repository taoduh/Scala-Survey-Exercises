// Vectors have good indexed access
val someLetters = Vector("a", "t", "p", "a")
someLetters(3)
someLetters.tail // this works but is less efficient

// using the base trait Seq lets the compiler decide
// usually that is a good idea but in a worksheet it won't get the whole context
val otherLetters = Seq("p", "q", "e", "x") // it picked List
otherLetters(3) // this works but isn't efficient for larger collections
otherLetters.head
otherLetters.tail // these are efficient with Lists

// sorting is easy
// comparison method can be passed in using sortWith
// look at the Ordered trait if you want the elements to be sorted on insert
otherLetters.sorted

// Sets are unordered and elements are unique
someLetters toSet
val uniqueLetters = Set("t", "o", "d", "d")
// other useful implementations include:
// SortedSet
// TreeSet (implementation of SortedSet)

val californiaNl = Map("San Francisco" -> "Giants", "Los Angeles" -> "Dodgers", "San Diego" -> "Padres")
californiaNl("San Diego")
californiaNl.getOrElse("San Diego", "")
californiaNl.contains("Bakersfield")
californiaNl.getOrElse("Bakersfield", "")
californiaNl.get("Bakersfield")
// other useful implementations include:
// SortedMap
// TreeMap (implementation of SortedMap)

/////////// My favorite methods
someLetters.length
someLetters.filter(_ > "r")
someLetters.find(_ == "t")
someLetters.find(_ == "w")
someLetters.exists(_ == "t")
someLetters.exists(_ == "w")

// transform to team name -> city length
val teamToLength = californiaNl.map { case(k, v) => (v, k.length) }

teamToLength.values.sum
teamToLength.values.foldLeft(0)(_ + _)
