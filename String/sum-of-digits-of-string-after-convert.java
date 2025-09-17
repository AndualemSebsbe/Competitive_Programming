class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            int res = c - 'a' + 1;
            while (res > 0) {
                sum += res % 10;
                res /= 10;
            }
        }

        k -= 1;
        int res = sum;
        sum = 0;
        while (k > 0 && res >= 10) {
            while (res > 0) {
                sum += (res % 10);
                res /= 10;
            }

            res = sum;
            sum = 0;
            k -= 1;
        }

        return res;
    }
}