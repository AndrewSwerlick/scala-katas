package swerlick.andrew.kata.roman.r1

import org.specs2._
import swerlick.andrew.kata.roman.r1._

class RomanNumSpec extends Specification with matcher.DataTables{def is = s2"""
	Given a Roman numeral
		ensure that calling negativesToLowerCase 
		eturns a string with all negative digits as lower case $negativesToLowerCaseTable
	"""

	def negativesToLowerCaseTable= 
	"orig" 	|| "lowered" 	|
	"IV" 	!!	"iV"		|
	"VI"	!! 	"VI"		|>{
		(orig,lowered)=> new RomanNum(orig).negativesToLowerCase must beEqualTo(lowered)
	}

}