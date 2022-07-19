package zoo;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−07-18 H O U R : 20:HOUR:28
 **/

public class zkdemo1 implements Watcher {

    private static final int SESSION_TIMEOUT = 5000;
    public ZooKeeper zk ;
    public CountDownLatch connectedSignal = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            connectedSignal.countDown();
        }
    }

    public static void main(String[] args) throws Exception {

        final zkdemo1 zkdemo1 = new zkdemo1();

        zkdemo1.zk = new ZooKeeper("", 5000, zkdemo1);

        zkdemo1.connectedSignal.wait();

        zkdemo1.zk.create("/zoo", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        zkdemo1.zk.close();


    }

}
