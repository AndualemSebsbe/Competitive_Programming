package PostCamp;

class traverseDiagonal {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] arr = new int[n*m];
        int i = 0, row = 0, col = 0;
        boolean up = true;

        while(row < m && col < n){
            if(up){
                while(row > 0 && col < n-1){
                    arr[i++] = mat[row][col];
                    row--;
                    col++;
                }
                arr[i++] = mat[row][col];
                if(col == n-1)
                    row += 1;
                else
                    col += 1;
            }
            else{
                while(col > 0 && row < m-1){
                    arr[i++] = mat[row][col];
                    row++;
                    col--;
                }
                arr[i++] = mat[row][col];
                if(row == m-1)
                    col += 1;
                else
                    row += 1;
            }
            up = !up;
        }

        return arr;
    }
}