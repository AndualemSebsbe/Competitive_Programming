class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        Set<String> set = new HashSet();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for(String token : tokens){
            if(set.contains(token)){
                int num2 = st.pop();
                int num1 = st.pop();

                if(token.equals("+"))
                    st.add(num1+num2);
                else if(token.equals("-"))
                    st.add(num1-num2);
                else if(token.equals("*"))
                    st.add(num1*num2);
                else
                    st.add(num1/num2);
            }
            else
                st.add(Integer.valueOf(token));            
        }

        return st.peek();
    }
}