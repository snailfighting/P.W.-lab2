package laba2;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class Writable implements Writable {
    private float arr_delay;
    private float cancelled;
    private float air_time;

    private int dest_aeroport_id;

    public Writable(){}



}
