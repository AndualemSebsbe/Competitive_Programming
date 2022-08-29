public class numberOfIslands {

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1')
                    count += dfs(grid, i, j);
            }
        }
        return count;
    }
    
    public int dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0')
            return 0;
        grid[row][col] = '0';
        
        int count = 1;
        int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
        for(int[] dir : dirs){
            int newR = row + dir[0];
            int newC = col + dir[1];
            dfs(grid, newR, newC);
        }
        
        return count;
    }
}