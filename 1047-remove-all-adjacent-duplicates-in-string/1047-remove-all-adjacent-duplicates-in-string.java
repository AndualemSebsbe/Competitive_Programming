class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < sb.length()-1; i++){
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(i+1);
            
            if(c1 == c2){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                
                if(i != 0)
                    i -= 2;
                else
                    i = -1;
            }
        }
        
        return sb.toString();
    }
}