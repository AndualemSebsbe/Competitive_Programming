class minCostConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
      PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        UnionFind uf = new UnionFind(points.length);
        
        int d = 0;
        for(int i = 0; i < points.length; i++){
           for(int j = i + 1; j < points.length; j++){
               d = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
               pq.add(new int[]{d, i, j});
           }
        }
        
        int res = 0;
        while(pq.size() > 0){
            int[] curr = pq.poll();
            
            if(uf.find(curr[1]) != uf.find(curr[2])){
                uf.union(curr[1], curr[2]);
                res += curr[0];
            }
        }
        return res;
    }
}

class UnionFind {
    int[] parents;
    int[] size;
    
    public UnionFind(int n){
        parents = new int[n];
        size = new int[n];
        
        for(int i = 0; i <n; i++){
            parents[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int curr){
        if(curr == parents[curr])
            return curr;
        return parents[curr] = find(parents[curr]);
    }
    
    public void union(int n1, int n2){
       int p1 = find(n1);
       int p2 = find(n2);
        
        if(p1 == p2)
            return;
        if(size[p1] > size[p2]){
            parents[p2] = p1;
            size[p1] += size[p2];
            size[p2] = 1;
        }
        else{
            parents[p1] = p2;
            size[p2] += size[p1];
            size[p1] = 1;
        }
    }
    
}