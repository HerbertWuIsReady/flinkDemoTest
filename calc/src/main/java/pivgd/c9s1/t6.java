package pivgd.c9s1;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−10-26 H O U R : 16:HOUR:09
 **/

public class t6 {
    public static void main(String[] args) {

        System.out.println(f1("abcdefg"));
        System.out.println(f1("abcdefggggg"));
        System.out.println(f1("aaaaaaaaaaaaabcdefggggg"));
        System.out.println(f1("absdasdasdasdasdsadasdsadasdsacdefggggg"));
    }

    public static String f1(String str) {
       StringBuilder res = new StringBuilder();

       char last = 0;
       int counter = 0;

       for (int i = 0; i < str.length(); i++) {
           if (last != 0 && last != str.charAt(i)) {
               res.append(last);
               res.append(counter);
               counter = 1;
               last = str.charAt(i);
           } else {
               last = str.charAt(i);
               counter++;
           }
       }

        return res.toString().length() >= str.length() ? str : res.toString();
    }
}
