package nettyserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * <p> netty 服务端配置类 </p>
 *
 * @author zhixiang.yuan
 * @create 2018/08/17 18:29
 */
public class NettyConfig {

    private int port;

    public NettyConfig(int port){
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new NettyConfig(port).start();
    }

    public void start(){
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap().group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            /** 下面这个类实现心跳机制，参数分别为：读超时时间、写超时时间、所有类型超时时间、时间单位 */
//                            ch.pipeline().addLast(new IdleStateHandler(5,0,0, TimeUnit.SECONDS));
                            /** 下面这个类不太懂 */
//                            ch.pipeline().addLast(new LineBasedFrameDecoder(2048));
                            /** 下面这个类按字节长度解析，少于 2048 则粘包，多于 2048 则切包 */
//                            ch.pipeline().addLast(new FixedLengthFrameDecoder(2048));
                            /** 下面这个类按照 $$__ 进行切包*/
//                            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,
//                                    Unpooled.copiedBuffer("$$__".getBytes())));
                            ch.pipeline().addLast("decoder", new StringDecoder());
                            ch.pipeline().addLast("encoder", new StringEncoder());
                            ch.pipeline().addLast(new ServerHandler());
                            ch.pipeline().addLast(new SimpleServerHandler());
                        }

                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // 绑定端口，开始接收进来的连接
            ChannelFuture future = bootstrap.bind(port).sync();
            System.out.println("Server start listen at " + port );
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
