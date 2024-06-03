class Solution {
    public int appendCharacters(String s, String t) {
        int n = s.length(), m = t.length();
        int idx = 0, i = 0, j = 0;
        while(i < n && j < m){
            if(s.charAt(i) == t.charAt(j))
                j += 1;
    
            i += 1;
        }

        return m - j;
    }
}