package pivgd.c9s1;

import java.util.HashMap;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−10-25 H O U R : 19:HOUR:37
 **/

public class t4 {
    public static void main (String args[]) {

        System.out.println(f1("Tact Coa"));
        System.out.println(f1("bcTact Coa")); //false
        System.out.println(f1("bbTact Coa"));
        System.out.println(f1("Tacect Coa")); //false
        System.out.println(f1("Tllact Coa"));
    }

    public static boolean f1 (String str) {

        str = str.toLowerCase();
        final HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            boolean flag = isChar(c);
            if(flag && map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else if (flag) {
                map.put(c, 1);
            }
        }
        int odd = 0;
        for(int v : map.values()) {
            if (v % 2 != 0) {
                odd ++ ;
            }
            if (odd > 1) {return false;}
        }

        return true;
    }


    public static boolean isChar (char c) {
        return c >= 'a' && c <= 'z' ? true : false;
    }
}
