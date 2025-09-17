class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] indegree = new int[n];
        for(int[] road : roads){
            int src = road[0], dst = road[1];
            indegree[src] += 1;
            indegree[dst] += 1;
        }

        Arrays.sort(indegree);
        reverse(indegree);
        int value = n;
        long res = 0;
        for(int i = 0; i < n; i++){
            res += ((long)indegree[i] * (long)value);
            value -= 1;
        }

        return res;
    }

    void reverse(int[] indegree){
        int l = 0, r = indegree.length - 1;
        while(l < r){
            int temp = indegree[l];
            indegree[l++] = indegree[r];
            indegree[r--] = temp;
        }
    }
}