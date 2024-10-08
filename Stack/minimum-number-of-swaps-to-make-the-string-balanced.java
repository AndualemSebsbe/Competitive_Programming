class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == '[' && c == ']')
                st.pop();
            else
                st.add(c);
        }

        int imbalancePair = st.size() / 2;

        return (imbalancePair + 1) / 2;
    }
}