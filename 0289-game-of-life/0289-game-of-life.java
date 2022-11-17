class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = 0; 
                for(int[] dir : dirs){
                    int newI = i + dir[0];
                    int newJ = j + dir[1];
                    
                    if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && 
                       (board[newI][newJ] == 1 || board[newI][newJ] == 2))
                        count += 1;
                }
                
                if(board[i][j] == 1){
                    if(count < 2 || count > 3)
                        board[i][j] = 2;
                }
                else{
                    if(count == 3)
                        board[i][j] = 3;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] %= 2;
            }
        }
    }
}