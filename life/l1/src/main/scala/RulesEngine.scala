package swerlick.andrew.kata.life.l1

class RulesEngine{
	def nextState(cellToCheck:Tuple2[Int,Int],gameCells:Set[Tuple2[Int,Int]]) = {
		val c = cellToCheck
		val neighboringCells = (for(x <- c._1-1 to c._1+1; y<- c._2-1 to c._2+1) yield (x,y)).
			filter(ce=> ce != c && gameCells.contains(ce)) 

		Console.print(neighboringCells)

		neighboringCells.size == 2
	}
}