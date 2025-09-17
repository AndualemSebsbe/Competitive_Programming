class Solution {
    public int numOfSubarrays(int[] arr) {
        int sum = 0, odd = 0, even = 0;
        int mod = 1_000_000_007;
        int res = 0;
        for (int num : arr) {
            sum += num;
            if (sum % 2 != 0) {
                res += 1;
                res = (res + even) % mod;
                odd += 1;
            }
            else {
                res = (res + odd) % mod;
                even += 1;
            }
        }

        return res;
    }
}