class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return 0;

        Arrays.sort(nums);
        int moves = nums[1] - nums[0];
        for (int i = 2; i < n; i++) {
            nums[i] += moves;
            moves += (nums[i] - nums[i - 1]);
        }

        return moves;
    }
}