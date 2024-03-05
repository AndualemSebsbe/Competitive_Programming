class Solution {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return r - l + 1;
            
            while(l < r && s.charAt(l) == s.charAt(r))
                r -= 1;
            r += 1;
            while(l < r && s.charAt(l) == s.charAt(r))
                l += 1;
            r -= 1;
        }

        return r - l + 1;
    }
}