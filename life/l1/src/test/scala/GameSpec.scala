package swerlick.andrew.kata.life.l1.test

import org.specs2._
import swerlick.andrew.kata.life.l1._

class GameSpec extends Specification{def is = s2"""
	Given a game class it should be possible to 
		initialize a game with a series of cells = $initialize
		retrieve starting cells from a new game  = $getCells
	Given a game initialized with a glider pattern
		ensure that calling nextTurn method returns the next iteration of the glider = $glider
		"""

	def initialize = new Game(Set((1,1),(1,2))) mustNotEqual(null)
	def getCells = new Game(Set((1,1),(1,2))).cells must beEqualTo(Set((1,1),(1,2)))
	def glider = {
		var game = new Game(Set((1,1),(2,2),(2,3),(1,3),(0,3)))
		game.nextTurn.cells must beEqualTo(Set((0,2),(2,2),(1,3),(2,3),(1,4)))	
	}
}