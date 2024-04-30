class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        Map<Integer, List<int[]>> graph = new HashMap();
        
        for(int[] edge : edges){
            int src = edge[0], dst = edge[1], time = edge[2];
            if(!graph.containsKey(src))
                graph.put(src, new ArrayList());
            graph.get(src).add(new int[]{dst, time});

            if(!graph.containsKey(dst))
                graph.put(dst, new ArrayList());
            graph.get(dst).add(new int[]{src, time});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{0, 0});

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        boolean[] visited = new boolean[n];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int curNode = curr[0], curTime = curr[1];

            if(visited[curNode] || curTime >= disappear[curNode])
                continue;
            
            dist[curNode] = curTime;
            visited[curNode] = true;

            if(graph.containsKey(curNode)){
                for(int[] neigh : graph.get(curNode)){
                    int neighNode = neigh[0], neighTime = neigh[1];
                    if(!visited[neighNode])
                        pq.add(new int[]{neighNode, neighTime + curTime});
                }
            }
        }

        return dist;
    }
}