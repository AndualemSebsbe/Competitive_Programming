class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        
        return solve(0, 0, m-1, n-1, memo);
    }
    
    public int solve(int i, int j, int m, int n, Integer[][] memo){
        if(i == m+1 || j == n+1)
            return 0;
        if(i == m && j == n)
            return 1;
        
        if(memo[i][j] != null)
            return memo[i][j];
        
        memo[i][j] = solve(i+1, j, m, n, memo) + solve(i, j+1, m, n, memo);
        return memo[i][j];
    }
}