class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, max = 0;
        long total = 0;
        
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
            
            while((long)nums[i]*(i-l+1) > (total + k)){
                total -= nums[l];
                l += 1;
            }
            
            max = Math.max(max, (i-l+1));
        }
        
        return max;
    }
}