class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxGold = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++)
                maxGold = Math.max(maxGold, dfsBacktrack(grid, row, col));
        }

        return maxGold;
    }

    int dfsBacktrack(int[][] grid, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0)
            return 0;

        int max = 0, curVal = grid[row][col];
        grid[row][col] = 0;
        
        for(int[] dir : dirs){
            int newR = row + dir[0];
            int newC = col + dir[1];
            
            max = Math.max(max, curVal + dfsBacktrack(grid, newR, newC));
            
        }

        grid[row][col] = curVal;

        return max;
    }
}