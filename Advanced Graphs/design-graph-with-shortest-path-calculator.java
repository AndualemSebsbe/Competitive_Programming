class Graph {
    Map<Integer, List<int[]>> graph = new HashMap();
    int n;
    public Graph(int n, int[][] edges) {
        this.n = n;
        for(int[] edge : edges){
            int src = edge[0], dst = edge[1], cost = edge[2];
            if(!graph.containsKey(src))
                graph.put(src, new ArrayList());
            graph.get(src).add(new int[]{dst, cost});
        }
    }
    
    public void addEdge(int[] edge) {
        int src = edge[0], dst = edge[1], cost = edge[2];
        if(!graph.containsKey(src))
            graph.put(src, new ArrayList());
        graph.get(src).add(new int[]{dst, cost});
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{node1, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0], curCost = cur[1];
            
            if(curNode == node2)
                return curCost;

            dist[curNode] = curCost;
            
            if(graph.containsKey(curNode)){
                for(int[] neigh : graph.get(curNode)){
                    int neighNode = neigh[0], neighCost = neigh[1];
                    int newDist = neighCost + curCost;
                    if(dist[neighNode] > newDist)
                        pq.add(new int[]{neighNode, newDist});
                }
            }
        }
        
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */