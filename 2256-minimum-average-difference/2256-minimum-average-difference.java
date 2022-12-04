class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        
        for(int i = 1; i < n; i++)
            prefix[i] = prefix[i-1] + nums[i];
        
        long[] res = new long[n];
        for(int i = 0; i < n-1; i++){
            long avg1 = prefix[i]/(i+1);
            long avg2 = (prefix[n-1] - prefix[i])/(n-i-1);
            res[i] = Math.abs(avg2 - avg1);
        }
        res[n-1] = prefix[n-1]/n;
        
        long min = res[0];
        int minIndex = 0;
        for(int i = 1; i < n; i++){
            if(min > res[i]){
                min = res[i];
                minIndex = i;
            }
        }
        
        return minIndex;
    }
}