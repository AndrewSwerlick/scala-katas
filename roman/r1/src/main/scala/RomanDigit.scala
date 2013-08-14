package swerlick.andrew.kata.roman.r1

class RomanDigit(digit:Char) extends Ordered[RomanDigit]{
	val orderedNumerals = Seq('I','V')

	var value = digit
	override def compare(that:RomanDigit) :Int = {
		orderedNumerals.indexOf(value) - orderedNumerals.indexOf(that.value)
	}
	override def >(that:RomanDigit) : Boolean = {
		compare(that) > 0
	}
	override def equals(obj:Any) =obj match {
    	case that: RomanDigit => compare(that) == 0
    	case _ => false
	}
	override def <(that:RomanDigit) : Boolean = {
		compare(that) < 0		
	}
}
