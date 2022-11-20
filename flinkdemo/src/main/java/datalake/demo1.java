package datalake;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.core.fs.Path;
import org.apache.flink.runtime.state.filesystem.FsStateBackend;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink;
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.table.types.logical.BigIntType;
import org.apache.flink.table.types.logical.RowType;
import org.apache.flink.util.Collector;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @program: flinkDemoTest
 * @description:
 * @author: wuxuan1@xiaomi.com
 * @create: Y E A R − 2022-YEAR−11-15 H O U R : 13:HOUR:29
 **/

public class demo1 {
    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();


        env.setParallelism(1);
        env.enableCheckpointing(1000);
        env.setStateBackend(new FsStateBackend("file:///C:\\Users\\Noch\\Downloads\\flinkDemoTest\\aabbcc"));
        ArrayList<RowType.RowField> rowFields = new ArrayList<>();
        rowFields.add(new RowType.RowField("id" ,new BigIntType()));

        RowType rowType = new RowType(true, rowFields);

        DataStreamSource<String> source = env.socketTextStream("localhost", 9999);
        final SingleOutputStreamOperator<String> process = source.setParallelism(1).map(
                        new MapFunction<String, Long>() {

                            @Override
                            public Long map(String s) throws Exception {
                                return Long.valueOf(s);
                            }
                        }
                ).assignTimestampsAndWatermarks(new BoundedOutOfOrdernessTimestampExtractor<Long>(Time.milliseconds(1)) {
                    @Override
                    public long extractTimestamp(Long element) {
                        return element;
                    }
                })
                .keyBy(new KeySelector<Long, Long>() {
                    @Override
                    public Long getKey(Long aLong) throws Exception {
                        return aLong;
                    }
                }).window(SlidingEventTimeWindows.of(Time.milliseconds(10), Time.milliseconds(10)))
                .process(new ProcessWindowFunction<Long, String, Long, TimeWindow>() {
                    @Override
                    public void process(Long aLong, ProcessWindowFunction<Long, String, Long, TimeWindow>.Context context, Iterable<Long> elements, Collector<String> out) throws Exception {
                        long count = 0;
                        for (Long ite : elements) {
                            count++;
                        }
                        out.collect("" + count );
                    }

                });

        final DefaultRollingPolicy<String, String> policyBuilder = DefaultRollingPolicy.builder()
                .withInactivityInterval(TimeUnit.SECONDS.toMillis(10))
                .withRolloverInterval(TimeUnit.SECONDS.toMillis(10))
                .withMaxPartSize(1024 * 1024 * 1024).build();
        final StreamingFileSink<String> build = StreamingFileSink.<String>forRowFormat(
                        new Path("file:///C:\\Users\\Noch\\Downloads\\flinkDemoTest\\aabb"), new SimpleStringEncoder<>("UTF-8")
                ).withRollingPolicy(policyBuilder)
                .withBucketCheckInterval(10000L)
                .withOutputFileConfig()
                .build();

        process.addSink(build);

        env.execute("abc");

        env.execute("abc");

    }
}
