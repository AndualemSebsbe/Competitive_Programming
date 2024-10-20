class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1)
            return '0';

        int len = (int) Math.pow(2, n) - 1;
        int mid = len / 2;

        if (k <= mid)
            return findKthBit(n - 1, k);
        else if (k > mid + 1) {
            char res = findKthBit(n - 1, 1 + len - k);
            return res == '0' ? '1' : '0';
        }
        else 
            return '1';
    }
}