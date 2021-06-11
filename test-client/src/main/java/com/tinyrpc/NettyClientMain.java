package com.tinyrpc;

import com.tinyrpc.config.RpcServiceConfig;
import com.tinyrpc.proxy.RpcClientProxy;
import com.tinyrpc.remoting.transport.RpcRequestTransport;
import com.tinyrpc.remoting.transport.netty.client.NettyRpcClient;
import com.tinyrpc.remoting.transport.socket.SocketRpcClient;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/11
 */
public class NettyClientMain {

    public static void main(String[] args) {
        // Manually
        RpcRequestTransport rpcRequestTransport = new NettyRpcClient();
        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
        RpcClientProxy rpcClientProxy = new RpcClientProxy(rpcRequestTransport, rpcServiceConfig);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        String hello = helloService.hello(new HelloObject("hello","service2"));
        System.out.println(hello);
        // Annotation

    }
}
