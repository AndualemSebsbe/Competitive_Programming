class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int[] counting = new int[100_001];

        for(int num : nums)
            counting[num] += 1;
        
        int idx = 0;
        for(int i = 0; i < counting.length; i++){
            while(counting[i]-- > 0)
                nums[idx++] = i;
        }
        
        int count = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] <= nums[i - 1]){
                count += (nums[i - 1] - nums[i] + 1);
                nums[i] = nums[i - 1] + 1;
            }
        }

        return count;
    }
}