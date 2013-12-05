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
  var passReport : Int = 0
  var bagReport : Int = 0
  /**
   * Upon receiving a report, it checks whether the inspection passed or not. If it didn't, it sends that passenger to jail.
   */
  def receive = {
  	case reportPassenger : reportPassenger => {
  	  println("\tThe report for passengers " +reportPassenger.passenger.num+ " has been completed")
  	  passReport = 1;
  		if (bagReport == 1){
	  	  if (!reportPassenger.inspection){
	  	     println("Passenger " + reportPassenger.passenger.num + " has failed the scan inspection, and is being sent to jail.\n")
	  	     jail ! new sendPassenger(reportPassenger.passenger)
	  	  }else
	  	    println("Passenger " + reportPassenger.passenger.num + " walks off into the distance\n")
  		}
  	}
  	
  	case reportBaggage : reportBaggage => {
	  println("\tThe report for passengers " +reportBaggage.passenger.num+ "s' baggage has been completed")
  	  bagReport = 1;
  		if (passReport == 1){
	  	  if (!reportBaggage.inspection){
	  	     println("Passenger " + reportBaggage.passenger.num + " has failed the scan inspection, and is being sent to jail.\n")
	  	     jail ! new sendPassenger(reportBaggage.passenger)
	  	  }else
	  	    println("Passenger " + reportBaggage.passenger.num + " walks off into the distance\n")
  		}
  	}
  }
}
