class Solution {
    public int numSquares(int n) {
       Integer[] memo = new Integer[n+1];
       return solve(n, memo);
    }
    
    public int solve(int n, Integer[] memo){
        if(n <= 3)
            return n;
        
        if(memo[n] != null)
            return memo[n];
        
        int min = n;
        for(int i = 1; i*i <= n; i++)
            min = Math.min(min, 1 + solve(n-i*i, memo));
        
        memo[n] = min;
        return memo[n];
    }
}