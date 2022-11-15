package pivgd.c9s5;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-10 H O U R : 13:HOUR:51
 **/

public class t6 {
    public static void main(String[] args) {

        System.out.println(f1(29 ,15));
        f1(29 ,15);
    }
	
	public static int f1(int m, int n) {

		int count = 0;
		for(int i = m ^ n; i != 0; i >>>= 1 ) {
			if((i & 1) >= 1) {
				count ++;
			}
		}
		return count;
	}
}
