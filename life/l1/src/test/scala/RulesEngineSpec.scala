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
	"cellToCheck" 		| "currentGameCells" 					| "nextState" 	|    
	//live cell 3 neighbors
			(1,1)    	!  Set((1,1),(1,2),(2,1),(0,0))  		!  true  		| 
	//dead cell 2 neighbors
			(1,1)    	!  Set((2,1),(0,0))  					!  false  		| 			 
	//dead cell 3 neighbors
			(1,1)    	!  Set((1,2),(2,1),(0,0))  				!  true  		|  			
	//live cell 4 neighbors
			(1,1)    	!  Set((1,1),(1,2),(2,1),(0,0),(1,0))  	!  false  		|  			                                
	//live cell no neighbors
			(1,1)    	!  Set((1,1))  							!  false  		|                                
	//live cell 2 neighbors
			(1,1)    	!  Set((1,1),(1,2),(2,1))  				!  true			|> {  
		(cellToCheck, currentGameCells, nextState) 
			=> engine.nextState(cellToCheck,currentGameCells) must beEqualTo(nextState)                  
	}
}