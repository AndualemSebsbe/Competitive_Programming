class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 1, r = cells.length, ans = 0;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(canWalk(cells, row, col, mid)){
                ans = mid;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return ans;
    }

    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    boolean canWalk(int[][] cells, int row, int col, int day){
        int[][] grid = new int[row][col];
        for(int i = 0; i < day; i++)
            grid[cells[i][0]-1][cells[i][1]-1] = 1;
        
        Queue<int[]> q = new LinkedList();
        for(int c = 0; c < col; c++){
            if(grid[0][c] == 0){
                q.add(new int[]{0, c});
                grid[0][c] = 1;
            }
        }

        while(q.size() > 0){
            int[] curr = q.poll();

            if(curr[0] == row-1)
                return true;

            for(int[] dir : dirs){
                int newR = curr[0] + dir[0];
                int newC = curr[1] + dir[1];

                if(newR < 0 || newR >= row || newC < 0 || newC >= col || 
                    grid[newR][newC] == 1)
                    continue;
                
                grid[newR][newC] = 1;
                q.add(new int[]{newR, newC});
            }
        }

        return false;
    }
}