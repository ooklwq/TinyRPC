package com.tinyrpc;

import com.tinyrpc.config.RpcServiceConfig;
import com.tinyrpc.proxy.RpcClientProxy;
import com.tinyrpc.remoting.transport.RpcRequestTransport;
import com.tinyrpc.remoting.transport.socket.SocketRpcClient;

/**
 * input description here
 *
 * @author wql
 * @date 2021/5/21
 */
public class SocketClientMain {
    public static void main(String[] args) {
        RpcRequestTransport rpcRequestTransport = new SocketRpcClient();
        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
        RpcClientProxy rpcClientProxy = new RpcClientProxy(rpcRequestTransport, rpcServiceConfig);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        String hello = helloService.hello(new HelloObject("111", "222"));
        System.out.println(hello);

    }
}
