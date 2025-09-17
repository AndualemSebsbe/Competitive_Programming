class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n];
        int[][] prefSum = new int[n][26];
        
        prefSum[0][s.charAt(0) - 'a'] = 1;
        for(int i = 1; i < n; i++){
            prefSum[i][s.charAt(i) - 'a'] += 1;
            
            for(int j = 0; j < 26; j++)
                prefSum[i][j] += prefSum[i - 1][j];
        }

        return minSubstring(prefSum, n - 1, dp);
    }

    int minSubstring(int[][] prefSum, int i, Integer[] dp){
        int n = prefSum.length;
        int min = n;

        if(i == -1)
            return 0;

        if(dp[i] != null)
            return dp[i];

        for(int j = i; j >= 0; j--){
            boolean isPossible = true;
            int count = 0;
            for(int k = 0; k < 26; k++){
                int freq = prefSum[i][k] - (j - 1 >= 0 ? prefSum[j - 1][k] : 0);
                if(count != 0 && freq != 0 && count != freq)
                    isPossible = false;
                count = Math.max(count, freq);
            }

            if(!isPossible)
                continue;
                
            min = Math.min(min, 1 + minSubstring(prefSum, j - 1, dp));
        }

        return dp[i] = min;
    }
}