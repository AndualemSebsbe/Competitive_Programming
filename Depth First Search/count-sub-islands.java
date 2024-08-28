class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length, cols = grid1[0].length;
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(grid2[row][col] == 1 && isSubIsland(grid1, grid2, row, col))
                    count += 1;
            }
        }

        return count;
    }

    boolean isSubIsland(int[][] grid1, int[][] grid2, int r, int c) {
        if (r < 0 || r == grid2.length || c < 0 || c == grid2[0].length || grid2[r][c] == 0)
            return true;
        
        if (grid2[r][c] != grid1[r][c])
            return false;
        
        grid2[r][c] = 0;
        
        boolean res = true;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            res = res & isSubIsland(grid1, grid2, newR, newC);
        }

        return res;
    }
}