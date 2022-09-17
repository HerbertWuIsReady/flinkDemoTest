package NioDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class DisCard {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel ssc = ServerSocketChannel.open();

        ssc.configureBlocking(false);

        ssc.bind(new InetSocketAddress(9999));

        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();

                if (next.isAcceptable()) {
                    SocketChannel sc = ssc.accept();

                    sc.configureBlocking(false);

                    sc.register(selector, SelectionKey.OP_READ);
                    System.out.println( "get connnection" );
                } else  if (next.isReadable()) {
                    SocketChannel sc = (SocketChannel) next.channel();

                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    while (sc.read(buf) != -1) {

                        buf.flip();
                        String s = new String(buf.array());
                        System.out.println(s);
                        buf.clear();
                    }
                }

                iterator.remove();


            }
        }

        ssc.close();
        selector.close();



    }

}
