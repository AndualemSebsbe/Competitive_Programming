class Solution {
    public int monotoneIncreasingDigits(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % 10);
            n /= 10;
        }

        sb.reverse();
        Stack<Character> st = new Stack();
        char ch = '\0';
        int len = sb.length();
        for(int i = 0; i < len; i++){
            char c = sb.charAt(i);
            if(!st.isEmpty() && c < st.peek()){
                ch = st.pop();
                break;
            }
            
            st.add(c);
        }

        while(!st.isEmpty() && ch == st.peek())
            st.pop();
        
        sb = new StringBuilder();
        int idx = 0;
        if(ch != '\0'){
            sb.append(ch - '1');
            idx += 1;
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
            idx += 1;
        }

        sb.reverse();
        for(int i = idx; i < len; i++)
            sb.append('9');

        int res = 0;
        for(int i = 0; i < len; i++)
            res = res * 10 + (sb.charAt(i) - '0');

        return res;
    }
}