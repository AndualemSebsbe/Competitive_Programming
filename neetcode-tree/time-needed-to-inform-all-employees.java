class Solution {
    int res = 0;
    public int numOfMinutes(int n, int headID, int[] manager, 
        int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int i = 0; i < n; i++){
            if(!graph.containsKey(manager[i]))
                graph.put(manager[i], new ArrayList());
            graph.get(manager[i]).add(i);
        }

        return dfs(graph, headID, informTime);
    }

    int dfs(Map<Integer, List<Integer>> map, int cur, int[] informTime){
        int max = 0;
        if(informTime[cur] == 0)
            return max;

        for(int sub : map.get(cur))
            max = Math.max(max, dfs(map, sub, informTime));

        return max + informTime[cur];
    }
}