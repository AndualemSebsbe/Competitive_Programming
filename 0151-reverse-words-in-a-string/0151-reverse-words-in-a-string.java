class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        String revS = "";
        
        for(int i = str.length-1; i >= 0; i--){
            revS += str[i] + " ";
        }
        
        return revS.substring(0, revS.length()-1);
    }
}