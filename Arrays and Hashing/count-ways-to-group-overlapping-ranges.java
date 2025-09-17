class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));
        int countMergedRanges = 0;

        int n = ranges.length;
        int maxEnd = ranges[0][1];
        for(int i = 0; i < n; i++){
            if(i == 0 || ranges[i][0] > maxEnd){
                countMergedRanges += 1;
                maxEnd = ranges[i][1];
            }
            else 
                maxEnd = Math.max(maxEnd, ranges[i][1]);
        }

        n = countMergedRanges;
        int mod = 1000_000_007;
        int total = 1;
        for(int i = 0; i < n; i++){
            total = (total * 2) % mod;
        }

        return total;
    }
}