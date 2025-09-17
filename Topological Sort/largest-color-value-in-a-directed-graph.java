class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> graph = new HashMap();
        int[] inDegree = new int[n];

        for(int[] edge : edges){
            int src = edge[0], dst = edge[1];
            if(!graph.containsKey(src))
                graph.put(src, new ArrayList());
            graph.get(src).add(dst);
            inDegree[dst] += 1;
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }

        int[][] counts = new int[n][26];
        for(int i = 0; i < n; i++){
            counts[i][colors.charAt(i) - 'a'] += 1;
        }

        int maxCount = 0, visited = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            visited += 1;
            if(graph.containsKey(u)){
                for(int v : graph.get(u)){
                    for(int i = 0; i < 26; i++)
                        counts[v][i] = Math.max(counts[v][i], counts[u][i] + (colors.charAt(v) - 'a' == i ? 1 : 0));
                    
                    inDegree[v] -= 1;
                    if(inDegree[v] == 0)
                        queue.add(v);
                }
            }
            
            int curMaxCount = 0;
            for(int i = 0; i < 26; i++)
                curMaxCount = Math.max(curMaxCount, counts[u][i]);
            maxCount = Math.max(maxCount, curMaxCount);
        }

        return visited == n ? maxCount : -1;
    }
}