package pivgd.c9s2;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-03 H O U R : 17:HOUR:01
 **/

public class t3 {

    public static void main(String[] args) {
        final Node testLinkList = Node.getTestLinkList();

        Node head = testLinkList;
        head = head.next;
        head = head.next;
        head = head.next;
        t1.printAllNode(testLinkList);
        System.out.println("-->");
        f1(head);
        t1.printAllNode(testLinkList);
    }

    public static void f1 (Node head) {
        Node temp = head.next;
        head.data = temp.data;
        head.next = temp.next;
        temp.next = null ;
    }
}
