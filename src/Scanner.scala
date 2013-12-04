package src

import akka.actor.Actor
import akka.actor.ActorRef
import scala.util.Random

abstract class Scanner(val securityStation : ActorRef) extends Actor {

  def randomInspection() : Boolean = {
    val i = new Random
    if(i.nextInt() <= 20) {
      false
    } else {
      true
    }
  }
}