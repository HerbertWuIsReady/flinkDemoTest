package org.apache.flink.runtime.rpc.akka.flinkHeartBeat



// 注册消息 TaskManager -> JobManager
case class RegisterTaskManager(val taskmanagerid: String, val memory: Int, val cpu: Int)

//  注册完成消息 JobManager -> TaskManager
case class RegisteredTaskManager(val jobmanagerhostname: String)

//  心跳消息 TaskManager -> JobManager
case class Heartbeat(val taskmanagerid: String)

//  TaskManager 信息类
class TaskManagerInfo(val taskmanagerid: String, val memory: Int, val cpu: Int) {
  // 上一次心跳时间
  var lastHeartBeatTime: Long = _
  override def toString: String = {
    taskmanagerid + "," + memory + "," + cpu
  }
}

 // 一个发送心跳的信号
case object SendMessage

 // 一个检查信号
case object CheckTimeOut
