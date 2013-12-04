package src

import akka.actor.Actor
import java.util.ArrayList
import akka.actor.ActorRef

/**
 * The jail holds all the passengers that fail the security check, 
 * and knows the number of stations feeding it passengers
 * @param numStations Number of stations contributing to the jail
 **/

class Jail (val numStations: Int) extends Actor {
  
  /**
   * The prisoners being held
   */
  private var inmates = new ArrayList[Passenger]()
  
  /**
   * @override
   */
  def receive = {
    case passenger : sendPassenger => {
      inmates.add(passenger.passenger)
      println("Passenger is incarcerated and has entered the jail.")
    }
  }
  
  /**
   * @override
   */
  override def postStop = {
    release()
  }
  
  /**
   * Releases all the prisoners being held.
   */
  def release() {
    inmates.clear();
    println("All incarcerated passengers have been transferred to permanent detention.")
  }
}

