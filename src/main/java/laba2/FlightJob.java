package laba2;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FlightJob {
        public static void main(String[] args) throws Exception {
            if (args.length != 3) {
                System.err.println("Usage: FlightJob <input path> <input path> <output path>");
                System.exit(-1);
            }
            Job job = Job.getInstance();
            job.setJarByClass(FlightJob.class);
            job.setJobName("Job sort");
            //....//
            MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMapper.class);
            MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, NameMapper.class);

            FileOutputFormat.setOutputPath(job, new Path(args[2]));

           // job.setMapperClass(FlightMapper.class);
            job.setGroupingComparatorClass(FlightGroupingComparatorClass.class);
            job.setMapOutputKeyClass(FlightWrComparable.class);
            job.setPartitionerClass(FlightPartitioner.class);
            job.setReducerClass(FlightReducer.class);
            job.setMapOutputValueClass(Text.class);

            /////
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);//
            job.setNumReduceTasks(2);
            System.exit(job.waitForCompletion(true) ? 0 : 1);

        }
}
