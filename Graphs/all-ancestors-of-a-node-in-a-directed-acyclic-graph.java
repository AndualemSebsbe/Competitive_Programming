class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int[] edge : edges){
            int src = edge[0], dst = edge[1];
            if(!graph.containsKey(src))
                graph.put(src, new ArrayList());
            graph.get(src).add(dst);
        }
        
        for(int i = 0; i < n; i++)
            res.add(new ArrayList());

        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[n];
            dfs(i, i, graph, visited);
        }

        return res;
    }

    void dfs(int val, int cur, Map<Integer, List<Integer>> graph, boolean[] visited){
        if(!graph.containsKey(cur))
            return;

        for(int node : graph.get(cur)){
            if(!visited[node]){
                res.get(node).add(val);
                visited[node] = true;
                dfs(val, node, graph, visited); 
            }
        }
    }
}