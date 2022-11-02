package jedis;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class jedis1 {

    public static void main(String[] args) throws IOException {
        Jedis localhost = new Jedis("localhost", 6379);

        localhost.set("a".getBytes(StandardCharsets.UTF_8),"b".getBytes(StandardCharsets.UTF_8));

        FileSystem fileSystem = FileSystem.get(new Configuration());

    }

}
