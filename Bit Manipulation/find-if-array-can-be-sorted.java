class Solution {
    public boolean canSortArray(int[] nums) {
        int high = nums[0], n = nums.length;
        int lastGroupHigh = 0;
        boolean bitChange;

        for (int i = 1; i < n; i++) {
            bitChange = bitCounts(high) != bitCounts(nums[i]);

            if (bitChange)
                lastGroupHigh = high;

            if (nums[i] > high)
                high = nums[i];

            if (nums[i] < lastGroupHigh)
                return false;
        }

        return true;
    }

    int bitCounts(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1)
                count += 1;

            num = num >> 1;
        }

        return count;
        // return Integer.bitCount(num);
    }
}