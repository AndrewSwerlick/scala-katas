package swerlick.andrew.kata.life.l1.test

import org.specs2._
import swerlick.andrew.kata.life.l1._

class RulesEngineSpec extends Specification with matcher.DataTables{def is =s2"""
	Given the following scenarios of cells in a set
	When we call nextState on the RulesEngine 
	it should appropriately calculate the next state $nextStateTable
	"""
	var engine = new RulesEngine();

	def nextStateTable =
	"cellToCheck" 		| "currentGameCells" 			| "nextState" 	|                                  
	//live cell no neighbors
			(1,1)    	!  Set((1,1))  					!  false  		|                                
	//live cell 2 neighbors
			(1,1)    	!  Set((1,1),(1,2),(2,1))  		!  true			|> {  
		(cellToCheck, currentGameCells, nextState) 
			=> engine.nextState(cellToCheck,currentGameCells) must beEqualTo(nextState)                  
	}
}