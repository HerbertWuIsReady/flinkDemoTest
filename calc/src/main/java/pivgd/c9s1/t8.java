package pivgd.c9s1;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−10-26 H O U R : 20:HOUR:21
 **/

public class t8 {
    public static void main (String[] args) {
        int[][] arrays2 = {{1, 2, 3}, {4, 5, 6}, {7, 0, 9}, {10, 11, 12}};

//        System.out.println(arrays2.length);
        f1(arrays2);
    }

    public static void f1(int[][] arrays) {

        boolean[] row = new boolean[arrays.length];
        boolean[] line = new boolean[arrays[0].length];

        for (int i = 0; i < row.length; i++)  {
            for (int j = 0; j < line.length; j++) {
                if (arrays[i][j] == 0) {
                    row[i] = true;
                    line[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if(row[i]) {
                for (int j = 0; j < line.length; j++) {
                    arrays[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < line.length; j++) {
            if(line[j]) {
                for (int i = 0; i < row.length; i++) {
                    arrays[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[0].length; j++) {
                System.out.print(arrays[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
