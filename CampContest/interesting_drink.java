import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class interesting_drink {
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

        // int[] readArray(int n) {
        //     int[] a = new int[n];
        //     for (int i = 0; i < n; i++) a[i] = nextInt();
        //     return a;
        // }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static long upperBound(long a[], long x) {
        long l = -1, r = a.length;
        while (l + 1 < r) {
            long m = (l + r) >>> 1;
            if (a[(int) m] <= x) l = m;
            else r = m;
        }
        return l + 1;
    }
    // static long LowerBound(long a[], long x) {
    //     long l=-1,r=a.length;
    //     while(l+1<r) {
    //         long m=(l+r)>>>1;
    //         if(a[(int) m]>=x) r=m;
    //         else l=m;
    //     }
    //     return r;
    // }
    public static void main(String[] args) {
        RealScanner sc = new RealScanner();
        long n = sc.nextInt();
        long arr[] = new long[(int) n];
        for (long i = 0; i < n; i++) {
            arr[(int) i] = sc.nextLong();
        }
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arrFast));
        long q = sc.nextLong();
        for (long i = 0; i < q; i++) {
            long a = sc.nextLong();
            long res = upperBound(arr, a);
            System.out.println(res);
        }
    }
}