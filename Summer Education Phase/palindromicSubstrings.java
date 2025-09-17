public class palindromicSubstrings {

    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res += isPalindrome(i, i, s);
            res += isPalindrome(i, i+1, s);
        }
        return res;
    }
    
    public int isPalindrome(int s, int e, String str){
        int count = 0;
        while(s >= 0 && e < str.length() && str.charAt(s--) == str.charAt(e++))
            count++;         
        
        return count;
    }
}