package src

/**
 * Passenger is the actor traveling through the security system, and is checked
 * for correct documents, and that the scanner picked nothing up
 * @param baggage, a Baggage item attached to a each particular passenger 
 **/
class Passenger(val baggage : Baggage, val num : Int){ }
