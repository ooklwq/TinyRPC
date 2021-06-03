package com.tinyrpc.remoting.transport.socket;

import com.tinyrpc.registry.ServiceDiscovery;
import com.tinyrpc.remoting.dto.RpcRequest;
import com.tinyrpc.remoting.transport.RpcRequestTransport;

/**
 * input description here
 *
 * @author wql
 * @date 2021/5/21
 */
public class SocketRpcClient implements RpcRequestTransport {
    private final ServiceDiscovery serviceDiscovery;

    public SocketRpcClient() {
        this.serviceDiscovery =
    }

    @Override
    public Object sendRpcRequest(RpcRequest rpcRequest) {
        return null;
    }
}
