import java.util.Stack;

public class reverseSubstring {
     
        public String reverseParentheses(String s) {
            int len = s.length();
            Stack<Integer> st = new Stack<>();
            for(int i=0; i<len; i++){
           // Push the index of the current
          // opening bracket
          if (s.charAt(i) == '(')
          {
            st.push(i);
          }
           
          // Reverse the substring starting
          // after the last encountered opening
          // bracket till the current character
          else if (s.charAt(i) == ')')
          {
            char[] ch = s.toCharArray();
            reverse(ch, st.peek() + 1, i);
            s = String.copyValueOf(ch); //Convert array of char to String
            st.pop();
          }  
        }
           // To store the modified string
        String res = "";
        for (int i = 0; i < len; i++)
        {
          if (s.charAt(i) != ')' && s.charAt(i) != '(')
          {
            res += (s.charAt(i));
          }
        }  
         return res;
        }
       public void reverse(char A[], int l, int h) {
        if (l < h){
          char ch = A[l];
          A[l] = A[h];
          A[h] = ch;
          reverse(A, l + 1, h - 1);
        }
      }
        
    }
