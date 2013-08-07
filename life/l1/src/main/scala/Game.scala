package swerlick.andrew.kata.life.l1

class Game(startingCells:Set[Tuple2[Int,Int]]){
	val engine = new RulesEngine()

	def cells = startingCells
	def nextTurn = {
		var maxMin = engine.getActiveGameSet(startingCells)
		var maxCorner = maxMin._2;
		var minCorner = maxMin._1;
		val cellsToSearch = for(x<-minCorner._1 to maxCorner._1; y<- minCorner._2 to maxCorner._2) yield(x,y)

		new Game(cellsToSearch.filter(ce=> engine.nextState(ce, startingCells)).toSet)
	}
}