package pivgd.c9s1;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−10-26 H O U R : 19:HOUR:15
 **/

public class t7 {
    public static void main(String[] args) {
//
//        int[][] arrays = {{1,2},{3,4}};
//        f1(arrays);


        int[][] arrays2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        f1(arrays2);
    }

    public static int[][] f1(int[][] arrays) {

        System.out.println(arrays.length);
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                System.out.print(arrays[i][j] + "\t");   // '\t' 相当于整数相加
            }
            System.out.println();
        }

        System.out.println(">>>>>");
        int length = arrays.length + 1 ;

        for (int i = 0; i < length / 2; i++) {

            for (int j = i; j < length / 2; j++) {
                int index = length - 2;
                int temp1 = arrays[j][index - i];
                arrays[j][index - i] = arrays[i][j];
                int temp2 = arrays[index - i][index - j];
                arrays[index - i][index - j] = temp1;
                temp1 = arrays[index - j][i];
                arrays[index - j][i] = temp2;
                arrays[i][j] = temp1;
            }

        }

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                System.out.print(arrays[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(">>>>>");
        return arrays;
    }
}
