class sumOfSubarrRanges {
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        long sum = 0L;
        for(int i = 0; i < len; i++){
            int max = nums[i];
            int min = nums[i];
            
            int j = i + 1;
            while(j < len){
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                sum += max - min;
                j++;
            }
        }
        return sum;
    }
}