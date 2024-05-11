class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int idx = 0;
        boolean found = false;
        int l = 0, r = m - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target <= matrix[mid][n - 1]){
                found = true;
                idx = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        if(!found)
            return false;

        return findTarget(matrix, idx, target);
    }

    boolean findTarget(int[][] matrix, int i, int target){
        int l = 0, r = matrix[0].length;
        boolean ans = false;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(matrix[i][mid] < target)
                l = mid + 1;
            else if(matrix[i][mid] > target)
                r = mid - 1;
            else{
                 ans = true;
                 return ans;
            }
        }

        return ans;
    }
}