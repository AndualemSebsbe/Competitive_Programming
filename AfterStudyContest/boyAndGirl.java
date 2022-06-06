import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class boyAndGirl {
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
        
       String s = sc.next();
       Set<Character> set = new HashSet();
       for(int i = 0; i < s.length(); i++){
           set.add(s.charAt(i));
       }
       if(set.size() % 2 == 0)
       System.out.println("CHAT WITH HER!");
       else
       System.out.println("IGNORE HIM!");
    }
}
