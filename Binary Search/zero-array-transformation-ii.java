class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int l = 0, r = queries.length;
        int best = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canTransform(nums, queries, mid)) {
                best = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        return best;
    }

    boolean canTransform(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], 
                val = queries[i][2];
            
            diff[l] += val;
            diff[r + 1] -= val;
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