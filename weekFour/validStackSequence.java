import java.util.Stack;

class validStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        boolean res = false;
        Stack<Integer> st = new Stack<Integer>();
        st.push(pushed[0]);
        int  j=0;
        for(int i=1; i< len; i++){
            while(!st.empty() && popped[j] == st.peek()){
                st.pop();
                j++;
                
            }
            
            st.push(pushed[i]);
        }
        // size of stack
        int stLen = st.size();
        for(int i=0; i< stLen; i++){
            if(st.peek() == popped[j]){
                st.pop();
            }
            else
            {
                 return res;
            }
            j++;
        }
        res = true;
        return res;
    }
}