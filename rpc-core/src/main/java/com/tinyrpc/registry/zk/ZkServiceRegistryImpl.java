package com.tinyrpc.registry.zk;

import com.tinyrpc.registry.ServiceRegistry;
import com.tinyrpc.registry.zk.util.CuratorUtils;
import java.net.InetSocketAddress;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

/**
 * service registration based on zookeeper
 *
 * @author wql
 * @date 2021/6/3
 */
@Slf4j
public class ZkServiceRegistryImpl implements ServiceRegistry {

    @Override
    public void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress) {
        String servicePath = CuratorUtils.ZK_REGISTER_ROOT_PATH + "/" + rpcServiceName + inetSocketAddress.toString();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        CuratorUtils.createPersistentNode(zkClient, servicePath);
    }
}
