public class minOPerationsToReduceXtoZero {
    public int minOperations(int[] nums, int x) {
        int l = 0, r = 0, n = nums.length, total = 0, max = -1;
        for(int num : nums) total += num;
        
        int target = total-x;
        int sum = 0;
        while(r < n){
            sum += nums[r];
            
            while(l <= r && sum > target){
                sum -= nums[l];
                l++;
            }
            
            if(sum == target)
                max = Math.max(max, r+1-l);
            r++;
        }
        
        return max != -1 ? n-max : -1;
    }
}