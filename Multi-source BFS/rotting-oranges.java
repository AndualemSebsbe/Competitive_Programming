class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int time = 0, fresh = 0;
        Queue<int[]> q = new LinkedList();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)
                    fresh += 1;
                else if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(q.size() > 0 && fresh > 0){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int newR = curr[0] + dir[0];
                    int newC = curr[1] + dir[1];

                    if(newR < 0 || newR >= m || 
                        newC < 0 || newC >= n || grid[newR][newC] != 1)
                        continue;
                    
                    grid[newR][newC] = 2;
                    q.add(new int[]{newR, newC});
                    fresh -= 1;
                }
            }

            time += 1;
        }

        return fresh == 0 ? time : -1;
    }
}