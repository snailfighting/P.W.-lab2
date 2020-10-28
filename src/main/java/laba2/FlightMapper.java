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
    private static final String NULLSTRING = "";
    private static final float FLOAT0 = 0.0f;

    private static float NullCheck (String current){
        if(current.equals(NULLSTRING)) {
            return FLOAT0;
        }else {
            return Float.parseFloat(current);
        }
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] table = value.toString().split(DELIMITER);
        int dest_aeroport_id = Integer.parseInt(table[DEST_AEROPORT_ID]);
        float arr_delay = NullCheck(table[ARR_DELAY]);

        if (ARR_DELAY > FLOAT0){
            FlightWrComparable current = new FlightWrComparable(dest_aeroport_id, 1);
            context.write(current, new Text(table[ARR_DELAY]));
        }

    }
}
