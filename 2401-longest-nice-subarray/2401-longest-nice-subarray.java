class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length, max = 1;
        int num = 0, l = 0;
        
        for(int i = 0; i < n; i++){
            
            while(l < i && (num&nums[i]) != 0){
                num ^= nums[l];
                l += 1;
            }
            
            num ^= nums[i];
            max = Math.max(max, i-l+1);
        }
        
        return max;
    }
}