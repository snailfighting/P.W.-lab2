package laba2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWrComparable implements WritableComparable {

    public int aeroport_id;
    public int indenity;

    public FlightWrComparable(){}

    public void FlightWrComparable(int aeroport_id, int indenity){
        this.aeroport_id = aeroport_id;
        this.indenity = indenity;
    }
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(aeroport_id);
        dataOutput.writeInt(indenity);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.aeroport_id = dataInput.readInt();
        this.indenity = dataInput.readInt();
    }

    public int getID() {
        return this.aeroport_id;
    }

    public int comparableID(Object o){
        FlightWrComparable that = (FlightWrComparable) o;
        return Integer.compare(this.aeroport_id, that.aeroport_id);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
