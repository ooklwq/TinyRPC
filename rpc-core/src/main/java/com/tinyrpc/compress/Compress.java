package com.tinyrpc.compress;

import com.tinyrpc.extension.SPI;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/10
 */
@SPI
public interface Compress {

    byte[] compress(byte[] bytes);

    byte[] decompress(byte[] bytes);
}
