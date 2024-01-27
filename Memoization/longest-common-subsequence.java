class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        Integer[][] memo = new Integer[len1][len2];

        return lcs(text1, 0, text2, 0, memo);
    }

    int lcs(String t1, int i, String t2, int j, Integer[][] memo){
        if(i >= t1.length() || j >= t2.length())
        return 0;

        if(memo[i][j] != null)
        return memo[i][j];

        int include = 0, exclude = 0;
        if(t1.charAt(i) == t2.charAt(j))
        include = 1 + lcs(t1, i+1, t2, j+1, memo);
        else
        exclude = Math.max(lcs(t1,i+1, t2, j, memo), lcs(t1,i, t2, j+1, memo));
        memo[i][j] = Math.max(include, exclude);
        return memo[i][j];
    }
}