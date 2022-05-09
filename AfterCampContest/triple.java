import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 import java.util.*;
import java.util.StringTokenizer;


public class triple {
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
        
       
       long t = sc.nextLong();
       while(t-- > 0){
           Map<Integer, Integer> map = new HashMap<>();
           int n = sc.nextInt();
           for(int i = 0; i < n; i++){
               int key = sc.nextInt();
               map.put(key, map.getOrDefault(key, 0) + 1);
           }
           int flag = 0;
           for(int key : map.keySet()){
               if(map.get(key) >= 3){
                   System.out.println(key);
                   flag = 1;
                   break;
               }
           }
           if(flag == 0)
           System.out.println(-1);
           
       }
    }
}

// 7
// 1
// 1
// 3
// 2 2 2
// 7
// 2 2 3 3 4 2 2
// 8
// 1 4 3 4 3 2 4 1
// 9
// 1 1 1 2 2 2 3 3 3
// 5
// 1 5 2 4 3
// 4
// 4 4 4 4