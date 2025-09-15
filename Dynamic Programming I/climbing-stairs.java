class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // number of ways to climb 0 steps (1 way: take no steps)
        dp[1] = 1; // number of ways to climb 1 step (1 way: take one step)
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}