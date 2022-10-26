package pivgd.c9s1;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−10-25 H O U R : 15:HOUR:53
 **/

public class demo {
    public static void main(String[] args) {

//        System.out.println("abcd".getBytes().length);
        final byte[] bytes = "abcd吴轩".getBytes(StandardCharsets.UTF_8);
        final byte[] bytes1 = "abcd".getBytes(StandardCharsets.UTF_8);
        final byte[] bytes2 = "abcd".getBytes(StandardCharsets.UTF_16);
        final char[] chars = "abcd吴轩".toCharArray();
        System.out.println("abcd");
        System.out.println(Charset.defaultCharset());
        System.out.println("abcd".getBytes(StandardCharsets.UTF_16));
        System.out.println("abcd".getBytes());

        System.out.println(1 << 2);
    }
}