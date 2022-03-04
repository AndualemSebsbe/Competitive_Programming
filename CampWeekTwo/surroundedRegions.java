class surroundedRegions {
    public void solve(char[][] board) {
         int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if(board[i][col - 1] == 'O')
                boundaryDFS(board, i, col - 1);
        }
            
        for(int j = 0; j < col; j++){
            if(board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if(board[row - 1][j] == 'O')
                boundaryDFS(board, row - 1, j);
        }          
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
        
    }
    
    public void boundaryDFS(char[][] board, int i, int j){
        if((i < 0) || (i >= board.length) || (j < 0) || (j >= board[i].length))
            return;
        
        if(board[i][j] == 'O') board[i][j] = '*';
        if((i < board.length - 1) && (board[i + 1][j] == 'O'))
            boundaryDFS(board, i + 1, j);
        if((i > 0) && (board[i - 1][j] == 'O'))
            boundaryDFS(board, i - 1, j);
        if((j < board[i].length - 1) && (board[i][j + 1] == 'O'))
            boundaryDFS(board, i, j + 1);
        if((j > 0) && (board[i][j - 1] == 'O'))
            boundaryDFS(board, i, j - 1);
            
    }
}