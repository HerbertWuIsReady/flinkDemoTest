package org.apache.flink.runtime.rpc.akka.flinkHeartBeat

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object TaskManagerMain {

  def main(args: Array[String]): Unit = {

    // TODO_MA 注释： 远程主机名称
    val HOSTNAME = "localhost"
    // TODO_MA 注释： JM 的 hostname 和 port
    val JM_HOSTNAME = "localhost"
    val JM_PORT = 6789
    // TODO_MA 注释： 抽象的内存资源 和 CPU 个数
    val TASKMANAGER_MEMORY = "4".toInt
    val TASKMANAGER_CORE = "1".toInt
    // TODO_MA 注释： 当前 TM 的 hostname 和 port
    var TASKMANAGER_PORT = "6781".toInt
    var TMHOSTNAME = "jb"
    // TODO_MA 注释： 指定主机名称和端口号相关的配置

    val str =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.artery.enable = "on"
         |akka.remote.artery.canonical.hostname = "${JM_HOSTNAME}"
         |akka.remote.artery.canonical.port  = "${TASKMANAGER_PORT}"
         |akka.actor.allow-java-serialization = "on"
         |akka.actor.warn-about-java-serializer-usage = "off"
  """.stripMargin
    val conf = ConfigFactory.parseString(str)
    // TODO_MA 注释： 启动一个 ActorSystem
    val actorSystem = ActorSystem(Constrant.JMAS, conf)
    // TODO_MA 注释： 启动一个 Actor
    actorSystem.actorOf(Props(new TaskManager(TMHOSTNAME, JM_HOSTNAME, JM_PORT, TASKMANAGER_MEMORY,
      TASKMANAGER_CORE)), Constrant.TMA)

  }

}
