package src

import akka.actor.Actor
import akka.actor.ActorRef
import scala.collection.mutable.Queue

/**
 * Holds a list of passengers waiting to go through the security station
 **/
class lineQueue(val bodyScanner : ActorRef, val baggageScanner : ActorRef) extends Actor{
  
  var baggageQueue = new Queue[Passenger]()
  var bodyQueue = new Queue[Passenger]()
  var passengerWait : Boolean = true
  
  def receive = {
  	case sendPass : sendPassenger => {
      bodyQueue += sendPass.passenger
      baggageQueue += sendPass.passenger
      
      printReceive("sendPassenger")
      
      val currentPassenger = baggageQueue.dequeue()
            
      baggageScanner ! new sendBaggage(currentPassenger.baggage, currentPassenger)
      printSend("sendBaggage", "BaggageScanner")
      
      if(!passengerWait) {
        var currentPassenger = bodyQueue.dequeue()
        bodyScanner ! new sendPassenger(currentPassenger)
        printSend("sendPassenger", "BodyScanner")
        passengerWait = true
      }
    }
    
    case reqPass : PassengerRequest => {
      
      printReceive("PassengerRequest")
      
      if (bodyQueue.size > 0) {
        bodyScanner ! new sendPassenger( bodyQueue.dequeue() )
        printSend("SendPassenger", "BodyScanner")
      }
      else {
        passengerWait = false
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
