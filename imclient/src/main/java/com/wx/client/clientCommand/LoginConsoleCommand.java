package com.wx.client.clientCommand;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Data
@Service("LoginConsoleCommand")
public class LoginConsoleCommand implements BaseCommand{

    public static final String KEY = "1";

    private String account;
    private String password;

    @Override
    public void exec(Scanner scanner) {
        System.out.println("请输入账号");
        account = scanner.next();
        System.out.println("请输入密码");
        password = scanner.next();
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String getTip() {
        return "登录";
    }
}
