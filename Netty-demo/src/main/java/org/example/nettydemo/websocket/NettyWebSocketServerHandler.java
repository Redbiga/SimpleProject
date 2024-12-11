package org.example.nettydemo.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author redA
 * @时间: 2024年11月21日 下午2:31
 */
//这里的泛型的意思表示要处理的消息的形式是TextWebSocketFrame
public class NettyWebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
//ChannelHandlerContext 可以将事件和消息从一个 ChannelHandler 传递给下一个 ChannelHandler，形成一个链条。例如，在数据处理过程中，ChannelHandlerContext 允许当前 ChannelHandler 将数据转发给下一个处理器。
// userEventTriggered 是 Netty 中 ChannelInboundHandler 接口的一个方法，用于处理 用户自定义事件
  @Override
    public  void  userEventTriggered(ChannelHandlerContext ctx, Object evt){
          if(evt instanceof WebSocketServerProtocolHandler.HandshakeComplete){
            System.out.println("握手成功");
        }
    //        这里的Idle是闲置的意思，当一个通道是空闲的时候，就触发 IdleStateHandler 事件
//        这里的空闲事件是在初始化IdleStateHandler传递参数控制
//        这里的意思是，当通告没有内容读的时候，空闲30秒，就会触发IdleStateHandler处理器，将IdleState设置为READER_IDLE
        else if (evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if(idleStateEvent.state()== IdleState.READER_IDLE){
//                根据配置，这里是建立websocket连接后，客户端30s内没有向后端（也就是这个连接的频道）发送信息（心跳或者内容）
//                就会触发IdleStateEvent事件，将IdleState设置为READER_IDLE，然后这里的if条件通过，执行if中的代码。
                System.out.println("读超时");
//                todo 用户下线
            }
        }

  }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

    }
}