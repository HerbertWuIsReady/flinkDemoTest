package decoder;

import akka.util.Switch;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.ReplayingDecoder;
import org.apache.flink.api.java.functions.SampleWithFraction;

import java.util.List;

public class Byte2IntReplayDecode extends ReplayingDecoder<Status> {


    private int one;
    private int two;

    public Byte2IntReplayDecode () {
        super(Status.PARSE_1);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        switch (state()) {
            case PARSE_1:
                one = byteBuf.readInt();
                this.checkpoint(Status.PARSE_2);
                break;
            case PARSE_2:
                two = byteBuf.readInt() + one ;
                list.add(two);
                this.checkpoint(Status.PARSE_1);
                break;
            default:
        }
    }

    public static void main(String[] args) {

        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {

                embeddedChannel.pipeline().addLast(new Byte2IntReplayDecode());
                embeddedChannel.pipeline().addLast(new InProcess());
            }

        };

        EmbeddedChannel embeddedChannel = new EmbeddedChannel(channelInitializer);

        for (int i = 0 ; i <= 100 ; i++) {
            ByteBuf buffer = Unpooled.buffer();
            buffer.writeInt(i);
            embeddedChannel.writeInbound(buffer);
        }

    }
}

class  InProcess extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        int a = (int) msg;

        System.out.println(a);
        //ctx.fireChannelRead(msg);
    }

}

enum Status {
    PARSE_1, PARSE_2
}
