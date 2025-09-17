class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer[] memo = new Integer[n+1];
        // memo[n] = 1; // if we reach end of string
        return numOfWays(s, 0, memo);
    }

    int numOfWays(String s, int i, Integer[] memo){
        if(memo[i] != null)
            return memo[i];
        if(i == s.length())
            return 1;
        if(s.charAt(i) == '0')
            return 0;
        
        int res = numOfWays(s, i+1, memo);
        if(i+1 < s.length() && (s.charAt(i) == '1' ||
            s.charAt(i) == '2' && s.charAt(i+1) <= '6'))
            res += numOfWays(s, i+2, memo);
        
        memo[i] = res;
        return res;
    }
}