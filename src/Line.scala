package src

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Actor._
import scala.collection.mutable.Queue

/**
 * Line holds a queue, security station, and scanners(line creates these objects)
 * A passenger is assigned to a line
 * 
 **/

class Line(val num: Int, val jail: ActorRef) extends Actor{
	val securityStation = actorOf(new securityStation(jail)).start()
	val bodyScanner = actorOf(new bodyScanner(securityStation)).start()
	val baggageScanner = actorOf(new baggageScanner(securityStation)).start()
	val lineQueue = new lineQueue(bodyScanner, baggageScanner)
	
	def receive = {
		case passenger : sendPassenger =>{}
	    
	}
}
