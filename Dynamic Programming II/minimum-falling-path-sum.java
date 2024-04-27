class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(row == 0)
                    dp[row][col] = matrix[row][col];
                else {
                    int res = Integer.MAX_VALUE;
                    res = Math.min(res, dp[row - 1][col]);
                    if(col - 1 >= 0)
                        res = Math.min(res, dp[row - 1][col - 1]);
                    if(col + 1 < n)
                        res = Math.min(res, dp[row - 1][col + 1]);
                    dp[row][col] = res + matrix[row][col];
                }
            }
        }

        for(int i = 0; i < n; i++){
            min = Math.min(min, dp[n-1][i]);
        }

        return min;
    }
}