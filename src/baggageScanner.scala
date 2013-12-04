package src
import akka.actor.Actor
import akka.actor.ActorRef

/**
 * Checks the bags of each passenger and makes sure it is clear.
 **/

class baggageScanner(val securityStation : ActorRef) extends Scanner {

  def receive() = {
    case sendBag : sendBaggage => {
      
      val passedInspection : Boolean = true
      
      securityStation ! new Report(sendBaggage.passenger, passedInspection)
    }
    
  }
  
}
