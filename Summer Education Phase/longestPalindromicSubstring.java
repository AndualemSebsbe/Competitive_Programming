public class longestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;
        for(int i = 0; i < n; i++){
                int len1 = isPalindrome(i, i, s);
                int len2 = isPalindrome(i, i+1, s);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        
        return s.substring(start, end+1);
    }
    
    public int isPalindrome(int s, int e, String str){
        while(s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)){
            s--; e++;
        }
        return e-s-1;
    }
}