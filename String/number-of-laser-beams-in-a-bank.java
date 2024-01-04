class Solution {
    public int numberOfBeams(String[] bank) {
        int rows = bank.length, cols = bank[0].length();
        int res = 0;
        int prev = 0;
        for(int row = 0; row < rows; row++){
            int count = 0;
            for(int col = 0; col < cols; col++){
                if(bank[row].charAt(col) == '1')
                    count += 1;
            }
           
            if(count != 0){
                res += (prev * count);
                prev = count;
            }
        }

        return res;
    }
}