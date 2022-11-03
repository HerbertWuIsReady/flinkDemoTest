package pivgd.c9s2;

import java.util.HashSet;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-03 H O U R : 17:HOUR:25
 **/

public class t7 {

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
        n6.data = 4;
        n7.data = 3;
        n8.data = 2;
        n9.data = 3;
        n10.data = 3;

        n1.next = n2;
        n2.next = n7;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        Node head = new Node();
        head.next = n1;

        t1.printAllNode(head);

        System.out.println("--->");

        boolean b = f1(n3, n1);
        Node d = f2(n3, n1);
        t1.printAllNode(d);


    }


    public static boolean f1 (Node head1, Node head2) {
        HashSet<Integer> hashSet = new HashSet<>();

        Node n1c = head1.next;
        Node n2c = head2.next;
        while (n1c.next != null) {
            n1c = n1c.next;
        }

        while (n2c.next != null) {
            n2c = n2c.next;
        }

        return n2c == n1c ? true : false;
    }

    public static Node f2 (Node head1, Node head2) {

        HashSet<Integer> hashSet = new HashSet<>();

        Node n1c = head1.next;
        Node n2c = head2.next;

        while (n1c != null) {
            hashSet.add(n1c.hashCode());
            n1c = n1c.next;
        }

        while (n2c.next != null) {
            if( hashSet.contains(n2c.hashCode()) ) {
                return n2c;
            }
            n2c = n2c.next;
        }


        return null ;
    }
}
