package com.tinyrpc.remoting.dto;

import lombok.*;

/**
 * input description here
 *
 * @author wql
 * @date 2021/5/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RpcMessage {

    /**
     * rpc message type
     */
    private byte messageType;

    /**
     * serialization type
     */
    private byte codec;

    /**
     * compress type
     */
    private byte compress;

    /**
     * request id
     */
    private int requestId;

    /**
     * request data
     */
    private Object data;

}
