class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] memo = new Boolean[n+1][m+1];
        return isExpressionMatch(s, p, 0, 0, memo);
    }
    
    public boolean isExpressionMatch(String s, String p, int i, int j,Boolean[][] memo){
        if(i >= s.length() && j >= p.length())
            return true;
        if(j >= p.length())
            return false;

        if(memo[i][j] != null)
            return memo[i][j];
        
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) 
                                               || p.charAt(j) == '.');
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            memo[i][j] = (match && isExpressionMatch(s, p, i+1, j, memo)) 
                   || isExpressionMatch(s, p, i, j+2, memo);
            return memo[i][j];
        }
        
        if(match)
            return memo[i][j] = isExpressionMatch(s, p, i+1, j+1, memo);
      memo[i][j] = false;
      return memo[i][j];  
    }
}