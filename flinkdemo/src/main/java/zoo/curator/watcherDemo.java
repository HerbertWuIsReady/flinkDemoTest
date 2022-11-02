package zoo.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.nio.charset.StandardCharsets;

public class watcherDemo {

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

        String path = "/test/crud/node_1";
//        String s = curator1.create().creatingParentContainersIfNeeded() .withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/test/crud/node_5", "支付穿".getBytes(StandardCharsets.UTF_8));
//        Watcher w = new Watcher() {
//
//            @Override
//            public void process(WatchedEvent watchedEvent) {
//                System.out.println("++++watcher" + watchedEvent);
//            }
//        };
//
//        byte[] bytes = curator1.getData().usingWatcher(w).forPath("/test/crud/node_1");
//
//        System.out.println("bytes " + new String(bytes));
//
//        curator1.setData().forPath("/test/crud/node_1", "zhifubao".getBytes(StandardCharsets.UTF_8));
//
//        curator1.setData().forPath("/test/crud/node_1", "bitebi".getBytes(StandardCharsets.UTF_8));
//
//        Thread.sleep(10000);

        // cache监控
//        NodeCache nodeCache = new NodeCache(curator1, path, false);
//
//        NodeCacheListener nodeCacheListener = new NodeCacheListener() {
//            @Override
//            public void nodeChanged() throws Exception {
//                ChildData currentData = nodeCache.getCurrentData();
//                System.out.println("---->" + currentData);
//            }
//        };
//
//        nodeCache.getListenable().addListener(nodeCacheListener);
//
//        nodeCache.start();
//
//        curator1.setData().forPath(path, "zhifubao".getBytes(StandardCharsets.UTF_8));
//
//        Thread.sleep(1000);
//
//        curator1.setData().forPath(path, "zhifubao".getBytes(StandardCharsets.UTF_8));
//
//        Thread.sleep(1000);
//
//        curator1.setData().forPath(path, "zhifubao".getBytes(StandardCharsets.UTF_8));
//
//        Thread.sleep(1000);


        // 子结点监听

        PathChildrenCache pathChildrenCache = new PathChildrenCache(curator1, path, true);

        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                System.out.println("-->" + event);
            }
        };

        pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);

        pathChildrenCache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);

        Thread.sleep(1000);


//        curator1.create().forPath(path + "/1");
        curator1.delete().forPath(path + "/1");

        Thread.sleep(1000);

//        new TreeCache();

    }
}
