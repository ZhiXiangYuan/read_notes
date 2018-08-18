package nettyserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * <p> 继承自 SimpleChannelInboundHandler 实现 server handler </p>
 *
 *
 * @author zhixiang.yuan
 * @create 2018/08/18 10:43
 */
public class SimpleServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("second server handler channel active");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("Client channelRead0 received:" + msg);
    }
}
