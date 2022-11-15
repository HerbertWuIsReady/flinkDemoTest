package pivgd.c9s5;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-09 H O U R : 20:HOUR:34
 **/

public class t2 {

    public static void main(String[] args) {
		System.out.println(0.0 == 0.0);
        f1(0.125);
		System.out.println( f1(0.125));
		System.out.println( f1(0.25));
		System.out.println( f1(0.5));
		System.out.println( f1(0.75));
    }
	
	public static String f1(double d)  {
		
		StringBuilder sb =  new StringBuilder();
		
		while (d != 0.0) {
			double temp = d * 2;
			
			if (temp >= 1) {
				sb.append(1);
				d = temp - 1;
			} else {
				sb.append(0);
				d = temp;
			}
			
			if (sb.length() >= 32 ) {
				return "ERROR";
			}

		} 
		
		return sb.toString();
		
		
	}
}
