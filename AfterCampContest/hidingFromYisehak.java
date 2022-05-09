import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 import java.util.*;
import java.util.StringTokenizer;


public class hidingFromYisehak {
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
        
           int col = sc.nextInt();
           
           while(col-- > 0){
               int n = sc.nextInt();
               int[] arr = new int[n];
               for(int i = 0; i < n; i++){
                   arr[i] = sc.nextInt();
               }
               
               int j = n - 1;
               int count = 0;
               for(int i = n - 1; i > 0; i--){
                   if(arr[j] > arr[i-1]){
                       count++;
                   }
                   else{
                       j = i - 1;
                   }
               }
               
               System.out.println(count);
           }
  }
}
