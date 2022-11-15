package pivgd.c9s5;


public class t3 {
    public static void main(String[] args) {

    //11011101111
        System.out.println(f1(1775));

    }
	
	public  static int f1(int num) {
		int last = 0;
		int cur = 0;
		int max = 0;
		int midZero = 0;
		int lastNum = 0;
		
		for (int i = 0 ; i < 32; i++) {
			// 1
			int temp = num & (1 << i);
			if (temp >= 1 && lastNum >= 1) {
				cur++;
				lastNum = temp;
			} else if (temp >= 1 && lastNum == 0) {
				if (midZero == 1 || midZero == 0) {
					max = max > (cur +  last) ? max : (cur +  last);
				}
				last = cur;
				cur = 0;
				cur ++;
				lastNum = temp;
				midZero = 0;
			} else if (temp == 0 && lastNum >= 1) {
				lastNum = temp;
				midZero ++ ;
			} else if (temp == 0 && lastNum == 0) {
				lastNum = temp;
				midZero ++ ;
			}
		}

        return max + 1;
	}
}
