package com.tinyrpc;

import com.tinyrpc.remoting.transport.socket.SocketRpcServer;
import com.tinyrpc.serviceimpl.HelloServiceImpl;

/**
 * input description here
 *
 * @author wql
 * @date 2021/5/21
 */
public class SocketServerMain {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        SocketRpcServer socketRpcServer = new SocketRpcServer();
        RpcServiceProperties rpcServiceProperties = RpcServiceProperties.builder()
                .group("test2").version("version2").build();
        socketRpcServer.
    }

}
