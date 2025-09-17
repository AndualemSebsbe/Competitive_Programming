import java.util.ArrayList;
import java.util.List;

public class pacificAtlanticWaterFlow {
  
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int row = heights.length, col = heights[0].length, prev = Integer.MIN_VALUE;
            boolean[][] pacific = new boolean[row][col];
            boolean[][] atlantic = new boolean[row][col];
            
            for(int i = 0; i < col; i++){
                dfs(heights, 0, i, prev, pacific);
                dfs(heights, row-1, i, prev, atlantic);
            }
            for(int i = 0; i < row; i++){
                dfs(heights, i, 0, prev, pacific);
                dfs(heights, i, col-1, prev, atlantic);
            }
            
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(pacific[i][j] && atlantic[i][j]){
                        res.add(Arrays.asList(i,j));
                    }
                }          
            }
            return res;
        }
        
        public void dfs(int[][] heights, int r, int c, int prev, boolean[][] visited){
            if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || heights[r][c] < prev || visited[r][c]) return;
            
            visited[r][c] = true;
            
            int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}};   
            for(int[] dir : dirs){
                int newR = r + dir[0];
                int newC = c + dir[1];
                
                dfs(heights, newR, newC, heights[r][c], visited);
            }
        }
    }