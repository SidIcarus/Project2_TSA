import akka.actor.Actor
import akka.actor.ActorRef
import java.util.ArrayList

/**
 * Line holds a queue, security station, and scanners(line creates these objects)
 * A passenger is assigned to a line
 * 
 **/

class Line(val num: Int) extends Actor{

  def receive = {
    case passenger : sendPassenger =>{}
    
  }
}
