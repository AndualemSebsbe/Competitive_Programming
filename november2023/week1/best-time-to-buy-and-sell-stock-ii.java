class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] memo = new Integer[n][2];
        return profit(prices, 0, 0, memo);
    }

    public int profit(int[] prices, int i, int buy, Integer[][] memo){
        if(i >= prices.length)
            return 0;
        
        if(memo[i][buy] != null)
            return memo[i][buy];

        int include = 0, exclude = 0;
        if(buy == 1){
            include = prices[i] + profit(prices, i+1, 0, memo);
            exclude = profit(prices, i+1, 1, memo);
            memo[i][buy] = Math.max(include, exclude);
            return memo[i][buy];
        }
        else{
            memo[i][buy] = Math.max(-prices[i] + profit(prices, i+1, 1, memo),
             profit(prices, i+1, 0, memo));
            return memo[i][buy];
        }
    }
}