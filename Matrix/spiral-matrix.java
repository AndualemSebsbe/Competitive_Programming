class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;

        List<Integer> res = new ArrayList();
        int dir = 0;
        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++)
                    res.add(matrix[top][i]);
                top += 1;
            }
            else if(dir == 1){
                for(int i = top; i <= bottom; i++)
                    res.add(matrix[i][right]);
                right -= 1;
            }
            else if(dir == 2){
                for(int i = right; i >= left; i--)
                    res.add(matrix[bottom][i]);
                bottom -= 1;
            }
            else if(dir == 3){
                for(int i = bottom; i >= top; i--)
                    res.add(matrix[i][left]);
                left += 1;
            }

            dir = (dir + 1)%4;
        }

        return res;
    }
}