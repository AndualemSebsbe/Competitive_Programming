class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int countOnes = 0;
        for(char c : s.toCharArray()){
            if(c == '1')
                countOnes += 1;
        }

        int zeroes = n - countOnes;
        StringBuilder sb = new StringBuilder();
        while(countOnes-- > 1){
            sb.append('1');
        }

        while(zeroes-- > 0)
            sb.append('0');
        
        sb.append('1');
        return sb.toString();
    }
}