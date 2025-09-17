class bestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        int profit = 0, len = prices.length;

        for(int i = 0; i < len - 1; i++){
            int j = i;
            while((i < len - 1) && (prices[j] < prices[i + 1])){
                profit = Math.max(profit, (prices[i + 1] - prices[j]));
                i++;
            }
        }
        return profit;
    }
}