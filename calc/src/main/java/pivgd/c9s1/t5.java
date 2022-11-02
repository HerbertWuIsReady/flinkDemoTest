package pivgd.c9s1;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−10-26 H O U R : 11:HOUR:18
 **/

public class t5 {
    public static void main (String[] args) {

        //pale, ple -> true
        //pales, pale -> true
        //pale, bale -> true
        //pale, bake -> false
        System.out.println(f1("pale", "ple"));
        System.out.println(f1("pales", "pale"));
        System.out.println(f1("pale", "bale"));
        System.out.println(f1("pale", "bake"));
        System.out.println(f1("", ""));
        System.out.println(f1("", ""));
        System.out.println(f1("", ""));
        System.out.println(f1("", ""));
    }

    public static boolean f1 (String s1, String s2) {
        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int subLength = s1.length() - s2.length();

        if (subLength > 1) {
            return false;
        }

        boolean flag = false;
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && subLength == 0) {
                if (flag) { return false; }
                flag = true;
            } else if (flag && subLength >= 1 && s1.charAt(i + 1) != s2.charAt(i) ) {
                if (flag) {return false;}
                flag = true;
            } else if (!flag && s1.charAt(i) != s2.charAt(i) && subLength >= 1 ) {
                flag = true;
            }
        }

        return true;

    }
}


