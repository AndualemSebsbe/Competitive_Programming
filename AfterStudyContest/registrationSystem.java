import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class registrationSystem {
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
       Map<String, Integer> map = new HashMap<>();
       while(t-- > 0){
           String str = sc.next();
           if(map.containsKey(str)){
               System.out.println(str + map.get(str));
               map.put(str, map.getOrDefault(str, 0) + 1);
           }
           else{
               System.out.println("OK");
               map.put(str, 1);
           }
       }
    }
}
