package laba2;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class FlightMapper extends Mapper<LongWritable, Text, WritableComparable, IntWritable>{
    private static final String DELIMITER = ",";
    private static final int DEST_AEROPORT_ID = 14;
    private static final int ARR_DELAY = 17;

    private static float NullCheck (String current){
        if(current.equals("")) {
            
        }
    }

}
