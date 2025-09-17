package PostCamp;

class uniquePathIII {
    public int uniquePathsIII(int[][] grid) {
        int zero = 0;
        int startR = 0, startC = 0;

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0)
                    zero += 1;
                else if(grid[r][c] == 1){
                    startR = r;
                    startC = c;
                }
            }
        }


        return uniquePaths(grid, startR, startC, zero);
    }

    int uniquePaths(int[][] grid, int r, int c, int zero){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1)
            return 0;
        
        if(grid[r][c] == 2)
            return zero == -1 ? 1 : 0;
        
        grid[r][c] = -1;
        zero -= 1;

        int totalPaths = 
        uniquePaths(grid, r+1, c, zero) + 
        uniquePaths(grid, r-1, c, zero) + 
        uniquePaths(grid, r, c+1, zero) + 
        uniquePaths(grid, r, c-1, zero);
        // let's say if we are not able to count all paths. Now we use         backtracking over here
        grid[r][c] = 0;
        zero += 1;

        return totalPaths;
    }
}