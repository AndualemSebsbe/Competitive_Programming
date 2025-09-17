class maximumAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(row*col);
        boolean firstTime = true;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    if(firstTime){
                        uf.maxArea = 1;
                        firstTime = false;
                    }
                    if(i+1 < row && grid[i+1][j]==1){uf.union(i*col+j, (i+1)*col+j);}
                    if(j+1 < col && grid[i][j+1]==1){uf.union(i*col+j, i*col+j+1);}
                }
            }
        }
        return uf.maxArea;
    }
}

 class UnionFind{
    int[] parents;
    int[] size;
    int maxArea;
    public UnionFind(int n){
        parents = new int[n];
        size = new int[n];
        maxArea = 0;
        
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int v){
        if(v == parents[v])
            return v;
        return parents[v] = find(parents[v]);
    }
    
    public int findComponentsSize(int curr){
        int parent = find(curr);
        return size[parent];
    }
    
    public void union(int a, int b){
       int aParent = find(a);
       int bParent = find(b);
        
        if(aParent == bParent)
            return;
        if(size[aParent] > size[bParent]){
            parents[bParent] = aParent;
            size[aParent] += size[bParent];
            maxArea = Math.max(maxArea, size[aParent]);
        }
        else{
            parents[aParent] = bParent;
            size[bParent] += size[aParent];
            maxArea = Math.max(maxArea, size[bParent]);
        }      
    }
}