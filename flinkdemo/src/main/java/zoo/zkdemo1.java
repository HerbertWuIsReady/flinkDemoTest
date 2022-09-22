package zoo;

import org.apache.zookeeper.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−07-18 H O U R : 20:HOUR:28
 **/

public class zkdemo1 implements Watcher {

    private static final int SESSION_TIMEOUT = 5000;
    public static ZooKeeper zk ;
    public CountDownLatch connectedSignal = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
            connectedSignal.countDown();
        }
    }

    public static void main(String[] args) throws Exception {

        final zkdemo1 zkdemo12 = new zkdemo1();


        zkdemo1.zk = new ZooKeeper("localhost:12188", 5000, zkdemo12);


        zkdemo12.connectedSignal.await();

        // 永久节点
//        zkdemo1.zk.create("/wuxuan", "wuxuan".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        zkdemo1.zk.close();

        // 临时节点
//        zkdemo1.zk.create("/zoo/wuxuan/wuxuan", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//        Thread.sleep(1000 * 20);

        // 列出临时节点
//        printZnode("/");

        //删除节点
//        zkdemo1.zk.delete("/zoo/wuxuan/wuxuan", -1);

        final byte[] data = zkdemo1.zk.getData("/wuxuan", false, null);
        System.out.println(new String(data));
//        printZnode(data.toString());
    }

    public static void printZnode(String path) throws Exception {
//        System.out.println("-->"+path);
        if (zkdemo1.zk.getAllChildrenNumber(path) >= 1) {
            for (String child: zkdemo1.zk.getChildren(path, false)) {
                String realPath = "";
                if (path.equals("/")) {
                    realPath = "/" + child;
                } else {
                    realPath = path + "/" + child;
                }
                printZnode(realPath);
            }
        } else {
            System.out.println(path);
        }
    }

}
