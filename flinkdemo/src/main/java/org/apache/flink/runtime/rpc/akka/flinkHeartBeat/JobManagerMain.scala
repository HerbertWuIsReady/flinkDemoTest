package org.apache.flink.runtime.rpc.akka.flinkHeartBeat

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object JobManagerMain {

  def main(args: Array[String]): Unit = {

    val host = "localhost"
    val port = 6789
    val str =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.artery.enable = "on"
         |akka.remote.artery.canonical.hostname = "${host}"
         |akka.remote.artery.canonical.port  = "${port}"
         |akka.actor.allow-java-serialization = "on"
         |akka.actor.warn-about-java-serializer-usage = "off"
      """.stripMargin

    val conf = ConfigFactory.parseString(str)
    // TODO_MA 注释：ActorSystem
    val actorSystem = ActorSystem(Constrant.JMAS, conf)


    // MyResourceManager
    val ref = actorSystem.actorOf(Props.create(classOf[JobManager]), Constrant.JMA)
    println(ref.path)

    //    actorSystem.actorOf(Props(new JobManager(host, port)), Constrant.JMA)
  }
}
