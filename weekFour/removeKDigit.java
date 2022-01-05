import java.util.Stack;

class removeKDigit {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len == k) return "0";
        Stack<Character> st = new Stack();
        StringBuilder sb = new StringBuilder();
       int count = 0;
     while(count< len){
     while(k>0 && !st.empty() && st.peek() > num.charAt(count)){
            st.pop();
            k--;
        }
         
       st.push(num.charAt(count));
            count++;
        }
        //"1000200" k=3
       while(k > 0){
             st.pop();
             k--;
         }
        while(!st.empty()){
            sb.append(st.pop());
        }
        sb.reverse();
        
        while(sb.length() >1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}