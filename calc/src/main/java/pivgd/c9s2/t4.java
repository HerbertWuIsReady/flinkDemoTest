package pivgd.c9s2;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-03 H O U R : 17:HOUR:07
 **/

public class t4 {
    public static void main(String[] args) {
        final Node node = f1(Node.getTestLinkList(), 0);
        t1.printAllNode(node);
    }

    public static Node f1 (Node head, int x) {
        Node small = new Node();
        Node big = new Node();

        Node smallCur = small;
        Node bigCur = big;

        Node cur = head.next;

        while (cur != null) {

            if (cur.data < x) {
                smallCur.next = cur;
                smallCur = cur;
            } else {
                bigCur.next = cur;
                bigCur = cur;
            }

            cur = cur.next;
        }

        smallCur.next = big.next;

        bigCur.next = null;

        return small;
    }
}
