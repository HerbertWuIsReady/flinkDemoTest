package pivgd.c9s3;

import java.util.*;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-08 H O U R : 14:HOUR:18
 **/

public class demo {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1000);

        Integer integer = list.get(0);
        integer--;

        list.set(0,100);
        System.out.println(list.get(0));
        System.out.println(integer);
    }
}
