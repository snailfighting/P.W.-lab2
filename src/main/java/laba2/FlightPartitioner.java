package laba2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


public class FlightPartitioner extends Partitioner<FlightWrComparable, Text> {
    @Override
    public int getPartition(FlightWrComparable flightWrComparable, Text text, int i) {
        return flightWrComparable.getID() %  i;
    }
}
