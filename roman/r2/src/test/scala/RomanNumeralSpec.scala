package swerlick.andrew.kata.roman.r2.test

import org.specs2._
import swerlick.andrew.kata.roman.r2._

class RomanNumeralSpec extends Specification with matcher.DataTables {def is = s2"""
	Given a RomanNumeral 
		ensure we can build a numeral from a list of digits $digitsConstructor
		ensure we can decompose it into a Sequence of RomanDigits $decomposeTable
		ensure we can add two numerals $additionTable

	"""

	def digitsConstructor = 
	"listOfDigits" 									| "resultingNumeral" 		|
	List(new RomanDigit('I'), new RomanDigit('V'))	! new RomanNumeral("VI")	|>{
		(listOfDigits,resultingNumeral) => 
			new RomanNumeral(listOfDigits) must beEqualTo(resultingNumeral)
	}

	def decomposeTable = 
	"numeral" 				| "digits" 												|
	new RomanNumeral("VI")	! Vector(new RomanDigit('V'), new RomanDigit('I')) 		|
	new RomanNumeral("IV")	! Vector(new RomanDigit('V'), -new RomanDigit('I')) 	|>{
		(numeral, digits) => numeral.decompose must containTheSameElementsAs(digits)
	}

	def additionTable = 
	"num1" 					| "num2"					| "sum"						|						
	new RomanNumeral("I") 	! new RomanNumeral("II") 	! new RomanNumeral("III") 	|
	new RomanNumeral("IV") 	! new RomanNumeral("I") 	! new RomanNumeral("V") 	|
	new RomanNumeral("II") 	! new RomanNumeral("II") 	! new RomanNumeral("IV") 	|>{
		(num1,num2,sum)=> num1 + num2 must beEqualTo(sum)
	}
}	