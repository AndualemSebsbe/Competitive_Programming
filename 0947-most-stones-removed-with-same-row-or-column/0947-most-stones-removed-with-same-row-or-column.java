class Solution {
    class UnionFind {
        int[] parent;
        int[] height;
        
        UnionFind(int n) {
            this.parent = new int[n];
            this.height = new int[n];
            
            Arrays.fill(height, 1);
            Arrays.fill(parent, -1);
        }
        
        public int findRoot(int node) {
            if(parent[node] == -1) return node;
            return (parent[node] = findRoot(parent[node]));
        }
        
        public void union(int node1, int node2) {
            int parent1 = findRoot(node1);
            int parent2 = findRoot(node2);
            
            if(parent1 != parent2) {
                if(height[parent1] < height[parent2]) 
                    parent[parent1] = parent2;
                
                else if(height[parent1] > height[parent2])
                    parent[parent2] = parent1;
                
                else {
                    parent[parent2] = parent1;
                    height[parent1] ++;
                }
            }
        }
    }
    
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(20005);
        
        for(int[] stone : stones) {
            uf.union(stone[0], 10001 + stone[1]);
        }
        
        Set<Integer> set = new HashSet<>();
        for(int[] stone : stones) {
            set.add(uf.findRoot(stone[0]));
        }
        
        return stones.length - set.size();
    }
}