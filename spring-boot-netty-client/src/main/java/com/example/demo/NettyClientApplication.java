package com.example.demo;

import com.example.demo.socket.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

/**
 * netty客户端
 */
@SpringBootApplication
public class NettyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyClientApplication.class, args);
        String serialNo = UUID.randomUUID().toString().replace("-", "");
        // 发送json字符串
        String msg1 = "{\"serialNo\":\"" + serialNo + "\",\"transCode\":\"TransCode1\",\"data\":{\"areaType\":\"0\",\"orgId\":\"0001\",\"userId\":\"1\"}}\n";
        String msg2 = "{\"serialNo\":\"" + serialNo + "\",\"transCode\":\"TransCode2\",\"data\":{\"areaType\":\"0\",\"orgId\":\"0001\",\"userId\":\"1\",\"oldPassword\":\"123456\",\"newPassword\":\"abcdef\"}}\n";
        String host = "127.0.0.1";
        int port = 8088;
        NettyClient nettyClient = new NettyClient(host, port);
//        nettyClient.connect(msg1);
        nettyClient.connect(msg2);
    }
}
