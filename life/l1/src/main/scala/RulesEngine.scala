package swerlick.andrew.kata.life.l1

class RulesEngine{
	def nextState(cellToCheck:Tuple2[Int,Int],gameCells:Set[Tuple2[Int,Int]]) = {
		val c = cellToCheck
		val cellIsActive = gameCells.contains(c);
		val neighboringCells = (for(x <- c._1-1 to c._1+1; y<- c._2-1 to c._2+1) yield (x,y)).
			filter(ce=> ce != c && gameCells.contains(ce)) 

		neighboringCells.size == 3 || (neighboringCells.size >=2 && neighboringCells.size < 4 && cellIsActive)
	}	

	def getActiveGameSet(gameCells:Set[Tuple2[Int,Int]]) ={
		var maxX = gameCells.maxBy(c=> c._1)._1 +1
		var maxY = gameCells.maxBy(c=> c._2)._2 +1
		var minX = gameCells.minBy(c=> c._1)._1 -1
		var minY = gameCells.minBy(c=> c._2)._2	-1
		((minX,minY),(maxX,maxY))
	}
}