package org.apache.flink.runtime.rpc.akka;

/**
 * @program: wuProject
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−06-28 H O U R : 19:HOUR:30
 **/


import akka.actor.ActorSystem;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.rpc.RpcEndpoint;
import org.apache.flink.runtime.rpc.RpcGateway;
import org.apache.flink.runtime.rpc.RpcService;

/**
 */
public class FlinkRpcDemo {
    public static void main(String[] args) throws Exception{
// 请开始你的表演！
        Configuration a = new Configuration();
        // TODO_MA 注释： 第一步： 启动 RPC 服务
//        Class<?> aClass = Class.forName("org.apache.flink.runtime.rpc.akka.AkkaUtils");
        ActorSystem defaultActorSystem = AkkaUtils.createDefaultActorSystem();
        AkkaRpcService akkaRpcService = new AkkaRpcService(defaultActorSystem,
                AkkaRpcServiceConfiguration.defaultConfiguration());
// TODO_MA 注释： 第二步： 创建 RpcEndpoint 实例，启动 RPC 服务
        GetNowRpcEndpoint getNowRpcEndpoint = new GetNowRpcEndpoint(akkaRpcService);
        getNowRpcEndpoint.start();
// ---- 到此为止，服务端启动好了
// TODO_MA 注释： 第三步： 通过 selfGateway 调用 RPC 服务
        GetNowGateway selfGateway = getNowRpcEndpoint.getSelfGateway(GetNowGateway.class);
        String getNowResult1 = selfGateway.getNow();
        System.out.println(getNowResult1);
// TODO_MA 注释： 第四步： 通过 RpcEndpoint 地址获得代理
        GetNowGateway getNowGateway = akkaRpcService.connect(getNowRpcEndpoint.getAddress(), GetNowGateway.class).get();
        String getNowResult2 = getNowGateway.getNow();
        System.out.println(getNowResult1);
        System.out.println(getNowRpcEndpoint.getAddress());
    }
    public interface GetNowGateway extends RpcGateway {
        String getNow();
    }
    static class GetNowRpcEndpoint extends RpcEndpoint implements GetNowGateway {
        @Override
        protected void onStart() throws Exception {
            System.out.println("GetNowRpcEndpoint 启动");
        }
        protected GetNowRpcEndpoint(RpcService rpcService) {
            super(rpcService);
        }
        @Override
        public String getNow() {
            return "2022-02-02 10:10:10";
        }
    }
}