import java.util.Stack;

class dailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int len=temperatures.length;
        int[] day = new int[len];
        st.push(len-1);
        
        for(int i=len-2; i>=0; i--){
             //st.push(i);
            
           if(temperatures[i]>=temperatures[st.peek()]){              
               st.pop();
               if(st.empty()){
                   st.push(i);
               }
               else
               {
                   i++;
               }
           }
           else
            {
                day[i] = st.peek()-i;
                st.push(i);
            }
        }
        
        return day;
    }
}