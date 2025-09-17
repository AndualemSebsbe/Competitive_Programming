class maximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxEnding = 0;
        int maxSoFar = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            maxEnding = maxEnding + nums[i];
            
            if(maxEnding < nums[i])
                maxEnding = nums[i];
            
            if(maxSoFar < maxEnding)
                maxSoFar = maxEnding;
        }
        
        return maxSoFar;
    }
}