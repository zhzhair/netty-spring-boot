package com.example.demo.socket;

import com.example.demo.service.MsgHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * 服务端处理器
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<String> {
    /**
     * 日志
     */
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        log.info("接收请求开始：======= 接收报文：" + msg);
        String respMsg = new MsgHandler().parseMsg(msg);
        log.info("返回报文 ========== " + respMsg);
        ctx.writeAndFlush(respMsg + "\n");//这个地方必须加上"\n"，不然客户端接收不到消息(_^V^_)
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        log.info("收到客户端[ip:" + clientIp + "]连接");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 当出现异常就关闭连接
        ctx.close();
    }

}
