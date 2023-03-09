import java.util.LinkedList;
import java.util.Queue;

class Solution {
  
	static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
		// your code goes here
        int m = grid.length, n = grid[0].length;
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        
        while(q.size() > 0){
        int size = q.size();
        
        while(size-- > 0){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            if(r == tr && c == tc)
                return res;
            
            int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int[] dir : dirs){
                int newR = r + dir[0];
                int newC = c + dir[1];
                
                if(newR < 0 || newR >= m || newC < 0 ||  newC >= n || grid[newR][newC] == 0)
                    continue;
                
                q.add(new int[]{newR, newC});
                grid[newR][newC] = 0;
            }
        }
        
        res += 1;
        }
        
        return -1;
    }

	public static void main(String[] args) {
	
	}
}