import akka.actor.Actor
import akka.actor.ActorRef
/**
 * Holds a list of passengers waiting to go through the security station
 **/

class Queue() extends Actor{
  
  def receive = {
    case passenger : sendPassenger => {}
  }

}
