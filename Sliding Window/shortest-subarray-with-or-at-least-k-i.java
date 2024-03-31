class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int l = 0; l < n; l++){
            int sum = 0;
            
            for(int r = l; r < n; r++){
                sum |= nums[r];
                
                if(sum >= k)
                    min = Math.min(min, r - l + 1);
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}