class sortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length,  m = mat[0].length, count = 0;
       
        int i = 0, j = 0 ;
        while(count < m+n){
            if(i == n-1 && j < m) j++;
            if(i != n-1) i++;
            
            sortDiagonal(mat, n-1-i, j, n, m);
            count++;
        }
        
        return mat;
    }
    
    public void sortDiagonal(int[][] mat, int row, int col, int n, int m){
        int[] nums = new int[101];
        //counting sort
        int i = row, j = col;
        while(row < n && col < m){
            nums[mat[row++][col++]]++;
        }
        
//         sort the array element using original array diagonal
        for(int k = 0; k < 101; k++){
            if(nums[k] > 0){
                while(nums[k] != 0){
                mat[i++][j++] = k;
                --nums[k];
            }
            }
        }
    }
}