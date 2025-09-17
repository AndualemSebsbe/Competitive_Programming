class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] matrix = new int[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // build matrix
                char c = grid[i].charAt(j);
                buildMatrix (c, matrix, 3 * i, 3 * j);
            }
        }

        // System.out.println(Arrays.deepToString(matrix));
        
        int count = 0;
        for (int row = 0; row < 3 * n; row++) {
            for (int col = 0; col < 3 * n; col++) {
                if(matrix[row][col] == 0)
                    count += dfs(matrix, row, col);
            }
        }

        return count;
    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int dfs(int[][] matrix, int row, int col) {
        if(row < 0 || row == matrix.length || col < 0 || col == matrix[0].length || matrix[row][col] == 1)
            return 0;
        
        int count = 1;
        matrix[row][col] = 1;
        for (int[] dir : dirs) {
            int newR = row + dir[0];
            int newC = col + dir[1];

            dfs(matrix, newR, newC);
        }

        return count;
    }

    void buildMatrix(char c, int[][] matrix, int row, int col) {
        int idx = 0;
        if (c == '\\') {
            while (idx < 3) {
                matrix[row][col] = 1;
                row += 1;
                col += 1;
                idx += 1;
            }
        }
        else if (c == '/') {
            col += 2;
            while (idx < 3) {
                matrix[row][col] = 1;
                row += 1;
                col -= 1;
                idx += 1;
            }
        }
    }
}