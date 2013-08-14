package swerlick.andrew.kata.roman.r2

class RomanNumeral(numeral:String) {
	val maxDigitOccurrences = Map((new RomanDigit('I'),3))
	val value = numeral
	val digits =value.toArray.toList	

	def this(digitList:List[RomanDigit]){
		this(digitList.sortBy(a=> a).reverse.mkString)
	}

	def decompose = {
		val numeralWithLowerCaseNegatives = digits.foldRight("")((thisChar,partialString) => 					
			if(partialString.size > 0 && new RomanDigit(partialString.head) > new RomanDigit(thisChar))
				thisChar.toLower + partialString					
			else	
				thisChar + partialString
		)
		numeralWithLowerCaseNegatives.map((c)=> if(c.isLower) -new RomanDigit(c) else new RomanDigit(c))
	}
	def +(that: RomanNumeral):RomanNumeral= {
		val groupedByAbsoluteDigit = (this.decompose ++ that.decompose).groupBy(d=> d.abs)
		val digitTotals = 
			groupedByAbsoluteDigit.map(group => 
				(
					group._1, 
					group._2.filter(digit=> !digit.isNegated).length - group._2.filter(digit=> digit.isNegated).length)
				)
		//val invalidDigitCounts = digitTotals.filter(total => total._2 > maxDigitOccurrences.get(total._1) )

		val listOfDigits = digitTotals.flatMap(digitTotal=> 
			if(digitTotal._2 < 0) for(x<-1 to digitTotal._2.abs) yield -(digitTotal._1) 
			else  for(x<-1 to digitTotal._2.abs) yield digitTotal._1
		)
		
		new RomanNumeral(listOfDigits.toList)
	}
	
	override def equals(other:Any) = other match{
		case that: RomanNumeral => that.value == value
		case _ => false
	}
	override def hashCode = value.hashCode()
	override def toString(): String =  value 
	
}