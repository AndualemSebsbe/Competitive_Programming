class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }

    int helper(int[] nums, int goal){
        if(goal < 0)
            return 0;
        
        int res = 0;
        int l = 0, curSum = 0;
        for(int r = 0; r < nums.length; r++){
            curSum += nums[r];
            while(curSum > goal){
                curSum -= nums[l];
                l += 1;
            }

            res += (r - l + 1);
        }

        return res;
    }
}