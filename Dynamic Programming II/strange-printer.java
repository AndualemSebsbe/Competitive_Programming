class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        Integer[][] memo = new Integer[n][n];

        return minTurns(0, n - 1, s, memo);
    }

    int minTurns(int i, int j, String s, Integer[][] memo) {
        if (i == j)
            return 1;
        
        if (memo[i][j] != null)
            return memo[i][j];
        
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++)
            min = Math.min(min, minTurns(i, k, s, memo) + minTurns(k + 1, j, s, memo));

        memo[i][j] = s.charAt(i) == s.charAt(j) ? min - 1 : min;
        return memo[i][j];
    }
}