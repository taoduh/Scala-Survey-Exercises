// NOTE: to pick up compiled changes
// (1) uncheck "Use external compile server for scala" in properties and
// (2) check "Make project" above

val ms = new com.illumina.scala.survey.MethodSyntax

def diameter2(radius: Double): Double = radius * 2

// return value is last statement in method
ms.diameter(3.5)
ms.isEven(42)
ms.isEven(-21)

// nothing returned type is Unit
ms.console

// ??? means "to implement"
// this complies but generates an implementation error at runtime
//val unimplemented = ms.writeCodeForMe

// dots not always required to call methods
1.to(10)
1 to 10

1 + 4
1.+(4)
"weird".*(4)
