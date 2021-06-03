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
    SERVICE_CAN_NOT_BE_FOUND("没有找到指定的服务");

    private final String message;
}
