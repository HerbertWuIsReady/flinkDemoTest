package com.wx.codec;

import com.wx.bean.MsgOuterClass;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ProtoBufDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {

        in.markReaderIndex();

        if (in.readableBytes() < 2 ) {
            return;
        }

        short length = in.readShort();

        if (in.readableBytes() < length) {
            in.resetReaderIndex();
            return;
        }

        byte[] bytes;
        if (in.hasArray()) {
            ByteBuf slice = in.slice();
            bytes = slice.array();
        } else {
            bytes = new byte[length];
            in.readBytes(bytes, 0, length);
        }

        MsgOuterClass.Msg msg = MsgOuterClass.Msg.parseFrom(bytes);

        out.add(msg);
    }
}
