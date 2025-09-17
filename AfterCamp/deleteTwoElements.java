package AfterCamp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class deleteTwoElements {
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
            int[] nums = new int[n];
            double sum = 0L;
            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
                sum += nums[i];
            }
            
           double newSum = (n-2)*(sum/n);
           double diff = sum - newSum;
           
           Map<Integer, Integer> map = new HashMap<>();
           int count = 0;
           for(int i = 0; i < n; i++){
               int key = (int)diff - nums[i];
               if(map.containsKey(key)){
                   count += map.get(key);
               }
               map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
           }
           System.out.println(count);
        }
    }
}


