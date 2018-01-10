import com.illumina.scala.survey._

val ps = new PatternSyntax

// match on kind of notification
// make use of the relevent parameters
ps.showNotification(SMS("12345", "Are you there?"))
ps.showNotification(VoiceRecording("Tom", "voicerecording.org/id/123"))

val formula1 = Fun(Product(Sum(Number(4), Number(2)), Number(3)))

// recursively match on expressions (sum, number, etc)
val funkyNotation = ps.print(formula1)
val sum = ps.calculate(formula1)
