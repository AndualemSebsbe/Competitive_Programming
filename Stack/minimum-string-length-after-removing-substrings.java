class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack();

        for (char curChar : s.toCharArray()) {
            if (st.isEmpty()) {
                st.add(curChar);
                continue;
            }

            if (curChar == 'B' && st.peek() == 'A')
                st.pop();
            else if (curChar == 'D' && st.peek() == 'C')
                st.pop();
            else
                st.add(curChar);
        }

        return st.size();
    }
}