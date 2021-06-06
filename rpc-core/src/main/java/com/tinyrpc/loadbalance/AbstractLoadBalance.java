package com.tinyrpc.loadbalance;

import com.tinyrpc.remoting.dto.RpcRequest;
import java.util.List;

/**
 * Abstract class for a load balancing policy
 *
 * @author wql
 * @date 2021/6/5
 */
public abstract class AbstractLoadBalance implements LoadBalance{

    @Override
    public String selectServiceAddress(List<String> serviceAddresses, RpcRequest rpcRequest) {
        if (serviceAddresses == null || serviceAddresses.size() == 0) {
            return null;
        }
        if (serviceAddresses.size() == 1) {
            return serviceAddresses.get(0);
        }
        return doSelect(serviceAddresses, rpcRequest);
    }

    protected abstract String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest);
}
