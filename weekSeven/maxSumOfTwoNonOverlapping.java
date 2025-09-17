class maxSumOfTwoNonOverlapping {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int len = nums.length;
        //find the sum of contiguous array at all index 
        for(int i=1; i<len; i++){
            nums[i] = nums[i-1] + nums[i];
        }
        //
        int maxFirst = nums[firstLen-1];
        int maxSecond = nums[secondLen-1];
        int res = nums[firstLen + secondLen - 1];
        
        for(int i=firstLen + secondLen; i<len; i++){
            maxFirst = Math.max(maxFirst, nums[i - secondLen] - nums[i - firstLen -secondLen]);
            
            maxSecond = Math.max(maxSecond, nums[i - firstLen] - nums[i - firstLen - secondLen]);
            
            res = Math.max(res, Math.max(maxFirst + (nums[i] - nums[i - secondLen]), maxSecond + nums[i] - nums[i - firstLen]));
            
        }
        return res;
    }
}