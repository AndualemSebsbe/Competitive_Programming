class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        List<int[]> minCoords = new ArrayList();
        for(int i = 0; i < rows; i++){
            int min = Integer.MAX_VALUE;
            int[] coord = {i, 0};
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] < min){
                    min = Math.min(min, matrix[i][j]);
                    coord = new int[]{i, j};
                }
            }

            minCoords.add(coord);
        }

        List<Integer> res = new ArrayList();
        for(int[] coord : minCoords){
            int row = coord[0], col = coord[1];
            int max = 0;
            for(int i = 0; i < rows; i++){
                if(matrix[i][col] > max)
                    max = matrix[i][col];
            }
            
            int min = matrix[row][col];
            if(max == min)
                res.add(max);
        }

        return res;
    }
}