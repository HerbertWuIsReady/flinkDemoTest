package wuakka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.dispatch.OnSuccess;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

public class AkkaDemo1 extends UntypedAbstractActor {

    public static ActorSystem actorSystem;
    public static void main(String[] args) {
//        new AkkaDemo1();
        actorSystem = ActorSystem.create();
        ActorRef actorRef = actorSystem.actorOf(Props.create(AkkaDemo1.class));

        actorRef.tell("aabb", ActorRef.noSender());

        Timeout timeout = new Timeout(Duration.create(2, TimeUnit.SECONDS));
        Future<Object> msg = Patterns.ask(actorRef, "aabb", timeout);

//        msg.onSuccess(
//                new OnSuccess<Object>() {
//                    @Override
//                    public void onSuccess(Object result) throws Throwable {
//                        System.out.println("收到消息");
//                    }
//                } ,actorSystem.dispatcher()
//        );
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        ActorRef actorRef = actorSystem.actorOf(Props.create(TagartDemo.class));

        if (message instanceof String) {
            System.out.printf("Message is String\n" + getSender() + '\n');
            getSender().tell("msg", getSelf());
            actorRef.forward(message ,getContext());
        } else {
            unhandled(message);
            System.out.printf("Message is String\n");
        }
    }
}
