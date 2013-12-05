package src

import akka.actor.Actor
import akka.actor.ActorRef

/**
 * Checks each passenger to make sure they are not carrying anything illegal
 **/

class bodyScanner(private val securityStation : ActorRef) extends Scanner(securityStation) {

  def receive() = {
    case sendPass : sendPassenger => {
      val passedInspection : Boolean = randomInspection()
      securityStation ! new Report(sendPass.passenger, passedInspection)
      println("BodyScanner sends a report to SecurityStation")
      println("")
    }
  }
  
}
