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
public enum SerializationTypeEnum {

    KRYO((byte)0x01, "kryo"),
    PROTOSTUFF((byte)0x02, "protostuff");

    private final byte code;
    private final String name;

    public static String getName(byte code) {
        for (SerializationTypeEnum c : SerializationTypeEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }
}
