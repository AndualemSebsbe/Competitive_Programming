class findPivotIndex {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int leftSum = 0, totalSum = nums[0];
        for(int i = 1; i<len; i++){
            totalSum += nums[i];          
        }
        if(leftSum == totalSum - leftSum - nums[0])
            return 0;
            
        for(int i = 1; i<len; i++){
            leftSum += nums[i-1];
            if(leftSum == totalSum - leftSum - nums[i])
                return i;
        }

        return -1;
    }
}