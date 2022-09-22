package decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.MessageToByteEncoder;

public class Int2ByteEncode  extends MessageToByteEncoder<Integer> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Integer integer, ByteBuf byteBuf) throws Exception {
        byteBuf.writeInt(integer);
    }

    public static void main(String[] args) {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<>() {

            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {
                embeddedChannel.pipeline().addLast(new Int2ByteEncode());

            }
        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);
        for (int i = 1 ; i < 100 ; i++) {
            embeddedChannel.write(i);
        }

        embeddedChannel.flush();

        ByteBuf bf = (ByteBuf)embeddedChannel.readOutbound();

        while (bf != null) {
            System.out.println( bf.readInt() );
            bf = (ByteBuf)embeddedChannel.readOutbound();
        }


    }
}
