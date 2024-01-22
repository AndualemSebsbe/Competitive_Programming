class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        long x = 0, y = 0;
        for(int i = 1; i <= n; i++){
            x += nums[i - 1] - i;
            y += (Math.pow(nums[i - 1], 2) - Math.pow(i, 2));
        }

        int missing = (int)((y - (x * x))/(2 * x));
        int duplicate = (int)x + missing;

        return new int[]{duplicate, missing};
    }
}