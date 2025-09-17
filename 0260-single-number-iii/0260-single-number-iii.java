class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] ans = new int[2];
        int j = 0;
        
        for(int i = 0; i < n-1; i+=2){
            if(nums[i] != nums[i+1]){
                ans[j++] = nums[i];
                i -= 1;
            }
        }
        
        if(nums[n-1] != nums[n-2])
            ans[j] = nums[n-1];
        
        return ans;
    }
}