package swerlick.andrew.kata.roman.r1.test

import org.specs2._
import swerlick.andrew.kata.roman.r1._

class RomanDigitSpec extends Specification with matcher.DataTables {def is =s2"""
	Given two roman digits 
		ensure that the greater operator behaves as expected $romanGreaterThan
		ensure that the less than operator behaves as expected $romanLessThan		
		"""

	def romanGreaterThan = 
	"d1" 	|| "d2" |
	'V'		!!	'I'	|>{
		(d1,d2) =>new RomanDigit(d1) > new RomanDigit(d2) must beEqualTo(true)
	}

	def romanLessThan = 
	"d1" 	|| "d2" |
	'I'		!!	'V'	|>{
		(d1,d2) =>new RomanDigit(d1) < new RomanDigit(d2) must beEqualTo(true)
	}

}