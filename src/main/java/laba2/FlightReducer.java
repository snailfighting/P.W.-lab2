package laba2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class FlightReducer extends Reducer<FlightWrComparable,Text,Text,LongWritable>{

    @Override
    protected void reduce(FlightWrComparable key, Iterable<Text> values, Context context) throws IOException,InterruptedException{
        Iterator<Text> iterator = 
    }
}
