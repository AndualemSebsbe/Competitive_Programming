import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


public class C_Less_or_Equal {
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
     
     int n = sc.nextInt();
     int k = sc.nextInt();
     int[] nums = new int[n];
     
     for(int i = 0; i < n; i++){
         nums[i] = sc.nextInt();
     }
     
     Arrays.sort(nums);
    if(n == k)
        System.out.println(nums[k-1]);
    else if(k == 0 && nums[0] > 1)
        System.out.println(nums[0]-1);
    else if(k == 0 || nums[k-1] == nums[k])
        System.out.println(-1);
    else
        System.out.println(nums[k-1]);
    }
}