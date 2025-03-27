class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int mid = nums.length / 2;
        for (int num : nums) {
            count += Math.abs(nums[mid] - num);
        }

        return count;
    }
}