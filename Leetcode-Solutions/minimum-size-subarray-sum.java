class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, l = 0, r = 0, sum = 0;
        int min = 100001;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            while(sum >= target){               
                min = Math.min(min, i+1-l);
                sum -= nums[l];
                l++;
            }
        }  
        
        return (min != 100001) ? min : 0;
    }
}