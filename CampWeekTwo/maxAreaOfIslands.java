public class maxAreaOfIslands {
  
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0, island = 1;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == 1)
                        max = Math.max(max, dfs(grid, i, j, island));
                }
            }
            
            return max;
        }
        
        public int dfs(int[][] grid, int i, int j, int island){
            if((i < 0) || (i >= grid.length) || (j < 0) || (j >= grid[i].length) || (grid[i][j] != island))           return 0;
            
            grid[i][j] = 0;
            int count = 1;
            count += dfs(grid, i + 1, j, island);
            count += dfs(grid, i - 1, j, island);
            count += dfs(grid, i, j + 1, island);
            count += dfs(grid, i, j - 1, island);
            return count;
        }
    }