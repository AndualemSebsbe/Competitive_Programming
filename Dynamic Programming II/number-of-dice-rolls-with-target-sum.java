class Solution {
        int mod = 1000000007;
	// memo solution (top down approach)
	public int numRollsToTarget(int n, int k, int target) {
		Integer[][] memo = new Integer[n + 1][target + 1];
		return countWays(n, k, target, memo);        
    }
	
	private int countWays(int n, int k, int target, Integer[][] memo) {
		if(n == 0){
            if(target == 0)
                return 1;
            else
                return 0;
        }

        if(target < 0)
            return 0;
            
		if(memo[n][target] != null)
            return memo[n][target];
		
		int count = 0;
		for(int i = 1; i <= k; i++) {
			count = (count + countWays(n - 1, k, target - i, memo))%mod;
		}
		
		return memo[n][target] = count;
    }
}