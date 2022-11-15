package pivgd.c9s5;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-08 H O U R : 20:HOUR:34
 **/

public class demo {
    public static void main(String[] args) {
        System.out.println(1 ^ 0);

        // 10.331304301568412  按照0.048
        // 11.851486948743885  按照0.03
        double li = 1.03;
        double li5 = Math.pow(li, 5);

        double d9 = 3.0 / li;

        double d8 = (d9 + 3) / li;

        double d7 = (d8 + 3) / li;

        double d6 = (d7 + 3) / li;

        double d5 = (d6 + 3) / li;

        double a = d5 / li5;

        System.out.println(a);

        System.out.println(0 & 0);

        System.out.println(76 & 127);
    }


}
