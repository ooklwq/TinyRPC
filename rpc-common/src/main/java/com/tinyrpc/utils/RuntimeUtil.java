package com.tinyrpc.utils;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/6
 */
public class RuntimeUtil {

    /**
     * 获取CPU的核心数
     * @return cpu的核心数
     */
    public static int cpus() {
        return Runtime.getRuntime().availableProcessors();
    }
}
