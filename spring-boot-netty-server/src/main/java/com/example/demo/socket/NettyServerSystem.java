package com.example.demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * netty服务端
 */
public class NettyServerSystem {

    private NettyServer nettyServer;

    private static NettyServerSystem nettyServerSystem = null;

    private NettyServerSystem() {
        nettyServer = new NettyServer();
    }

    //单利模式创建对象
    public static NettyServerSystem getSingleton() {
        if (nettyServerSystem == null) {
            nettyServerSystem = new NettyServerSystem();
        }
        return nettyServerSystem;
    }

    public void startNettyServer() {
        InputStream inputStream = this.getClass().getResourceAsStream("/cfg.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
//            properties.loadFromXML(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port = Integer.parseInt(properties.getProperty("netty.port"));
        nettyServer.start(port);
    }
}
