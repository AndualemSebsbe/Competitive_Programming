public class Solution {

    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] minObstacles = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                minObstacles[i][j] = Integer.MAX_VALUE;
        }

        minObstacles[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[] { minObstacles[0][0], 0, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int obstacles = cur[0], row = cur[1], col = cur[2];

            if (row == m - 1 && col == n - 1)
                return obstacles;

            for (int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];

                if (isValid(grid, newRow, newCol)) {
                    int newObstacles = obstacles + grid[newRow][newCol];

                    if (newObstacles < minObstacles[newRow][newCol]) {
                        minObstacles[newRow][newCol] = newObstacles;
                        pq.add(new int[] { newObstacles, newRow, newCol });
                    }
                }
            }
        }

        return minObstacles[m - 1][n - 1];
    }

  
    private boolean isValid(int[][] grid, int row, int col) {
        int m = grid.length, n = grid[0].length;
        return (
            row >= 0 && col >= 0 && row < m && col < n
        );
    }
}