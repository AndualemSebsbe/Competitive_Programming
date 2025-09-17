class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> ans = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            if(ans.size() == 0 || intervals[i][0] > ans.get(ans.size() - 1)[1]){
                ans.add(intervals[i]);
            }
            else{
                int prevIdx = ans.size() - 1;
                int start = ans.get(prevIdx)[0];
                int maxEnd = Math.max(ans.get(prevIdx)[1], intervals[i][1]);
                ans.set(prevIdx, new int[]{start, maxEnd});
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}