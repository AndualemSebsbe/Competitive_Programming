class Solution {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lower_bound(nums, upper + 1) - lower_bound(nums, lower);
    }

    // Calculate the number of pairs with sum less than `value`.
    private long lower_bound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long res = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum < value) {
                res += (right - left);
                left++;
            } else
                right--;
        }

        return res;
    }
}