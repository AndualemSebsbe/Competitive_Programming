package AfterCamp;
class numOfEnclaves {
    public int numEnclaves(int[][] grid) {

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if((grid[i][j] == 1) &&(i == 0 || i == grid.length - 1 || j == 0 || j == grid[i].length - 1))
                    dfs(grid, i, j);
            }
        }
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1)
                    count ++;
            }
        }
        return count;
    }
       
    public void dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1)
            return;
         grid[i][j] = -1;
                
         dfs(grid,i + 1, j);
         dfs(grid,i - 1, j);
         dfs(grid,i, j + 1);
         dfs(grid,i, j - 1);
    }
}
