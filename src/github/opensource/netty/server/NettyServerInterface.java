package github.opensource.netty.server;
/**
 * Project :  ZhiQuManage.
 * Package name: github.benjamin.zhiqumanage
 * Created by :  Administrator.
 * Created time: 2017/7/13 16:33
 * Changed by :  Administrator.
 * Changed time: 2017/7/13 16:33
 * Class description:
 */

/**
 * 定义一个Netty服务端接受消息的接口
 */
public interface NettyServerInterface {

    //接收到消息
    String onReceivedMessage(String message);

    //接收到错误消息
    void onErrorMessage(String errorMsg);
}
