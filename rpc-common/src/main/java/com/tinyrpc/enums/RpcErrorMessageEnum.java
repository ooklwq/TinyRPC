package com.tinyrpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/1
 */
@AllArgsConstructor
@Getter
@ToString
public enum RpcErrorMessageEnum {
    CLIENT_CONNECT_SERVER_FAILURE("客户端连接服务端失败"),
    SERVICE_INVOCATION_FAILURE("服务调用失败"),
    REQUEST_NOT_MATCH_RESPONSE("返回结果错误！请求和返回的响应不匹配"),
    SERVICE_CAN_NOT_BE_FOUND("没有找到指定的服务");


    private final String message;
}

