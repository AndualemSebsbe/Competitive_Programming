class Graph {
    Map<Integer, List<int[]>> graph = new HashMap();
    public Graph(int n, int[][] edges) {
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
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, node1});
        Set<Integer> visited = new HashSet();

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cost = cur[0], node = cur[1];

            if(visited.contains(node))
                continue;
            visited.add(node);
            
            if(node == node2)
                return cost;
            
            if(graph.containsKey(node)){
                for(int[] neigh : graph.get(node)){
                    int neighNode = neigh[0], neighCost = neigh[1] + cost;
                    pq.add(new int[]{neighCost, neighNode});
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