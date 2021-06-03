package com.tinyrpc;

import com.tinyrpc.entity.RpcServiceProperties;
import com.tinyrpc.remoting.transport.RpcRequestTransport;
import com.tinyrpc.remoting.transport.socket.SocketRpcClient;
import com.tinyrpc.remoting.transport.socket.SocketRpcServer;

/**
 * input description here
 *
 * @author wql
 * @date 2021/5/21
 */
public class SocketClientMain {
    public static void main(String[] args) {
        RpcRequestTransport rpcRequestTransport = new SocketRpcClient();
        RpcServiceProperties rpcServiceProperties = RpcServiceProperties.builder()
                .group("test2").version("version2").build();

    }
}
