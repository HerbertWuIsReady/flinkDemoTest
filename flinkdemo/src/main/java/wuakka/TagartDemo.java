package wuakka;

import akka.actor.UntypedAbstractActor;

public class TagartDemo extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {

        if(message instanceof String) {
            String msg = (String) message ;
            System.out.println("sender:" + msg);
        }

    }
}
