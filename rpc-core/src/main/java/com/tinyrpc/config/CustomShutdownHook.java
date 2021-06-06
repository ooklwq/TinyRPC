package com.tinyrpc.config;

import com.tinyrpc.registry.zk.util.CuratorUtils;
import com.tinyrpc.remoting.transport.netty.server.NettyRpcServer;
import com.tinyrpc.utils.concurrent.threadpool.ThreadPoolFactoryUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import lombok.extern.slf4j.Slf4j;

/**
 * when the server is closed, do something such as unregister all services
 *
 * @author wql
 * @date 2021/6/5
 */
@Slf4j
public class CustomShutdownHook {
    private static final CustomShutdownHook CUSTOM_SHUTDOWN_HOOK = new CustomShutdownHook();

    public static CustomShutdownHook getCustomShutdownHook() {return CUSTOM_SHUTDOWN_HOOK;}

    public void clearAll() {
        log.info("addShutdownHook for clearAll");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), NettyRpcServer.PORT);
                CuratorUtils.clearRegistry(CuratorUtils.getZkClient(), inetSocketAddress);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            ThreadPoolFactoryUtils.shutDownAllThreadPool();
        }));
    }
}
