package pivgd.c9s5;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-10 H O U R : 15:HOUR:54
 **/

public class t7 {
    //5.7 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也
    //就是说，位0 与位1 交换，位2 与位3 交换，以此类推）。
    public static void main(String[] args) {

        System.out.println(f1(100));
    }

    public static int f1(int num) {

        return ( (num & 0xaaaaaaaa) >>> 1 ) | ( (num & 0x55555555) << 1 );
    }
}
