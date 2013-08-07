package swerlick.andrew.kata.life.l1

class Game(startingCells:Set[Tuple2[Int,Int]]){
	val engine = new RulesEngine()

	def cells = startingCells
	def nextTurn = {
		new Game(startingCells.filter(ce=> engine.nextState(ce, startingCells)))
	}
}