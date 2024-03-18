class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        int start = newInterval[0], end = newInterval[1];
        while(i < n && intervals[i][1] < start)
            ans.add(intervals[i++]);

        int[] mergedInterval = new int[]{start, end};
        while(i < n && intervals[i][0] <= end){
            mergedInterval[0] = Math.min(mergedInterval[0], intervals[i][0]);
            mergedInterval[1] = Math.max(mergedInterval[1], intervals[i][1]);
            i += 1;
        }

        ans.add(mergedInterval);

        while(i < n)
            ans.add(intervals[i++]);
    
        return ans.toArray(new int[ans.size()][]);
    }
}
