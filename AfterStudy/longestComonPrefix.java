class longestComonPrefix {
    public String longestComonPrefix(String[] strs) {
        int minlen = strs[0].length();
        
        for(int i = 1; i < strs.length; i++){
            if(minlen > strs[i].length())
                minlen = strs[i].length();
        }
        
        int count = 0;
        for(int i = 0; i < minlen; i++){
            boolean flag = true;
            for(int j = 0; j < strs.length-1; j++){
                if(strs[j].charAt(i) != strs[j+1].charAt(i)){
                    flag = false;
                    break;
                }
                
            }
            
            if(!flag)
                break;
            else
                count += 1;
        }
        
        String s = "";
        for(int i = 0; i < count; i++){
            s += strs[0].charAt(i);
        }

        return s;
    }
}