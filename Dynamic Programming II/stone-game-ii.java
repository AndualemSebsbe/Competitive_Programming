class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        for (int i = n - 2; i >= 0; i--) 
            piles[i] += piles[i + 1];
        return dfs(piles, 1, 0, new int[n][n]);
    }

    int dfs(int[] piles, int m, int p, int[][] memo) {
        if (p + 2 * m >= piles.length) 
            return piles[p];

        if (memo[p][m] > 0) 
            return memo[p][m];

        int res = 0, take = 0;
        for (int i = 1; i <= 2 * m; i++) {
            take = piles[p] - piles[p + i];
            res = Math.max(res, take + piles[p + i] - 
                dfs(piles, Math.max(i, m), p + i, memo));
        }

        memo[p][m] = res;
        return res;
    }
}