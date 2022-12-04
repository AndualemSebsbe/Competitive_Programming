class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long total = 0;
        
        for(int i = 0; i < n; i++)
            total += nums[i];
        
        int count = 0;
        long leftSum = 0;
        for(int i = 0; i < n-1; i++){
            leftSum += nums[i];
            long rightSum = total - leftSum;
            
            if(leftSum >= rightSum)
                count += 1;
        }
        
        return count;
    }
}
//SC : O(1)