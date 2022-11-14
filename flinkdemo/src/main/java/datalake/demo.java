package datalake;


import io.delta.flink.sink.DeltaSink;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeutils.TypeSerializer;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.WindowAssigner;
import org.apache.flink.streaming.api.windowing.triggers.Trigger;
import org.apache.flink.streaming.api.windowing.windows.Window;
import org.apache.flink.table.data.RowData;
import org.apache.flink.table.types.logical.BigIntType;
import org.apache.flink.table.types.logical.RowType;
import org.apache.flink.util.Collector;
import org.apache.hadoop.conf.Configuration;

import java.util.ArrayList;
import java.util.Collection;

public class demo {
    public static void main(String[] args) {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        ArrayList<RowType.RowField> rowFields = new ArrayList<>();
        rowFields.add(new RowType.RowField("id" ,new BigIntType()));

        RowType rowType = new RowType(true, rowFields);
        KafkaSource.<String>builder()
                ;
        KafkaSource<String> source = KafkaSource.<String>builder()
                .setBootstrapServers("localhost:9092")
                .setTopics("test1")
                .setGroupId("wuxuan1")
                .setStartingOffsets(OffsetsInitializer.earliest())
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .build();
        SingleOutputStreamOperator<Long> kafkasource1 = env.fromSource(source, WatermarkStrategy.noWatermarks(), "kafkasource")
                .map(new RichMapFunction<String, Integer>() {
                    @Override
                    public Integer map(String s) throws Exception {
                        return Integer.parseInt(s);
                    }
                }).keyBy(new KeySelector<Integer, Integer>() {
                    @Override
                    public Integer getKey(Integer integer) throws Exception {
                        return integer;
                    }
                }).window(new WindowAssigner<Integer, Window>() {
                    @Override
                    public Collection<Window> assignWindows(Integer integer, long l, WindowAssignerContext windowAssignerContext) {
                        return null;
                    }

                    @Override
                    public Trigger<Integer, Window> getDefaultTrigger(StreamExecutionEnvironment streamExecutionEnvironment) {
                        return null;
                    }

                    @Override
                    public TypeSerializer<Window> getWindowSerializer(ExecutionConfig executionConfig) {
                        return null;
                    }

                    @Override
                    public boolean isEventTime() {
                        return false;
                    }
                }).process(new ProcessWindowFunction<Integer, RowData, Integer, Window>() {
                    @Override
                    public void process(Integer integer, ProcessWindowFunction<Integer, RowData, Integer, Window>.Context context, Iterable<Integer> iterable, Collector<RowData> collector) throws Exception {
                        long count = 0;
                        for (Integer ite : iterable) {
                            count++;
                        }
                        new RowData()
                        collector.collect(count);
                    }


                })

        SingleOutputStreamOperator<Long> kafkasource = kafkasource1;


        DeltaSink<RowData> build = DeltaSink.forRowData(
                new Path("")
                , new Configuration()
                , rowType
        ).build();


        kafkasource.sinkTo(build);


    }
}
