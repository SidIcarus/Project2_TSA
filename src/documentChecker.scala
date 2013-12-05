package src

import akka.actor.Actor;
import akka.actor.ActorRef;

/**
 * The security system checks the documents of all the passengers and inserts the passenger
 * in a line
 **/

class documentChecker(val lineList : List[ActorRef]) extends Actor{
  
  /**
   * Gets a passenger to have the document checked for
   */
 
 

  def receive = {
    case passenger : sendPassenger => {
      println("documentChecker receives a sendPassenger message")
      
      if (checkDocument()){
        addToLine(passenger)
      }
      else{
        println("Passenger does not have the proper documentation and is turned away")
      }
    }
  }


  
  /**
   * Checks the passengers documents. Has a 20% chance of failing
   * 
   * Returns true or false depending on whether it passed or not
   */
  
  def checkDocument() : Boolean = {
    
    val n = new scala.util.Random
    
    if (n.nextDouble() <= 0.2) 
    	false
    else true
    
  }
  
  
  /**
   * Adds passenger to the line
   */
  
  var lineNum = 0
  def addToLine(passenger : sendPassenger) = {
	 
	  
	  lineList(lineNum) ! new sendPassenger(passenger.passenger)
	  println("Sending passenger to line" + lineNum + ".")
    
	  lineNum+= 1
	  
	  
  }
  
  
  

}
