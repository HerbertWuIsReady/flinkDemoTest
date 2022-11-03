package pivgd.c9s2;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-03 H O U R : 14:HOUR:15
 **/

public class t2 {
    public static void main(String[] args) {

        final Index index = new Index();
//        f1(Node.getTestLinkList(), 1);
//        f2(Node.getTestLinkList(), 1);
//        final Node node = f3(Node.getTestLinkList(), 1, index);
//        t1.printAllNode(node);
        final Node node = f4(Node.getTestLinkList(), 10);
        t1.printAllNode(node);
    }

    public static void f1 (Node head , int k) {

        int counter = 0;
        Node n = head.next;
        while (n != null) {
            counter ++ ;
            n = n.next;
        }

        if (k > counter) {
            System.err.println("长度超过最大限制");
            return;
        }

        n = head.next;
        counter -= k;
        while(n != null && counter > 0) {
            counter--;
            n = n.next;
        }

        t1.printAllNode(n);
    }

    public static int f2 (Node head, int k) {
        int cur = 0;

        if (head != null) {
            cur = f2(head.next, k);
        } else {
            return 0;
        }

        if (cur + 1 == k) {
            System.out.println("-->" +head.data);
        }

        System.out.println(cur + 1 + "-->" + head.data);
        return cur + 1;
    }

    public static Node f3 (Node head, int k, Index index) {

        Node n = null;
        if (head.next != null) {
            n = f3(head.next, k, index);
        }

        index.index++;

        if (index.index == k) {
            return head;
        }


        return n ;
    }

    // 迭代法
    // 双指针方法
    public static Node f4 (Node head, int k) {

        Node n1 = head;
        Node n2 = head;

        while (n1 != null && k > 0) {
            k-- ;
            n1 = n1.next;
        }

        while (n1 != null) {
            n2 = n2.next;
            n1 = n1.next;
        }

        return n2;
    }

}

class Index{
    public int index;
}
