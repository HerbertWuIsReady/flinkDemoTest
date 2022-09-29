package com.wx.client.sender;


import com.wx.bean.MsgOuterClass;
import com.wx.bean.User;
import com.wx.client.client.ClientSession;

public class LoginSender extends BaseSender{

    public void sendLoginMsg () {

        if(isConnected()) {
            System.out.println("还没建立起链接");

        }

        System.out.println("构建登录消息");
        MsgOuterClass.Msg.Message message = buildLoginMsg(getUser(), getSession());
        System.out.println("发送登录消息");
        super.sendMsg(message);
    }

    public static MsgOuterClass.Msg.Message buildLoginMsg (User user, ClientSession session) {

        MsgOuterClass.Msg.LoginRequest.Builder builder = MsgOuterClass.Msg.LoginRequest.newBuilder();
        builder.setDeviceId(user.getDevId())
                .setPlatform("Windows98")
                .setToken(user.getToken())
                .setUid(user.getUid());

        MsgOuterClass.Msg.Message.Builder builderMsg = MsgOuterClass.Msg.Message.newBuilder();

        builderMsg.setLoginRequest(builder.build());

        return builderMsg.build();
    }


}
