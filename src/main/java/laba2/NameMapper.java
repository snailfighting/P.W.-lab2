package laba2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class NameMapper extends Mapper<LongWritable, Text,Text,IntWritable> {
    private static final String DELIMITER = "\",";
    private static final int DEST_AEROPORT_ID = 0;
    private static final int NAME_AEROPORT = 1;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if(get.key > 0)
    }
}
