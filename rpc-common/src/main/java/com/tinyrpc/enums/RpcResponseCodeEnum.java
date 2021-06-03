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
@ToString
@Getter
public enum RpcResponseCodeEnum {
    SUCCESS(200, "The remote call is successful"),
    FAIL(500, "The remote call is fail");

    private final int code;

    private final String message;
}
