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
		var numPass = 25
    
		//checks for command line arguments and overwrites the above variables
		if (args != null && args.size == 2){
			numLines = args(0).toInt
			numPass = args(1).toInt
		}
		
		val jail = actorOf(new Jail(numLines)).start()
		
		val lineList = new Array[ActorRef](numLines)
		val i = 0
		
		for ( i <- 0 to numLines -1){
			lineList(i) = actorOf(new Line(i))
			lineList(i).start()
		}
		
		val documentChecker = actorOf(new documentChecker(List.fromArray(lineList))).start
	}
  
	registry.shutdownAll()
	println("The system is turning off")
}