class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        
        for(int[] req : requests){
            prefixSum[req[0]] += 1;
            if(req[1] + 1 < n)
                prefixSum[req[1]+1] -= 1;
        }
        
        for(int i = 1; i < n; i++)
            prefixSum[i] += prefixSum[i-1];
        
        Arrays.sort(nums);
        Arrays.sort(prefixSum);
        
        long res = 0;
        int mod = 1000000007;
        for(int i = 0; i < n; i++){
            long val = (long)prefixSum[i] * (long)nums[i];
            res += val;
            res %= mod;
        }
        
        return (int)res;
    }
}