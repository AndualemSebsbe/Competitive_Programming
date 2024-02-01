class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++)
            dp[i] = 1;

        int max = 1;
        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }
}