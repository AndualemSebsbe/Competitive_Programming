class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] preSum = new int[n];
        preSum[0] = arr[0];
        for (int i = 1; i < n; i++)
            preSum[i]= preSum[i - 1] ^ arr[i];
        
        int len = queries.length;
        int[] res = new int[len];
        int idx = 0;
        for (int[] query : queries) {
            int left = query[0], right = query[1];
            if (left != 0)
                res[idx++] = preSum[right] ^ preSum[left - 1];
            else
                res[idx++] = preSum[right];
        }

        return res;
    }
}