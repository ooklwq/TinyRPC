package com.tinyrpc.loadbalance;

import com.tinyrpc.extension.SPI;
import com.tinyrpc.remoting.dto.RpcRequest;
import java.util.List;

/**
 * interface to the load balancing policy
 *
 * @author wql
 * @date 2021/6/5
 */
@SPI
public interface LoadBalance {

    /**
     * Choose one from the list of existing service address list
     * @param serviceAddresses Service address list
     * @param rpcRequest
     * @return target service address
     */
    String selectServiceAddress(List<String> serviceAddresses, RpcRequest rpcRequest);
}
