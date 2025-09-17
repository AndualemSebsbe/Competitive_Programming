class stringCompression {
    public int compress(char[] chars) {
        int len = chars.length, indx = 0, l = 0, r = 0;
        while(r < len){
            while(r < len && chars[l] == chars[r])
                r++;
        
            chars[indx++] = chars[l];
            
            if((r-l) > 1){
                for(char c: ("" + (r-l)).toCharArray()){
                    chars[indx++] = c;
                }
            }
            l = r;
        }
        return indx;
    }
}