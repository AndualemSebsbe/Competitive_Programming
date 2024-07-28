class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;
        long[][] grid = new long[26][26];
        for(int i = 0; i < 26; i++){
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < n; i++){
            int src = original[i] - 'a';
            int dst = changed[i] - 'a';
            grid[src][dst] = Math.min(grid[src][dst], (long) cost[i]);
        }

        for(int i = 0; i < 26; i++){
            grid[i][i] = 0;
        }

        for(int k = 0; k < 26; k++){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 26; j++){
                    grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }

        long res = 0;
        for(int i = 0; i < source.length(); i++){
            int node1 = source.charAt(i) - 'a';
            int node2 = target.charAt(i) - 'a';

            if(grid[node1][node2] >= Integer.MAX_VALUE)
                return -1;
            res += grid[node1][node2];
        }

        return res;
    }
}