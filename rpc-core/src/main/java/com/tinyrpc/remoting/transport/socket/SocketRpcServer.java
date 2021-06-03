package com.tinyrpc.remoting.transport.socket;

import com.tinyrpc.provider.ServiceProvider;
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
        //TODO:线程池和注册中心
        this.threadPool =
        //this.serviceProvider =
    }

    public void start() {
        try (ServerSocket server = new ServerSocket()){
            String host = InetAddress.getLocalHost().getHostAddress();
            server.bind(new InetSocketAddress(host, 9999));
            //TODO:ShutdownHook
            Socket socket;
            while ((socket = server.accept()) != null) {
                log.info("client connected [{}]", socket.getInetAddress());
                //TODO：线程池执行
            }
            //threadPool.shutdown();
        } catch (IOException e) {
            log.error("occur IOException:", e);
        }
    }
}
