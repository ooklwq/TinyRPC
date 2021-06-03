package com.tinyrpc.provider;

import com.tinyrpc.config.RpcServiceConfig;

/**
 * store and provide service object
 *
 * @author wql
 * @date 2021/6/1
 */
public interface ServiceProvider {

    /**
     *
     * @param rpcServiceConfig rpc service related attributes
     */
    void addService(RpcServiceConfig rpcServiceConfig);

    /**
     *
     * @param rpcServiceName rpc service name
     */
    Object getService(String rpcServiceName);


    /**
     *
     * @param rpcServiceConfig  rpc service related attributes
     */
    void publishService(RpcServiceConfig rpcServiceConfig);
}
