class Solution {
    public String intToRoman(int num) {
        String[] notations ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        String roman = "";
        for(int pos = 0; pos < value.length; pos++){
            if(num >= value[pos]){
                int val = num / value[pos];
                num %= value[pos];
                
                for(int i = 0; i < val; i++)
                    roman += notations[pos];
            }
        }
        
        return roman;
    }
}