class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        
        int maxArea = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1')
                    heights[j] = heights[j] + 1;
                else
                    heights[j] = 0;
            }
            
            maxArea = Math.max(maxArea, laregestRectangle(heights));
        }
        
        return maxArea;
    }
    
    public int laregestRectangle(int[] heights){
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