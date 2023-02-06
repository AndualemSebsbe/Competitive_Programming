class raceCar {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;

            int forwardCount = 1;
            int j = (1 << forwardCount) - 1;
            for (; j < i; j = (1 << ++forwardCount) - 1) {
                int backwardCount = 0;
                for(int k = j; k > 0; k = j - ((1 << ++backwardCount) - 1)){
                    dp[i] = Math.min(dp[i], 
                    forwardCount + backwardCount + 2 + dp[i - k]);
                }
            }
            
            if (j == i) {
                dp[i] = Math.min(dp[i], forwardCount);
            } else {
                dp[i] = Math.min(dp[i], forwardCount + 1 + dp[j - i]);
            }
        }
        return dp[target];
    }
}