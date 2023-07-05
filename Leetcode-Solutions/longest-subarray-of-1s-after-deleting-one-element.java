class Solution {
    public int longestSubarray(int[] nums) {
        int k = 1;
        int l = 0, r = 0, n = nums.length;
        
        while(r < n && k > 0){
            if(nums[r] == 0)
                k -= 1;
            r += 1;
        }

        int max = r;
        while(r < n){
            while(r < n && nums[r] == 1)
                r += 1;

            max = Math.max(max, r - l);
            r += 1;
            while(l < n && nums[l] != 0)
                l += 1;
            l += 1;            
        }

        return max - 1;
    }
}