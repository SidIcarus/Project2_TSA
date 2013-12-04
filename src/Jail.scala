import akka.actor.Actor
import akka.actor.ActorRef
/**
 * The jail holds all the passengers that fail the security check, 
 * and knows the number of stations feeding it passengers
 * 
 **/

class Jail() extends Actor{

  def receive = {
    case passenger : sendPassenger => {}
    
  }
}
