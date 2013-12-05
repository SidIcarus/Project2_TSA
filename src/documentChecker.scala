package src

import akka.actor.Actor;
import akka.actor.ActorRef;

/**
 * The security system checks the documents of all the passengers and inserts the passenger
 * in a line
 * 
 * @param lineList, a list of all the Line Actor References
 **/

class documentChecker(val lineList : List[ActorRef]) extends Actor{
  
  /**
   * Gets a passenger to have the document checked for
   */
 
 
/**
 * Upon receiving a passenger, it will check the document and then add it to the shortest line
 */
  def receive = {
    case passenger : sendPassenger => {
      println("documentChecker receives a sendPassenger message from the Driver\n")
      println("Passenger " + passenger.passenger.num + " turns their documents over.\n")
      
      if (checkDocument()){
        addToLine(passenger)
        
      }
      else{
        println("Passenger " + passenger.passenger.num + "  does not have the proper documentation and is turned away\n")
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
   * Adds passenger to the shortest line
   */
  
  var lineNum = 0
  def addToLine(passenger : sendPassenger) = {
	 
	  
	  lineList(lineNum) ! new sendPassenger(passenger.passenger)
	  println("documentChecker is Sending passenger to line " + lineNum + ".\n")
	  println("Passenger " + passenger.passenger.num + " goes to line " + lineNum + ".\n")
	  
    
	  lineNum+= 1
	  
	  if (lineNum == lineList.size){
	    lineNum = 0
	  }
	  
	  
  }
  
  
  

}
