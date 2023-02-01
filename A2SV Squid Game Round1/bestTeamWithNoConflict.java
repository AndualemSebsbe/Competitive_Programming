import java.util.Arrays;

class bestTeamWithNoConflit {
    Integer memo[];
    int max;
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] players = new int[n][2];
        
        for(int i = 0; i < n; i++){
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }
        
        Arrays.sort(players, (a, b) -> a[0] == b[0] ? 
        a[1]-b[1] : a[0]-b[0]);
        
        memo = new Integer[n];
        
        for(int i = 0; i < n; i++)
            max = Math.max(max, dfs(i, players));
        
        return max;
    }
    
    public int dfs(int idx, int[][] players) {
        if(memo[idx] != null) 
            return memo[idx];
        
        memo[idx] = players[idx][1];
        for(int i = idx+1; i < players.length; i++) {
            if(players[i][1] >= players[idx][1]) {
                memo[idx] = Math.max(memo[idx], 
                        dfs(i, players) + players[idx][1]);
            }
        }
        
        return memo[idx];
    }
}
