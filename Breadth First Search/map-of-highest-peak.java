class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (isWater[r][c] == 1) {
                    res[r][c] = 0;
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            for (int[] dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR < 0 || newR >= m || newC < 0 || newC >= n || visited[newR][newC])
                    continue;
                
                res[newR][newC] = res[r][c] + 1;
                queue.add(new int[] {newR, newC});
                visited[newR][newC] = true;
            }
        }

        return res;
    }
}