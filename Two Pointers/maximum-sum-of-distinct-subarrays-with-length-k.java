class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0, maxSum = 0;
        Set<Integer> set = new HashSet();
        
        int l = 0, r = 0;
        while (r < n) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l++];
            }

            set.add(nums[r]);
            sum += nums[r++];

            if (set.size() > k) {
                set.remove(nums[l]);
                sum -= nums[l++];
            }

            if (set.size() == k)
                maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}