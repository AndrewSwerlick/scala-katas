package swerlick.andrew.kata.roman.r1.spec

import org.specs2._
import swerlick.andrew.kata.roman.r1._

class ExpressionSimplifierSpec extends Specification with matcher.DataTables {def is = s2"""
	Given a Roman Numeral expression with negatives
		ensure that the Expression simplifier returns an equivalent express without them $simplifyExpressionTable
	"""

	def simplifyExpressionTable = 
	""
}