package NioDemo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientSocket {

    public static void main(String[] args) throws Exception {

        SocketChannel client = SocketChannel.open();

        client.configureBlocking(false);

        client.connect(new InetSocketAddress("localhost" , 9999));

        while (! client.finishConnect()) {

        }

        System.out.println("connection success !!!!");

        ByteBuffer buf = ByteBuffer.allocate(1024);

        int len = 0;
        while ( (len = client.read(buf) ) != -1) {

            buf.flip();

            String s = new String(buf.array());
            System.out.println(len + "--" + s);

            buf.clear();

            buf.put("hello".getBytes());

            buf.flip();

            client.write(buf);

            buf.clear();
            Thread.sleep(1000);

        }

        client.close();

    }

}
