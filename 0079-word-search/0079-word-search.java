class Solution {
    public boolean exist(char[][] board, String word) {
        int len = word.length();
        int m = board.length;
        int n = board[0].length;
       
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = word.charAt(0);
                if(board[i][j] == c && wordSearch(board, i, j, word, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean wordSearch(char[][] board, int r, int c, String word, int idx){
        if(idx == word.length())
            return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || 
           board[r][c] != word.charAt(idx))
            return false;
        
        char temp = board[r][c];
        board[r][c] = ' ';
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        boolean found = false;
        
        for(int[] dir : dirs){
            int newR = r + dir[0];
            int newC = c + dir[1];
            
           found = found || wordSearch(board, newR, newC, word, idx+1);
        }
        board[r][c] = temp;
        
        return found;
    }
}