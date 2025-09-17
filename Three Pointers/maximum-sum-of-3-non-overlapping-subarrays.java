class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxSum = 0;

        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];

        int[] leftMaxIdx = new int[n];
        int[] rightMaxIdx = new int[n];

        int[] res = new int[3];

        for (int i = k, curMaxSum = prefixSum[k] - prefixSum[0]; i < n; i++) {
            if (prefixSum[i + 1] - prefixSum[i + 1 - k] > curMaxSum) {
                leftMaxIdx[i] = i + 1 - k;
                curMaxSum = prefixSum[i + 1] - prefixSum[i + 1 - k];
            } else
                leftMaxIdx[i] = leftMaxIdx[i - 1];
        }

        rightMaxIdx[n - k] = n - k;
        for (int i = n - k - 1, curMaxSum = prefixSum[n] - prefixSum[n - k]; i >= 0; i--) {
            if (prefixSum[i + k] - prefixSum[i] >= curMaxSum) {
                rightMaxIdx[i] = i;
                curMaxSum = prefixSum[i + k] - prefixSum[i];
            } else
                rightMaxIdx[i] = rightMaxIdx[i + 1];
        }

        for (int i = k; i <= n - 2 * k; i++) {
            int leftIdx = leftMaxIdx[i - 1];
            int rightIdx = rightMaxIdx[i + k];
            int totalSum =
                (prefixSum[i + k] - prefixSum[i]) +
                (prefixSum[leftIdx + k] - prefixSum[leftIdx]) +
                (prefixSum[rightIdx + k] - prefixSum[rightIdx]);

            if (totalSum > maxSum) {
                maxSum = totalSum;
                res[0] = leftIdx;
                res[1] = i;
                res[2] = rightIdx;
            }
        }

        return res;
    }
}