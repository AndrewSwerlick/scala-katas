package swerlick.andrew.kata.roman.r1

class RomanNum(numeral:String){
	val value = numeral;
	def negativesToLowerCase = {
			value.foldLeft("")((partialString, thisChar) => 					
				if(partialString.size > 0 && new RomanDigit(partialString.last) < new RomanDigit(thisChar))
					partialString.substring(0,partialString.size -1) + partialString.last.toLower + thisChar					
				else	
					partialString + thisChar			
			)}

	override def toString(): String =  numeral
	
}