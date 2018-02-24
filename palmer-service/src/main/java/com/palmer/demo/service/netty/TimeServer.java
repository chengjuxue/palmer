package com.palmer.demo.service.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/8/19, at 下午5:10
 * @Modified by:
 * @Description:{netty编程实现时间服务器}
 */
public class TimeServer {

    public void bind(int port) throws Exception{
        //配置服务器端的NIO线程组boss和worker
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)//设置TCP缓冲区
                    .childHandler(new ChildChannelHandler());
            //绑定端口，同步等待成功
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            //等待服务器端接口关闭
            channelFuture.channel().closeFuture();
        } finally {
            //优雅退出，释放线程池资源
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception{
        int port = 8000;
        if(args != null && args.length>0){
            port = Integer.valueOf(args[0]);
        }
        new TimeServer().bind(port);
    }
}
