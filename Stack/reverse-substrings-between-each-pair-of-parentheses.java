class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack();
        for(char c : s.toCharArray()){
            if(c == '(')
                st.add('(');
            else if( c == ')'){
                String temp = "";
                while(st.peek() != '(')
                    temp += st.pop();
                st.pop();

                for(char ch : temp.toCharArray())
                    st.push(ch);
            }
            else
                st.push(c);
        }

        String str = "";
        while(!st.isEmpty())
            str += st.pop();
        
        String rev = "";
        int n = str.length();
        for(int i = n - 1; i >= 0; i--)
            rev += str.charAt(i);
        
        return rev;
    }
}