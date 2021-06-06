package com.tinyrpc.remoting.transport.netty.server;

import com.tinyrpc.enums.CompressTypeEnum;
import com.tinyrpc.enums.RpcResponseCodeEnum;
import com.tinyrpc.enums.SerializationTypeEnum;
import com.tinyrpc.factory.SingletonFactory;
import com.tinyrpc.remoting.constants.RpcConstants;
import com.tinyrpc.remoting.dto.RpcMessage;
import com.tinyrpc.remoting.dto.RpcRequest;
import com.tinyrpc.remoting.dto.RpcResponse;
import com.tinyrpc.remoting.handler.RpcRequestHandler;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Customize the ChannelHandler of the server to process the data sent by the client.
 *
 * @author wql
 * @date 2021/6/6
 */
@Slf4j
public class NettyRpcServerHandler extends ChannelInboundHandlerAdapter {

    private final RpcRequestHandler rpcRequestHandler;

    public NettyRpcServerHandler() {
        this.rpcRequestHandler = SingletonFactory.getInstance(RpcRequestHandler.class);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            if (msg instanceof RpcMessage) {
                log.info("server receive msg: [{}]", msg);
                byte messageType = ((RpcMessage) msg).getMessageType();
                RpcMessage rpcMessage = new RpcMessage();
                rpcMessage.setCodec(SerializationTypeEnum.PROTOSTUFF.getCode());
                rpcMessage.setCompress(CompressTypeEnum.GZIP.getCode());
                if (messageType == RpcConstants.HEARTBEAT_REQUEST_TYPE) {
                    rpcMessage.setMessageType(RpcConstants.HEARTBEAT_REQUEST_TYPE);
                    rpcMessage.setData(RpcConstants.PONG);
                } else {
                    RpcRequest rpcRequest = (RpcRequest) ((RpcMessage) msg).getData();
                    // Execute the target method (the method the client needs to execute) and return the method result.
                    Object result = rpcRequestHandler.handle(rpcRequest);
                    log.info(String.format("server get result: %S"), result.toString());
                    rpcMessage.setMessageType(RpcConstants.RESPONSE_TYPE);
                    if (ctx.channel().isActive() && ctx.channel().isWritable()) {
                        RpcResponse<Object> rpcResponse = RpcResponse.success(result, rpcRequest.getRequestId());
                        rpcMessage.setData(rpcResponse);
                    } else {
                        RpcResponse<Object> rpcResponse = RpcResponse.fail(RpcResponseCodeEnum.FAIL);
                        rpcMessage.setData(rpcResponse);
                        log.error("not writable now, message dropped");
                    }
                }
                ctx.writeAndFlush(rpcMessage).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            }
        } finally {
            // Ensure the ByteBuf is released, otherwise there may be memory leaks
            ReferenceCountUtil.release(msg);
        }
    }

}
