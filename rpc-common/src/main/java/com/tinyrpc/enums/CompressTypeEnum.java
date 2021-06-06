package com.tinyrpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/6
 */
@AllArgsConstructor
@Getter
public enum CompressTypeEnum {

    GZIP((byte) 0x01, "gzip");

    private final byte code;
    private final String name;

    public static String getName(byte code) {
        for (CompressTypeEnum c : CompressTypeEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }
}
