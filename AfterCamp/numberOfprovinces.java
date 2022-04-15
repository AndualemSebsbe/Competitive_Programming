class numberOfProvinces {
    
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);
        
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(isConnected[i][j] == 1)
                   uf.union(i, j);
            }
        }
        return uf.numOfProvinces;
    }
}

public class UnionFind{
    int[] parents;
    int[] size;
    int numOfProvinces = 0;
    
    public UnionFind(int n){
        parents = new int[n];
        size = new int[n];
        
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
            size[i] = i;
            numOfProvinces = n;
        }
    }
    
    public int find(int v){
        if(v == parents[v])
            return v;
        return parents[v] = find(parents[v]);
    }

    public void union(int a, int b){
       int aParent = find(a);
       int bParent = find(b);
        
        if(aParent == bParent)
            return;
        if(size[aParent] > size[bParent]){
            parents[bParent] = aParent;
            size[aParent] += size[bParent];
        }
        else{
            parents[aParent] = bParent;
            size[bParent] += size[aParent];
        }
        numOfProvinces--;
    }
}