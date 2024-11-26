class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            int src = edge[0], dst = edge[1];
            inDegree[dst] += 1;
        }

        int count = 0, res = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                count += 1;
                res = i;
            }
        }

        return count == 1 ? res : -1;
    }
}