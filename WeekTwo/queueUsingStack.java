import java.util.Stack;

class MyQueue {
         
    Stack<Integer> st= new Stack<Integer>();
    Stack<Integer> st1= new Stack<Integer>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
       // MyQueue obj= new MyQueue();
        st.push(x);
    }
    
    public int pop() {
         int i=st.size()-1;
        int j=0;
        int k=0;
        if(st1.empty()){
        while(i >=0){
        st1.push(st.pop());
        //int i = st.pop();
            i--;
            j++;
        }        
          k=(int)st1.pop();
        }
        else
        {
           k=(int)st1.pop();
        }
        return k;
                
    }
    
    public int peek() {
         int i=st.size()-1;
        int j=0;
        int k=0;
        if(st1.empty()){
        while(i >=0){
        st1.push(st.pop());
        //int i = st.pop();
            i--;
            j++;
        }        
         k = (int)st1.peek();
        }
        else
        {
         k = (int)st1.peek();
        }
       return k;
    }
    
    public boolean empty() {
         boolean param = false;
       if(st1.empty()){
         param = (boolean)st.empty();
       }
        else
        {
          param = (boolean)st1.empty(); 
        }
        return param;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */