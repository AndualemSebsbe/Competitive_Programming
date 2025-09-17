class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack();
        for(char c : num.toCharArray()){
            while(!st.isEmpty() && c < st.peek() && k > 0){
                st.pop();
                k -= 1;
            }

            st.add(c);
        }

        while(k-- > 0)
            st.pop();
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        
        sb.reverse();
        int n = sb.length();
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(sb.charAt(i) != '0')
                break;
            idx += 1;
        }

        String res = sb.substring(idx).toString();

        return res.length() == 0 ? "0" : res;
    }
}
//"1000200" k=3 