# netty-spring-boot
spring boot2.1.4集成netty服务端和客户端。

项目启动说明：服务端--spring-boot-netty-server，客户端--spring-boot-netty-client，先启动服务端的启动类，再启动客户端的启动类，从控制台能看到已完成从客户端发起请求--服务端处理请求并返回数据--客户端接收到数据并做后续处理的过程

项目描述：项目对架构做了封装，服务端每次只需要到msg.xml配置请求码和处理类（处理类都放在service文件夹下），就可以实现一次调用需要的功能。客户端也是java写的，但是不推荐java写客户端（我只会Java，方便测试^_^），客户端对应请求码和相应的处理类是在Factory类
