class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Set<Integer> visited = new HashSet();
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited.contains(grid[i][j]))
                    ans[0] = grid[i][j];
                visited.add(grid[i][j]);
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (!visited.contains(i))
                ans[1] = i;
        }

        return ans;
    }
}