package com.akkademy

/**
  * Created by lantingeee on 22/10/2017.
  */


import akka.actor.Actor
import akka.event.Logging
import com.akkademy.messages.SetRequest
import scala.collection.mutable.HashMap

class AkkademyDb extends Actor {

  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case SetRequest(key, value) =>
      log.info("recived SetRequest - key:{} value:{}", key, value)
      map.put(key, value)
    case o =>
      log.info("recevied unknow message:{}", o)
  }
}
