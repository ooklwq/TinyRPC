package com.tinyrpc.remoting.handler;


import com.tinyrpc.factory.SingletonFactory;
import com.tinyrpc.provider.ServiceProvider;
import com.tinyrpc.provider.ServiceProviderImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * input description here
 *
 * @author wql
 * @date 2021/5/21
 */
@Slf4j
public class RpcRequestHandler {
    private final ServiceProvider serviceProvider;

    public RpcRequestHandler() {
        serviceProvider = SingletonFactory.getInstance(ServiceProviderImpl.class);
    }



}
