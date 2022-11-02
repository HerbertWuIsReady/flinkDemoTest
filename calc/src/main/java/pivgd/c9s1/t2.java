package pivgd.c9s1;

import java.util.Arrays;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−10-25 H O U R : 15:HOUR:37
 **/

public class t2 {
    public static void main (String[] args) {

        System.out.println(f1("abcdefg", "abefgcd"));
        System.out.println(f1("lmppf", "lmpfp"));
        System.out.println(f1("God", "dog")); // false
        System.out.println(f1("", ""));
        System.out.println(f1("asdf", "asds")); // false
        System.out.println(f1("aabb ", " bbaa"));

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(f2("abcdefg", "abefgcd"));
        System.out.println(f2("lmppf", "lmpfp"));
        System.out.println(f2("God", "dog")); // false
        System.out.println(f2("", ""));
        System.out.println(f2("asdf", "asds")); // false
        System.out.println(f2("aabb ", " bbaa"));

    }

    public static boolean f1 (String s1, String s2) {
        if (s1.length() != s2.length()) { return false; }

        final char[] chars1 = s1.toCharArray();
        final char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < s1.length(); i++) {
            if(chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    // 采用hash的方式去做， 时间复杂度在o（s1+s2）
    public static boolean f2 (String s1, String s2) {
        int[] hash = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            hash[s1.charAt(i)] += 1;
        }

        for (int i = 0; i < s1.length(); i++) {
            hash[s2.charAt(i)] -= 1;
            if (hash[s2.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }
}
