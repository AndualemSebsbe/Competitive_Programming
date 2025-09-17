import java.util.Arrays;
import java.util.Comparator;

public class mergeIntervals {
    
        public int[][] merge(int[][] intervals) {
            int len = intervals.length;
           int k=len;
           int j=0;
            double[][] doubleIntervals = new double[len][2];
              for(int i = 0; i < intervals.length; i++)
              {
                doubleIntervals[i][0] = (double) intervals[i][0];
                doubleIntervals[i][1] = (double) intervals[i][1];
              }
           // System.out.println(doubleIntervals);
         
            // int[][] res = new int[len][2];
            int[][] temp = new int[len][2];
            // Sort the double 2d array
            Arrays.sort(doubleIntervals, Comparator.comparingDouble(o -> o[0]));
            int[][] intIntervals = new int[len][2];
            for(int i=0; i<len; i++){
                intIntervals[i][0] = (int)doubleIntervals[i][0];
                intIntervals[i][1] = (int)doubleIntervals[i][1];
               
            }
             
     int index = 0; // Stores index of last element
            // in output array (modified arr[])
       
            // Traverse all input Intervals
            for (int i=1; i<intIntervals.length; i++)
            {
                // If this is not first Interval and overlaps
                // with the previous one
                if (intIntervals[index][1] >=  intIntervals[i][0])
                {
                       // Merge previous and current Intervals
                    intIntervals[index][1] = Math.max(intIntervals[index][1], intIntervals[i][1]);
                    len--;
                }
                else {
                    index++;
                    intIntervals[index] = intIntervals[i];
                }   
            }
            int[][] mergeInterval = new int[len][2];
            for(int i=0; i<len; i++){
                mergeInterval[i] = intIntervals[i];
            }
            
           return mergeInterval; 
        }
    }
