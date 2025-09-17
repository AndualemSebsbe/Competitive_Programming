package AfterCamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.*;
import java.util.StringTokenizer;

public class redBlueShuffle {
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
        int Nr = 0, Nb = 0;
        while(t-- > 0){
            int n = sc.nextInt();
            String r = sc.next();
            String b = sc.next();
            
            for(int i = 0; i < n; i++){
                if(r.charAt(i) == b.charAt(i)){
                    continue;
                }
                else if(r.charAt(i) < b.charAt(i)){
                    Nb += 1;
                    // break;
                }
                else{
                    Nr += 1;
                }
               }
            
            if(Nr > Nb)
             System.out.println("RED");
            else if(Nb > Nr)
              System.out.println("BLUE");
            else
              System.out.println("EQUAL");

              Nr = 0; Nb = 0;
        }
    }
}