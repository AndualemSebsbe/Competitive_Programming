class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, List<Integer>> rowGraph = buildGraph(rowConditions);
        Map<Integer, List<Integer>> colGraph = buildGraph(colConditions);

        List<Integer> rowTopo = topoSort(k, rowGraph);
        List<Integer> colTopo = topoSort(k, colGraph);

        int m = rowTopo.size(), n = colTopo.size();
        if(m == 0 || n == 0)
            return new int[0][0];
        
        fillTopoArray(k, rowTopo);
        fillTopoArray(k, colTopo);

        m = rowTopo.size(); n = colTopo.size();
        int[] colIdx = new int[k + 1];
        for(int col = 0; col < n; col++)
            colIdx[colTopo.get(col)] = col;
        
        int[][] matrix = new int[k][k];
        for(int i = 0; i < m; i++){
            int col = colIdx[rowTopo.get(i)];
            matrix[i][col] = rowTopo.get(i);
        }

        return matrix;
    }

    Map<Integer, List<Integer>> buildGraph(int[][] conditions){
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int[] condition : conditions){
            int src = condition[0], dst = condition[1];
            if(!graph.containsKey(src))
                graph.put(src, new ArrayList());
            graph.get(src).add(dst);
        }

        return graph;
    }

    List<Integer> topoSort(int k, Map<Integer, List<Integer>> graph){
        int[] inDegree = new int[k + 1];
        for(int node = 1; node <= k; node++){
            if(graph.containsKey(node)){
                for(int neigh : graph.get(node)){
                    inDegree[neigh] += 1;
                }
            }
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 1; i <= k; i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }

        List<Integer> topoSort = new ArrayList();
        boolean[] visited = new boolean[k + 1];
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int cur = queue.poll();
                visited[cur] = true;
                topoSort.add(cur);

                if(graph.containsKey(cur)){
                    for(int neigh : graph.get(cur)){
                        if(!visited[neigh]){
                            inDegree[neigh] -= 1;
                            if(inDegree[neigh] == 0)
                                queue.add(neigh);
                        }
                    }
                }
            }
        }

        for(int i = 1; i <= k; i++){
            if(inDegree[i] != 0)
                return new ArrayList();
        }

        return topoSort;
    }

    void fillTopoArray(int k, List<Integer> topo){
        boolean[] visited = new boolean[k + 1];
        for(int num : topo)
            visited[num] = true;
        
        for(int i = 1; i <= k; i++){
            if(!visited[i])
                topo.add(i);
        }
    }
}