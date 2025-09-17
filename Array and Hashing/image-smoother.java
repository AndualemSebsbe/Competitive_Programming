class Solution {
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0},{1,-1},{1,1},{-1,-1},{-1,1}};

    public int[][] imageSmoother(int[][] img) {
        int rows = img.length, cols = img[0].length;
        int[][] smoother = new int[rows][cols];

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int sum = img[row][col], count = 1;

                for(int[] dir : dirs){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(isValid(newRow, rows, newCol, cols)){
                        count += 1;
                        sum += img[newRow][newCol];
                    }
                }

                smoother[row][col] = sum / count;
            }
        }

        return smoother;
    }

    boolean isValid(int row, int rows, int col, int cols){
        if(row >= 0 && row < rows && col >= 0 && col < cols)
            return true;
        return false;
    }
}