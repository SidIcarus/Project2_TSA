//import akka.actor.Actor;
//import akka.actor.ActorRef;

/**
 * The security system checks the documents of all the passengers and inserts the passenger
 * in a line
 **/

class securitySystem() /*extends Actor*/{
  
  /**
   * Gets a passenger to have the document checked for
   */
  /*
  def getPassenger()= {
    case passenger : sendPassenger => {
      if (checkDocument()){
        //send the passenger to a line
      }
      else{
        println("Passenger does not have the proper documenation and is turned away")
      }
    }
  }*/

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
  
  def addToLine = {
    
  }
}
