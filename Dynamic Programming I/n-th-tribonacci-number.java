class Solution {
    public int tribonacci(int n) {
        Integer[] memo = new Integer[n+1];

        return trib(n, memo);
    }

    int trib(int n, Integer[] memo){
        if(n == 0 || n == 1)
            return n;
        if(n == 2)
            return 1;
        
        if(memo[n] != null)
            return memo[n];

        memo[n] = trib(n-3, memo) + trib(n-2, memo) + 
                trib(n-1, memo);
        return memo[n];
    }
} 