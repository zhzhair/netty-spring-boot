package com.example.demo.socket;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.Factory;
import com.example.demo.service.IBaseMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.util.StringUtils;

/**
 * 客户端处理器
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        if (!StringUtils.hasText(msg)) return;
        JSONObject.parseObject(msg);
        String transCode = JSONObject.parseObject(msg).getString("transCode");
        IBaseMsg iBaseMsg = Factory.getInstance(transCode);
        if (iBaseMsg != null) {
            iBaseMsg.setMsg(msg);
            System.out.println("客户端处理后返回的报文:" + iBaseMsg.createResp());
        }
    }
}
