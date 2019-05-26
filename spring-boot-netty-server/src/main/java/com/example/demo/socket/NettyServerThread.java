package com.example.demo.socket;

public class NettyServerThread implements Runnable {

    @Override
    public void run() {
        NettyServerSystem.getSingleton().startNettyServer();
    }
}
