class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        String res = "";
        Stack<Character> st = new Stack();
        for (int i = 0; i <= n; i++) {
            char c = Integer.toString(i + 1).charAt(0);
            st.add(c);

            while (!st.isEmpty() && 
                (i == n || pattern.charAt(i) == 'I')) {
                    res += st.pop();
            }
        }

        return res;
    }
}