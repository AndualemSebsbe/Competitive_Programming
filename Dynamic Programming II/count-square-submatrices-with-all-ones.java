class Solution {

    public int solve(int i, int j, int[][] grid, Integer[][] dp) {
        if (i >= grid.length || j >= grid[0].length)
            return 0;
        
        if (grid[i][j] == 0)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int right = solve(i, j + 1, grid, dp);
        int diagonal = solve(i + 1, j + 1, grid, dp);
        int below = solve(i + 1, j, grid, dp);

        return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, below));
    }

    public int countSquares(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        Integer[][] dp = new Integer[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                ans += solve(i, j, grid, dp);
        }

        return ans;
    }
}