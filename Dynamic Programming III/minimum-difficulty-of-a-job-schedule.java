class Solution {
    Integer[][][] memo = new Integer[301][11][1001];
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d)
            return -1;
        
        return dfs(jobDifficulty, 0, d, -1);
    }

    int dfs(int[] jobDifficulty, int i, int d, int curMax){
        if(i == jobDifficulty.length){
            if(d == 0)
                return 0;
            else 
                return 300001; // max value
        }

        if(d == 0)
            return 300001;
        
        curMax = Math.max(curMax, jobDifficulty[i]);
        if(memo[i][d][curMax] != null)
            return memo[i][d][curMax];

        int res = Math.min(dfs(jobDifficulty, i + 1, d, curMax),
            curMax + dfs(jobDifficulty, i + 1, d - 1, -1));
        
        memo[i][d][curMax] = res;
        return res;
    }
}