package org.example.nettydemo.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author redA
 * @时间: 2024年11月21日 下午1:33
 */
@Slf4j
@Configuration
public class NettyWebSocketServer {
//    设置ws服务器的监听端口
    public static final int WEB_SOCKET_PORT = 8090;
//    自定义处理器
 public static final NettyWebSocketServerHandler NETTY_WEB_SOCKET_SERVER_HANDLER = new NettyWebSocketServerHandler();
//    根据netty的线程池创建2个线程池（看原理就明白了）
    private EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    private EventLoopGroup workerGroup = new NioEventLoopGroup(NettyRuntime.availableProcessors());
//    初始化这个bean也就是启动spring容器的时候就使用run方法启动ws服务器，实现ws监听
    @PostConstruct
    public void start() throws InterruptedException {
        run();
    }
//    当这个bean要摧毁的时候就关闭ws服务器
    @PreDestroy
    public void destroy() {
        Future<?> future = bossGroup.shutdownGracefully();
        Future<?> future1 = workerGroup.shutdownGracefully();
        future.syncUninterruptibly();
        future1.syncUninterruptibly();
        log.info("关闭 ws server 成功");
    }
    public void run() throws InterruptedException {
// 服务器启动引导对象
         // 服务器启动引导对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)//设置通道的类型，NioServerSocketChannel是服务端类型的通道
                .option(ChannelOption.SO_BACKLOG, 128)//设置TCP连接队列的大小
                .option(ChannelOption.SO_KEEPALIVE, true)//设置tcp保活，实现长连接
                .handler(new LoggingHandler(LogLevel.INFO)) // 为 bossGroup 添加 日志处理器
//设置childHandler处理器，这个处理器是每个通道的请求都会调用的
                 .childHandler(new ChannelInitializer<SocketChannel>() {

                     @Override
                     protected void initChannel(SocketChannel socketChannel) throws Exception {
//      ChannelPipeline用来设置通道处理器的
                     ChannelPipeline pipeline = socketChannel.pipeline();
                      //30秒客户端没有向服务器发送心跳则关闭连接，参数1：读的空闲时间，参数2：写的空闲时间；参数3：全局的空闲时间
                        pipeline.addLast(new IdleStateHandler(30, 0, 0));
                        // 因为使用http协议，所以需要使用http的编码器，解码器
                        pipeline.addLast(new HttpServerCodec());
                        // 以块方式写，添加 chunkedWriter 处理器
                        pipeline.addLast(new ChunkedWriteHandler());
                        /**
                         * 说明：
                         *  1. http数据在传输过程中是分段的，HttpObjectAggregator可以把多个段聚合起来；
                         *  2. 这就是为什么当浏览器发送大量数据时，就会发出多次 http请求的原因
                         */
                        pipeline.addLast(new HttpObjectAggregator(8192));
//                         下面是将“/"这个路径下的http协议转换为webSocket协议
                        pipeline.addLast(new WebSocketServerProtocolHandler("/"));
                        // 自定义handler ，处理业务逻辑
                        pipeline.addLast((ChannelHandler) NETTY_WEB_SOCKET_SERVER_HANDLER);
                     }
                 });
         // 启动服务器，监听端口，阻塞直到启动成功;配合上面的bean初始化注解，在spring启动的时候ws服务器就开始监听了
        serverBootstrap.bind(WEB_SOCKET_PORT).sync();

    }
}