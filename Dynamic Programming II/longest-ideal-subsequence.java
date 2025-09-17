class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();

        int[][] dp = new int[n][27];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return dfs(0, '{', dp, s, k);
    }

    public int dfs(int i, char lastC, int[][] dp, String s, int k) {
        if(i == s.length())
            return 0;

        if (dp[i][lastC - 'a'] != -1)
            return dp[i][lastC - 'a'];

        int take = 0, dontTake = 0;
        if(lastC == '{' || Math.abs(s.charAt(i) - lastC) <= k)
            take = 1 + dfs(i + 1, s.charAt(i), dp, s, k);
        
        dontTake = dfs(i + 1, lastC, dp, s, k);
        dp[i][lastC - 'a'] = Math.max(take, dontTake);
        return dp[i][lastC - 'a'];
    }
}