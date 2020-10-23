package laba2;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class FlightWritable implements Writable {
    private float arr_delay;
    private float cancelled;
    private float air_time;

    private int dest_aeroport_id;

    public FlightWritable(){}

    public FlightWritable(float arr_delay, float cancelled, float air_time, int dest_aeroport_id){
        this.air_time = air_time;
        this.arr_delay = arr_delay;
        this.cancelled = cancelled;
        this.dest_aeroport_id = dest_aeroport_id;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException{
        dataOutput.writeFloat(this.air_time);
        dataOutput.writeFloat(this.arr_delay);
        dataOutput.writeFloat(this.cancelled);
        dataOutput.writeInt(this.dest_aeroport_id);
    }

    



}
