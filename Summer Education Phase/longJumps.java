import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class longJumps {
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
      
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int[] dp = new int[n+1];
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            
            int max = 0;
            while(n > 0){
                
                if(n + nums[n-1] > nums.length){
                    dp[n] = nums[n-1];
                }else{
                    dp[n] = dp[n + nums[n-1]] + nums[n-1];
                }
                max = Math.max(max, dp[n]);
                n--;
            }
            System.out.println(max);
        }
    }
}