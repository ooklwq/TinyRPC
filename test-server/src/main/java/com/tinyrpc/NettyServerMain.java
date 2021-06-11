package com.tinyrpc;

import com.tinyrpc.config.RpcServiceConfig;
import com.tinyrpc.remoting.transport.netty.server.NettyRpcServer;
import com.tinyrpc.serviceimpl.HelloServiceImpl2;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/11
 */
public class NettyServerMain {

    public static void main(String[] args) {
        // Register service manually
        HelloService helloService2 = new HelloServiceImpl2();
//        RpcServiceConfig rpcServiceConfig = RpcServiceConfig.builder()
//            .group("test2").version("version2").service(helloService2).build();
        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
        rpcServiceConfig.setService(helloService2);
        NettyRpcServer nettyRpcServer = new NettyRpcServer();
        nettyRpcServer.registerService(rpcServiceConfig);
        nettyRpcServer.start();
    }

}
