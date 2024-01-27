class Solution {
    int mod = 1000_000_007;
    Map<String, Integer> memo = new HashMap();
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove < 0)
            return 0;
        if(startRow >= m || startRow < 0 || startColumn >= n ||
        startColumn < 0)
            return 1;

        String key = startRow + "," + startColumn + "," + maxMove;
        if(memo.containsKey(key))
            return memo.get(key);
            
        int count = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int[] dir : dirs){
            int newR = startRow + dir[0];
            int newC = startColumn + dir[1];

            count = 
                (count + findPaths(m, n, maxMove - 1, newR, newC))%mod;
        }

        memo.put(key, count);
        return count;
    }
}