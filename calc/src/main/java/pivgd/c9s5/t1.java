package pivgd.c9s5;

public class t1 {
    public static void main(String[] args){

        f1(0xffffffff,6, 2, 0x13);
    }
	
	
	public static void f1(int n, int j, int i, int m) {

        final byte b = new Integer(n).byteValue();
        final byte c = new Integer(m).byteValue();

        final int i1 = m << i;
        final int i2 = (1 << (j+1)) - 1;

        int k1 = ((m << i) & ((1 << j+1) - 1));
        int k2 = (n & ~ ( (1 << (j - i + 1) - 1 ) << i));

        final int i3 = m << i;
        final int i4 = (1 << j) - 1;
        final int i5 = n & ~((1 << (j - i + 1) - 1) << i);
        final int i6 = j - i + 1;
        final int i7 = (1 << (j - i + 2)) - 1;
        final int i8 = ((1 << (j - i + 2)) - 1) << i;
        final int i9 = ~(((1 << (j - i + 2)) - 1) << i);
        final int i10 = n & ~(((1 << (j - i + 2)) - 1) << i);


        int k = ((m << i) & ((1 << (j+1)) - 1)) | (n & ~ ( ((1 << (j - i + 2)) - 1 ) << i));
        final byte d = new Integer(k).byteValue();

        System.out.println(d);
	}
}
