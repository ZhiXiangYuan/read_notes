package nettyserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <p> 服务端处理器 </p>
 *
 * @author zhixiang.yuan
 * @create 2018/08/17 18:21
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        System.out.println("server channelRead..");
        System.out.println(ctx.channel().remoteAddress() + "-> Server :" + msg.toString());
        ctx.write("server write" + msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
