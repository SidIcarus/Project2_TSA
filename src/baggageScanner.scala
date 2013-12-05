package src

import akka.actor.ActorRef

/**
 * Checks the bags of each passenger and makes sure it is clear.
 **/

class baggageScanner(private val securityStation : ActorRef) extends Scanner(securityStation) {

  def receive() = {
    case sendBag : sendBaggage => {
      val passedInspection : Boolean = randomInspection()
      securityStation ! new Report(sendBag.passenger, passedInspection)
      println("BaggageScanner sends a report to SecurityStation")
      println("")
    }    
  }
  
}
