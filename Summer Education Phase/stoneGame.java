// public class stoneGame {
    // public boolean stoneGame(int[] piles) {
        // return true;
// }
// }
// OR
class stoneGame {
    public boolean stoneGame(int[] piles) {
        int sum = 0, s = 0, e = piles.length-1;
        Integer[][] memo = new Integer[piles.length][piles.length];
        
        for(int pile : piles)
            sum += pile;
        int alice = winner(piles, s, e, memo);
        
        return (sum - alice) < alice;
    }
    
    public int winner(int[] nums, int s, int e, Integer[][] memo){
        if(s == e) return nums[s];
        
        if(memo[s][e] != null)
            return memo[s][e];
        
        int left = nums[s] + winner(nums, s+1, e, memo);
        int right = nums[e] + winner(nums, s, e-1, memo);
        memo[s][e] = Math.max(left, right);
        return memo[s][e];   
    }
}