package com.tinyrpc.remoting.handler;


import com.tinyrpc.exception.RpcException;
import com.tinyrpc.factory.SingletonFactory;
import com.tinyrpc.provider.ServiceProvider;
import com.tinyrpc.provider.impl.ZKServiceProviderImpl;
import com.tinyrpc.remoting.dto.RpcRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        serviceProvider = SingletonFactory.getInstance(ZKServiceProviderImpl.class);
    }

    /**
     * Processing rpcRequest: call the corresponding method, and then return the method result
     * @param rpcRequest
     * @return
     */
    public Object handle(RpcRequest rpcRequest) {
        Object service = serviceProvider.getService(rpcRequest.getRpcServiceName());
        return invokeTargetMethod(rpcRequest, service);
    }

    /**
     * get method execution results.
     * @param rpcRequest client request
     * @param service service object
     * @return the result of the target method execution
     */
    public Object invokeTargetMethod(RpcRequest rpcRequest, Object service) {
        Object result;
        try {
            Method method = service.getClass().getMethod(rpcRequest.getMethodName(), rpcRequest.getParamTypes());
            result = method.invoke(service, rpcRequest.getParameters());
            log.info("service:[{}] successful invoke method:[{}]", rpcRequest.getInterfaceName(), rpcRequest.getMethodName());
        } catch (NoSuchMethodException | IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
            throw new RpcException(e.getMessage(), e);
        }
        return result;
    }



}
