class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] res = new int[(n * (n + 1)) / 2];
        int idx = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                res[idx++] = sum;
            }
        }

        int[] counting = new int[100001];
        for(int i = 0; i < res.length; i++){
            counting[res[i]] += 1;
        }

        idx = 0;
        for(int i = 0; i < counting.length; i++){
            while(counting[i]-- > 0)
                res[idx++] = i;
        }

        int total = 0, MOD = 1_000_000_007;
        for(int i = left - 1; i < right; i++){
            total = (total + res[i]) % MOD;
        }

        return total;
    }
}