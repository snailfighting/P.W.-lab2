package laba2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWrComparable implements WritableComparable {

    public int aeroport_id;
    public int indenity;

    public FlightWrComparable(){}

    public FlightWrComparable(int dest_aeroport_id, int i) {
    }

    public void FlightWrComparable(int aeroport_id, int indenity){
        this.aeroport_id = aeroport_id;
        this.indenity = indenity;
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
        FlightWrComparable that = (FlightWrComparable) o;
        return this.aeroport_id - that.aeroport_id > 0 ? 1 :
                ((this.aeroport_id - that.aeroport_id == 0) && (this.indenity - that.indenity > 0 ) ? 1 : -1);
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

}
