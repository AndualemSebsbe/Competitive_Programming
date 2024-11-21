class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < guards.length; i++) {
            int row = guards[i][0];
            int col = guards[i][1];
            grid[row][col] = 1;
        }
        
        for (int i = 0; i < walls.length; i++) {
            int row = walls[i][0];
            int col = walls[i][1];
            grid[row][col] = 2;
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    for (int i = row - 1; i >= 0; i--) {
                        if (grid[i][col] == 2 || grid[i][col] == 1)
                            break;
                        
                        grid[i][col] = -1;
                    }
                    
                    for (int j = col + 1; j < n; j++) {
                        if (grid[row][j] == 2 || grid[row][j] == 1)
                            break;
                        
                        grid[row][j] = -1;
                    }
                    
                    for (int i = row + 1; i < m; i++) {
                        if (grid[i][col] == 2 || grid[i][col] == 1)
                            break;
                        
                        grid[i][col] = -1;
                    }
                    
                    for (int j = col - 1; j >= 0; j--) {
                        if (grid[row][j] == 2 || grid[row][j] == 1)
                            break;
                        
                        grid[row][j] = -1;
                    }
                }
            }
        }

        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0)
                    count += 1;
            }
        }

        return count;
    }
}