# NettyServer
<a>基于Netty的server和client测试工程 </a>
<p>客户端和服务端我写在一起</p>

<h2>使用 </h2>
- <a>NettyEntrance -- 这个就是服务的入口 </a>
- <a>NettyClient-- 客户端的入口 </a>
客户端没有写main方法需要运行<pre><code> new NettyClient().sendMessage(message); </code></pre>
<h2>client 使用 </h2>
- message就是你需要发送的消息，
如果需要做测试就在<code>NettyClient.class</code>中添加一个main方法
调用 <pre><code> new NettyClient().sendMessage(message);</code>就可以了</pre>
