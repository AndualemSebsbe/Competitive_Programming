class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int sum = prices[0] + prices[1];
        if(money >= sum)
            money -= sum;
        
        return money;
    }
}