package com.tinyrpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/3
 */
@AllArgsConstructor
@Getter
public enum RpcConfigEnum {
    RPC_CONFIG_PATH("rpc.properties"),
    ZK_ADDRESS("rpc.zookeeper.address");

    private final String propertyValue;
}
