import akka.actor.Actor
import akka.actor.ActorRef
/**
 * Security Station keeps track of the results of the two scanners, and manages the scanners 
 **/

class securityStation() extends Actor {
  
  def receive = {
    case passenger : sendPassenger =>{}
  }

}
