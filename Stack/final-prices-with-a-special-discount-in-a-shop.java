class Solution {

    public int[] finalPrices(int[] prices) {
        int[] res = prices.clone();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[st.peek()] >= prices[i])
                res[st.pop()] -= prices[i];

            st.add(i);
        }

        return res;
    }
}