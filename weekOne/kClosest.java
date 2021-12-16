import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int len=points.length;
        double[][] d=new double[len][2];
        for(int i=0; i<len; i++){
            
            d[i][0] = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            
            d[i][1] = i;
           
        }
        
       Arrays.sort(d, Comparator.comparingDouble(o -> o[0]));

        
        int[][] intD = new int[d.length][d[0].length];

    for(int i = 0; i < d.length; i++)
    {
        for(int j = 0; j < d[0].length; j++)
            intD[i][j] = (int) d[i][j];
    }
        
   
       int[][] result=new int[k][2];
        for (int i=0 ; i < k ; i++){
            result[i][0]=points[intD[i][1]][0];
            result[i][1]=points[intD[i][1]][1];
           
        }
        
        return result;
    }
}