package pivgd.c9s1;

import java.util.Arrays;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−10-25 H O U R : 15:HOUR:25
 **/

public class t1 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(f1("abcdefd")); //false
        System.out.println(f1("abcfd")); // true
        System.out.println(f1("abcdef")); // true
        System.out.println(f1("defd")); //false

        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        System.out.println(System.currentTimeMillis());
        System.out.println(f2("abcdefd")); //false
        System.out.println(f2("abcfd")); // true
        System.out.println(f2("abcdef")); // true
        System.out.println(f2("defd")); //false

        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        System.out.println(System.currentTimeMillis());
        System.out.println(f3("abcdefd")); //false
        System.out.println(f3("abcfd")); // true
        System.out.println(f3("abcdef")); // true
        System.out.println(f3("defd")); //false

        System.out.println(System.currentTimeMillis());
    }

    // 数组方法
    public static boolean f1 (String s) {
        boolean[] a = new boolean[128];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (a[c]) {return false;}
            a[c] = true;
        }
        return true;
    }

    // 使用位来做,假设只有小写a-z,如果包含128个字符，则需要扩展上面的数组,更节省内存
    public static boolean f2 (String s) {
        int checker = 0;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if ( ( checker & (1 << c) ) > 0 ) {
                return false;
            }
            checker |= 1 << c;
        }

        return true;
    }

    public static boolean f3 (String s) {
        final char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] == chars[i-1]) {
                return false;
            }
        }
        return true;
    }
}

