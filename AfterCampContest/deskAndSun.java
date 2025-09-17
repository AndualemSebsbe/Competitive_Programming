import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 import java.util.*;
import java.util.StringTokenizer;


public class deskAndSun {
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
        
           long n = sc.nextLong();
           long m = sc.nextLong();
           
           Map<String, Integer> map = new HashMap<>();
           
           long[][] arr = new long[101][101];
           while(n-- > 0){
               long i = sc.nextLong();
               long j = sc.nextLong();
               
               arr[(int)i][(int)j] = 1;
               
               String str = i + "," + j;
               map.put(str, map.getOrDefault(str, 0) + 1);
           }
           
           
           while(m-- > 0){
              long count = 0L;
              long ulI = sc.nextLong();
              long ulJ = sc.nextLong();
              long brI = sc.nextLong();
              long brJ = sc.nextLong();
              
              for(long i = ulI; i <= brI; i++){
                  for(long j = ulJ; j <= brJ; j++){
                      if(arr[(int)i][(int)j] == 1){
                          String s = i + "," + j;
                          count += map.get(s);
                      }
                  }
              }
              System.out.println(count);
           }
           
  }
}