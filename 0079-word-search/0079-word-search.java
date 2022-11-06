class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int res = 0;
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == word.charAt(0) && searchWord(board, i, j, word, 0))
                    return true;

        return false;
    }
    
    public boolean searchWord(char[][] board, int i, int j, String word, int idx){
        if(idx == word.length())
            return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx))
            return false;
        
        char temp = board[i][j];
        board[i][j] = ' ';
            
        boolean found = searchWord(board, i+1, j, word, idx+1) ||
                        searchWord(board, i-1, j, word, idx+1) ||
                        searchWord(board, i, j+1, word, idx+1) ||
                        searchWord(board, i, j-1, word, idx+1);
        board[i][j] = temp; 
        return found;
    }
}