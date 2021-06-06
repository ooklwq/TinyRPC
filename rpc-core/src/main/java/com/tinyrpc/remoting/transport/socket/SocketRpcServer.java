package com.tinyrpc.remoting.transport.socket;

import com.tinyrpc.config.CustomShutdownHook;
import com.tinyrpc.config.RpcServiceConfig;
import com.tinyrpc.factory.SingletonFactory;
import com.tinyrpc.provider.ServiceProvider;
import com.tinyrpc.provider.impl.ZKServiceProviderImpl;
import com.tinyrpc.remoting.transport.netty.server.NettyRpcServer;
import com.tinyrpc.utils.concurrent.threadpool.ThreadPoolFactoryUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * input description here
 *
 * @author wql
 * @date 2021/5/21
 */
@Slf4j
public class SocketRpcServer {

    private final ExecutorService threadPool;
    private final ServiceProvider serviceProvider;

    public SocketRpcServer() {
        this.threadPool = ThreadPoolFactoryUtils.createCustomThreadPoolIfAbsent("socket-server-rpc-pool");
        this.serviceProvider = SingletonFactory.getInstance(ZKServiceProviderImpl.class);
    }

    public void registerService(RpcServiceConfig rpcServiceConfig) {
        serviceProvider.publishService(rpcServiceConfig);
    }

    public void start() {
        try (ServerSocket server = new ServerSocket()){
            String host = InetAddress.getLocalHost().getHostAddress();
            server.bind(new InetSocketAddress(host, NettyRpcServer.PORT));
            CustomShutdownHook.getCustomShutdownHook().clearAll();
            Socket socket;
            while ((socket = server.accept()) != null) {
                log.info("client connected [{}]", socket.getInetAddress());
                threadPool.execute(new SocketRpcRequestHandlerRunnable(socket));
            }
            threadPool.shutdown();
        } catch (IOException e) {
            log.error("occur IOException:", e);
        }
    }
}
