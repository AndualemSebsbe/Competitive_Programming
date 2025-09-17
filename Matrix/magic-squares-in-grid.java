class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if(isValidSquare(grid, i, j))
                    count += 1;
            }
        }

        return count;
    }

    boolean isValidSquare(int[][] grid, int i, int j) {
        boolean isValid = true;
        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        boolean[] visited = new boolean[16];
        
        int idx = 0;
        for (int row = i; row < i + 3; row++) {
            for (int col = j; col < j + 3; col++) {
                if(visited[grid[row][col]] || grid[row][col] > 9 || grid[row][col] == 0)
                    isValid = false;
                visited[grid[row][col]] = true;
                rowSum[idx] += grid[row][col];
            }

            idx += 1;
        }
        
        idx = 0;
        for (int col = j; col < j + 3; col++) {
            for (int row = i; row < i + 3; row++)
                colSum[idx] += grid[row][col];
        
            idx += 1;
        }
        
        // find sum diagonally to the right
        int row = i, col = j;
        int diagRSum = 0;
        idx = 0;
        while (idx < 3) {
            diagRSum += grid[row][col];
            row += 1;
            col += 1;
            idx += 1;
        }

        // find sum diagonally to the left
        row = i; col = j + 2;
        int diagLSum = 0;
        idx = 0;
        while (idx < 3) {
            diagLSum += grid[row][col];
            row += 1;
            col -= 1;
            idx += 1;
        }

        // check if the each row have the same sum
        isValid = isValid && (rowSum[0] == rowSum[1] && rowSum[0] == rowSum[2]);
        // check id each col have the same sum
        isValid = isValid && (colSum[0] == colSum[1] && colSum[0] == colSum[2]);
        // check if the row, col and diagonal sum are equal
        isValid = isValid && (rowSum[0] == colSum[0] && rowSum[0] == diagRSum && rowSum[0] == diagLSum);

        return isValid;
    }
}