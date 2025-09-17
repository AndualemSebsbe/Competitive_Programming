class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1)
            return Arrays.asList(0);

        Map<Integer, List<Integer>> graph = new HashMap();
        int[] inDegree = new int[n];
        for(int[] edge : edges){
            int src = edge[0], dst = edge[1];
            if(!graph.containsKey(src))
                graph.put(src, new ArrayList());
            graph.get(src).add(dst);
            inDegree[src] += 1;

            if(!graph.containsKey(dst))
                graph.put(dst, new ArrayList());
            graph.get(dst).add(src);
            inDegree[dst] += 1;
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 1)
                queue.add(i);
        }

        while(n > 2){
            int size = queue.size();
            while(size-- > 0){
                int node = queue.poll();
                n -= 1;
                if(graph.containsKey(node)){
                    for(int neigh : graph.get(node)){
                        if(inDegree[neigh] == 0)
                            continue;

                        inDegree[node] -= 1;
                        inDegree[neigh] -= 1;
                        if(inDegree[neigh] == 1)
                            queue.add(neigh);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList();
        while(!queue.isEmpty())
            res.add(queue.poll());
        
        return res;
    }
}