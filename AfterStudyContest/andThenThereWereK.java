import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class andThenThereWereK {
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
    
    static long sum = 0;
    public static void main(String[] args) {
        RealScanner sc = new RealScanner();
        
       int t = sc.nextInt();
       while(t-- > 0){
           int n = sc.nextInt();
           long i = 1;
           while(i < n){
               i = i<<1;
               
           }
           if(i == n){
               System.out.println(i-1);
           }
           else{
               System.out.println(i/2 -1);
           }
       }
    }
}