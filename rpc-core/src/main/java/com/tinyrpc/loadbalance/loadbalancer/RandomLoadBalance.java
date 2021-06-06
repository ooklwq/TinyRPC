package com.tinyrpc.loadbalance.loadbalancer;

import com.tinyrpc.loadbalance.AbstractLoadBalance;
import com.tinyrpc.remoting.dto.RpcRequest;
import java.util.List;
import java.util.Random;

/**
 * Implementation of random load balancing strategy
 *
 * @author wql
 * @date 2021/6/5
 */
public class RandomLoadBalance extends AbstractLoadBalance {

    @Override
    protected String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest) {
        Random random = new Random();
        return serviceAddresses.get(random.nextInt(serviceAddresses.size()));
    }
}
