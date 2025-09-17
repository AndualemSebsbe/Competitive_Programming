class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxMoves = 0;

        Queue<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            queue.add(new int[] {row, 0, 0}); // (row, col, moves);
            visited[row][0] = true;
        }

        int[][] dirs = {{-1, 1}, {0, 1}, {1, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                int[] cur = queue.poll();
                int row = cur[0], col = cur[1], moves = cur[2];
                maxMoves = Math.max(maxMoves, moves);

                for (int[] dir : dirs) {
                    int newR = row + dir[0];
                    int newC = col + dir[1];

                    if (newR < 0 || newR >= m || newC < 0 || newC >= n 
                        || visited[newR][newC] || grid[row][col] >= grid[newR][newC])
                        continue;

                    queue.add(new int[] {newR, newC, moves + 1});
                    visited[newR][newC] = true;
                }
            }
        }

        return maxMoves;
    }
}