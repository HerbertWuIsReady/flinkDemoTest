package pivgd.c9s2;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-03 H O U R : 17:HOUR:25
 **/

public class t5 {

//    NullPointerException
    public static void main(String[] args) {
        final Node n1 = new Node();
        final Node n2 = new Node();
        final Node n3 = new Node();

        n1.data = 6;
        n2.data = 6;
        n3.data = 2;


        n1.next = n2;
        n2.next = n3;

        final Node n11 = new Node();
        final Node n21 = new Node();
        final Node n31 = new Node();

        n11.data = 6;
        n21.data = 6;
        n31.data = 2;

        n11.next = n21;
        n21.next = n31;

        Node h1 = new Node();
        Node h2 = new Node();

        h1.next = n1;
        h2.next = n11;

        System.out.println("--->");
        t1.printAllNode(h1);
        System.out.println("--->");
        t1.printAllNode(h2);
        System.out.println("--->");
        final Node node = f2(h1, h2);
        t1.printAllNode(node);
    }

    public static Node f1 (Node n1, Node n2) {
        Node res = new Node();

        Node resCur = res;

        Node n1Cur = n1.next;
        Node n2Cur = n2.next;
        int flag = 0;

        while (n1Cur != null || n2Cur != null) {
            resCur.next = new Node();
            resCur = resCur.next;
            if (n1Cur != null && n2Cur != null) {
                resCur.data = (n1Cur.data + n2Cur.data + flag) % 10;
                flag = (n1Cur.data + n2Cur.data + flag) / 10;
                n1Cur = n1Cur.next;
                n2Cur = n2Cur.next;
            } else if (n1Cur != null && n2Cur == null) {
                resCur.data = (n1Cur.data + flag) % 10;
                flag = (n1Cur.data + flag) / 10;
                n1Cur = n1Cur.next;
            } else if (n1Cur == null && n2Cur != null) {
                resCur.data = (n2Cur.data + flag) % 10;
                flag = (n2Cur.data + flag) / 10;
                n2Cur = n2Cur.next;
            }

        }

        if (flag > 0) {
            resCur.next = new Node();
            resCur = resCur.next;
            resCur.data = flag;
        }

        return res;
    }

    public static Node f2 (Node n1, Node n2) {
        Node res = new Node();

        Node resCur = res;

        Node n1Cur = n1.next;
        Node n2Cur = n2.next;

        int flag = 0;

        while (n1Cur != null || n2Cur != null) {
            Node temp = new Node();
            temp.next = resCur.next;
            resCur.next = temp;
            if (n1Cur != null && n2Cur != null) {
                temp.data = n1Cur.data + n2Cur.data;
                n1Cur = n1Cur.next;
                n2Cur = n2Cur.next;
            } else if (n1Cur != null && n2Cur == null) {
                temp.data = n1Cur.data ;
                n1Cur = n1Cur.next;
            } else if (n1Cur == null && n2Cur != null) {
                temp.data = n2Cur.data ;
                n2Cur = n2Cur.next;
            }
        }

        resCur = res.next;
        while (resCur != null) {
            int temp = resCur.data;
            resCur.data = (flag + resCur.data) % 10;
            flag = (flag + temp) / 10;
            resCur = resCur.next;
        }

//        if (flag > 0) {
//            resCur = new Node();
//            resCur.data = flag;
//        }

        Node last = res.next;
        resCur = last.next;
        Node after= resCur.next;
        last.next = null ;

        while (resCur != null) {
            resCur.next = last;
            last = resCur;
            resCur = after;
            if (resCur != null) {
                after = after.next;
            }
        }

        res.next = last;

        resCur = new Node();
        resCur.data = flag;

        resCur.next = res.next;

        res.next = resCur;
        return res;
    }


}
