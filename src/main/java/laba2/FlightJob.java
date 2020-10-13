package laba2;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FlightJob {
        public static void main(String[] args) throws Exception {
            if (args.length != 2) {
                System.err.println("Usage: WordCountApp <input path> <output path>");
                System.exit(-1);
            }
            Job job = Job.getInstance();
            job.setJarByClass(FlightJob.class);
            job.setJobName("Word count");
            //....//
            FileInputFormat.addInputPath(job, new Path(args[0]));
            FileOutputFormat.setOutputPath(job, new Path(args[1]));

            job.setMapperClass(FlightMapper.class);
            job.setReducerClass(FlightReducer.class);

        }
}
