package swerlick.andrew.kata.life.l1.test

import org.specs2._
import swerlick.andrew.kata.life.l1._

class GameSpec extends Specification{def is = s2"""
	Given a rules engine class it should be possible to 
		initialize a game with a series of cells = $initialize
		retrieve starting cells from a new game  = $getCells
		"""

	def initialize = new Game(Set((1,1),(1,2))) mustNotEqual(null)
	def getCells = new Game(Set((1,1),(1,2))).cells must beEqualTo(Set((1,1),(1,2)))
}