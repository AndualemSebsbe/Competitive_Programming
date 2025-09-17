class Solution {
    public long minimumSteps(String s) {
        int zeroes = 0, n = s.length();
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0')
                zeroes += 1;
            else
                res += zeroes;
        }

        return res;
    }
}