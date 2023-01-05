package PostCamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.math.BigInteger;


public class planets {
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
         int secCost = sc.nextInt();
         
         Map<Integer, Integer> map = new HashMap();
         for(int i = 0; i < n; i++){
             int num = sc.nextInt();
             map.put(num, map.getOrDefault(num, 0) + 1);
         }
         
         int minCost = 0;
         for(int key : map.keySet()){
             int val = map.get(key);
             
            if(val > secCost)
                minCost += secCost;
            else
                minCost += val;
         }
         
         System.out.println(minCost);
     }
     }
}