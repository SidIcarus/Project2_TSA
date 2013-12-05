package src

import akka.actor.ActorRef
import akka.actor.Actor._
import akka.actor.UntypedActor
/**
 * This class is what will setup and run the program
 */
object Driver extends App{
	override def main(args: Array[String]){
		//sets up the number of lines and number of passengers with defaults
		var numLines = 5
		var numPass = 10
		
		//counter for for loops
		val i = 0
		
    
		//checks for command line arguments and overwrites the above variables
		if (args != null && args.size == 2){
			numLines = args(0).toInt
			numPass = args(1).toInt
		}
		
		println("System is starting up")
		
		//starts the jail actor
		val jail = actorOf(new Jail(numLines)).start()
		println("Jail is up and running.")
		
		//list of all the lines
		val lineList = new Array[ActorRef](numLines)
		
		//adds a line to the list and starts it
		for ( i <- 0 to numLines -1){
			lineList(i) = actorOf(new Line(i, jail))
			lineList(i).start()
		}
		println("Lines are up and running.")
		
		//starts the documentChecker
		val documentChecker = actorOf(new documentChecker(List.fromArray(lineList))).start
		println("Document Check is up and running.")
		println("Passengers are now being sent through\n")
		
		//sends passenger through the document Checker
		for (i <- 1 to numPass){
		  documentChecker ! new sendPassenger(new Passenger(new Baggage(), i))
		}
	
  
	registry.shutdownAll()
	println("The system is turning off")
	}
}