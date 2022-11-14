package decoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.parquet.hadoop.ParquetInputFormat;
import scala.Byte;

import java.util.List;

public class Byte2IntegerDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        while ( byteBuf.readableBytes() > 4 ) {
            int i = byteBuf.readInt();
            list.add(i);
        }
    }

    public static void main(String[] args) {

//        SequenceFileInputFormat
//        ParquetInputFormat
        FileOutputFormat
        ChannelInitializer<EmbeddedChannel> channelInitializer = new ChannelInitializer<>() {
            @Override
            protected void initChannel(EmbeddedChannel embeddedChannel) throws Exception {

                embeddedChannel.pipeline().addLast(new Byte2IntegerDecoder());
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

