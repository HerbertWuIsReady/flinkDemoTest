package NioDemo;

import java.nio.IntBuffer;

public class Demo1 {
    public static void main(String[] args) {

        IntBuffer buffer = IntBuffer.allocate(20);

        buffer.put(1);
        buffer.put(2);
        buffer.put(3);
        buffer.put(4);
        buffer.put(5);

        System.out.println(buffer.get(1));
        buffer.flip();

        System.out.println("position=" + buffer.position());
        System.out.println("limit=" + buffer.limit());
        System.out.println("capatity=" + buffer.capacity());


        buffer.get();
        buffer.get();
        buffer.get();
        buffer.get();
        buffer.get();

        System.out.println("---------");
        System.out.println("position=" + buffer.position());
        System.out.println("limit=" + buffer.limit());
        System.out.println("capatity=" + buffer.capacity());

        buffer.rewind();
        System.out.println("---------");
        System.out.println("position=" + buffer.position());
        System.out.println("limit=" + buffer.limit());
        System.out.println("capatity=" + buffer.capacity());

        buffer.get();
        buffer.get();
        buffer.get();
        buffer.get();
        buffer.get();

        System.out.println("---------");
        System.out.println("position=" + buffer.position());
        System.out.println("limit=" + buffer.limit());
        System.out.println("capatity=" + buffer.capacity());

        buffer.clear();
//        buffer.compact();

        System.out.println("---------");
        System.out.println("position=" + buffer.position());
        System.out.println("limit=" + buffer.limit());
        System.out.println("capatity=" + buffer.capacity());

        buffer.put(1);
        buffer.put(2);
        buffer.put(3);
        buffer.put(4);
        buffer.put(5);

    }
}
