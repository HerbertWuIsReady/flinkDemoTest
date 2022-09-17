package NioDemo;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocket {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel server = ServerSocketChannel.open();

        server.configureBlocking(false);

        server.socket().bind(new InetSocketAddress("localhost", 8080));

        server.configureBlocking(false);

        SocketChannel socketChannel = server.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while ( socketChannel.read(buf) != -1 ) {

            System.out.println(buf.toString());

            buf.clear();

            buf.put("welcome".getBytes());

            buf.flip();

            socketChannel.write(buf);

            buf.clear();
        }

        server.close();



    }
}
