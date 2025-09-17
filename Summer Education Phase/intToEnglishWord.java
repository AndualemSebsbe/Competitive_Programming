class intToEnglishWord {
    int[] n = {
            1_000_000_000, 1_000_000, 1_000, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14,13,12,11,10,9,8,7,6,5,4,3,2,1
        };
        
        String[] str = {
            "Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty","Nineteen", "Eighteen","Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"
        };
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return numToWord(num);
    }
    
    public String numToWord(int num){
        
        StringBuilder sb = new StringBuilder();
        
        if(num == 0) return sb.toString();
        
        for(int i = 0; i < n.length; i++){
            if(num >= n[i]){
                if(num >= 100){
                    sb.append(numToWord(num/n[i])).append(" ");
                }
                
                sb.append(str[i]).append(" ").append(numToWord(num%n[i])).append(" ");
                break;
            }
        }
        
        return sb.toString().trim();
    }
}