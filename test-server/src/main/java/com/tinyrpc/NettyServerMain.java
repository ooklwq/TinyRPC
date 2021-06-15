package com.tinyrpc;

import com.tinyrpc.annotation.RpcScan;
import com.tinyrpc.config.RpcServiceConfig;
import com.tinyrpc.remoting.transport.netty.server.NettyRpcServer;
import com.tinyrpc.serviceimpl.HelloServiceImpl2;
import org.checkerframework.checker.units.qual.A;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/11
 */
@RpcScan(basePackage = {"com.tinyrpc"})
public class NettyServerMain {

    public static void main(String[] args) {
        // annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(NettyServerMain.class);
        NettyRpcServer nettyRpcServer = (NettyRpcServer) applicationContext.getBean("nettyRpcServer");
        // Register service manually
//        HelloService helloService2 = new HelloServiceImpl2();
//        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
//        rpcServiceConfig.setService(helloService2);
////        NettyRpcServer nettyRpcServer = new NettyRpcServer();
//        nettyRpcServer.registerService(rpcServiceConfig);
        nettyRpcServer.start();

    }

}
