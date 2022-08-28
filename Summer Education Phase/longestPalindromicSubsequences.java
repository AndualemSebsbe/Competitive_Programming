public class longestPalindromicSubsequences {

    public int longestPalindromeSubseq(String s) {
        StringBuilder revSb = new StringBuilder(s);
        revSb.reverse();
        String str = revSb.toString();
        int idx1 = s.length(), idx2 = str.length();
        int[][] dp = new int[idx1+1][idx2+1];
        
        for(int i = 1; i < idx1+1; i++){
            for(int j = 1; j < idx2+1; j++){
                if(s.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[idx1][idx2];
    }
}