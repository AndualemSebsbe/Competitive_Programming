class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int res = n * n;
        int[][] cells = {{0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}};
        for(int[] cell : cells){
            res = Math.min(res, computeCost(grid, cell[0], cell[1]));
        }

        return res;
    }

    int computeCost(int[][] grid, int y, int notY){
        int n = grid.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if((i <= n/2 && (i == j || i + j == n - 1))
                    || (i >= n/2 && j == n/2)){
                    if(grid[i][j] != y)
                        ans += 1;
                    }
                else {
                    if(grid[i][j] != notY)
                        ans += 1;
                }
            }
        }

        return ans;
    }
}