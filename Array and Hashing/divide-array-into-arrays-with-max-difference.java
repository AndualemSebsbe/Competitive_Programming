class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] res = new int[n/3][3];

        int idx = 0;
        while(idx < n){
            if((nums[idx + 2] - nums[idx]) <= k){
                for(int col = idx; col <=  idx + 2; col++)
                    res[idx/3][col%3] = nums[col];
            }
            else
                return new int[0][0];
            
            idx += 3;
        }

        return res;
    }
}