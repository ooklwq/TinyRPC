package com.tinyrpc.registry.zk;

import com.tinyrpc.registry.ServiceRegistry;
import java.net.InetSocketAddress;

/**
 * service registration based on zookeeper
 *
 * @author wql
 * @date 2021/6/3
 */
public class ZkServiceRegistryImpl implements ServiceRegistry {

    @Override
    public void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress) {
        String servicePath =
    }
}
