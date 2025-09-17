class Solution {
    public char findKthBit(int n, int k) {
        boolean invert = false;
        while (n > 1) {
            int len = (int) Math.pow(2, n) - 1;
            int mid = len / 2;

            if (k <= mid)
                n -= 1;
            else if (k > mid + 1) {
                k = 1 + len - k;
                n -= 1;
                invert = !invert;
            }
            else
                return !invert ? '1' : '0';
        }

        return !invert ? '0' : '1';
    }
}