package laba2;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FlightGroupingComparatorClass extends WritableComparator {
    protected FlightGroupingComparatorClass(){
        super(FlightWrComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        FlightWrComparable first = (FlightWrComparable) a;
        FlightWrComparable second = (FlightWrComparable) b;
        return first.comparableID(second);
    }
}
