class minCoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length+1;
        int amt = amount + 1;
        long[][] dp = new long[n][amt];
        
        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i < amt; i++){
            dp[0][i] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i < n; i++){
           for(int j = 1; j < amt; j++){
               if(j < coins[i-1])
                   dp[i][j] = dp[i-1][j];
               else
                   dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
           }
        }
        
        return (int)dp[n-1][amt-1] > Math.pow(10,4) ? -1 : (int)dp[n-1][amt-1];
    }
}

//OR

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length+1;
//         int amt = amount + 1;
//         long[][] dp = new long[n][amt];
// for(int i=0;i<n;++i)
//         {
//             for(int j=0;j<amt;++j)
//             {
//                 if(j==0)
//                     dp[i][j] = 0;
//                 else if(i==0)
//                     dp[i][j] = Integer.MAX_VALUE;
//                 else if(coins[i-1]>j)
//                     dp[i][j] = dp[i-1][j];
//                 else
//                     dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
//             }
//         }
// return (int)dp[n-1][amt-1] > Math.pow(10,4) ? -1 : (int)dp[n-1][amt-1];
//     }
// }
