package org.apache.flink.runtime.rpc.akka.flinkHeartBeat

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import java.time.Duration
import scala.collection.mutable
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{FiniteDuration, SECONDS}

class JobManager extends Actor{

  var hostname: String = "localhost"
  var port: Int = 6781
  var infoToLong = new mutable.HashMap[String, TaskManagerInfo]()

  override def preStart(): Unit = {

    val start = new FiniteDuration(0, SECONDS)
    val gap = new FiniteDuration(5, SECONDS)
    Duration.ofMillis(0)
    context.system.scheduler.scheduleWithFixedDelay(start , gap , self, CheckTimeOut)
    println("preStart")
  }

  override def receive: Receive = {


    case RegisterTaskManager(taskmanagerid, memory, cpu) => {

      val task = new TaskManagerInfo(taskmanagerid, memory, cpu)
      task.lastHeartBeatTime = System.currentTimeMillis()
      infoToLong.put(taskmanagerid, new TaskManagerInfo(taskmanagerid, memory, cpu))
      sender() ! RegisteredTaskManager(hostname + ":" + port)
      println("RegisterTaskManager" )
    }

    case Heartbeat (taskmanagerid) => {

      val taskinfo = infoToLong.getOrElse(taskmanagerid , null)
      taskinfo.lastHeartBeatTime = System.currentTimeMillis()
      println("Heartbeat")
    }

    case CheckTimeOut => {

      infoToLong.foreach(
        x => {
          val current = System.currentTimeMillis()
          val task = x._2
          val ht = current - task.lastHeartBeatTime
          if ( ht >= 15 * 1000)
          println(task.taskmanagerid + " is over")
        }
      )

      infoToLong = infoToLong.filter(
        x => {
          val current = System.currentTimeMillis()
          val task = x._2
          val ht = current - task.lastHeartBeatTime
          if ( ht >= 15 * 1000) false
          true
        }
      )

    }


  }
}

