// val is immutable
// notice type is inferred
val theAnswer = 42
// theAnswer = 41 // compiler error - Reassignment to val
// var is mutable
var theYear = 2017
theYear = 2018

// collections are immutable unless I import a mutable class
val hqBuildings = Seq(1, 2, 3, 4, 5, 6)
hqBuildings.updated(2, 100)
hqBuildings // 100 is not there

// types are specified after the variable name
val pi: Double = 3.14159
val myPiePortion: Double = 0.5

// generic parameters in square brackets
val fundamentalConstants: Seq[Double] = Seq(pi, Math.pow(6.62607, -34), 2.7182818)

// default collection types are immutable
val bestCitiesInCa = List("San Diego")
var sdSportsTeams = scala.collection.mutable.Set("Padres", "Chargers", "Gulls")
sdSportsTeams.remove("Chargers")
sdSportsTeams
sdSportsTeams toSet
