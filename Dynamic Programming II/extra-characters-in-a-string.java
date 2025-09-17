class Solution {
    Set<String> set = new HashSet();
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        for (String dict : dictionary)
            set.add(dict);
        
        Integer[][] memo = new Integer[n][n];
        int max = maxChars(s, 0, 0, memo);
        return n - max;
    }

    int maxChars(String s, int l, int r, Integer[][] memo) {
        if (r >= s.length())
            return 0;
        
        if (memo[l][r] != null)
            return memo[l][r];
        
        int pick = 0, dontPick = 0;
        if (set.contains(s.substring(l, r + 1)))
            pick = (r - l + 1) + maxChars(s, r + 1, r + 1, memo);
        
        dontPick = Math.max(maxChars(s, l + 1, r + 1, memo), maxChars(s, l, r + 1, memo));

        return memo[l][r] = Math.max(pick, dontPick);
    }
}