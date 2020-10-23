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
        if(key.get() > 0){
            String[] table = value.toString().split(DELIMITER);
            int dest_aeroport_id = Integer.parseInt(table[DEST_AEROPORT_ID].replaceAll("\"", ""));
            WritableComparable currentKey = new WritableComparable(dest_aeroport_id, 0);
            context.write();
        }
    }
}
