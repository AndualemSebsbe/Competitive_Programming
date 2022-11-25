class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        Stack<Integer> st = new Stack();
        
        for(int i = 0; i <= n; i++){
            
            while(!st.empty() && (i == n || heights[i] < heights[st.peek()])){
                int temp = heights[st.pop()];
                int width = 0;
                
                if(st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                max = Math.max(max, temp * width);
            }
            st.push(i);
        }
        
        return max;
    }
}