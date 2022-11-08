class Solution {
    public String makeGood(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        
        while(sb.length() > 1){
            boolean find = false;
            
            for(int i = 0; i < sb.length()-1; i++){
                char c1 = sb.charAt(i);
                char c2 = sb.charAt(i+1);
                
                if(Math.abs(c1-c2) == 32){
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    find = true;
                    break;
                }
            }
            
            if(!find)
                break;
        }    
        
        return sb.toString();
    }
}