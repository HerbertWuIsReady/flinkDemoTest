package pivgd.c9s2;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-03 H O U R : 15:HOUR:42
 **/

public class demo {

    public static void main(String[] args) {

        final Person person = new Person();
        person.name = "wuxuan";

        System.out.println(person);
        f1 (person);
        System.out.println(person);
    }

    public static void f1 (Person p) {
        p.name = "wuxuan1";
    }
}

class Person {
    public String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
