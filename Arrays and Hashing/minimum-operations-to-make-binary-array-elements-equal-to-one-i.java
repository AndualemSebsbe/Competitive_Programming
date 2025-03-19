class Solution {
    public int minOperations(int[] nums) {
        int count = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0 && i + 3 <= n){
                for(int j = i; j < i + 3; j++){
                    if(nums[j] == 0)
                        nums[j] = 1;
                    else
                        nums[j] = 0; 
                }
                
                count += 1;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(nums[i] == 0)
                return -1;
        }
        
        return count;
    }
}