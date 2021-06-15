package com.tinyrpc.remoting.transport;

import com.tinyrpc.extension.SPI;
import com.tinyrpc.remoting.dto.RpcRequest;

/**
 * send RpcRequest
 *
 * @author wql
 * @date 2021/5/21
 */
@SPI
public interface RpcRequestTransport {

    /**
     * send rpc request to server and get result
     * @param rpcRequest
     * @return
     */
    Object sendRpcRequest(RpcRequest rpcRequest);
}
