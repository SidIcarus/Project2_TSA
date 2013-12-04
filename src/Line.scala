import akka.actor.Actor
import akka.actor.ActorRef

/**
 * Line holds a queue, security station, and scanners(line creates these objects)
 * A passenger is assigned to a line
 * 
 **/

class Line() extends Actor{

  def receive = {
    case passenger : sendPassenger =>{}
    
  }
}
