package laba2;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class FlightMapper extends Mapper<LongWritable, Text, FlightWrComparable, Text>{
    private static final String DELIMITER = ",";
    private static final int DEST_AEROPORT_ID = 14;
    private static final int ARR_DELAY = 17;

    private static float NullCheck (String current){
        if(current.equals("")) {
            return 0.0F;
        }else {
            return Float.parseFloat(current);
        }
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] table = value.toString().split(DELIMITER);
        int dest_aeroport_id = Integer.parseInt(table[DEST_AEROPORT_ID]);
        float arr_delay = NullCheck(table[ARR_DELAY]);

        if (ARR_DELAY > 0.0f){
            FlightWrComparable current = new FlightWrComparable(dest_aeroport_id, 1);
            context.write(current, Text(table[]));
        }

    }
}
