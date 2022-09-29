package com.wx.codec;

import com.wx.bean.MsgOuterClass;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ProtoBufEncoder extends MessageToByteEncoder<MsgOuterClass.Msg> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MsgOuterClass.Msg msg, ByteBuf byteBuf) throws Exception {
        byte[] bytes = msg.toByteArray();

        byteBuf.writeShort(bytes.length);

        byteBuf.writeBytes(bytes);
    }
}
