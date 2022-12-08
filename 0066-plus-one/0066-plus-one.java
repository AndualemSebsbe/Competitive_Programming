class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        int flag = 1;
        for(int digit : digits)
            if(digit != 9)
                flag = 0;
        
        int[] res = new int[len+1];
        if(flag == 1){
            res[0] = 1;
            for(int i = 1; i <= len; i++)
                res[i] = 0;
            
            return res;
        }
        
        for(int i = len-1; i >= 0; i--){
            if(digits[i] == 9)
                digits[i] = 0;
            else{
                digits[i] += 1;
                break;
            }
        }
        
        return digits;
    }
}