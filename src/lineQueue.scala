import akka.actor.Actor
import akka.actor.ActorRef
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.Queue

/**
 * Holds a list of passengers waiting to go through the security station
 **/
class lineQueue() extends Actor{
  
  var passengerList = new Queue[Passenger]()
  var baggageQueue = new Queue[Passenger]()
  var bodyQueue = new Queue[Passenger]()
  var wait : Boolean = true
  
  def receive = {
  	case sendPass : sendPassenger => {
      bodyQueue += sendPassenger.passenger
      baggageQueue += sendPassenger.passenger
      
      printReceive("sendPassenger")
      
      var currentPassenger = baggageQueue.dequeue()
            
      baggageScanner ! new sendBaggage(currentPassenger.baggage, currPassenger)
      printSend("sendBaggage", "BaggageScanner")
      
      if(!wait) {
        var currentPassenger = bodyQueue.dequeue()
        bodyScanner ! new sendPassenger(currentPassenger)
        printSend("sendPassenger", "BodyScanner")
        wait = true
      }
    }
    
    case reqPass : PassengerRequest => {
      
      printReceive("PassengerRequest")
      
      if (bodyQueue.size > 0) {
        bodyScanner ! new SendPassenger( bodyQueue.dequeue() )
        printSend("SendPassenger", "BodyScanner")
      }
      else {
        wait = false
      }
    }
    
  }

  def printSend(msgType : String, messageTo : String) {
    println("Queue sends " + msgType + " message to " + messageTo + "." )
  }
  
  def printReceive(msgType : String) {
    println("Queue receives " + msgType + " message.")
  }
  
}
