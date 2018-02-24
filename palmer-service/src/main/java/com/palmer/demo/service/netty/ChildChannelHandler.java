package com.palmer.demo.service.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/8/21, at 下午5:50
 * @Modified by:
 * @Description:
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {//SocketChannel建立连接后的管道
//      socketChannel.pipeline().addLast(new DiscardServerHandler());
        socketChannel.pipeline().addLast(new TimeServerHandler());

    }
}
