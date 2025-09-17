import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.math.BigInteger;


public class A_Kefa_and_First_Steps {
    static class RealScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
    
   
    public static void main(String[] args) {
       RealScanner sc = new RealScanner();
       int n = sc.nextInt();
       int l = 0;
       int[] nums = new int[n];
       for(int i = 0; i < n; i++){
           nums[i] = sc.nextInt();
       }
       
       int max = 1;
       for(int i = 1; i < n; i++){
           while(i < n && nums[i] >= nums[i-1]){
               i++;
           }
           
           max = Math.max(max, i-l);
           l = i;
       }

       System.out.println(max);
     }
}