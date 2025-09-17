public class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int l = 0, minIdx = -1, maxIdx = -1;
        long count = 0;
        
        for(int i = 0; i < n; i++){
            if(nums[i] <= min){
                min = nums[i];
                minIdx = i;
            }

            if(nums[i] >= max){
                max = nums[i];
                maxIdx = i;
            }

            if(min < minK || max > maxK){
                l = i + 1;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                minIdx = maxIdx = -1;
            }

            if(min == minK && max == maxK)
                count += (Math.min(minIdx, maxIdx) - l + 1);
        }

        return count;
    }
}