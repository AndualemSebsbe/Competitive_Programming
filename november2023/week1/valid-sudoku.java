class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> visited = new HashSet();
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                int val = board[r][c];
                if(val != '.'){
                    if(visited.contains(val + "r" + r) || 
                        visited.contains(val + "c" + c) || 
                        visited.contains(val + "sqr" + r/3 + c/3)) 
                        return false;
                    
                    visited.add(val + "r" + r);
                    visited.add(val + "c" + c);
                    visited.add(val + "sqr" + r/3 + c/3);
                }
            }
        }
        
        return true;
    }
}