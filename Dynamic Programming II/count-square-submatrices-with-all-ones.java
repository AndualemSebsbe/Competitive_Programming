class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        int res = 0;
        for (int col = 0; col < n; col++) {
            dp[0][col] = matrix[0][col];
            res += dp[0][col];
        }

        for (int row = 1; row < m; row++) {
            dp[row][0] = matrix[row][0];
            res += dp[row][0];
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] == 1) {
                    int min = Math.min(dp[row - 1][col - 1],
                            Math.min(dp[row - 1][col], dp[row][col - 1]));
                    dp[row][col] = 1 + min;
                    res += dp[row][col];
                }
            }
        }

        return res;
    }
}