class Solution {
    public int findCenter(int[][] edges) {
        int[] degree = new int[100001];
        for(int[] edge : edges){
            int src = edge[0], dst = edge[1];
            degree[src] += 1;
            degree[dst] += 1;
        }

        // number of nodes
        int n = edges.length + 1;
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == n - 1)
                return i;
        }

        return -1;
    }
}