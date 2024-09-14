class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        for (int i = 1; i < n; i++)
            arr[i] ^= arr[i - 1];
        
        int len = queries.length;
        int[] res = new int[len];
        int idx = 0;
        for (int[] query : queries) {
            int left = query[0], right = query[1];
            if (left != 0)
                res[idx++] = arr[right] ^ arr[left - 1];
            else
                res[idx++] = arr[right];
        }

        return res;
    }
}