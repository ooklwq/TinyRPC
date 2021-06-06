package com.tinyrpc.registry.zk;

import com.tinyrpc.enums.RpcErrorMessageEnum;
import com.tinyrpc.exception.RpcException;
import com.tinyrpc.extension.ExtensionLoader;
import com.tinyrpc.loadbalance.LoadBalance;
import com.tinyrpc.registry.ServiceDiscovery;
import com.tinyrpc.registry.zk.util.CuratorUtils;
import com.tinyrpc.remoting.dto.RpcRequest;
import java.net.InetSocketAddress;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

/**
 * service discovery based on zookeeper
 *
 * @author wql
 * @date 2021/6/3
 */
@Slf4j
public class ZkServiceDiscoveryImpl implements ServiceDiscovery {
    private final LoadBalance loadBalance;

    public ZkServiceDiscoveryImpl() {
        this.loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("loadBalance");
    }

    @Override
    public InetSocketAddress lookupService(RpcRequest rpcRequest) {
        String rpcServiceName = rpcRequest.getRpcServiceName();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        List<String> serviceUrlList = CuratorUtils.getChildrenNodes(zkClient, rpcServiceName);
        if (serviceUrlList == null || serviceUrlList.size() == 0) {
            throw new RpcException(RpcErrorMessageEnum.SERVICE_CAN_NOT_BE_FOUND, rpcServiceName);
        }
        // load balancing
        String targetServiceUrl = loadBalance.selectServiceAddress(serviceUrlList, rpcRequest);
        log.info("Successfully found the service address:[{}]", targetServiceUrl);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int post = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host, post);
    }
}
