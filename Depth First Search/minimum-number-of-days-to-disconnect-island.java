class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0)
                    count += dfs(grid, i, j, visited);
            }
        }

        if (count != 1)
            return 0;

        // check if we are able to disconnect in one day
        boolean isInOneDay = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    
                    count = 0;
                    visited = new int[m][n];
                    for (int row = 0; row < m; row++) {
                        for (int col = 0; col < n; col++) {
                            if(grid[row][col] == 1 && visited[i][j] == 0)
                                count += dfs(grid, row, col, visited);
                        }
                    }

                    if (count != 1)
                        isInOneDay = true;

                    grid[i][j] = 1;
                }
            }
        }

        if(isInOneDay)
            return 1;
        else
            return 2;
    }

    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    int dfs(int[][] grid, int row, int col, int[][] visited) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || visited[row][col] == 1 || grid[row][col] == 0)
            return 0;

        visited[row][col] = 1;

        int count = 1;
        for (int[] dir : dirs) {
            int newR = row + dir[0];
            int newC = col + dir[1];

            dfs(grid, newR, newC, visited);
        }

        return count;
    }
}