class Solution {
    public int findComplement(int num) {
        int res = 0;
        int shift = 0, temp = num;
        while(num > 0){
            int rightMost = num & 1;
            int bit = rightMost ^ 1; 
            res = res | (bit << shift);
        
            num = num >> 1;
            shift += 1;
        }
        
        return res;
    }
}