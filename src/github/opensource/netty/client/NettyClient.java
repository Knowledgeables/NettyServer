package github.opensource.netty.client;

import java.net.InetSocketAddress;

import github.opensource.netty.app.ApplicationContext;
import github.opensource.netty.app.NettySimpleChannel;
import github.opensource.netty.server.NettyServerImpl;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

/**
 * Project :  NettyServer.
 * Package name: github.opensource.netty.client
 * Created by :  Administrator.
 * Created time: 2017/7/17 11:23
 * Changed by :  Administrator.
 * Changed time: 2017/7/17 11:23
 * Class description:
 */

public  class NettyClient {

    public void sendMessage(String message) {
        NettyServerImpl nettyServer = new NettyServerImpl();
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap boot = new Bootstrap();
        boot.group(group).channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST,true)
                .handler(new NettySimpleChannel(nettyServer));
        Channel channel = null;
        try {
            channel = boot.bind(0).sync().channel();
            channel.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer(message, CharsetUtil.UTF_8), new InetSocketAddress(ApplicationContext.clientSendToIp,ApplicationContext.clientPort))).sync();
            if(!channel.closeFuture().await(15000)){
                System.out.println("查询超时！");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
