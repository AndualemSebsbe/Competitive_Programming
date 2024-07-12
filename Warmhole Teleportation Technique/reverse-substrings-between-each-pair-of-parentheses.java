class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack();
        int[] oppIdx = new int[n];
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(')
                st.add(i);
            else if(c == ')'){
                int open = st.pop(), closed = i;
                oppIdx[open] = closed;
                oppIdx[closed] = open;
            }
        }

        int dir = 1;
        String res = "";
        for(int i = 0; i < n; i += dir){
            char c = s.charAt(i);
            if(c == '(' || c == ')'){
                i = oppIdx[i];
                dir *= -1;
            }
            else
                res += c;
        }

        return res;
    }
}