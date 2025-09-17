class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowsCount = new int[m];
        int[] colsCount = new int[n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    rowsCount[r] += 1;
                    colsCount[c] += 1;
                }
            }
        }

        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    if (rowsCount[r] > 1 || colsCount[c] > 1)
                        count += 1;
                }
            }
        }

        return count;
    }
}