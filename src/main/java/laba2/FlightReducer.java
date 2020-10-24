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
        float max = 0.0f;
        float min = 0.0f;
        int count = 0;

        float average = 0.0f;

        Iterator<Text> iterator = values.iterator();
        Text inf = new Text(iterator.next());

        while(iterator.hasNext()){
            float current = Float.parseFloat(iterator.next().toString());
            min = Float.min(min, current);
            max = Float.max(max, current);

            average += current;
            count++;
        }
        if (count > 0){
            context.write(inf, new Text (min + max + average));
        }

    }
}
