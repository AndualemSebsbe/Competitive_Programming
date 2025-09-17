class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        Arrays.sort(rewardValues);
        int totalReward = 0;
        int[][] dp = new int[n][4000];
        
        return maxReward(rewardValues, 0, totalReward, dp);
    }
    
    int maxReward(int[] nums, int i, int totalReward, int[][] dp){
        int n = nums.length;
        if(i == n || totalReward > nums[n - 1])
            return 0;

        if(dp[i][totalReward] != 0)
            return dp[i][totalReward];
        
        int pick = 0, dontPick = 0;
        if(nums[i] > totalReward)
            pick = nums[i] + maxReward(nums, i + 1, totalReward + nums[i], dp);
        
        dontPick = maxReward(nums, i + 1, totalReward, dp);      
        dp[i][totalReward] = Math.max(pick, dontPick);

        return dp[i][totalReward];
    }
}