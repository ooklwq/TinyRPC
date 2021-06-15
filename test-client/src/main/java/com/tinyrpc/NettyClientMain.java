package com.tinyrpc;

import com.tinyrpc.annotation.RpcScan;
import com.tinyrpc.config.RpcServiceConfig;
import com.tinyrpc.proxy.RpcClientProxy;
import com.tinyrpc.remoting.transport.RpcRequestTransport;
import com.tinyrpc.remoting.transport.netty.client.NettyRpcClient;
import com.tinyrpc.remoting.transport.socket.SocketRpcClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/11
 */
@RpcScan(basePackage = {"com.tinyrpc"})
public class NettyClientMain {

    public static void main(String[] args) throws InterruptedException{
        // Manually
//        RpcRequestTransport rpcRequestTransport = new NettyRpcClient();
//        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
//        RpcClientProxy rpcClientProxy = new RpcClientProxy(rpcRequestTransport, rpcServiceConfig);
//        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
//        String hello = helloService.hello(new HelloObject("hello","service2"));
//        System.out.println(hello);
        // Annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(NettyClientMain.class);
        HelloController helloController = (HelloController) applicationContext.getBean("helloController");
        helloController.test();
    }
}
