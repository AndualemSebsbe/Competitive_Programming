class Solution {
    class UnionFind {
        int[] parent;
        int[] height;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.height = new int[n];

            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int node) {
            if (parent[node] == node)
                return node;
            return parent[node] = find(parent[node]);
        }

        void union(int node1, int node2) {
            int par1 = find(node1);
            int par2 = find(node2);

            if (par1 != par2){    
                if (height[par1] < height[par2])
                    parent[par1] = par2;
                else if (height[par1] > height[par2])
                    parent[par2] = par1;
                else {
                    parent[par2] = par1;
                    height[par1] += 1;
                }
            }

        }
    }
    
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(20002);
        
        for(int[] stone : stones)
            uf.union(stone[0], 10001 + stone[1]);
        
        Set<Integer> set = new HashSet<>();
        for(int[] stone : stones)
            set.add(uf.find(stone[0]));
        
        return stones.length - set.size();
    }
}