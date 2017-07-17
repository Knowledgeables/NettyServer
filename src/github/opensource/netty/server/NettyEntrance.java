package github.opensource.netty.server;

import github.opensource.netty.app.NettySimpleChannel;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;


/**
 * Project :  ZhiQuManage.
 * Package name: github.benjamin.zhiqumanage
 * Created by :  Administrator.
 * Created time: 2017/7/13 17:02
 * Changed by :  Administrator.
 * Changed time: 2017/7/13 17:02
 * Class description:
 */

class NettyEntrance {
    static NettyServerImpl nettyServer = null;

    public static void main(String[] args) {
        if (nettyServer == null) {
            nettyServer = new NettyServerImpl();

        }
        int port = 6008;
        try {
            new NettyEntrance().run(port);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错误日志打印" + e.getMessage());
        }
    }

    private void run(int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap trap = new Bootstrap();
        //由于我们用的是UDP协议，所以要用NioDatagramChannel来创建
        trap.group(group).channel(NioDatagramChannel.class)//由于我们用的是UDP协议，所以要用NioDatagramChannel来创建
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new NettySimpleChannel(nettyServer));//设置支持广播
        trap.bind(port).sync().channel().closeFuture().await();
    }
}
