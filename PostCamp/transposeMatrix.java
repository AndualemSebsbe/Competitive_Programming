package PostCamp;
class transposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] transMat = new int[n][m];

        for(int col = 0; col < n; col++){
            for(int row = 0; row < m; row++){
                transMat[col][row] = matrix[row][col];
            }
        }

        return transMat;
    }
}