package src

import akka.actor.Actor
import akka.actor.ActorRef
import scala.collection.mutable.Queue

/**
 * Line holds a queue, security station, and scanners(line creates these objects)
 * A passenger is assigned to a line
 * 
 **/

class Line(val num: Int, val jail: ActorRef) extends Actor{
	val securityStation = new securityStation(jail)
	val bodyScanner = new bodyScanner(securityStation)
	val bagScanner = new baggageScanner(securityStation)
	val lineQueue = new lineQueue(bodyScanner, bagScanner)
	
	def receive = {
		case passenger : sendPassenger =>{}
	    
	}
}
