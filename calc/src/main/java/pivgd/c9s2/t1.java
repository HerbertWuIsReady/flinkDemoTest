package pivgd.c9s2;

import java.util.HashSet;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-02 H O U R : 16:HOUR:22
 **/

public class t1 {

    public static void main(String[] args) {

        final Node n1 = new Node();
        final Node n2 = new Node();
        final Node n3 = new Node();
        final Node n4 = new Node();
        final Node n5 = new Node();
        final Node n6 = new Node();
        final Node n7 = new Node();
        final Node n8 = new Node();
        final Node n9 = new Node();
        final Node n10 = new Node();
        n1.data = 1;
        n2.data = 3;
        n3.data = 2;
        n4.data = 3;
        n5.data = 4;
        n6.data = 5;
        n7.data = 1;
        n8.data = 1;
        n9.data = 1;
        n10.data = 1;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        Node head = new Node();
        head.next = n1;

        printAllNode(head);

        System.out.println("--->");

        f2(head);
    }

    // f1
    public static void f1 (Node head) {
        HashSet<Integer> temp = new HashSet<Integer>();

        Node cur = head.next;
        Node n = new Node ();
        Node nw = n;

        while(cur != null) {
            if (!temp.contains(cur.data)) {
                nw.next = cur;
                temp.add(cur.data);
                cur = cur.next;
                nw = nw.next ;
                nw.next = null;
            } else {
                cur = cur.next;
            }

        }

        printAllNode(n);
    }

    // 只能达到n2的时间复杂度
    public static void f2 (Node head) {
<<<<<<< HEAD
=======
        HashSet<Integer> temp = new HashSet<Integer>();
>>>>>>> 46ffba67e81a6f6f2ac33dd12fb127129e6121f7

        Node cur1 = head.next;
        Node n = new Node ();
        Node nw = n;
        Node last = n;
        boolean flag = false;

        while (cur1 != null) {

            while (nw != null && nw.data != cur1.data) {
                    nw = nw.next;
            }

            if (nw == null || nw.data != cur1.data) {
                nw = new Node();
                nw.data = cur1.data;
                last.next = nw;
                last = nw;

            }
            nw = n ;
            cur1 = cur1.next;
        }

        printAllNode(n);
    }

    public static void printAllNode(Node head) {
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }

}
