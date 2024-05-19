class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = 0, r = n * n;
        int res = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(canSwim(grid, mid)){
                res = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        return res;
    }

    boolean canSwim(int[][] grid, int time){
        int n = grid.length;
        Queue<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[n][n];

        if(grid[0][0] <= time){
            queue.add(new int[]{0, 0});
            visited[0][0] = true;
        }
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0], curC = cur[1];
            if(curR == n - 1 && curC == n - 1)
                return true;

            for(int[] dir : dirs){
                int newR = curR + dir[0];
                int newC = curC + dir[1];

                if(newR < 0 || newR == n || newC < 0 || newC == n || grid[newR][newC] > time || visited[newR][newC])
                    continue;
                
                visited[newR][newC] = true;
                queue.add(new int[]{newR, newC});
            }
        }

        return false;
    }
}