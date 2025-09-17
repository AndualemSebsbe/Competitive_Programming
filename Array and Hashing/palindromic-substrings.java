class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res += isPalindrome(i, i, s);
            res += isPalindrome(i, i + 1, s);
        }

        return res;
    }

    int isPalindrome(int l, int r, String s){
        int count = 0;
        while(l >= 0 && r < s.length()){
            if(s.charAt(l) == s.charAt(r))
                count += 1;
            else
                break;
            l -= 1;
            r += 1;
        }

        return count;
    }
}