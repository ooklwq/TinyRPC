package com.tinyrpc;

import com.tinyrpc.annotation.RpcReference;
import javafx.scene.shape.HLineTo;
import org.springframework.stereotype.Component;

/**
 * input description here
 *
 * @author wql
 * @date 2021/6/15
 */
@Component
public class HelloController {

    @RpcReference(version = "version1", group = "test1")
    private HelloService helloService;

    public void test() throws InterruptedException{
        String hello = this.helloService.hello(new HelloObject("111","222"));
        Thread.sleep(12000);
        for (int i = 0; i < 10; i++) {
            System.out.println(helloService.hello(new HelloObject("111", "222")));
        }
    }
}
