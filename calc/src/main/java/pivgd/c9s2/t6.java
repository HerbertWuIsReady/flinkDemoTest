package pivgd.c9s2;

import java.util.Stack;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-03 H O U R : 17:HOUR:25
 **/

public class t6 {
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

        t1.printAllNode(head);

        System.out.println("--->");

        boolean b = f2(head);
        System.out.println(b);

    }

    public static boolean  f1(Node head) {

        Node n1 = new Node();
        Node hCur = head.next;

        while (hCur != null) {
            Node t = new Node();
            t.data = hCur.data;
            t.next = n1.next;
            n1.next = t;
            hCur = hCur.next;
        }

        Node n1Cur = n1.next;
        hCur = head.next;

        while (hCur != null) {
            if (hCur.data != n1Cur.data) {
                return false;
            }

            hCur = hCur.next;
            n1Cur = n1Cur.next;
        }

        return true;
    }

    public static boolean f2(Node head) {

        Stack<Integer> s = new Stack<>();

        Node n1 = head;
        Node n2 = head;

        while (n1 != null && n1.next != null) {
            n1 = n1.next;
            n2 = n2.next;
            if (n1 != null) {
                n1 = n1.next;
                if (n1 != null) {
                    s.add(n2.data);
                }

            }

        }

        n2 = n2.next;
        while (n2 != null) {
           if(s.pop() != n2.data) {
               return false;
           }
           n2 = n2.next;
         }



        return true;
    }
}
