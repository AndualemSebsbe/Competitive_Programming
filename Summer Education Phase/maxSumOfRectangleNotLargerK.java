public class maxSumOfRectangleNotLargerK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length, max = Integer.MIN_VALUE;
        System.out.println(row);
        System.out.println(col);
        for(int i = 0; i < row; i++){
            
            int[] nums = new int[col];
            for(int j = i; j < row; j++){
                
                for(int x = 0; x < col; x++)
                    nums[x] += matrix[j][x];
                    
                int sum = total(nums, k);
                max = Math.max(max, sum);
            }
        }
        return max;
    }
    
    public int total(int[] nums, int k){
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum <= k)
                    ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}