class Solution {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        Stack<Character> st = new Stack();
        if(x > y){
            for(char c : s.toCharArray()){
                if(c == 'b' && !st.empty() && st.peek() == 'a'){
                    res += x;
                    st.pop();
                }
                else
                    st.add(c);
            }

            String str = "";
            while(!st.empty())
                str += st.pop();
            
            char[] ch = str.toCharArray();
            reverse(ch);
            for(char c : ch){
                if(c == 'a' && !st.empty() && st.peek() == 'b'){
                    res += y;
                    st.pop();
                }
                else
                    st.add(c);
            }
        }
        else {
            for(char c : s.toCharArray()){
                if(c == 'a' && !st.empty() && st.peek() == 'b'){
                    res += y;
                    st.pop();
                }
                else
                    st.add(c);
            }

            String str = "";
            while(!st.empty())
                str += st.pop();
            
            char[] ch = str.toCharArray();
            reverse(ch);

            for(char c : ch){
                if(c == 'b' && !st.empty() && st.peek() == 'a'){
                    res += x;
                    st.pop();
                }
                else
                    st.add(c);
            }
        }

        return res;
    }

    void reverse(char[] ch){
        int l = 0, r = ch.length - 1;
        while(l < r){
            char temp = ch[l];
            ch[l++] = ch[r];
            ch[r--] = temp;
        }
    }
}