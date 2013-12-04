package src

import akka.actor.Actor
import akka.actor.ActorRef

/**
 * Checks each passenger to make sure they are not carrying anything illegal
 **/

class bodyScanner(val securityStation : ActorRef) extends Scanner(securityStation) {

  def receive() = {
    case sendPass : sendPassenger => {
      
      val passedInspection : Boolean = randomInspection()
      
      securityStation ! new Report(sendPass.passenger, passedInspection)
    }
    
    case start : Start => {
      //this will start the body scanner
    }
    
  }
  
}
