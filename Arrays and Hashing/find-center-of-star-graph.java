class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] degree = new int[100001];
        Set<Integer> set = new HashSet();
        for(int[] edge : edges){
            int src = edge[0], dst = edge[1];
            degree[src] += 1;
            degree[dst] += 1;
            set.add(src);
            set.add(dst);
        }

        int count = set.size();
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == count - 1)
                return i;
        }

        return -1;
    }
}