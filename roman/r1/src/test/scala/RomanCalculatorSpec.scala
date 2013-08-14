package swerlick.andrew.kata.roman.r1.test

import org.specs2._
import swerlick.andrew.kata.roman.r1._

class RomanCalculatorSpec extends Specification with matcher.DataTables{def is=s2"""
	Given a roman calculator 
		ensure the following numerals are calculated correctly $calcTable
	"""

	def calcTable = 
	"a" 	|| "b" 		|| "c" 		|
	"I" 	!! "I" 		!! "II" 	|
	"II" 	!! "II" 	!! "IV" 	|
	"III"   !! "II" 	!!  "V"		|>{
	/*"IV"	!!	"I"		!!	"V"	 	|>{*/
		(a,b,c)=> new RomanCalculator().add(a,b) must beEqualTo(c)
	}

}