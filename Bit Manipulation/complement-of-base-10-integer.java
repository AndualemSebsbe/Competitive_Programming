class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0)
            return 1;

        int res = 0, shift = 0;
        while (n > 0) {
            int rightMost = n & 1;
            int bit = rightMost ^ 1;
            res = res | (bit << shift);

            n = n >> 1;
            shift += 1;
        }

        return res;
    }
}