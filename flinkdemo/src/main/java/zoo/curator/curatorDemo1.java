package zoo.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class curatorDemo1 {

    public static void main(String[] args) throws Exception {
        RetryPolicy r = new ExponentialBackoffRetry(1000, 3);

        String conStr = "127.0.0.1:2181";
        CuratorFramework curator1 = CuratorFrameworkFactory.newClient(conStr, r);

        CuratorFramework curator2 = CuratorFrameworkFactory.builder()
                .connectString(conStr)
                .retryPolicy(r)
                .connectionTimeoutMs(10000)
                .sessionTimeoutMs(10000)
                .build();

        curator1.start();
//        String s = curator1.create().creatingParentContainersIfNeeded() .withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/test/crud/node_5", "支付穿".getBytes(StandardCharsets.UTF_8));
//
//        System.out.println(s);
//        System.out.println(s.lastIndexOf("node_5"));

//        Stat stat = curator1.checkExists().forPath("/test/crud/node_4");
//
//        System.out.println("->" + stat);
//
//        byte[] bytes = curator1.getData().forPath("/test/crud/node_4");
//
//        System.out.println(new String(bytes));
//
//        List<String> strings = curator1.getChildren().forPath("/test/crud");
//
//        System.out.println(strings);

        // 同步更新
//        curator1.setData().forPath("/test/crud/node_4", "支付宝".getBytes(StandardCharsets.UTF_8));

//        bytes = curator1.getData().forPath("/test/crud/node_4");
//
//        System.out.println(new String(bytes));

        // 异步更新
        AsyncCallback.StringCallback stringCallback = new AsyncCallback.StringCallback() {
            @Override
            public void processResult(int i, String s, Object o, String s1) {

                System.out.println(i + "<->" + s + "<->" + o + "<->" + s1);
            }
        };

//        curator1.start();
//        curator1.setData()
//                .inBackground(stringCallback)
//                .forPath("/test/crud/node_4", "支付宝1".getBytes(StandardCharsets.UTF_8));


//        bytes = curator1.getData().forPath("/test/crud/node_4");
//
//        System.out.println(new String(bytes));

        Thread.sleep(10000);

    }
}
