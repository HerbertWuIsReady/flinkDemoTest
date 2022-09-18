package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyDiscardServer {

    public static void main(String[] args) throws Exception {

        int port = 9999;
        System.out.println("<><><><><><><>");

        ServerBootstrap server = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup work = new NioEventLoopGroup();

        server.group(boss, work);

        server.channel(NioServerSocketChannel.class);

        server.localAddress(port);

        server.option(ChannelOption.SO_KEEPALIVE, true);

        server.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

        server.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new NettyDiscardHandler());
            }
        });

        ChannelFuture sync = server.bind().sync();

        ChannelFuture channelFuture = sync.channel().closeFuture();

        channelFuture.sync();

    }
}

class NettyDiscardHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        while (in.isReadable()) {
            System.out.println( (char) in.readByte() );
        }
    }
}
