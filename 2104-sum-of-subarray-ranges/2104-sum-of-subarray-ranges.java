class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        
        for(int left = 0; left < n-1; left++){
            int min = Math.min(nums[left], nums[left+1]);
            int max = Math.max(nums[left], nums[left+1]);
            ans += (max - min);
            
            for(int right = left + 1; right < n-1; right++){
                min = Math.min(min, nums[right+1]);
                max = Math.max(max, nums[right+1]);
                ans += (max - min);
            }
        }
        return ans;
    }
}