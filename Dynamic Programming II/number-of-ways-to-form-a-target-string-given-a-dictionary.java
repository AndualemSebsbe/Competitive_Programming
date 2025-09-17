class Solution {
    int mod = (int)1e9 + 7;
    public int numWays(String[] words, String target) {
        int n = words.length, k = words[0].length();
        long[][] count = new long[k][26];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < k; j++)
                count[j][words[i].charAt(j) - 'a'] += 1;

        int t = target.length();
        Integer[][] memo = new Integer[t][k];
        return dfs(words, count, 0, 0, target, memo);
    }

    int dfs(String[] words, long[][] count, int i, int k, 
        String t, Integer[][] memo){
        if(i == t.length())
            return 1;
        if(k >= words[0].length())
            return 0;
        
        if(memo[i][k] != null)
            return memo[i][k];
        
        int idx = t.charAt(i) - 'a';
        memo[i][k] = dfs(words, count, i, k+1, t, memo) % mod +
            (int)(count[k][idx] * 
                dfs(words, count, i+1, k+1, t, memo) % mod);

        return memo[i][k] % mod;
    }
}