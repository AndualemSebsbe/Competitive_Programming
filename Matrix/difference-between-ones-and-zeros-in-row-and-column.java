class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1){
                    onesRow[row] += 1;
                    onesCol[col] += 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = onesRow[i] + onesCol[j] - 
                (m - onesRow[i]) - (n - onesCol[j]);
            }
        }

        return grid;
    }
}