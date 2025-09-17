class Solution {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int m = items.length, n = queries.length;
        int[] ans = new int[n];

        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int[][] queriesWithIndices = new int[n][2];
        for (int i = 0; i < n; i++) {
            queriesWithIndices[i][0] = queries[i];
            queriesWithIndices[i][1] = i;
        }

        Arrays.sort(queriesWithIndices, (a, b) -> a[0] - b[0]);

        int itemIdx = 0;
        int maxBeauty = 0;

        for (int i = 0; i < n; i++) {
            int query = queriesWithIndices[i][0];
            int originalIndex = queriesWithIndices[i][1];

            while (itemIdx < m && items[itemIdx][0] <= query) {
                maxBeauty = Math.max(maxBeauty, items[itemIdx][1]);
                itemIdx++;
            }

            ans[originalIndex] = maxBeauty;
        }

        return ans;
    }
}