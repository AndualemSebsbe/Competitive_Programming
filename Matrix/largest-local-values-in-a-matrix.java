class Solution {
    public int[][] largestLocal(int[][] grid) {
        int m = grid.length - 2, n = grid[0].length - 2;
        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = largestValue(grid, i, j);
            }
        }

        return res;
    }

    int largestValue(int[][] grid, int i, int j){
        int maxVal = 0;
        for(int row = i; row < i + 3; row++){
            for(int col = j; col < j + 3; col++){
                maxVal = Math.max(maxVal, grid[row][col]);
            }
        }

        return maxVal;
    }
}