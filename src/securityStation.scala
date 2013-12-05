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
  
  /**
   * @override
   */
  def receive = {
  	case report : Report=>{
  	  
  	  if (!report.inspection){
  	    
  	     jail ! new sendPassenger(report.passenger)
  	     println("Passenger " + report.passenger.num + " has failed the scan inspection, and is being sent to jail.\n")
  	  }
  	}
  	
  	
  }
  
  /**
   * Prints output for a received message.
   * 
   * @param msgType The type of message received.
   */
  def printReceive(msgType : String) {
    println("SecurityStation receives " + msgType + " message.\n")
    
  }
  
  /**
   * Prints output for a sent message.
   * 
   * @param msgType The type of the outgoing message.
   * @param recipient The recipient of the message.
   */
  def printSend(msgType : String, recipient : String) {
    println("SecurityStation sends " + msgType + " message to " + recipient + ".\n")
   
  }
  
}
