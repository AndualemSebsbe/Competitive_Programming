class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        int res = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(countOfSmallest(matrix, mid) >= k){
                res = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        return res;
    }

    int countOfSmallest(int[][] matrix, int val){
        int count = 0, n = matrix.length;
        for(int i = 0; i < n; i++){
            int l = 0, r = n - 1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(matrix[i][mid] <= val)
                    l = mid + 1;
                else
                    r = mid - 1;
            }

            count += l;
        }

        return count;
    }
}