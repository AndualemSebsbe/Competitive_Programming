import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class petyaAndStrings {
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
        
        String s1 = sc.next();
        String s2 = sc.next();
        // for(int i = 0; i < )
        String str1 = s1.toLowerCase();
        String str2 = s2.toLowerCase();
        
        //  System.out.println(str2);
        for(int i = 0; i < s1.length(); i++){
            int a = str1.charAt(i) - 'a';
            int b = str2.charAt(i) - 'a';
            // System.out.println(b);
            if(a > b){
                System.out.println("1");
                break;
            }
            else if(a < b){
                System.out.println("-1");
                break;
            }
            
            if(i == s1.length() - 1 && a == b)
            System.out.println("0");
        }
    
    }
}