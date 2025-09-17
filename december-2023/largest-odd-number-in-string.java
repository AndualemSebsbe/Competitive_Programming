class Solution {
    public String largestOddNumber(String num) {
        int len = num.length();
        while(len-- > 0){
            int val = num.charAt(len) - '0';
            if(val % 2 == 1){
                return num.substring(0, len + 1);
            }
        }

        return "";
    }
}