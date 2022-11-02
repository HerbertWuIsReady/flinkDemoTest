package pivgd.c9s1;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−10-25 H O U R : 17:HOUR:33
 **/

public class t3 {
    public static void main (String[] args) {

        String s1 = "a b s d            ";
        f1(s1.toCharArray(), s1.trim().length());

        s1 = "a dsab s d            ";
        f1(s1.toCharArray(), s1.trim().length());

        s1 = "a bdasd s d            ";
        f1(s1.toCharArray(), s1.trim().length());

        s1 = "a b sdsad d            ";
        f1(s1.toCharArray(), s1.trim().length());

        s1 = "assbasssssd            ";
        f1(s1.toCharArray(), s1.trim().length());
    }

    public static void f1 (char[] chars, int length) {

        int count = 0;

        for(int i = 0; i < length; i++){
            if (chars[i] == ' ') {
                count++;
            }
        }

        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                chars[i + count * 2] = chars[i];
            } else {
                chars[i + count * 2] = '0';
                chars[i + count * 2 - 1] = '2';
                chars[i + count * 2 - 2] = '%';
                count--;
            }
        }

        System.out.println(chars);
    }
}
