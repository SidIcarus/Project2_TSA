package src

import akka.actor.Actor
import akka.actor.ActorRef
import scala.util.Random

abstract class Scanner(private val securityStation : ActorRef) extends Actor {

  def randomInspection() : Boolean = {
    val i = new Random
    if(i.nextDouble() <= 0.20)
      false
    else
      true
  }
}