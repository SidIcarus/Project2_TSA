import akka.actor.Actor
import akka.actor.ActorRef
<<<<<<< HEAD
import java.util.ArrayList
=======
>>>>>>> branch 'master' of https://github.com/SidIcarus/Project2_TSA.git

/**
 * Line holds a queue, security station, and scanners(line creates these objects)
 * A passenger is assigned to a line
 * 
 **/

<<<<<<< HEAD
class Line(val num: Int){
	
	private var 
  
	def receive(passenger: ActorRef) = {
	  
	}
}
=======
class Line() extends Actor{

  def receive = {
    case passenger : sendPassenger =>{}
    
  }
}
>>>>>>> branch 'master' of https://github.com/SidIcarus/Project2_TSA.git
