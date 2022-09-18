package future;

import com.google.common.util.concurrent.*;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.*;

public class GuavaDemo {

    public static void main(String[] args) {

        print p = new print();
        p.threadName = "p1";

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ListeningExecutorService gpool = MoreExecutors.listeningDecorator(executorService);

        ListenableFuture<Boolean> pf = gpool.submit(p);

        Futures.addCallback(pf, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean aBoolean) {
                System.out.println("success");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("fail");
            }
        });


        print p2 = new print();
        p.threadName = "p2";

        ListenableFuture<Boolean> pf2 = gpool.submit(p2);

        Futures.addCallback(pf2, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean aBoolean) {
                System.out.println("success p2");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("fail p2");
            }
        });

        System.out.println("end!!!");
    }

}

class print implements Callable<Boolean> {

    public static String threadName;

    @Override
    public Boolean call() throws Exception {
        System.out.println(threadName + System.currentTimeMillis() );
        Thread.sleep(1000);
        return true;
    }
}