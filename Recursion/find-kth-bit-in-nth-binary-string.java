class Solution {
    public char findKthBit(int n, int k) {
        return helper(n, k, false);
    }

    char helper(int n, int k, boolean invert) {
        if (n == 1)
            return !invert ? '0' : '1';

        int len = (int) Math.pow(2, n) - 1;
        int mid = len / 2;

        if (k <= mid)
            return helper(n - 1, k, invert);
        else if (k > mid + 1) {
            return helper(n - 1, 1 + len - k, !invert);
        } else
            return !invert ? '1' : '0';
    }
}