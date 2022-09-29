package com.wx.client.client;

import com.wx.bean.User;
import com.wx.client.clientCommand.LoginConsoleCommand;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Data
@Service("CommandClient")
public class CommandClient {

    private boolean connectFlag = false;
    private String sessionId;
    private User user;
    private ClientSession session;

    public void startCommandThread() {

        Thread.currentThread().setName("主线程");
        while (true) {

            while (!connectFlag) {
                // 执行连接命令
            }

            while (sessionId != null) {
                Scanner scanner = new Scanner(System.in);
//                scan
            }
        }

    }

    public void startLogin(LoginConsoleCommand command) {

        if (!isConnectFlag()) {
            System.out.println("登录异常");
        }

        User user = new User();
        user.setUid(command.getAccount());
        user.setToken(command.getPassword());
        user.setDevId("1111");
        this.user = user;
    }
}
