class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] != '.'){
                    if(!isValid(board, r, c)) return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int r, int c){
        int val = board[r][c];
        for(int i = 0; i < 9; i++){
            if(i != r && board[i][c] == val) return false;
            if(i != c && board[r][i] == val) return false;
        }
        
        r = (r/3 == 0) ? 0 : r/3 == 1 ? 3 : 6;
        c = (c/3 == 0) ? 0 : c/3 == 1 ? 3 : 6;
        
        int k = 0;
        for(int i = r; i < r+3; i++){
            for(int j = c; j < c+3; j++){
                if(board[i][j] == val)
                    k++;
                if(k >= 2) return false;
            } 
        }
        
        return true;
    }
}