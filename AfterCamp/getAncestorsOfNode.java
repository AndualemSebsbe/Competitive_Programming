class getAncestorsOfNode {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> toFrom = new HashMap<>();
        Map<Integer, List<Integer>> fromTo = new HashMap<>();
        int[] degree = new int[n];
        
        int src = 0, dst = 0;
        for(int[] edge : edges){
            src = edge[0]; dst = edge[1];
            toFrom.computeIfAbsent(dst, l -> new ArrayList()).add(src);
            fromTo.computeIfAbsent(src, l -> new ArrayList()).add(dst);
            degree[dst]++;
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(degree[i] == 0)
                queue.add(i);
            // bfs(graph,answer, i);
        }
        Map<Integer, Set<Integer>> ancestors = new HashMap();
        
        //now bfs starts
        while(queue.size() > 0){
            Integer curr = queue.poll();
            Set<Integer> ans = new HashSet();
            
            for(int ancestor : toFrom.getOrDefault(curr, new ArrayList<>())){
                ans.add(ancestor);
                ans.addAll(ancestors.getOrDefault(ancestor, new HashSet()));
            }
            
            ancestors.put(curr, ans);
            
            for(int v : fromTo.getOrDefault(curr, new ArrayList<>())){
                degree[v]--;
                if(degree[v] == 0)
                    queue.add(v);
            }
        }
        
        //as the output needs to be given in sorted order, we will sort the ancestors list
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < n; i++){
            Set<Integer> ans = ancestors.get(i);
            List<Integer> sorted = new ArrayList(ans);
            Collections.sort(sorted);
            answer.add(sorted);
        }
        return answer;
    }
}