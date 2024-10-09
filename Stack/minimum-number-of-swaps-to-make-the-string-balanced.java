class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack();
        int imbalanceCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '[')
                st.add(c);
            else {
                if (!st.isEmpty())
                    st.pop();
                else
                    imbalanceCount += 1;
            }
        }
        
        return (imbalanceCount + 1) / 2;
    }
}