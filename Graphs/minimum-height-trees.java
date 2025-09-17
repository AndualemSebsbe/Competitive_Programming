class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] degree = new int[n];
        if(n == 1)
            list.add(0);
        if(n == 1) return list;
        
        int src = 0, dst = 0;
         for(int[] edge : edges){
             src = edge[0]; dst = edge[1];
             degree[src] += 1;
             degree[dst] += 1;

             if(!graph.containsKey(src))
                graph.put(src, new ArrayList());
             graph.get(src).add(dst);

            if(!graph.containsKey(dst))
                graph.put(dst, new ArrayList());
             graph.get(dst).add(src);
         }
        
        Queue<Integer> leaves = new LinkedList();
        
        for(int i = 0; i < n; i++){
            if(degree[i] == 1)
                leaves.add(i);
        }
        
        while(n > 2){
            int size = leaves.size();
            n -= size;
            
            while(size-- > 0){
                Integer leaf = leaves.remove();
                for(Integer val : graph.get(leaf)){
                    degree[val] -= 1;
                    if(degree[val] == 1)
                        leaves.add(val);
                }
            }
        }
        
        return new ArrayList<>(leaves);
    }
}