class maximumMatrixBlock {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] prefixS = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                prefixS[i][j] = mat[i-1][j-1] + prefixS[i][j-1] + prefixS[i-1][j] - prefixS[i-1][j-1]; 
            }
        }
        
        int[][] res = new int[m][n];
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                int r1 = Math.max(r-k, 0),
                 c1 = Math.max(c-k, 0), 
                 r2 = Math.min(m-1, r+k),
                 c2 = Math.min(n-1, c+k);
                 //since prefixS starts at idx 1
                 r1 += 1; c1 += 1; r2 += 1; c2 += 1;
                 res[r][c] =  prefixS[r2][c2] - 
                 prefixS[r2][c1-1] - prefixS[r1-1][c2] + 
                 prefixS[r1-1][c1-1];
            }
        }
        return res;
    }
}