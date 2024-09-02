class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int num : chalk)
            sum += num;
        
        long quotient = k / sum;
        k = k - (int) (quotient * sum);
        int n = chalk.length;
        while (k >= 0) {
            for (int i = 0; i < n; i++) {
                if (k < chalk[i])
                    return i;

                k -= chalk[i];
            }
        }

        return -1;
    }
}