import java.util.Stack;

class largestRectangle {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxValue = 0;
        // int num = 0, maxValue = 0, pro = 0, val = 0;
        
        if(len==1) return heights[0];
        Stack<Integer> st = new Stack<>();
           st.add(0);
        for(int i=1; i<len ; i++){
            int curr = heights[i];
            if(curr >= heights[st.peek()]){
                st.add(i);
            }
            else {
          while(!st.empty() && curr < heights[st.peek()]){
               int temp = heights[st.pop()];
                if(st.empty()){
                    maxValue = Math.max(maxValue, temp*i);
                }
            else {
                maxValue = Math.max(maxValue, temp*(i-st.peek()-1));
            }
            
            }  
                st.add(i);
            }
        }
     if(!st.empty()){
         int i = heights.length;
         while(!st.empty()){
               int temp = heights[st.pop()];
                if(st.empty()){
                    maxValue = Math.max(maxValue, temp*i);
                }
           else {
                maxValue = Math.max(maxValue, temp*(i-st.peek()-1));
            }
            
            }  
            }
            
        
      return maxValue;  
    }
}