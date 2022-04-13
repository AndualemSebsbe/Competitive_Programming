import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
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
                    for(int j = 0; j < n; j++){
                    if(i == j) continue;
                    
                    if(r.charAt(j) > b.charAt(j)){
                    Nr += (n - j - 1);
                    break;
                }
                else if(r.charAt(j) < b.charAt(j)){
                    Nb += (n - j - 1);
                    break;
                }
                else{
                    continue;
                }
                }
                }
                else if(r.charAt(i) > b.charAt(i)){
                    Nr += (n - i - 1);
                    break;
                }
                else{
                    Nb += (n - i - 1);
                    break;
                }
                
            }
        }
        
        if(Nr > Nb)
        System.out.println("RED");
        else if(Nb > Nr)
        System.out.println("BLUE");
        else
        System.out.println("Equal");
        // int n = sc.nextInt();
        // int m = sc.nextInt(); 
       
        //   int[] arrb = new int[m];
        //   for(int i = 0; i< m; i++)
        //   arrb[i] = sc.nextInt();
        //   int x = 0;
        //   for(int i = 0; i < n; i++){
        //      int val = sc.nextInt();
        //     x = dfs(arrb, val, 0);
        //   System.out.println((x >= n/2 && x < n)  ? "YES" : "NO");
        //   }
       
        
    }
// //   public static int dfs(int[] arrb, int val, int j){
// //       if(j >= arrb.length)
// //       return 0;
// //       int count = 1;
// //       if(val >= arrb[j])
// //      count += dfs(arrb,val, j + 1);
// //       return count;
//   }
}
