import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class swimWater {
    // TC : O(n2logn)
    public class Tile{
        private int x;
        private int y;
        private int time;
        public Tile(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        PriorityQueue<Tile> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        Set<String> visited = new HashSet<>();
        
        pq.add(new Tile(0, 0, grid[0][0]));
        visited.add("" + 0 + 0);
        int leastTime = 0;
        
        while(!pq.isEmpty()){
                
                Tile currTile = pq.poll();
                leastTime = Math.max(currTile.time, leastTime);
                if(currTile.x == n - 1 && currTile.y == n - 1)
                    return leastTime;
                for(int[] direction : directions){
                    int nextX = currTile.x + direction[0];
                    int nextY = currTile.y + direction[1];
                    if((nextX < 0) || (nextX >= n) || (nextY < 0) || (nextY >= n) || (visited.contains("" + nextX + nextY)))
                        continue;
                       
                    pq.add(new Tile(nextX, nextY, grid[nextX][nextY]));
                    visited.add("" + nextX + nextY);
                }
        }
        return leastTime;
    }
}