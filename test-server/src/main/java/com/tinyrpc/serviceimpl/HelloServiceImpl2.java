package com.tinyrpc.serviceimpl;

import com.tinyrpc.HelloObject;
import com.tinyrpc.HelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/11
 */
@Slf4j
public class HelloServiceImpl2 implements HelloService {

    static {
        System.out.println("HelloServiceImpl2被创建");
    }
    @Override
    public String hello(HelloObject hello) {
        log.info("HelloServiceImpl2收到: {}.", hello.getMessage());
        String result = "Hello description is " + hello.getDescription();
        log.info("HelloServiceImpl2返回: {}.", result);
        return result;
    }

}
