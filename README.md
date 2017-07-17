# NettyServer
基于Netty的server和client测试工程
客户端和服务端我写在一起


NettyEntrance-> 这个就是服务的入口 
NettyClient ->客户端的入口 
客户端没有写main方法 需要运行   

new NettyClient().sendMessage(message);

message就是你需要发送的消息，
如果需要做测试就在NettyClient.class中添加一个main方法
调用 new NettyClient().sendMessage(message);就可以了
