class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        return dfs(-1, 0, adj, hasApple);
    }

    int dfs(int prev,int curr, List<Integer>[] adj, List<Boolean> hasApple){
        int ans = 0;
        for(int child : adj[curr]){
            if(child != prev){
               int res = dfs(curr, child, adj, hasApple);
               if(res > 0 || hasApple.get(child))
                   ans += (res+2);
            }
        }
        return ans;
    }
}