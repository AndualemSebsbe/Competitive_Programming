class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList();
        Map<Integer, Boolean> map = new HashMap();
        for(int i = 0; i < graph.length; i++)
            if(dfs(graph, i, map))
                res.add(i);
        return  res;
    }

    boolean dfs(int[][] graph, int i, Map<Integer, Boolean> map){
        if(map.containsKey(i))
            return map.get(i);
        
        map.put(i, false);
        for(int neigh : graph[i]){
            if(!dfs(graph, neigh, map))
                return map.get(i);
        }

        map.put(i, true);
        return map.get(i);
    }
}