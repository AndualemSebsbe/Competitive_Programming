class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> op = new Stack();
        Stack<Character> st = new Stack();
        for (char c : expression.toCharArray()) {

            if (c == '&' || c == '|' || c == '!')
                op.add(c);
            else if (c == ')') {
                boolean res = st.pop() == 't';
                while (st.peek() == ',') {
                    st.pop();
                    boolean val = st.pop() == 't';
                    if (op.peek() == '&')
                        res = res && val;
                    else 
                        res = res || val;
                }

                if (st.peek() == '(')
                    st.pop();
                if (op.peek() == '!')
                    res = !res;
                
                if (res)
                    st.add('t');
                else
                    st.add('f');

                op.pop();
            }
            else
                st.add(c);
        }

        return st.pop() == 't';
    }
}