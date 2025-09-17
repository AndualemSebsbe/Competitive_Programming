class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] preRow1 = new long[n];
        long[] preRow2 = new long[n];

        preRow1[0] = grid[0][0];
        preRow2[0] = grid[1][0];
        for(int i = 1; i < n; i++){
            preRow1[i] = grid[0][i] + preRow1[i - 1];
            preRow2[i] = grid[1][i] + preRow2[i - 1];
        }

        long res = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            long top = preRow1[n - 1] - preRow1[i];
            long bottom = 0;
            if(i > 0)
                bottom = preRow2[i - 1];
            
            long secondRobot = Math.max(top, bottom);
            res = Math.min(res, secondRobot);
        }

        return res;
    }
}