class Solution {
    public long maxPoints(int[][] points) {
        int rows = points.length, cols = points[0].length;
        long[] prevRow = new long[cols];
        for (int col = 0; col < cols; col++)
            prevRow[col] = points[0][col];

        for (int row = 1; row < rows; row++) {
            long[] left = new long[cols];
            left[0] = prevRow[0];
            for (int col = 1; col < cols; col++)
                left[col] = Math.max(prevRow[col], left[col - 1] - 1);

            long[] right = new long[cols];
            right[cols - 1] = prevRow[cols - 1];
            for (int col = cols - 2; col >= 0; col--)
                right[col] = Math.max(prevRow[col], right[col + 1] - 1);
            
            long[] curRow = new long[cols];
            for (int col = 0; col < cols; col++)
                curRow[col] = points[row][col] + Math.max(left[col], right[col]);

            prevRow = curRow;
        } 

        long max = 0;
        for (int col = 0; col < cols; col++) 
            max = Math.max(max, prevRow[col]);
        
        return max;
    }
}