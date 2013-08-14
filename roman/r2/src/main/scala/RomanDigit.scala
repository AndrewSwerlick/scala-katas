package swerlick.andrew.kata.roman.r2

class RomanDigit private(negated:Boolean,digit:Char) extends Ordered[RomanDigit]{
	private val orderedDigits = Seq('v','i','I','V')
	val value = if(negated) digit.toLower else digit
	val isNegated = negated

	def this(digit:Char)= {
		this(false,digit)
	}

	def abs : RomanDigit = new RomanDigit(false,value)
	def unary_- : RomanDigit = new RomanDigit(!isNegated,value)
	override def compare(that:RomanDigit) = 
		orderedDigits.indexOf(this.value) - orderedDigits.indexOf(that.value)

	override def toString(): String =  value.toString 

	override def equals(other:Any) = other match{
		case that: RomanDigit => this.compare(that) == 0
		case _ => false
	}

	override def hashCode = value.hashCode()
	
}