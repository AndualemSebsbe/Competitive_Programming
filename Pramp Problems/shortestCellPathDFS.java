  
class Solution {
  static int max = 100000;
  static boolean found;
	static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
		// your code goes here

        found = false;
        int count = dfs(grid, sr, sc, tr, tc);
        if(found)
        return count;
        
        return -1;
	}
  
  static int dfs(int[][] grid, int r, int c, int tr, int tc){
    int m = grid.length, n = grid[0].length;
    
    if(r >= m || c >= n || r < 0 || c < 0 || grid[r][c] == 0)
      return max;
    
    if(r == tr && c == tc){
      found = true;
      return 0;
    }
    
    grid[r][c] = 0;
   
    int best_min_count = max;
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    for(int[] dir : dirs){
      int newR = r + dir[0];
      int newC = c + dir[1];
     
      best_min_count = Math.min(best_min_count, 1+dfs(grid, newR, newC, tr, tc));
    }
    
    return best_min_count;
  }

	public static void main(String[] args) {
	
	}
}
