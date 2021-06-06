package com.tinyrpc.provider.impl;

import com.tinyrpc.config.RpcServiceConfig;
import com.tinyrpc.enums.RpcErrorMessageEnum;
import com.tinyrpc.exception.RpcException;
import com.tinyrpc.extension.ExtensionLoader;
import com.tinyrpc.provider.ServiceProvider;
import com.tinyrpc.registry.ServiceRegistry;
import com.tinyrpc.remoting.transport.netty.server.NettyRpcServer;
import java.net.InetSocketAddress;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/1
 */
@Slf4j
public class ZKServiceProviderImpl implements ServiceProvider {

    /**
     * key:; rpc service name(interface name + group + version)
     * value: service object
     */
    private final Map<String, Object> serviceMap;
    private final Set<String> registeredService;
    private final ServiceRegistry serviceRegistry;

    public ZKServiceProviderImpl() {
        serviceMap = new ConcurrentHashMap<>();
        registeredService = ConcurrentHashMap.newKeySet();
        serviceRegistry = ExtensionLoader.getExtensionLoader(ServiceRegistry.class).getExtension("zk");
    }

    @Override
    public void addService(RpcServiceConfig rpcServiceConfig) {
        String rpcServiceName = rpcServiceConfig.getRpcServiceName();
        if (registeredService.contains(rpcServiceName)){
            return;
        }
        registeredService.add(rpcServiceName);
        serviceMap.put(rpcServiceName, rpcServiceConfig.getService());
        log.info("Add Service: {} and interfaces: {}", rpcServiceName, rpcServiceName, rpcServiceConfig.getService().getClass().getInterfaces());
    }

    @Override
    public Object getService(String rpcServiceName) {
        Object service = serviceMap.get(rpcServiceName);
        if (null == service) {
            throw new RpcException(RpcErrorMessageEnum.SERVICE_CAN_NOT_BE_FOUND);
        }
        return service;
    }

    @Override
    public void publishService(RpcServiceConfig rpcServiceConfig) {
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            this.addService(rpcServiceConfig);
            serviceRegistry.registerService(rpcServiceConfig.getServiceName(), new InetSocketAddress(host,
                NettyRpcServer.PORT));
        } catch (UnknownHostException e) {
            log.error("occur exception when getHostAddress", e);
        }
    }
}
