import akka.actor.Actor
import akka.actor.ActorRef
/**
 * Security Station keeps track of the results of the two scanners,
 * and manages the scanners 
 **/
import akka.actor.Actor
import akka.actor.ActorRef
import java.util.ArrayList

<<<<<<< HEAD
/***
 * The Security Station that takes reports from the scanners and directs
 * the passenger accordingly.
 * 
 * @param lineNum Line the station is associated with
 * @param jail Jail to send passengers to
 */
class securityStation(val lineNum : Int, val jail : ActorRef) extends Actor {
  
  /**
   * @override
   */
  def receive = {
 
  }
  
  /**
   * Prints output for a received message.
   * 
   * @param msgType The type of message received.
   */
  def printReceive(msgType : String) {
    println("SecurityStation receives " + msgType + " message.")
  }
  
  /**
   * Prints output for a sent message.
   * 
   * @param msgType The type of the outgoing message.
   * @param recipient The recipient of the message.
   */
  def printSend(msgType : String, recipient : String) {
    println("SecurityStation sends " + msgType + " message to " + recipient + ".")
  }
  
}
=======
class securityStation() extends Actor {
  
  def receive = {
    case passenger : sendPassenger =>{}
  }

}
>>>>>>> branch 'master' of https://github.com/SidIcarus/Project2_TSA.git
