class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int countPos = 0, countNeg = 0;
        for (int num : nums) {
            if (num > 0)
                countPos += 1;
            else if (num < 0)
                countNeg += 1;
        }

        return Math.max(countPos, countNeg);
    }
}