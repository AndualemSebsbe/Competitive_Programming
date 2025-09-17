class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowsCnt = new int[m];
        int[] colsCnt = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rowsCnt[i] += 1;
                    colsCnt[j] += 1;
                }
            }
        }

        long res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    res += (rowsCnt[i] - 1) * (colsCnt[j] - 1);
                }
            }
        }

        return res;
    }
}