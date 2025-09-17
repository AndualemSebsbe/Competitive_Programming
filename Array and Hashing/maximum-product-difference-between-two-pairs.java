class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int w = nums[n-1], x = nums[n-2];
        int y = nums[0], z = nums[1];

        return (w * x) - (y * z);
    }
}