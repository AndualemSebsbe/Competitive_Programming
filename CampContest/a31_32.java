package CampContest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a31_32 {
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
           int k = sc.nextInt();
           int x = dfs(k, 32);
           int y = dfs(k, 31);
           int z = Math.min(x, y);
           System.out.println(z == x ? 32 : 31);
       }
        
    }
  public static int dfs(int k, int curr){
      if(k == curr)
      return 0;
      
      int count = 1;
      if(k > curr)
      count+= dfs(k, curr+=4);
      if(k < curr)
      count += dfs(k, curr-=1);
      return count;
  }
}