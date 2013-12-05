package src

import akka.actor.Actor
import java.util.ArrayList

/**
 * The jail holds all the passengers that fail the security check, 
 * and knows the number of stations feeding it passengers
 * @param numStations Number of stations contributing to the jail
 **/
class Jail (val numStations: Int) extends Actor {
  
  // Inmate holder
  private var inmates = new ArrayList[Passenger]()
  
  /**
   * @override
   */
  def receive = {
    case passenger : sendPassenger => {
      inmates.add(passenger.passenger)
      println("Passenger " +passenger.passenger.num+ " is incarcerated and has entered the jail. The jail now holds " + inmates.size() + " people.\n")
    }
  }
  
  /**
   * Releases all the prisoners being held.
   * @override
   */
  override def postStop = {
    inmates.clear();
    println("All incarcerated passengers have been transferred to permanent detention.\n")
  }
}

