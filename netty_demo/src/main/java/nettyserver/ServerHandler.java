package nettyserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.LineBasedFrameDecoder;

/**
 * <p> 服务端处理器 </p>
 *
 * <p>
 *     问题：如果这个 server handler 前面还有一个 server handler，那么就跑不到这儿来，
 *     这是不是意味着只能有一个 server handler。
 *
 *     解决方案：netty 默认只调用第一个，如果需要调用下一个，需要使用 fire 的方法来调用。
 *
 *     问题：如果在第一个 channelAction 中调用 fireChannelActive 那么接下来是执行
 *     channelRead，还是下一个 channelAction。
 *
 *     解决方案：执行 channelAction
 * </p>
 *
 * @author zhixiang.yuan
 * @create 2018/08/17 18:21
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("first server handler channel active");
        ctx.fireChannelActive();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        System.out.println("server channelRead..");
        System.out.println(ctx.channel().remoteAddress() + "-> Server :" + msg.toString());
        ctx.write("server write" + msg);
        ctx.flush();
        ctx.fireChannelRead(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
