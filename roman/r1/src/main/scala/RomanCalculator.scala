package swerlick.andrew.kata.roman.r1

class RomanCalculator {
	val maxOcurrences = Map(('I',3))
	val orderedNumerals = Seq('I','V')

	def add(numberOne:String, numberTwo:String) : String= {

		var concatedString = numberOne + numberTwo
		
		val invalidNumerals = getInvalidNumerals(concatedString)

		for(numAndCount<- invalidNumerals){
			val newString = getNewStringForInvalidNumerals(numAndCount)

			val oldString = new String((1 to numAndCount._2).map(i=> numAndCount._1).toArray)
			
			concatedString = concatedString.replace(oldString,newString)
			Console.println(concatedString)
		}

		return concatedString
	}

	private def getInvalidNumerals(concatedNumbers:String) : Map[Char,Int] = {
		val frequencyMap = concatedNumbers.groupBy(_.toChar).map{ num => (num._1, num._2.length)};
		frequencyMap.
				filter(numAndCount=> 
						numAndCount._2 > (maxOcurrences.get(numAndCount._1) getOrElse 0))
	}

	private def getNewStringForInvalidNumerals(invalidNumeral:Tuple2[Char,Int]) :String = {
		val maxOcurrenceForNumeral = maxOcurrences.get(invalidNumeral._1) getOrElse 0
		val countInString = invalidNumeral._2
		var nextNumeral = orderedNumerals(orderedNumerals.indexOf(invalidNumeral._1) + 1)
			 
		if(countInString == maxOcurrenceForNumeral + 1)
			invalidNumeral._1 + nextNumeral.toString
		else
			nextNumeral.toString
	}	
}