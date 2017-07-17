package github.opensource.netty.app;

import github.opensource.netty.server.NettyServerInterface;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

/**
 * Project :  ZhiQuManage.
 * Package name: github.benjamin.zhiqumanage
 * Created by :  Administrator.
 * Created time: 2017/7/13 16:46
 * Changed by :  Administrator.
 * Changed time: 2017/7/13 16:46
 * Class description:
 */

  public class NettySimpleChannel extends SimpleChannelInboundHandler<DatagramPacket> {
    NettyServerInterface serverInterface;

    public NettySimpleChannel(NettyServerInterface server) {
        this.serverInterface = server;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String receivedMsg = msg.content().toString(CharsetUtil.UTF_8);//通过content获取消息内容
        String sendMsg = serverInterface.onReceivedMessage(receivedMsg);
        ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer(sendMsg, CharsetUtil.UTF_8), msg.sender()));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
        cause.printStackTrace();
        serverInterface.onErrorMessage(cause.getMessage().toString());
    }
}
