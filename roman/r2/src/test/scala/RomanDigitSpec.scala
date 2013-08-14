package swerlick.andrew.kata.roman.r2.test

import org.specs2._
import swerlick.andrew.kata.roman.r2._

class RomanDigitSpec extends Specification with matcher.DataTables {def is= s2"""
	Given two Roman Digits 
		ensure they can be correctly ordered using compare $romanDigitOrderTable
		ensure they can be correctly ordered using greater than $romanDigitGreaterThanTable
		ensure we can negate a digits $negation
	"""

	def romanDigitOrderTable = 
	"d1" 	| "d2" 	| "resultCheckFunc" 	|
	'I'		! 'V'	! ((x:Int) => x<0)		|
	'V' 	! 'I'	! ((x:Int) => x>0) 		|
	'I' 	! 'I'	! ((x:Int) => x==0)		|>{
		(d1,d2,resultCheckFunc) => resultCheckFunc(new RomanDigit(d1).compare(new RomanDigit(d2)))
	}

	def romanDigitGreaterThanTable = 
	"d1" | "d2" |
	'I'  ! 'V' 	|>{
		(d1,d2) => {d1 < d2}
	}

	def negation = (-new RomanDigit('I')).isNegated must beTrue

}