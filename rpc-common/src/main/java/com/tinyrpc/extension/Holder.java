package com.tinyrpc.extension;

import lombok.Data;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/4
 */
@Data
public class Holder<T> {

    private volatile T value;
}
