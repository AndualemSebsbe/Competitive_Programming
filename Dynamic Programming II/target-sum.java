class Solution {
    int total = 0;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        for (int num : nums)
            total += num;
            
        Integer[][] memo = new Integer[n][2 * total + 1];
        return countWays(nums, 0, 0, target, memo);
    }

    int countWays(int[] nums, int i, int t, int target, Integer[][] memo) {

        if (i == nums.length) {
            if (target == t)
                return 1;
            else
                return 0;
        }

        if (memo[i][t + total] != null)
            return memo[i][t + total];

        memo[i][t + total] = countWays(nums, i + 1, t + nums[i], target, memo)
                + countWays(nums, i + 1, t - nums[i], target, memo);

        return memo[i][t + total];
    }
}