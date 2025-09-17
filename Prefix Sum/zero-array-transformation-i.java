class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];
            diff[l] += 1;
            diff[r + 1] -= 1;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (sum < nums[i])
                return false;
        }

        return true;
    }
}