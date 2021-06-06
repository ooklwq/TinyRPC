package com.tinyrpc.registry;

import com.tinyrpc.extension.SPI;
import com.tinyrpc.remoting.dto.RpcRequest;
import java.net.InetSocketAddress;

/**
 * service discovery
 *
 * @author wql
 * @date 2021/6/1
 */
@SPI
public interface ServiceDiscovery {

    /**
     * lookup service by rpcServiceName
     * @param rpcRequest rpc service poji
     * @return service address
     */
    InetSocketAddress lookupService(RpcRequest rpcRequest);
}
