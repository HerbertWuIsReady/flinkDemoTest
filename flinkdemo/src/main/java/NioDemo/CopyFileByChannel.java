package NioDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFileByChannel {
    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\Noch\\IdeaProjects\\flinkDemoTest\\flinkdemo\\src\\main\\java\\NioDemo\\CopyFileByChannel.java");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);

        File fileOut = new File("C:\\Users\\Noch\\IdeaProjects\\flinkDemoTest\\flinkdemo\\src\\main\\java\\NioDemo\\CopyFileByChannelCopy.java");
        FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
        FileChannel channelOut = fileOutputStream.getChannel();

        while ( channel.read(buf) != -1) {
            buf.flip();
            channelOut.write(buf);
            buf.clear();
        }


    }
}
