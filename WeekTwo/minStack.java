import java.util.Stack;

class MinStack {
    Stack<Integer> st;
     Stack<Integer> st1;
     
     public MinStack() {
         Stack<Integer> st = new Stack<>();
         Stack<Integer> st1 = new Stack<>();
         this.st = st;
         this.st1 = st1;
     }
     
     public void push(int val) {
         st.push(val);
     }
     
     public void pop() {
         st.pop();
     }
     
     public int top() {
         
         return st.peek();
     }
     
     public int getMin() {
         while(!st.empty()){
         st1.push(st.pop());
         }
         int len = st1.size();
         int k=0;
         int[] nums = new int[len];
         while(!st1.empty()){
             st.push(st1.peek());
             nums[k++] = st1.pop();
         }
         int min= nums[0];
        for(int i=0; i< len; i++){
            if(min > nums[i]){
                min = nums[i];
            }
        }
          
         return min;
     }
 }
 
 /**
  * Your MinStack object will be instantiated and called as such:
  * MinStack obj = new MinStack();
  * obj.push(val);
  * obj.pop();
  * int param_3 = obj.top();
  * int param_4 = obj.getMin();
  */