import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lectureSleep {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) throws Exception {
        FastReader sc=new FastReader();
        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int[] b=new int[n];
        for(int i=0;i<n;i++)b[i]=sc.nextInt();

        long slid=0;
        long sum=0;

        for(int i=0;i<n;i++){
            if(b[i]==1)sum=sum+a[i];
        }

        for(int i=0;i<k;i++){
            if(b[i]==0)slid+=a[i];
        }

        long dp=slid;
        for(int i=0;i<n-k;i++){
            if(b[i]==0)slid-=a[i];
            if(b[i+k]==0)slid+=a[i+k];

            if(slid>dp)dp=slid;
        }
        System.out.println(sum+dp);
    }
}