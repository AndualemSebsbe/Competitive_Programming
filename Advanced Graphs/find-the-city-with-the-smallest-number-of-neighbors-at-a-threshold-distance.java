class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for(int[] edge : edges){
            int src = edge[0], dst = edge[1], weight = edge[2];
            if(!graph.containsKey(src))
                graph.put(src, new ArrayList());
            graph.get(src).add(new int[]{dst, weight});

            if(!graph.containsKey(dst))
                graph.put(dst, new ArrayList());
            graph.get(dst).add(new int[]{src, weight});
        }

        int res = -1, minCount = n;
        for(int i = 0; i < n; i++){
            int count = dijkstra(graph, i, distanceThreshold);
            if(count <= minCount){
                res = i;
                minCount = count;
            }
        }

        return res;
    }

    int dijkstra(Map<Integer, List<int[]>> graph, int src, int disThreshold){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, src});
        Set<Integer> visited = new HashSet();

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int dist = cur[0], node = cur[1];

            if(visited.contains(node))
                continue;
            visited.add(node);

            if(graph.containsKey(node)){
                for(int[] neigh : graph.get(node)){
                    int neighNode = neigh[0], neighWeight = neigh[1];
                    int neighDist = dist + neighWeight;

                    if(neighDist <= disThreshold)
                        pq.add(new int[]{neighDist, neighNode});
                }
            }
        }

        return visited.size() - 1;
    }
}