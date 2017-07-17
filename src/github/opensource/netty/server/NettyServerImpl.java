package github.opensource.netty.server;

import github.opensource.netty.client.NettyClient;

/**
 * Project :  ZhiQuManage.
 * Package name: github.benjamin.zhiqumanage
 * Created by :  Administrator.
 * Created time: 2017/7/13 16:40
 * Changed by :  Administrator.
 * Changed time: 2017/7/13 16:40
 * Class description:
 */

public class NettyServerImpl implements NettyServerInterface {

    @Override
    public String onReceivedMessage(String message) {
        System.out.println("接收到消息:" + message);
        String sendMsg = "服务端返回的数据" + message;
        System.out.println("待发送的消息:" + sendMsg);
        if (message.equals("nihao")) {
            new NettyClient().sendMessage(message);
        }
        return sendMsg;
    }

    @Override
    public void onErrorMessage(String errorMsg) {
        System.out.println("错误消息" + errorMsg);
    }
}
