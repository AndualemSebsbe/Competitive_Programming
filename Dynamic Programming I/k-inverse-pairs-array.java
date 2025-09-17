class Solution {
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        int[] prev = new int[k + 1];
        prev[0] = 1;

        for(int N = 1; N <= n; N++){
            int[] cur = new int[k + 1];
            int total = 0;
            for(int K = 0; K <= k; K++){
                if(K >= N)
                    total = (total - prev[K - N] + mod) % mod;

                total = (total + prev[K]) % mod;
                cur[K] = total;
            }

            prev = cur;
        }
        
        return prev[k];
    }
}