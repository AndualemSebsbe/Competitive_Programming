class Solution {
    Integer[] dp = new Integer[50001];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++)
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        for(int i = 0; i < n; i++)
            startTime[i] = jobs[i][0];

        return findMaxProfit(jobs, startTime, 0, n);
    }

    int findMaxProfit(int[][] jobs, int[] startTime, int idx, int n){
        if(idx == n)
            return 0;
        
        if(dp[idx] != null)
            return dp[idx];
        
        int nextIdx = binarySearch(startTime, jobs[idx][1]);
        
        int pick = jobs[idx][2] + findMaxProfit(jobs, startTime, nextIdx, n);
        int dontPick = findMaxProfit(jobs, startTime, idx + 1, n);
        int max = Math.max(pick, dontPick);

        return dp[idx] = max;
    }

    int binarySearch(int[] startTime, int endIdx){
        int l = 0, r = startTime.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(startTime[mid] >= endIdx)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return l;
    }
}