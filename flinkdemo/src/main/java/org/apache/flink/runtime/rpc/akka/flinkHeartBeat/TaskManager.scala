package org.apache.flink.runtime.rpc.akka.flinkHeartBeat

import akka.actor.{Actor, ActorSelection}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{FiniteDuration, SECONDS}

class TaskManager(val tmhostname: String, val jobmanagerhostname: String, val jobmanagerport: Int, val memory: Int,
                  val cpu: Int) extends Actor{

  val taskManagerId = tmhostname
  var actorRef: ActorSelection = _

  override def preStart(): Unit = {

    val path = s"akka://${
      Constrant.JMAS
    }@${jobmanagerhostname}:${jobmanagerport}/user/${Constrant.JMA}"

    actorRef = context.actorSelection(path)

    // 发送消息
    println(path)
    actorRef ! RegisterTaskManager(taskManagerId, memory, cpu)
    println(taskManagerId + " preStart")
  }

  override def receive: Receive = {

    case RegisteredTaskManager(jobmanagerhostname) => {

      val start = new FiniteDuration(0, SECONDS)
      val gap = new FiniteDuration(5, SECONDS)
      context.system.scheduler.scheduleWithFixedDelay(start , gap , self, SendMessage)
      println(taskManagerId + " RegisteredTaskManager")
    }

    case SendMessage =>{
      actorRef ! Heartbeat(taskManagerId)
      println(taskManagerId + " SendMessage")
    }

  }

}
