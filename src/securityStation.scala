package src

import akka.actor.Actor
import akka.actor.ActorRef

/***
 * The Security Station that takes reports from the scanners and directs
 * the passenger accordingly.
 * 
 * @param lineNum Line the station is associated with
 * @param jail Jail to send passengers to
 */
class securityStation(val jail : ActorRef) extends Actor {
  
  // to see if the report pair is matching
  var passReport : Boolean = false
  var pass
  /**
   * Upon receiving a report, it checks whether the inspection passed or not. If it didn't, it sends that passenger to jail.
   */
  def receive = {
  	case reportPassenger : reportPassenger=>{
  	  if (!reportPassenger.inspection){
  	     println("Passenger " + reportPassenger.passenger.num + " has failed the scan inspection, and is being sent to jail.\n")
  	     jail ! new sendPassenger(reportPassenger.passenger)
  	  }else
  	    println("Passenger " + reportPassenger.passenger.num + " goes to heaven")
  	}
  }
}
