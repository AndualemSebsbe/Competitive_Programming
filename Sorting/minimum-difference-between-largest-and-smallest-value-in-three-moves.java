class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 3)
            return 0;

        Arrays.sort(nums);
        int res = Math.min(nums[n - 3] - nums[1], nums[n - 2] - nums[2]);
        res = Math.min(res, Math.min(nums[n - 1] - nums[3], nums[n - 4] - nums[0]));
        
        return res;
    }
}