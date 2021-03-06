package com.tinyrpc.registry;

import com.tinyrpc.extension.SPI;
import java.net.InetSocketAddress;

/**
 * service registration
 *
 * @author wql
 * @date 2021/6/1
 */
@SPI
public interface ServiceRegistry {

    /**
     * register service
     * @param rpcServiceName    rpc service name
     * @param inetSocketAddress service address
     */
    void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress);
}
