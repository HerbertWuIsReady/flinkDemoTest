package pivgd.c9s2;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-02 H O U R : 20:HOUR:22
 **/

public class Node {
    public Node next;
    public int data;

    @Override
    public String toString() {
        return  "data=" + data;
    }

    public static Node getTestLinkList(){
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
        n10.data = 11;

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

        return head;
    }
}
