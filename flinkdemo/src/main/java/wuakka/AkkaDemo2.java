package wuakka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.japi.Procedure;
import scala.Function1;
import scala.Option;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

public class AkkaDemo2 extends UntypedAbstractActor {

    Procedure Level1 = new Procedure<Object>() {

        @Override
        public void apply(Object param) throws Exception, Exception {
            if(param instanceof String) {
                String paramStr = (String) param;
                if( paramStr.equals("end") ) {
                    getContext().unbecome();
                }

            }

            if (param instanceof String) {
                System.out.println("level1:" + param);
            }

        }

    };

    Procedure Level2 = new Procedure<Object>() {

        @Override
        public void apply(Object param) throws Exception, Exception {
            if(param instanceof String) {
                String paramStr = (String) param;
                if( paramStr.equals("end") ) {
                    getContext().unbecome();
                }

            }

            if (param instanceof String) {
                System.out.println("level2:" + param);
            }

        }

    };

//    Receive level3 = new Receive(){}

    PartialFunction level3 = new PartialFunction<Object, BoxedUnit>(){
        @Override
        public boolean isDefinedAt(Object x) {
            return false;
        }

        @Override
        public BoxedUnit apply(Object v1) {

            System.out.println("a");
            if(v1 instanceof String) {
                String paramStr = (String) v1;
                if( paramStr.equals("end") ) {
                    getContext().unbecome();
                }

            }

            if (v1 instanceof String) {
                System.out.println("level3:" + v1);
            }
            return  null;
        }

    };

    public static void main(String[] args) {
        ActorSystem actor = ActorSystem.create("actor");

        ActorRef child = actor.actorOf(Props.create(AkkaDemo2.class), "child");

//        actor.stop(child);

        child.tell("level3" ,ActorRef.noSender());
        child.tell("level3" ,ActorRef.noSender());
        child.tell("end" ,ActorRef.noSender());
        child.tell("level3" ,ActorRef.noSender());

//        actor.stop(child);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {

        if (message instanceof String) {
            String paramStr = (String) message;
            if( paramStr.equals("level3") ) {
//                getContext().become((PartialFunction<Object, BoxedUnit>) Level1);
//                getContext().become( level3 );
                System.out.println("receiver");

            }
        }

    }
}
