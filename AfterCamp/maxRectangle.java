package AfterCamp;
import java.util.Stack;

class maxRectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        int[][] dp = new int[rows][cols];
        
        // Calculate height for each row
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else{
                    if(matrix[i][j] == '1')
                        dp[i][j] = dp[i - 1][j] + matrix[i][j] - '0';
                }
            }
        }
        // Find the maximum height from each row
        for(int[] row : dp){
            max = Math.max(max, largestRectangle(row));
        }
        return max;
    }
    
    public int largestRectangle(int[] h){
        Stack<Integer> st = new Stack<Integer>();
        st.add(0);
        int max = 0;
        for(int i = 1; i < h.length; i++){
            while(!st.isEmpty() && h[st.peek()] > h[i]){
                int temp = h[st.pop()];
                if(st.isEmpty())
                    max = Math.max(max, temp * i);
                else{
                    max = Math.max(max, temp * (i - st.peek() - 1));
                }
            }
            st.add(i);
        }
        int i = h.length;
        if(!st.isEmpty()){
            while(!st.isEmpty()){
                int temp = h[st.pop()];
                if(st.isEmpty())
                    max = Math.max(max, temp * i);
                else{
                    max = Math.max(max, temp * (i - st.peek() - 1));
                }
            }
        }
        return max;
    }
}